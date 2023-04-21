package kr.co.igns.business.mat.dao.postgre;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.mat.model.mat0070.Mat0070ReqDto;
import kr.co.igns.business.mat.model.mat0070.TransRptSubVO;
import kr.co.igns.business.mat.model.mat0070.Mat0012VO;
import kr.co.igns.business.mat.model.mat0070.Mat0018VO;
import kr.co.igns.business.mat.model.mat0070.TransRptVO;

@Mapper
public interface Mat0070Dao {

	List<Mat0012VO> getMat0012(Mat0070ReqDto reqDto);
	List<Mat0018VO> getMat0018(Mat0070ReqDto reqDto);
	List<TransRptVO> getTransRptHeader(HashMap<String, Object> param);
	List<TransRptSubVO> getTransRptSub(HashMap<String, Object> param);

}
