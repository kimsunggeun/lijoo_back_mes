package kr.co.igns.business.ProdManage.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.igns.business.ProdManage.dao.postgre.Pro0020Dao;
import kr.co.igns.business.ProdManage.model.pro0020.Pro0020ReqDto;
import kr.co.igns.business.ProdManage.model.pro0020.Pro0020VO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Pro0020Service {
	
	@Autowired
	private final Pro0020Dao pro0020Dao;
	private int result = 0;
	
	//생산계획 조회
	public List<Pro0020VO> getPro0020(Pro0020ReqDto reqDto) {
        return pro0020Dao.getPro0020(reqDto);
    }
	
	//생산계획 등록/수정
	public int createPro0020(List<Pro0020VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
			
		voList.forEach(s -> {
			if(s.is__created__()) {
				s.setMaker(loginId.equals("") ? "" : loginId);
				pro0020Dao.createPro0020(s);					
			} else if(s.is__modified__()) {
				s.setEditor(loginId.equals("") ? "" : loginId);
				pro0020Dao.updatePro0020(s);
			}
		});

		return 0;
    }
	
    //업로드 가져오기
	public List<Pro0020VO> getUpload(List<Pro0020VO> voList){
		ArrayList<Pro0020VO> returnList = new ArrayList<Pro0020VO>();
		
		int idCnt = 0;
		
		for(Pro0020VO vo : voList) {
			vo.setId(Integer.toString(idCnt));
			returnList.add(pro0020Dao.getUpload(vo).get(0));
			idCnt++;			
		}
		
		return returnList;
	}
	
	//생산계획 업로드 저장하기
	@Transactional(rollbackFor = Exception.class)
	public int saveUpload(List<Pro0020VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		for(Pro0020VO vo :voList) {
			vo.setPrePlanQty(pro0020Dao.getPrePlanQty(vo));
			vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
			pro0020Dao.ctUpload(vo);
			result = 1;
		}
		return result;
	}
}
