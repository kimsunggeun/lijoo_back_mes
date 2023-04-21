package kr.co.igns.business.pop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.igns.business.pop.dao.postgre.Pop0011Dao;
import kr.co.igns.business.pop.model.Pop0011VO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Pop0011Service {

	private static Pop0011Dao pop0011dao;
	
	public List<Pop0011VO> getPop0011(Pop0011VO vo) {
        return pop0011dao.getPop0011(vo);
    }
}
