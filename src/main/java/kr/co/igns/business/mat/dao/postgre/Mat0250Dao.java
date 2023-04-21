package kr.co.igns.business.mat.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.mat.model.mat0250.Mat0014ReqDto;
import kr.co.igns.business.mat.model.mat0250.Mat0014VO;
import kr.co.igns.business.mat.model.mat0250.Mat0250ReqDto;
import kr.co.igns.business.mat.model.mat0250.Mat0250VO;

@Mapper
public interface Mat0250Dao {
	
	public List<Mat0250VO> getMat0250(Mat0250ReqDto reqDto);
	public List<Mat0014VO> getMat0250Detail(Mat0014ReqDto reqDto);
}
