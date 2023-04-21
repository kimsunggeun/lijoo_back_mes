package kr.co.igns.business.mat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.igns.business.mat.dao.postgre.Mat0250Dao;
import kr.co.igns.business.mat.model.mat0250.Mat0014ReqDto;
import kr.co.igns.business.mat.model.mat0250.Mat0014VO;
import kr.co.igns.business.mat.model.mat0250.Mat0250ReqDto;
import kr.co.igns.business.mat.model.mat0250.Mat0250VO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Mat0250Service {
	
	private final Mat0250Dao mat0250Dao;
	
	//자재관리-현황관리-기타/사급자재현황 조회
	public List<Mat0250VO> getMat0250(Mat0250ReqDto reqDto) {
		List<Mat0250VO> result = new ArrayList<Mat0250VO>(); 
		try {
			result = mat0250Dao.getMat0250(reqDto);
		}catch(Exception e) {
			e.printStackTrace();
		}

        return result;
    }
	
	public List<Mat0014VO> getMat0250Detail(Mat0014ReqDto reqDto){
		List<Mat0014VO> result = new ArrayList<Mat0014VO>();
		try {
			result = mat0250Dao.getMat0250Detail(reqDto);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
