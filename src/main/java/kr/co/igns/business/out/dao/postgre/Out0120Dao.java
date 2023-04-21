package kr.co.igns.business.out.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.out.model.out0120.Out0120ReqDto;
import kr.co.igns.business.out.model.out0120.Out0120VO;

@Mapper
public interface Out0120Dao {

	List<Out0120VO> getOut0120(Out0120ReqDto reqDto);
	String getOut0120byDate(Out0120ReqDto reqDto);
	
}
