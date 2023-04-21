package kr.co.igns.business.baseInfo.bas0410.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.igns.business.baseInfo.bas0410.dao.postgre.Bas0410Dao;
import kr.co.igns.business.baseInfo.bas0410.model.Bas0410ReqDto;
import kr.co.igns.business.baseInfo.bas0410.model.Bas0410VO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Bas0410Service {

	private final Bas0410Dao bas0410dao;
	
	//검사유형 조회
	public List<Bas0410VO> getInspecType(Bas0410ReqDto dto){
		dto.setCodegr("QAT");
		dto.setCode("INPT");
		return bas0410dao.getInspecType(dto);
	}
	
	//검사항목 조회
	public List<Bas0410VO> getInspecItem(Bas0410ReqDto dto){
		List<Bas0410VO> list = bas0410dao.getInspecItem(dto);
		return list;
	}
	
	//검사항목 입력/수정
	public void saveInspecItem(List<Bas0410VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		
		voList.forEach(s -> {
			if(s.is__created__()) {
				s.setMaker(loginId);
				bas0410dao.setInspecItem(s);
			}else if(s.is__modified__()) {
				s.setEditor(loginId);
				bas0410dao.modiInspecItem(s);
			}
		});
	}
	
	//검사항목 삭제
	public void delInspecItem(List<Bas0410ReqDto> voList) {
		voList.forEach(s -> bas0410dao.delInspItem(s));
	}
	
}
