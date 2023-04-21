package kr.co.igns.business.eqp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.igns.business.eqp.dao.postgre.Eqp0060Dao;
import kr.co.igns.business.eqp.model.eqp0060.Eqp0060Dto;
import kr.co.igns.business.eqp.model.eqp0060.Eqp0060VO;
//import kr.co.igns.business.eqp.model.eqp0060.Eqp0060DetailVO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Eqp0060Service{

	private final Eqp0060Dao eqp0060Dao;
	private final IgnsSessionUtils ignsSessionUtils;
	
	//수리내역 조회
	public List<Eqp0060VO> getFacilityItem(Eqp0060Dto dto) {
		List<Eqp0060VO> list = eqp0060Dao.getFacilityItem(dto);
        return list;
    }
	//수리내역 입력/수정
	public int saveEqp0050(List<Eqp0060VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		
		for(Eqp0060VO vo : voList) {
			if(vo.is__created__()) {
				vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
				eqp0060Dao.createEqp0050(vo);					
			} else if(vo.is__modified__()) {
				vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
				eqp0060Dao.updateEqp0050(vo);
			}
		}
		return 0;
    }
//	
	//수리내역 삭제
	public int deleteEqp0050(List<Eqp0060VO> voList) {
		for(Eqp0060VO vo : voList) {
			eqp0060Dao.deleteEqp0050(vo);
		}
		return 0;
	}
	
}
