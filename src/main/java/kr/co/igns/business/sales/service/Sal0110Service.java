package kr.co.igns.business.sales.service;


import java.util.List;

import org.json.JSONException;
import org.json.*;
import org.springframework.stereotype.Service;

import kr.co.igns.business.sales.dao.postgre.Sal0110Dao;
import kr.co.igns.business.sales.model.sal0110.Sal0110ReqDto;
import kr.co.igns.business.sales.model.sal0110.Sal0110VO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Sal0110Service{

	private final Sal0110Dao sal0110Dao;
	
	//출하계획등록 조회
	public JSONArray getSal0110(Sal0110ReqDto reqDto) {
		try {
		  //결과값 데이터와 휴일값 담기
		  JSONArray resultJobject = new JSONArray();      
		  resultJobject.put(new JSONArray(sal0110Dao.getSal0110(reqDto)));
		  resultJobject.put(new JSONArray(sal0110Dao.getBas0081(reqDto))); //월력 정보
			  
		  return resultJobject;
		  
		}catch(JSONException e) {
			e.printStackTrace();
			return new JSONArray(e.toString());
		}
    }
		
	//출하계획등록 입력/수정
	public int createSal0110(List<Sal0110VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();

		return 0;
    }
}
