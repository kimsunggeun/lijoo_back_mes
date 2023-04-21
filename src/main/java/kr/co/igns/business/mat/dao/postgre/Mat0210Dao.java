package kr.co.igns.business.mat.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.mat.model.mat0210.Mat0210ReqDto;
import kr.co.igns.business.mat.model.mat0210.Mat0210ReqDtoDetail;
import kr.co.igns.business.mat.model.mat0210.Mat0210VO;

@Mapper
public interface Mat0210Dao {

	List<Mat0210VO> getMat0210(Mat0210ReqDto reqDto);
	Mat0210VO getStrictMat0210(Mat0210ReqDto reqDto);
	int createMat0210(Mat0210VO vo);
	int updateMat0210(Mat0210VO vo);
	
	List<Mat0210VO> getMat0210Detail(Mat0210ReqDto reqDto);
	Mat0210VO getStrictMat0210Detail(Mat0210ReqDtoDetail reqDto);
	int createMat0210Detail(Mat0210VO vo);
	int updateMat0210Detail(Mat0210VO vo);
	
	String getLocCodeFromLotDetail(String strLotDetail);
}
