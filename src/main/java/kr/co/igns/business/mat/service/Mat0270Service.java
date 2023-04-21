package kr.co.igns.business.mat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.igns.business.mat.dao.postgre.Mat0270Dao;
import kr.co.igns.business.mat.model.mat0270.Mat0270ReqDto;
import kr.co.igns.business.mat.model.mat0270.Mat0270VO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Mat0270Service {
	
	private final Mat0270Dao mat0270Dao;
	
	//반품현황조회
	public List<Mat0270VO> getMat0270(Mat0270ReqDto reqDto){
		List<Mat0270VO> result = new ArrayList<Mat0270VO>();
		try {
			result = mat0270Dao.getMat0270(reqDto);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
