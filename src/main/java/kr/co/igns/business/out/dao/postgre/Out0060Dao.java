package kr.co.igns.business.out.dao.postgre;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.eqp.model.eqp0010.Eqp0010DetailVO;
import kr.co.igns.business.eqp.model.eqp0010.Eqp0010Dto;
import kr.co.igns.business.eqp.model.eqp0010.Eqp0010VO;
import kr.co.igns.business.mat.model.mat0070.TransRptSubVO;
import kr.co.igns.business.mat.model.mat0070.TransRptVO;
import kr.co.igns.business.out.model.out0040.MatOutputRptSubVO;
import kr.co.igns.business.out.model.out0040.MatOutputRptVO;
import kr.co.igns.business.out.model.out0040.Out0040ReqDto;
import kr.co.igns.business.out.model.out0040.Out0040VO;
import kr.co.igns.business.out.model.out0060.Out0060DVO;
import kr.co.igns.business.out.model.out0060.Out0060ReqDto;
import kr.co.igns.business.out.model.out0060.Out0060VO;
import kr.co.igns.business.out.model.out0060.outMainRptVO;
import kr.co.igns.business.out.model.out0060.outSubRptVO;

@Mapper
public interface Out0060Dao {

	
	
	
	
	List<Out0060VO> getOut0060VO(Out0060ReqDto dto);
	List<Out0060DVO> geOut0060DVO(Out0060ReqDto dto);
	
	
	List<TransRptVO> getTransRptHeader(HashMap<String, Object> param);
	List<TransRptSubVO> getTransRptSub(HashMap<String, Object> param);
	
	
	
}
