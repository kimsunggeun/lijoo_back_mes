package kr.co.igns.business.qat.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.igns.business.qat.dao.postgre.Qat0060Dao;
import kr.co.igns.business.qat.model.qat0060.Qat0060Dto;
import kr.co.igns.business.qat.model.qat0060.Qat0060VO;
import kr.co.igns.business.qat.model.qat0060.QatOutStatusDto;
import kr.co.igns.business.sales.model.sal0130.Sal0130VO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Qat0060Service {
	
	private final Qat0060Dao qat0060dao;
	private int result = 0;
	private int cnt = 0;
	
	//납품정보 조회
	public List<Qat0060VO> getQat0060(Qat0060Dto dto){
		List<Qat0060VO> list = qat0060dao.getQat0060(dto);
		return list;
	}
	
	//출하검사 검사내역 조회
	public List<Qat0060VO> getInspection(QatOutStatusDto dto) {
		List<Qat0060VO> list = qat0060dao.getInspection(dto);
		return list;
	}

	//출하검사 입력/수정
	public int createQat0060(List<Qat0060VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		String ilno = qat0060dao.selectIlno(voList.get(0));
		for(Qat0060VO vo : voList) {
			if(vo.is__created__()) {
				vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
				
				vo.setIlno(ilno);
				qat0060dao.createQat0060(vo); // qat0010 테이터 저장
			}
		}
		return 1;
    }
	
	
	//검사내역 취소(삭제)
	@Transactional(rollbackFor = Exception.class)
	public int deleteQat0060(List<Qat0060VO> voList)throws Exception {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		
		for(Qat0060VO vo : voList) {
			if(vo.is__created__()) {
				vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
				qat0060dao.deleteQat0060(vo);
			}			
		}
		return 0;
	}
	
	
}
