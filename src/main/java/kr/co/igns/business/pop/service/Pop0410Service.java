package kr.co.igns.business.pop.service;

import java.util.List;

import org.springframework.stereotype.Service;


import kr.co.igns.business.pop.dao.postgre.Pop0410Dao;
import kr.co.igns.business.pop.model.Pop0410ReqDto;
import kr.co.igns.business.pop.model.Pop0410VO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Pop0410Service {
	
	private final Pop0410Dao pop0410; 
	
	// 수주번호 획득
	public List<Pop0410VO> getPop0410OrderNo(Pop0410ReqDto reqDto) {
		return pop0410.getPop0410OrderNo(reqDto);
	}
	
	// 출하일별 조회
	public List<Pop0410VO> getPop0410PlannedShipmentInfo(Pop0410ReqDto reqDto) {
        return pop0410.getPop0410PlannedShipmentInfo(reqDto);
    }

}
