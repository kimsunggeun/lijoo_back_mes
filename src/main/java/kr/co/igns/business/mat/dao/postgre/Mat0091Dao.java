package kr.co.igns.business.mat.dao.postgre;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.mat.model.mat0091.Mat0091ReqDto;

@Mapper
public interface Mat0091Dao {

	void createMat0091(Mat0091ReqDto reqDto);
	void deleteMat0091(Mat0091ReqDto reqDto);
	String getMat0091(Mat0091ReqDto reqDto);
}
