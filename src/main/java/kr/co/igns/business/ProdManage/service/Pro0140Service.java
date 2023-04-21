package kr.co.igns.business.ProdManage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.igns.business.ProdManage.dao.postgre.Pro0140Dao;
import kr.co.igns.business.ProdManage.model.pro0140.Pro0140ReqDto;
import kr.co.igns.business.ProdManage.model.pro0140.Pro0140VO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Pro0140Service {

	@Autowired
	private final Pro0140Dao pro0140Dao;
	
	//비가동현황  조회
	public List<Pro0140VO> getPro0140(Pro0140ReqDto reqDto) {
        return pro0140Dao.getPro0140(reqDto);
    }
}
