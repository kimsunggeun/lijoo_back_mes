package kr.co.igns.business.pop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.igns.business.pop.dao.postgre.Pop0420Dao;
import kr.co.igns.business.pop.model.Pop0420ReqDto;
import kr.co.igns.business.pop.model.Pop0420VO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Pop0420Service {
	
	private final Pop0420Dao pop0420;
	
	// 수주번호 획득
	public List<Pop0420VO> getPop0420OrderNo(Pop0420ReqDto reqDto) {
		return pop0420.getPop0420OrderNo(reqDto);
	}
	
	// 출하일별 조회
	public List<Pop0420VO> getPop0420UnPlannedShipmentInfo(Pop0420ReqDto reqDto) {
        return pop0420.getPop0420UnPlannedShipmentInfo(reqDto);
    }
}