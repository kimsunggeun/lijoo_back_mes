package kr.co.igns.business.mat.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.mat.model.mat0270.Mat0270ReqDto;
import kr.co.igns.business.mat.model.mat0270.Mat0270VO;

@Mapper
public interface Mat0270Dao {
	public List<Mat0270VO> getMat0270(Mat0270ReqDto reqDto);
}
