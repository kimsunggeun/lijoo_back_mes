package kr.co.igns.business.baseInfo.bas0250.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.igns.business.baseInfo.bas0250.dao.postgre.Bas0250Dao;
import kr.co.igns.business.baseInfo.bas0250.model.Bas0250ReqDto;
import kr.co.igns.business.baseInfo.bas0250.model.Bas0250VO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Bas0250Service {

	private final Bas0250Dao bas0250dao;
	
	//잡셋업유형 조회
	public List<Bas0250VO> getInspecType(Bas0250ReqDto dto){
		dto.setCodegr("COM");
		dto.setCode("JOB_TYPE");
		return bas0250dao.getInspecType(dto);
	
	}
	
	//잡셋업항목 조회
	public List<Bas0250VO> getFacItem(Bas0250ReqDto dto){
		List<Bas0250VO> list = bas0250dao.getFacItem(dto);
		return list;
	}
	
	//작업반 콤보박스 조회
	public List<Bas0250VO> getWorkShopInfo(Bas0250ReqDto dto){
		List<Bas0250VO> list = bas0250dao.getWorkShopInfo(dto);
		return list;
	}
	
	//설비코드 콤보박스 조회
	public List<Bas0250VO> getFacilityInfo(Bas0250ReqDto dto){
		List<Bas0250VO> list = bas0250dao.getFacilityInfo(dto);
		return list;
	}
	
	//잡셋업항목 입력/수정
	public void saveInspecItem(List<Bas0250VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		
		voList.forEach(s -> {
			if(s.is__created__()) {
				s.setMaker(loginId);
				bas0250dao.setInspecItem(s);
			}else if(s.is__modified__()) {
				s.setEditor(loginId);
				bas0250dao.modiInspecItem(s);
			}
		});
	}
	
	//잡셋업항목 삭제
	public void delInspecItem(List<Bas0250ReqDto> voList) {
		voList.forEach(s -> bas0250dao.delInspecItem(s));
	}
	
}
