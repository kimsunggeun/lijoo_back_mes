package kr.co.igns.business.qat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;
import kr.co.igns.business.qat.model.qat0120.Qat0120VO;
import kr.co.igns.business.qat.model.qat0120.Qat0120Dto;
import kr.co.igns.business.qat.dao.postgre.Qat0120Dao;
@Service
@RequiredArgsConstructor
public class Qat0120Service {
	private final Qat0120Dao qat0120dao;
	private final IgnsSessionUtils ignsSessionUtils;

	//불량현황 조회
	public List<Qat0120VO> getdefStatus(Qat0120Dto dto){
		List<Qat0120VO> list = qat0120dao.getdefStatus(dto);
		return list;
	}
	
	//불량현황상세 조회
	public List<Qat0120VO> getDefDetail(Qat0120Dto dto){
		List<Qat0120VO> list = qat0120dao.getDefDetail(dto);
		return list;
	}
	
	//불량수량상세 조회
	public List<Qat0120VO> getDefQtyDetail(Qat0120Dto dto){
		List<Qat0120VO> list = qat0120dao.getDefQtyDetail(dto);
		return list;
	}
		

	

}
