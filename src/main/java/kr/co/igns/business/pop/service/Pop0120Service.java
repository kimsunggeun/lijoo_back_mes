package kr.co.igns.business.pop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.igns.business.pop.dao.postgre.Pop0120Dao;
import kr.co.igns.business.pop.model.Pop0120ReqDto;
import kr.co.igns.business.pop.model.Pop0120VO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Pop0120Service {

	private final Pop0120Dao pop0120dao;
	
	//거래처별 전표번호
	public List<String> getinIlno(Pop0120ReqDto reqDto){
		return pop0120dao.getinIlno(reqDto);
	}
	
	//스캔
	public List<Pop0120VO> getPop0120(Pop0120ReqDto reqDto) {
        return pop0120dao.getPop0120(reqDto);
    }
	
	//공정외주입고-입고정보 저장
	public int setPop0120(List<Pop0120VO> voList) {
		for(Pop0120VO vo : voList) {
			pop0120dao.updatePop0120(vo);
			pop0120dao.insertPop0120(vo);
		}
		return 0;
	}
}
