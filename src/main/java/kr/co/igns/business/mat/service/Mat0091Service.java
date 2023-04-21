package kr.co.igns.business.mat.service;

import org.apache.ibatis.reflection.ExceptionUtil;
import org.json.JSONArray;
import org.json.JSONObject;
import org.postgresql.util.PSQLException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import kr.co.igns.business.ProdManage.dao.postgre.Pro0010Dao;
import kr.co.igns.business.ProdManage.model.pro0010.Pro0010ReqDto;
import kr.co.igns.business.mat.dao.postgre.Mat0091Dao;
import kr.co.igns.business.mat.model.mat0091.Mat0091ReqDto;
import kr.co.igns.framework.config.exception.ExceptionAdvice;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Mat0091Service{

	private final Mat0091Dao mat0091Dao;
	private final Pro0010Dao pro0010Dao;
	private final IgnsSessionUtils ignsSessionUtils;
	private final ExceptionAdvice exceptionAdvice;
	
	//자재소요량(생산계획기준) 생성
	public void createMat0091(Mat0091ReqDto reqDto) throws Exception {
		if(reqDto.is__created__()) {
			mat0091Dao.deleteMat0091(reqDto);
		}
		try {
			mat0091Dao.createMat0091(reqDto);
		} catch (Exception  e) {
			throw new Exception(e.getCause().getMessage().toString().split("\\.")[0]);
		}
		
    }
	
	//자재소요량(생산계획기준) 조회
	public JSONArray getMat0091(Mat0091ReqDto reqDto) {
		JSONArray jsonArrayTemp = new JSONArray(mat0091Dao.getMat0091(reqDto));
		JSONArray jsonArray = new JSONArray();
		JSONObject json = new JSONObject();
		int lackQtuTemp = jsonArrayTemp.getJSONObject(0).getInt("stock_qty");
		String partNoTemp = jsonArrayTemp.getJSONObject(0).getString("part_no");
		int count = 0;
		int id = 0;

		for (int i=0;i<jsonArrayTemp.length();i++) {
			JSONObject jsonObjectTemp = jsonArrayTemp.getJSONObject(i);
			
			if(jsonObjectTemp.getString("part_no").equals(partNoTemp)) {
				lackQtuTemp -= jsonObjectTemp.getInt("sum_qty");

				if(i == 0) {
					json.put("currQty"+count, jsonObjectTemp.getInt("stock_qty"));
					json.put("lackQty"+count, lackQtuTemp);
				} else {
					
					json.put("currQty"+count, json.getInt("lackQty"+(count-1)));
					json.put("lackQty"+count, lackQtuTemp);
				}
				
				json.put("reqQty"+count, jsonObjectTemp.getInt("reg_qty"));
				json.put("expQty"+count, jsonObjectTemp.getString("exp_qty"));
				
				if(i == jsonArrayTemp.length() - 1) {
					json.put("id", String.valueOf(id));
					json.put("comCode", jsonObjectTemp.getString("com_code"));
					json.put("facCode", jsonObjectTemp.getString("fac_code"));
					json.put("partNo", partNoTemp);
					json.put("fromDate", jsonObjectTemp.getString("from_date"));
					json.put("toDate", jsonObjectTemp.getString("to_date"));
					jsonArray.put(json);
				}
			} else {
				json.put("id", String.valueOf(id));
				json.put("comCode", jsonObjectTemp.getString("com_code"));
				json.put("facCode", jsonObjectTemp.getString("fac_code"));
				json.put("partNo", partNoTemp);
				json.put("fromDate", jsonObjectTemp.getString("from_date"));
				json.put("toDate", jsonObjectTemp.getString("to_date"));
				jsonArray.put(json);
				
				json = new JSONObject();
				count = 0;
				lackQtuTemp = jsonObjectTemp.getInt("stock_qty") - jsonObjectTemp.getInt("sum_qty");
				json.put("currQty"+count, jsonObjectTemp.getInt("stock_qty"));
				json.put("expQty"+count, jsonObjectTemp.getString("exp_qty"));
				json.put("reqQty"+count, jsonObjectTemp.getInt("reg_qty"));
				json.put("lackQty"+count, lackQtuTemp);
				partNoTemp = jsonObjectTemp.getString("part_no");
				
				id++;
			}
			
			if(count == 0)
				json.put("stockQty", jsonObjectTemp.getInt("stock_qty"));
			
			count++;
		} 
		
		Pro0010ReqDto dto = new Pro0010ReqDto();
		dto.setFrPlanDate(json.getString("fromDate"));
		dto.setToPlanDate(json.getString("toDate"));
		
		//결과값 데이터와 휴일값 담기
		JSONArray resultJobject = new JSONArray();      
		resultJobject.put(jsonArray);
		resultJobject.put(new JSONArray(pro0010Dao.getBas0081(dto))); //월력 정보
		
		return resultJobject;
	}
}
