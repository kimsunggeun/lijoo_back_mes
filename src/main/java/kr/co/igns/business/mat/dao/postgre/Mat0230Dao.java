package kr.co.igns.business.mat.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.mat.model.mat0230.Mat0230ReqDto;
import kr.co.igns.business.mat.model.mat0230.Mat0230VO;

@Mapper
public interface Mat0230Dao {

	List<Mat0230VO> getMat0014_mat0230(Mat0230ReqDto reqDto);
	List<Mat0230VO> getMat0018_mat0230(Mat0230ReqDto reqDto);
}
