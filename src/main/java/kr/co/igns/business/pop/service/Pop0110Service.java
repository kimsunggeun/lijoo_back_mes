package kr.co.igns.business.pop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.igns.business.pop.dao.postgre.Pop0110Dao;
import kr.co.igns.business.pop.model.Pop0110ReqDto;
import kr.co.igns.business.pop.model.Pop0110VO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Pop0110Service {

	private final Pop0110Dao pop0110dao;
	
	//스캔
	public List<Pop0110VO> getPop0110(Pop0110ReqDto reqDto) {
        return pop0110dao.getPop0110(reqDto);
    }
	
	//
	public int setPop0110(List<Pop0110ReqDto> reqDto) {
			
		for(Pop0110ReqDto reqdto : reqDto) {
			pop0110dao.setPop0110(reqdto);
		}
		return 0;
	}
	
	
}
