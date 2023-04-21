package kr.co.igns.business.ProdManage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.igns.business.ProdManage.dao.postgre.Pro0120Dao;
import kr.co.igns.business.ProdManage.model.pro0120.Pro0120ReqDto;
import kr.co.igns.business.ProdManage.model.pro0120.Pro0120VO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Pro0120Service {

	@Autowired
	private final Pro0120Dao pro0120Dao;
	
	//생산실적현황  조회
	public List<Pro0120VO> getPro0120(Pro0120ReqDto reqDto) {
        return pro0120Dao.getPro0120(reqDto);
    }
	//생산실적현황  조회
		public List<Pro0120VO> getWorkDecode(Pro0120ReqDto reqDto) {
	        return pro0120Dao.getWorkDecode(reqDto);
	    }

}
