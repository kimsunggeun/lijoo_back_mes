package kr.co.igns.business.mat.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.igns.business.mat.dao.postgre.Mat0120Dao;
import kr.co.igns.business.mat.model.mat0120.Mat0120ReqDto;
import kr.co.igns.business.mat.model.mat0120.Mat0120VO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Mat0120Service {

	private final Mat0120Dao mat0120Dao;
	
	//재고실사 현황 마스터 조회
	public List<Mat0120VO> getMat0120(Mat0120ReqDto reqDto) {
		List<Mat0120VO> list = mat0120Dao.getMat0120(reqDto);
		return list;
	}
	
	//재고실사 현황 상세 조회
	public List<Mat0120VO> getMat0120Detail(Mat0120ReqDto reqDto) {
		List<Mat0120VO> list = mat0120Dao.getMat0120Detail(reqDto);
		return list;
	}
}
