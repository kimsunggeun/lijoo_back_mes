package kr.co.igns.business.mat.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.mat.model.mat0050.Mat0012ReqDto;
import kr.co.igns.business.mat.model.mat0050.Mat0012VO;
import kr.co.igns.business.mat.model.mat0050.Mat0018VO;
import kr.co.igns.business.mat.model.mat0050.Mat0021VO;
import kr.co.igns.business.mat.model.mat0050.Mat0030VO;

@Mapper
public interface Mat0050Dao {
	//반품등록 페이지 - 입고정보확인
	List<Mat0012VO> getMat0012(Mat0012ReqDto reqDto);
	List<Mat0012VO> getMat0013(Mat0012ReqDto reqDto);
	//반품등록 페이지 - 재고현황확인
	List<Mat0018VO> getMat0018(Mat0012VO reqDto);
	List<Mat0018VO> getMat0018_2(Mat0012VO reqDto);
	//반품등록 페이지 - 반품내역확인
	List<Mat0030VO> getMat0030(Mat0012VO reqDto);
	List<Mat0030VO> getMat0030_2(Mat0012VO reqDto);
	//반품등록 페이지 - 반품등록
	int insertMat0030(Mat0030VO vo);
	//반품등록 페이지 - 반품취소
	int deleteMat0030(Mat0030VO vo);
	//반품등록 후 재고현황 수정
	int updateMat0018(Mat0018VO vo);
	//반품등록 후 입고정보 수량 변경
	String updateMat0012(Mat0012VO vo);

	//반품등록 후 창고별 재고현황 수정
	Mat0021VO updateMat0021(Mat0030VO vo);
	int updateMat0020(Mat0021VO vo);
	
	//반품등록 페이지 재고현황 반품수량 수정
	int updateRetMat0018(Mat0030VO vo);
	int updateRetMat0014(Mat0030VO vo);

}
