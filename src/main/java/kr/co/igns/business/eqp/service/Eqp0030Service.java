package kr.co.igns.business.eqp.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.igns.business.eqp.dao.postgre.Eqp0010Dao;
import kr.co.igns.business.eqp.dao.postgre.Eqp0030Dao;
import kr.co.igns.business.eqp.model.eqp0010.Eqp0010DetailVO;
import kr.co.igns.business.eqp.model.eqp0010.Eqp0010Dto;
import kr.co.igns.business.eqp.model.eqp0010.Eqp0010VO;
import kr.co.igns.business.eqp.model.eqp0030.Eqp0030DetailVO;
import kr.co.igns.business.eqp.model.eqp0030.Eqp0030Dto;
import kr.co.igns.business.eqp.model.eqp0030.Eqp0030VO;
import kr.co.igns.business.eqp.model.eqp0070.Eqp0070DetailVO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Eqp0030Service{

	private final Eqp0030Dao eqp0030Dao;
	private final IgnsSessionUtils ignsSessionUtils;
	
		public List<Eqp0030VO> getEqp0030(Eqp0030Dto dto) {
			List<Eqp0030VO> list = eqp0030Dao.getEqp0030(dto);
	        return list;
	    }
		
		
		
		
		
		
		
		
		
		
		
		public List<Eqp0030DetailVO> getEqp0030Detail(Eqp0030Dto dto) {
			List<Eqp0030DetailVO> list = eqp0030Dao.getEqp0030Detail(dto);
	        return list;
	    }
		
	//저장
		@Transactional(rollbackFor = Throwable.class)
		public int createEqp0030(List<Eqp0030DetailVO> saveList) throws Exception {
			int result = 0;
			String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
			
			Iterator<Eqp0030DetailVO> iterator = saveList.iterator();
			while(iterator.hasNext()) {
				Eqp0030DetailVO svo = (Eqp0030DetailVO)iterator.next();		
				svo.setEditor(loginId.equals("") ? svo.getEditor() : loginId);
				result = eqp0030Dao.createEqp0030(svo);
			}		
			return result ;
		}
		
		//
		

		
		
		//구매발주정보 삭제
		public int deleteEqp0030(List<Eqp0030DetailVO> voList) {
			for(Eqp0030DetailVO vo : voList) {
				eqp0030Dao.deleteEqp0030(vo);
			}
			return 0;
		}
	
	
}
