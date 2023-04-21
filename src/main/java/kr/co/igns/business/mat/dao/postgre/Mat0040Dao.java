package kr.co.igns.business.mat.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.mat.model.mat0040.Mat0040ReqDto;
import kr.co.igns.business.mat.model.mat0040.Mat0013VO;
import kr.co.igns.business.mat.model.mat0040.Mat0014VO;

@Mapper
public interface Mat0040Dao {

	List<Mat0013VO> getFacCode(Mat0040ReqDto reqDto);
	List<Mat0013VO> getMat0013(Mat0040ReqDto reqDto);
	List<Mat0013VO> getPartNo(Mat0040ReqDto reqDto);
	int createMat0013(Mat0013VO vo);
	int updateMat0013(Mat0013VO vo);
	int deleteMat0013(Mat0013VO vo);
	List<Mat0014VO> getMat0014(Mat0040ReqDto reqDto);
	
	String getIlno(Mat0013VO vo);
	
	int createMat0014(Mat0013VO vo);
	int updateMat0014(Mat0013VO vo);
	int deleteMat0014(Mat0013VO vo);
	
	//재고마스터
	int createMat0020(Mat0013VO vo);
	int createMat0021(Mat0013VO vo);
	String getPrice(Mat0013VO vo);
	String getLotDetail(Mat0013VO vo);
	
	int updateMat0020(Mat0013VO vo);
	int updateMat0020_2(Mat0013VO vo);
	int deleteMat0021(Mat0013VO vo);
	String sumQty(Mat0013VO vo);
	String getInAmount(Mat0013VO vo);
	String mat0020NullCheck(Mat0013VO vo);
	
	//입고창고GET
	List<Mat0013VO> getInWh(Mat0013VO vo);
	
}
