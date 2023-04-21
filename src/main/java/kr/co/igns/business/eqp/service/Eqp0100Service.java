package kr.co.igns.business.eqp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.igns.business.eqp.dao.postgre.Eqp0100Dao;
import kr.co.igns.business.eqp.model.eqp0100.Eqp0100Dto;
import kr.co.igns.business.eqp.model.eqp0100.Eqp0100VO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Eqp0100Service {
	
	private final Eqp0100Dao eqp0100dao;
	private int result = 0;
	
	//예비품 정보 GET
	public List<Eqp0100VO> getMainList(Eqp0100Dto dto) {
		List<Eqp0100VO> list = eqp0100dao.getMainList(dto);
		return list;
	}
	
	//예비품 정보 GET
	public List<Eqp0100VO> getReceiptDetailList(Eqp0100Dto dto) {
		List<Eqp0100VO> list = eqp0100dao.getReceiptDetailList(dto);
		return list;
	}
	
	//예비품 정보 GET
	public List<Eqp0100VO> getDeliDetailList(Eqp0100Dto dto) {
		List<Eqp0100VO> list = eqp0100dao.getDeliDetailList(dto);
		return list;
	}
	
	//입고내역, 출고내역 입력/수정
	public int saveDetailInfo(List<Eqp0100VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
				
		for(Eqp0100VO vo : voList) {
			if(vo.is__created__()) {
				vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
				eqp0100dao.ctHeaderInfo(vo);
				eqp0100dao.ctDetailInfo(vo);
			} else if(vo.is__modified__()) {
				vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
				eqp0100dao.utHeaderInfo(vo);
				eqp0100dao.utDetailInfo(vo);
			}
		}
		return 0;
	}
}
