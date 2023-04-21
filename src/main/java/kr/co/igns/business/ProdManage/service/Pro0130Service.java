package kr.co.igns.business.ProdManage.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.co.igns.business.ProdManage.dao.postgre.Pro0130Dao;
import kr.co.igns.business.ProdManage.model.pro0130.Pro0130GridVO;
import kr.co.igns.business.ProdManage.model.pro0130.Pro0130ReqDto;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Pro0130Service {

	private final Pro0130Dao pro0130Dao;
	
	//pro0130(공정불량현황) 화면 조회
	public List<Pro0130GridVO> getPro0130(Pro0130ReqDto reqDto){
		List<Pro0130GridVO> result = new ArrayList<Pro0130GridVO>();
		try {
			result = pro0130Dao.getPro0130(reqDto);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
