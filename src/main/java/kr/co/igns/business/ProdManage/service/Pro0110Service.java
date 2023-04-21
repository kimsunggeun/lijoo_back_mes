package kr.co.igns.business.ProdManage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.igns.business.ProdManage.dao.postgre.Pro0110Dao;
import kr.co.igns.business.ProdManage.model.pro0110.Pro0110ReqDto;
import kr.co.igns.business.ProdManage.model.pro0110.Pro0110VO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Pro0110Service {

	@Autowired
	private final Pro0110Dao pro0110Dao;
	
	//작업지시현황  조회
	public List<Pro0110VO> getPro0110(Pro0110ReqDto reqDto) {
        return pro0110Dao.getPro0110(reqDto);
    }
}
