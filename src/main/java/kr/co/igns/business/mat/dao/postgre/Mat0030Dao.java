package kr.co.igns.business.mat.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.mat.model.mat0030.Mat0030ReqDto;
import kr.co.igns.business.mat.model.mat0030.Mat0012VO;
import kr.co.igns.business.mat.model.mat0030.Mat0018VO;

@Mapper
public interface Mat0030Dao {

	List<Mat0012VO> getMat0012(Mat0030ReqDto reqDto);

	int updateMat0011(Mat0012VO vo);
	int createMat0012(Mat0012VO vo);
	int updateMat0012(Mat0012VO vo);
	int deleteMat0012(Mat0018VO vo);
	String getIlNo(Mat0012VO vo);
	String getLotDetail(Mat0012VO vo);
	String getLotDetail_mat0021(Mat0012VO vo);
	List<Mat0018VO> getMat0018(Mat0030ReqDto reqDto);
	int createMat0018(Mat0012VO vo);
	int updateMat0011(Mat0018VO vo);
	int updateMat0011_2(Mat0018VO vo);
	int updateMat0011_3(Mat0012VO vo);
	int updateMat0011_4(Mat0018VO vo);
	int updateMat0018(Mat0018VO vo);
	int deleteMat0018(Mat0018VO vo);
	String sumQty(Mat0018VO vo);
	
	String mat0020NullCheck(Mat0012VO vo);
	
	int createMat0020(Mat0012VO vo);
	int updateMat0020(Mat0012VO vo);
	int updateMat0020_2(Mat0018VO vo);
	int createMat0021(Mat0012VO vo);
	int deleteMat0021(Mat0018VO vo);
	int deleteQat0010(Mat0018VO vo);
	String getPrice(Mat0018VO vo);

}
