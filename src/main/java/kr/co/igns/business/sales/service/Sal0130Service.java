package kr.co.igns.business.sales.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.igns.business.qat.model.qat0010.Qat0010VO;
import kr.co.igns.business.sales.dao.postgre.Sal0130Dao;
import kr.co.igns.business.sales.model.sal0130.Sal0130ReqDto;
import kr.co.igns.business.sales.model.sal0130.Sal0130VO;
import kr.co.igns.business.sales.model.sal0130.SalOutStatusDto;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Sal0130Service{

	private final Sal0130Dao sal0130Dao;
	private final IgnsSessionUtils ignsSessionUtils;
	
	//출하전표 조회
	public List<Sal0130VO> getSal0130(Sal0130ReqDto reqDto) {
		List<Sal0130VO> list = sal0130Dao.getSal0130(reqDto);
        return list;
    }
	
	//출하로트현황 조회
	public List<Sal0130VO> getOutStatus(SalOutStatusDto dto) {
		List<Sal0130VO> list = sal0130Dao.getOutStatus(dto);
		return list;
	}
	
	//출하검사 검사내역 조회
	public List<Sal0130VO> getInspection(SalOutStatusDto dto) {
		List<Sal0130VO> list = sal0130Dao.getInspection(dto);
		return list;
	}
	
	//출하검사 입력/수정
	public int createSal0130(List<Sal0130VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		
		for(Sal0130VO vo : voList) {
			if(vo.is__created__()) {
				vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
				sal0130Dao.createSal0130(vo);
			}
		}
		return 0;
    }
	
	
	//구매발주정보 상세 삭제
	@Transactional(rollbackFor = Exception.class)
	public int delSal0130(List<Sal0130VO> voList)throws Exception {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		
		for(Sal0130VO vo : voList) {
			if(vo.is__created__()) {
				vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
				sal0130Dao.delSal0130(vo);
			}			
			
		}
		return 0;
	}
	
}
