package kr.co.igns.business.out.service;

import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.igns.business.out.dao.postgre.Out0120Dao;
import kr.co.igns.business.out.model.out0120.Out0120ReqDto;
import kr.co.igns.business.out.model.out0120.Out0120VO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Out0120Service {
	
	@Autowired
	private final Out0120Dao out0120Dao;
	
	//기간별공정외주입고현황 조회
	public List<Out0120VO> getOut0120(Out0120ReqDto reqDto) {
        return out0120Dao.getOut0120(reqDto);
    }
	
	//기간별공정외주입고현황 - 일자별조회 조회
	public JSONArray getOut0120byDate(Out0120ReqDto reqDto) {
		JSONArray resultJobject = new JSONArray();
		resultJobject.put(new JSONArray(out0120Dao.getOut0120byDate(reqDto)));
		return resultJobject;
	}
}