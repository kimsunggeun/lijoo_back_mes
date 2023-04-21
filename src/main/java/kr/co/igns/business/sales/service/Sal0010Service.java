package kr.co.igns.business.sales.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.igns.business.baseInfo.bas0120.model.Bas0030VO;
import kr.co.igns.business.sales.dao.postgre.Sal0010Dao;
import kr.co.igns.business.sales.model.sal0010.Sal0010ReqDto;
import kr.co.igns.business.sales.model.sal0010.Sal0010VO;
import kr.co.igns.business.sales.model.sal0010.Sal0011VO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Sal0010Service{

	private final Sal0010Dao sal0010Dao;
	private final IgnsSessionUtils ignsSessionUtils;

	//품목정보 조회
	public List<Sal0010VO> getItemInfo(Sal0010ReqDto reqDto) {
		List<Sal0010VO> list = sal0010Dao.getItemInfo(reqDto);
        return list;
    }	
	
	//수주정보 조회
	public List<Sal0010VO> getSal0010(Sal0010ReqDto reqDto) {
		List<Sal0010VO> list = sal0010Dao.getSal0010(reqDto);
        return list;
    }
		
	//수주정보 입력/수정
	public int createSal0010(List<Sal0010VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		
		for(Sal0010VO vo : voList) {
			if(vo.is__created__()) {
				vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
				sal0010Dao.createSal0010(vo);					
			} else if(vo.is__modified__()) {
				vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
				sal0010Dao.updateSal0010(vo);
			}
		}
		return 0;
    }
	
	//수주세부정보 조회
	public List<Sal0011VO> getSal0011(Sal0010ReqDto reqDto) {
		List<Sal0011VO> list = sal0010Dao.getSal0011(reqDto);
        return list;
    }
		
	//수주세부정보 입력/수정
	public int createSal0011(List<Sal0011VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		
		for(Sal0011VO vo : voList) {
			if(vo.is__created__()) {
				vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
				sal0010Dao.createSal0011(vo);					
			} else if(vo.is__modified__()) {
				vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
				sal0010Dao.updateSal0011(vo);
			}
		}
		return 0;
    }
	//수주정보등록 확정
	public int confirmSal0010(List<Sal0010VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		
		for(Sal0010VO vo : voList) {
			sal0010Dao.confirmSal0010(vo);
		}
		return 0;
	}
	//수주정보등록 확정
	public int confirmCancelSal0010(List<Sal0010VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		
		for(Sal0010VO vo : voList) {
			sal0010Dao.confirmCancelSal0010(vo);
		}
		return 0;
	}
	
	//수주정보 삭제
	@Transactional(rollbackFor = Exception.class)
	public int deleteSal0010(List<Sal0010VO> voList) {
		for(Sal0010VO vo : voList) {
			
			if(sal0010Dao.NullCheck_Sal0011(vo).isEmpty()) {
				sal0010Dao.deleteSal0010(vo);
			}
		}
		return 0;
	}
	//수주세부정보 삭제
	public int deleteSal0011(List<Sal0011VO> voList) throws Exception{
		for(Sal0011VO vo : voList) {
			if(sal0010Dao.outQtyCheck(vo) > 0) {
				throw new Exception("출하량이 존재해 삭제할 수 없습니다");
			}
			sal0010Dao.deleteSal0011(vo);
		}
		return 0;
	}
}
