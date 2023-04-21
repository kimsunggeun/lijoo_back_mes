package kr.co.igns.business.ProdManage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.igns.business.ProdManage.dao.postgre.Pro0160Dao;
import kr.co.igns.business.ProdManage.model.pro0160.Pro0160ReqDto;
import kr.co.igns.business.ProdManage.model.pro0160.Pro0160VO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Pro0160Service {

	@Autowired
	private final Pro0160Dao pro0160Dao;
	
	//생산 실적현황  조회
	public List<Pro0160VO> getPro0160(Pro0160ReqDto reqDto) {
        return pro0160Dao.getPro0160(reqDto);
    }
}
