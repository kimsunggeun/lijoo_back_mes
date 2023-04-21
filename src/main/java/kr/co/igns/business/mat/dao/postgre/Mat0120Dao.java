package kr.co.igns.business.mat.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.mat.model.mat0120.Mat0120ReqDto;
import kr.co.igns.business.mat.model.mat0120.Mat0120VO;

@Mapper
public interface Mat0120Dao {
	List<Mat0120VO> getMat0120(Mat0120ReqDto reqDto);
	List<Mat0120VO> getMat0120Detail(Mat0120ReqDto reqDto);
}
