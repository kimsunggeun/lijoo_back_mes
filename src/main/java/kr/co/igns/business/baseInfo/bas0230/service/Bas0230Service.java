package kr.co.igns.business.baseInfo.bas0230.service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.apache.commons.collections.map.MultiKeyMap;
import org.springframework.stereotype.Service;

import kr.co.igns.business.baseInfo.bas0230.dao.postgre.Bas0230Dao;
import kr.co.igns.business.baseInfo.bas0230.model.Bas0230Dto;
import kr.co.igns.business.baseInfo.bas0230.model.Bas0230VO_BOM;
import kr.co.igns.business.baseInfo.bas0230.model.Bas0230VO_ITEM;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Bas0230Service {
	
	private final Bas0230Dao bas0230dao;
	
	// 품목선택 조회
	public List<Bas0230VO_ITEM> getItemSelect(Bas0230Dto dto){
		List<Bas0230VO_ITEM> list = bas0230dao.getItemSelect(dto);
		return list;
	}
		
	public static Integer iNewId = 0;
	
	// BOM 역전개 신버전
	public List<Bas0230VO_BOM> getBomImplosion(Bas0230Dto dto)
	{
		List<Bas0230VO_BOM> list = bas0230dao.getBomImplosion(dto);
		
		MultiKeyMap multiMap = new MultiKeyMap();
		List<String> isChildIdList = new ArrayList<String>();
		
		Map<String, Bas0230VO_BOM> onlyValueMap = new HashMap<String, Bas0230VO_BOM>();
		
		for (Bas0230VO_BOM vo : list)
		{
			String onlyKey = vo.getPathType() + "-" + vo.getPathCode() + "-" + vo.getProCode() + "-" + vo.getPaPartNo() + "-" + vo.getPartNo();
			
			if (onlyValueMap.containsKey(onlyKey) == false)
				onlyValueMap.put(onlyKey, vo);
		}
		
		List<Bas0230VO_BOM> tempList = new ArrayList<Bas0230VO_BOM>(onlyValueMap.values());
		Collections.sort(tempList, (o1, o2) -> Integer.parseInt(o1.getId()) - Integer.parseInt(o2.getId()));
		
		for (Bas0230VO_BOM vo : tempList)
		{
			int iLevel = Integer.parseInt(vo.getLevel());
			String strPartNo = vo.getPartNo();
			String strPaPartNo = vo.getPaPartNo();
			String strId = vo.getId();
			String strParentId = vo.getParentId();
			
			Object[] arguments = {strParentId, strId, iLevel, strPaPartNo, strPartNo};
			System.out.println(MessageFormat.format("ParentId:{0}, Id:{1}, Level:{2}, PaPartNo:{3}, PartNo:{4}", arguments));			
		}	
		
		System.out.println("----------------------------------------------------------------------------------------------");
		
		for (Bas0230VO_BOM vo : tempList)
		{				
			int iLevel = Integer.parseInt(vo.getLevel());
			String strPartNo = vo.getPartNo();
			String strPaPartNo = vo.getPaPartNo();
			String strId = vo.getId();
						
			if (multiMap.containsKey(iLevel - 1, strPaPartNo) == true)
			{
				String[] strSplit = multiMap.get(iLevel - 1, strPaPartNo).toString().split("/");
				int myLevel = Integer.parseInt(strSplit[1]) + 1;
				
				vo.setParentId(strSplit[0]);
				vo.setLevel(Integer.toString(myLevel));

				String strValue = strId + "/" + myLevel + "/" + strPaPartNo;
				multiMap.put(iLevel, strPartNo, strValue);
				System.out.println("OriginLevel:" + iLevel + ", Level:" + myLevel + ", Id:" + strId + ", ParentId:" + vo.getParentId() + ", PaPartNo:" + strPaPartNo + ", PartNo:" + strPartNo);
				
				isChildIdList.add(vo.getParentId());
			}
			else
			{
				vo.setLevel("1");
				
				String strValue = strId + "/" + "1" + "/" + strPaPartNo;				
				multiMap.put(iLevel, strPartNo, strValue);
				System.out.println("OriginLevel:" + iLevel + ", Level:" + "1" + ", Id:" + strId + ", ParentId:" + "0" + ", PaPartNo:" + strPaPartNo + ", PartNo:" + strPartNo);
			}			
		}
		
		System.out.println("----------------------------------------------------------------------------------------------");
		
		List<Bas0230VO_BOM> rootList = new ArrayList<Bas0230VO_BOM>();
		List<Bas0230VO_BOM> finalList = new ArrayList<Bas0230VO_BOM>();
		
		for (Bas0230VO_BOM vo : tempList)
		{
			if (vo.getParentId().equals("0") == true)
				rootList.add(vo);
		}
		
		for (Bas0230VO_BOM voRoot : rootList)
		{
			Bas0230VO_BOM newVO = new Bas0230VO_BOM(voRoot);
			++iNewId;
			newVO.setId(Integer.toString(iNewId));
			newVO.setParentId("0");
			newVO.setLevel("1");			
			finalList.add(newVO);
			
			AutoAddChildBom(newVO, tempList, finalList);
		}
		
		return finalList;
	}
	
	public void AutoAddChildBom(Bas0230VO_BOM voParent, List<Bas0230VO_BOM> totalList, List<Bas0230VO_BOM> newList)
	{
		for (Bas0230VO_BOM voFinal : totalList)
		{
			if (voFinal.getPaPartNo().equals(voParent.getPartNo()) == true)
			{
				Bas0230VO_BOM newVO = new Bas0230VO_BOM(voFinal);
				++iNewId;
				newVO.setId(Integer.toString(iNewId));
				newVO.setParentId(voParent.getId());
				newVO.setLevel(Integer.toString(Integer.parseInt(voParent.getLevel()) + 1));			
				newList.add(newVO);
				
				AutoAddChildBom(newVO, totalList, newList);
			}
		}		
	}
}

