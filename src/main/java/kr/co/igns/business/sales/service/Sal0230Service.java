package kr.co.igns.business.sales.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.igns.business.sales.dao.postgre.Sal0230Dao;
import kr.co.igns.business.sales.model.sal0230.Sal0230ReqDto;
import kr.co.igns.business.sales.model.sal0230.Sal0230VO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Sal0230Service {
	private final Sal0230Dao sal0230Dao;
	
	//출하반품현황 조회
	public List<Sal0230VO> getSal0230(Sal0230ReqDto reqDto) {
		List<Sal0230VO> list = sal0230Dao.getSal0230(reqDto);
        return list;
    }
}
