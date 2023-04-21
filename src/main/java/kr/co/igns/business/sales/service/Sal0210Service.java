package kr.co.igns.business.sales.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.igns.business.sales.dao.postgre.Sal0210Dao;
import kr.co.igns.business.sales.model.sal0210.Sal0210ReqDto;
import kr.co.igns.business.sales.model.sal0210.Sal0210VO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Sal0210Service{

	private final Sal0210Dao sal0210Dao;
	private final IgnsSessionUtils ignsSessionUtils;
	
	//수주진행현황 조회
	public List<Sal0210VO> getSal0210(Sal0210ReqDto reqDto) {
		List<Sal0210VO> list = sal0210Dao.getSal0210(reqDto);
        return list;
    }
}
