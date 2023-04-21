package kr.co.igns.business.sales.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.igns.business.sales.dao.postgre.Sal0150Dao;
import kr.co.igns.business.sales.model.sal0150.Sal0150ReqDto;
import kr.co.igns.business.sales.model.sal0150.Sal0120VO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Sal0150Service{

	private final Sal0150Dao sal0150Dao;
	private final IgnsSessionUtils ignsSessionUtils;
	
	//출하등록 조회
	public List<Sal0120VO> getSal0150(Sal0150ReqDto reqDto) {
		List<Sal0120VO> list = sal0150Dao.getSal0150(reqDto);
        return list;
    }
		
	//출하등록 입력/수정
	public int createSal0150(List<Sal0120VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		
		for(Sal0120VO vo : voList) {
			if(vo.is__modified__()) {
				vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
				sal0150Dao.updateSal0150(vo);
			}
		}
		return 0;
    }
}
