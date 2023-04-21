package kr.co.igns.business.baseInfo.bas0320.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.igns.business.baseInfo.bas0320.dao.postgre.Bas0320Dao;
import kr.co.igns.business.baseInfo.bas0320.model.Bas0320Dto;
import kr.co.igns.business.baseInfo.bas0320.model.Bas0320VO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Bas0320Service {
	
	private final Bas0320Dao bas0320dao;
	
	//환율정보관리 조회
	public List<Bas0320VO> getExrateInfoManage(Bas0320Dto dto){
		List<Bas0320VO> list = bas0320dao.getExrateInfoManage(dto);
		return list;
	}

	@Transactional(rollbackFor = Exception.class)
	public int setExrateInfoManage(Bas0320Dto dto) throws Exception {	
		
		int rtn = 0;

		String strUrl = "https://www.koreaexim.go.kr/site/program/financial/exchangeJSON?";
		strUrl += "authkey=" + "ZHRSGPLGcV6kob0iE11eoOk7QU16Oik5";
		//strUrl += "authkey=" + "2YwxfvaHv54Q7WYHhTZURrs5Ftma5pqQ"; //인증키 만료
		strUrl += "&searchdate=" + dto.getDtFrom();
		strUrl += "&data=AP01";

		URL url = new URL(strUrl);
		HttpURLConnection http = (HttpURLConnection)url.openConnection();

		System.out.println("strUrl " + strUrl);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream(),"UTF-8"));        	        
        String strJson = br.readLine();
        JSONArray jArr = new JSONArray(strJson);
        
        if (jArr.length() == 0)
        {
        	throw new Exception("DATA 없음.");
        }
        else if (jArr.length() == 1)
        {
        	JSONObject jobject = jArr.getJSONObject(0);
        	int resultCode = jobject.getInt("result");
        	if (resultCode == 2)
        	{        		
            	throw new Exception("DATA코드 오류");
        	}
        	else if (resultCode == 3)
        	{
            	throw new Exception("인증코드 오류");
        	}
        	else if (resultCode == 4)
        	{
            	throw new Exception("일일제한횟수 마감");
        	}
        }
        
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
				
		for (int i=0; i < jArr.length(); i++)
		{			
			JSONObject jobject = jArr.getJSONObject(i);
			Bas0320VO vo = new Bas0320VO();
			vo.setComCode(dto.getComCode());
			vo.setCurrDate(dto.getDtFrom());
			vo.setCurrCode(jobject.getString("cur_unit").substring(0, 3));
			vo.setPrice(Double.parseDouble(jobject.getString("deal_bas_r").replace(",", "")));
			vo.setMaker(loginId);

			rtn = bas0320dao.setExrateInfoManage(vo);
			rtn++;
		}
		
		return rtn;		
	}
}
