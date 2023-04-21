package kr.co.igns.business.pop.service;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.igns.business.pop.dao.postgre.Pop0350Dao;
import kr.co.igns.business.pop.model.Pop0350ReqDto;
import kr.co.igns.business.pop.model.Pop0350VO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Pop0350Service {

	private final Pop0350Dao pop0350Dao;

	//경로유형(조회조건) 조회
	public List<Pop0350VO> getPathCode(Pop0350ReqDto reqDto) {
        return pop0350Dao.getPathCode(reqDto);
    }
	//공정코드(조회조건) 조회
	public List<Pop0350VO> getProCode(Pop0350ReqDto reqDto) {
        return pop0350Dao.getProCode(reqDto);
    }
	
	//작업반(조회조건) 조회
	public List<Pop0350VO> getWorkDecode(Pop0350ReqDto reqDto) {
        return pop0350Dao.getWorkDecode(reqDto);
    }
	//작업반(LookUp) 조회
	public List<Pop0350VO> getWorkDecode2(Pop0350ReqDto reqDto) {
        return pop0350Dao.getWorkDecode2(reqDto);
    }
	
	//로트정보 추가
	@Transactional(rollbackFor = Exception.class)
	public int createPro0026(List<Pop0350VO> voList) throws Exception {
		
		for(Pop0350VO vo : voList) {		
			pop0350Dao.createPro0026(vo);
		}
		return 0;
	}
	
	
}	



