package kr.co.igns.business.qat.service;

import java.util.List;

import org.springframework.stereotype.Service;


import kr.co.igns.business.qat.dao.postgre.Qat0110Dao;
import kr.co.igns.business.qat.model.qat0110.Qat0110Dto;
import kr.co.igns.business.qat.model.qat0110.Qat0110VO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Qat0110Service {
	
	private final Qat0110Dao qat0110dao;
	private final IgnsSessionUtils ignsSessionUtils;
	//납품정보 조회
	public List<Qat0110VO> getQat0010(Qat0110Dto dto){
		
		List<Qat0110VO> list = qat0110dao.getQat0010(dto);
		return list;
	}

}
