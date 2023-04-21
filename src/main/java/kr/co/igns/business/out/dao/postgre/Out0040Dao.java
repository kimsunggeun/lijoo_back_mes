package kr.co.igns.business.out.dao.postgre;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.mat.model.mat0070.TransRptSubVO;
import kr.co.igns.business.mat.model.mat0070.TransRptVO;
import kr.co.igns.business.out.model.out0040.MatOutputRptSubVO;
import kr.co.igns.business.out.model.out0040.MatOutputRptVO;
import kr.co.igns.business.out.model.out0040.Out0040ReqDto;
import kr.co.igns.business.out.model.out0040.Out0040VO;

@Mapper
public interface Out0040Dao {

	List<Out0040VO> getOut0011(Out0040ReqDto reqDto);
	
	int createOut0040(Out0040VO vo);
	int updateOut0040(Out0040VO vo);
	List<TransRptVO> getTransRptHeader(HashMap<String, Object> param);
	List<TransRptSubVO> getTransRptSub(HashMap<String, Object> param);
	MatOutputRptVO getMatOutputRptHeader(HashMap<String, Object> param);
	List<MatOutputRptSubVO> getMatOutputRptSub(HashMap<String, Object> param);
	
}
