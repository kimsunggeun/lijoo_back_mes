package kr.co.igns.business.mat.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.mat.model.mat0020.Mat0020ReqDto;
import kr.co.igns.business.mat.model.mat0020.Mat0010VO;
import kr.co.igns.business.mat.model.mat0020.Mat0011VO;

@Mapper
public interface Mat0020Dao {
	List<Mat0010VO> getItemInfo2(Mat0020ReqDto reqDto);
	List<Mat0010VO> getMat0010(Mat0020ReqDto reqDto);
	List<Mat0010VO> nullCheck_Mat0011(Mat0010VO vo);
	int createMat0010(Mat0010VO vo);
	int updateMat0010(Mat0010VO vo);
	int deleteMat0010(Mat0010VO vo);
	
	int confirmMat0010(Mat0010VO vo);
	int confirmCancelMat0010(Mat0010VO vo);
	
	List<Mat0011VO> getMat0011toOut0110(Mat0020ReqDto reqDto);
	String getMat0011byDate(Mat0020ReqDto reqDto);
	List<Mat0011VO> getMat0011(Mat0020ReqDto reqDto);
	
	int createMat0011(Mat0011VO vo);
	int updateMat0011(Mat0011VO vo);
	int deleteMat0011(Mat0011VO vo);
}
