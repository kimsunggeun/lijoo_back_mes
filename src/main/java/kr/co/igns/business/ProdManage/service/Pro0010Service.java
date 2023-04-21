package kr.co.igns.business.ProdManage.service;

import java.util.List;

import org.json.*;
import org.springframework.stereotype.Service;

import kr.co.igns.business.ProdManage.dao.postgre.Pro0010Dao;
import kr.co.igns.business.ProdManage.model.pro0010.Bas0040ReqDto;
import kr.co.igns.business.ProdManage.model.pro0010.Bas0040VO;
import kr.co.igns.business.ProdManage.model.pro0010.Pro0010ReqDto;
import kr.co.igns.business.ProdManage.model.pro0010.Pro0010VO;
import kr.co.igns.business.ProdManage.model.pro0050.Pro0050VO;
import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
@Service
public class Pro0010Service {

	private final Pro0010Dao pro0010Dao;
	
	//생산계획등록 조회
	public JSONArray getPro0010(Pro0010ReqDto reqDto) {
		try {
		  //결과값 데이터와 휴일값 담기
		  JSONArray resultJobject = new JSONArray();      
		  resultJobject.put(new JSONArray(pro0010Dao.getPro0010(reqDto)));
		  resultJobject.put(new JSONArray(pro0010Dao.getBas0081(reqDto))); //월력 정보
			  
		  return resultJobject;
		  
		}catch(JSONException e) {
			e.printStackTrace();
			return new JSONArray(e.toString());
		}
    }
	
	//작업지시  조회
	public List<Pro0050VO> getPro0010Detail(Pro0010ReqDto reqDto) {
        return pro0010Dao.getPro0010Detail(reqDto);
    }
	
	//작지대상품목 삽입/수정
	public int upsertPro0010(List<Pro0010VO> voList) {
		int result = 0;
		try {
			for(Pro0010VO vo : voList) {
				pro0010Dao.upsertPro0010(vo);
			}
			result = 1;
		}catch(Exception e) {
			e.printStackTrace();
			result = -1;
		}
		return result;
	}
	
	//작지대상품목 삭제
	public int deletePro0010(List<Pro0010VO> voList) {
		int result = 0;
		try {
			for(Pro0010VO vo : voList) {
				pro0010Dao.deletePro0010(vo);
			}
			result = 1;
		}catch(Exception e) {
			e.printStackTrace();
			result = -1;
		}
		return result;
	}
	
	public List<Bas0040VO> getBas0040(Bas0040ReqDto reqDto){
		return pro0010Dao.getBas0040(reqDto);
	}
}
