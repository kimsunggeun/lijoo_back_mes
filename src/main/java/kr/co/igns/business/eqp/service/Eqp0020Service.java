package kr.co.igns.business.eqp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.igns.business.eqp.dao.postgre.Eqp0010Dao;
import kr.co.igns.business.eqp.dao.postgre.Eqp0020Dao;
import kr.co.igns.business.eqp.model.eqp0010.Eqp0010DetailVO;
import kr.co.igns.business.eqp.model.eqp0010.Eqp0010Dto;
import kr.co.igns.business.eqp.model.eqp0010.Eqp0010VO;
import kr.co.igns.business.eqp.model.eqp0020.Eqp0020Dto;
import kr.co.igns.business.eqp.model.eqp0020.Eqp0020VO;
import kr.co.igns.business.eqp.model.eqp0070.Eqp0070DetailVO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Eqp0020Service{

	private final Eqp0020Dao eqp0020Dao;
	private final IgnsSessionUtils ignsSessionUtils;
	
		public List<Eqp0020VO> getEqp0020grd(Eqp0020Dto dto) {
			List<Eqp0020VO> list = eqp0020Dao.getEqp0020grd(dto);
	        return list;
	    }


		public int saveEqp0020(List<Eqp0020VO> voList) {
			String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
			
			for(Eqp0020VO vo : voList) {
				if(vo.is__created__()) {
					vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
					eqp0020Dao.createEqp0020(vo);					
				} else if(vo.is__modified__()) {
					vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
					eqp0020Dao.updateEqp0020(vo);
				}
			}
			return 0;
	    }
//		
//		
		public int deleteEqp0020(List<Eqp0020VO> voList) {
			for(Eqp0020VO vo : voList) {
				eqp0020Dao.deleteEqp0020(vo);
			}
			return 0;
		}
	
	
}
