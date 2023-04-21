package kr.co.igns.business.ProdManage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.igns.business.ProdManage.dao.postgre.Pro0190Dao;
import kr.co.igns.business.ProdManage.model.pro0190.Pro0190ReqDto;
import kr.co.igns.business.ProdManage.model.pro0190.Pro0190VO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Pro0190Service {

	@Autowired
	private final Pro0190Dao pro0190Dao;
	
	//생산 실적현황  조회
	public List<Pro0190VO> getPro0190(Pro0190ReqDto reqDto) {
        return pro0190Dao.getPro0190(reqDto);
    }
}
