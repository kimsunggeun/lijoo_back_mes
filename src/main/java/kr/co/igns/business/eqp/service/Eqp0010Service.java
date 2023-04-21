package kr.co.igns.business.eqp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.igns.business.eqp.dao.postgre.Eqp0010Dao;
import kr.co.igns.business.eqp.model.eqp0010.Eqp0010DetailVO;
import kr.co.igns.business.eqp.model.eqp0010.Eqp0010Dto;
import kr.co.igns.business.eqp.model.eqp0010.Eqp0010VO;

import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Eqp0010Service{

	private final Eqp0010Dao eqp0010Dao;
	private final IgnsSessionUtils ignsSessionUtils;
	
		public List<Eqp0010VO> getMaingrd() {
			List<Eqp0010VO> list = eqp0010Dao.getMaingrd();
	        return list;
	    }
		public List<Eqp0010DetailVO> getDetailgrd(Eqp0010Dto dto) {
			List<Eqp0010DetailVO> list = eqp0010Dao.getDetailgrd(dto);
	        return list;
	    }
		
		//계측기 검교정 입력/수정
		public int saveEqp0010(List<Eqp0010DetailVO> voList) {
			String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
			
			for(Eqp0010DetailVO vo : voList) {
				if(vo.is__created__()) {
					vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
					eqp0010Dao.createEqp0010(vo);					
				} else if(vo.is__modified__()) {
					vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
					eqp0010Dao.updateEqp0010(vo);
				}
			}
			return 0;
	    }
		
		//구매발주정보 삭제
		public int deleteEqp0010(List<Eqp0010DetailVO> voList) {
			for(Eqp0010DetailVO vo : voList) {
				eqp0010Dao.deleteEqp0010(vo);
			}
			return 0;
		}
	
	
}
