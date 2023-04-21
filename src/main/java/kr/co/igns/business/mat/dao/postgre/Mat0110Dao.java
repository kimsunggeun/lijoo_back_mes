package kr.co.igns.business.mat.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.mat.model.mat0110.Mat0110ReqDto;
import kr.co.igns.business.mat.model.mat0110.Mat0110VO;

@Mapper
public interface Mat0110Dao {

	List<Mat0110VO> getMat0110(Mat0110ReqDto reqDto);
	
	int insertMat0110(Mat0110VO vo);
	
	List<Mat0110VO> getMat0110FromLotDetail(Mat0110VO vo);
}
