package kr.co.igns.business.baseInfo.bas0220.service;

import java.util.List;

import org.springframework.stereotype.Service;

import org.apache.commons.collections.map.MultiKeyMap;
import kr.co.igns.business.baseInfo.bas0220.dao.postgre.Bas0220Dao;
import kr.co.igns.business.baseInfo.bas0220.model.Bas0220Dto;
import kr.co.igns.business.baseInfo.bas0220.model.Bas0220VO_ITEM;
import kr.co.igns.business.baseInfo.bas0220.model.Bas0220VO_BOM;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Bas0220Service {
	
	private final Bas0220Dao bas0220dao;
	
	//품목선택 조회
	public List<Bas0220VO_ITEM> getItemSelect(Bas0220Dto dto){
		List<Bas0220VO_ITEM> list = bas0220dao.getItemSelect(dto);
		return list;
	}

	// BOM 정전개 신버전
	public List<Bas0220VO_BOM> getBomExplosion(Bas0220Dto dto){
		List<Bas0220VO_BOM> list = bas0220dao.getBomExplosion(dto);		
		
		MultiKeyMap multiMap = new MultiKeyMap();
		
		for (Bas0220VO_BOM vo : list)
		{				
			int iLevel = Integer.parseInt(vo.getLevel());
			String strPartNo = vo.getPartNo();
			String strPaPartNo = vo.getPaPartNo();
			String strId = vo.getId();
			
			if (iLevel == 1)
			{					
				multiMap.put(iLevel, strPartNo, strId);			
			}
			else if (iLevel > 1)
			{							
				if (multiMap.containsKey(iLevel - 1, strPaPartNo) == true)
				{						
					vo.setParentId(multiMap.get(iLevel - 1, strPaPartNo).toString());									
					multiMap.put(iLevel, strPartNo, strId);
				}
			}
		}
		
		return list; 
	}
}

