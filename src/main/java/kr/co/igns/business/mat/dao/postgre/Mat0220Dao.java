package kr.co.igns.business.mat.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.mat.model.mat0210.Mat0210ReqDto;
import kr.co.igns.business.mat.model.mat0220.Mat0220ReqDto;
import kr.co.igns.business.mat.model.mat0220.Mat0220VO;

@Mapper
public interface Mat0220Dao {

	List<Mat0220VO> getMat0220(Mat0220ReqDto reqDto);

}
