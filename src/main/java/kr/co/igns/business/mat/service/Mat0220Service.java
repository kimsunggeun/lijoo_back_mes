package kr.co.igns.business.mat.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.igns.business.mat.dao.postgre.Mat0210Dao;
import kr.co.igns.business.mat.dao.postgre.Mat0220Dao;
import kr.co.igns.business.mat.model.mat0210.Mat0210ReqDto;
import kr.co.igns.business.mat.model.mat0220.Mat0220ReqDto;
import kr.co.igns.business.mat.model.mat0220.Mat0220VO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Mat0220Service{

	private final Mat0220Dao mat0220Dao;
	private final IgnsSessionUtils ignsSessionUtils;
	
	//재고정보(MASTER) 조회
	public List<Mat0220VO> getMat0220(Mat0220ReqDto reqDto) {
		List<Mat0220VO> list = mat0220Dao.getMat0220(reqDto);
        return list;
    }
}
