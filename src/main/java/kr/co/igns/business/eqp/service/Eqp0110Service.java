package kr.co.igns.business.eqp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.igns.business.eqp.dao.postgre.Eqp0110Dao;
import kr.co.igns.business.eqp.model.eqp0110.Eqp0110Dto;
import kr.co.igns.business.eqp.model.eqp0110.Eqp0110VO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Eqp0110Service{

	private final Eqp0110Dao eqp0110Dao;
	private final IgnsSessionUtils ignsSessionUtils;
	
	//계측기 마스터 조회
	public List<Eqp0110VO> getEqp0032(Eqp0110Dto dto) {
		List<Eqp0110VO> list = eqp0110Dao.getEqp0032(dto);
        return list;
    }
	
}
