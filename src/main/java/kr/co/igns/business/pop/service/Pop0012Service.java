package kr.co.igns.business.pop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.igns.business.pop.dao.postgre.Pop0012Dao;
import kr.co.igns.business.pop.model.Pop0012VO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Pop0012Service {

	private static Pop0012Dao pop0012dao;
	
	public List<Pop0012VO> getPop0012(Pop0012VO vo) {
        return pop0012dao.getPop0012(vo);
    }
}
