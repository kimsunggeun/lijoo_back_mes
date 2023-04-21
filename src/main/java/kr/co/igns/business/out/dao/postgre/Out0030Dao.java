package kr.co.igns.business.out.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.out.model.out0030.Out0030DelDto;
import kr.co.igns.business.out.model.out0030.Out0030ReqDto;
import kr.co.igns.business.out.model.out0030.Out0030VO;

@Mapper
public interface Out0030Dao {

	List<Out0030VO> getPro0026(Out0030ReqDto reqDto);
	List<Out0030VO> getOut0011(Out0030ReqDto reqDto);
	String getIlno(Out0030VO vo);
	String getSumQty(Out0030DelDto vo);
	int createOut0011(Out0030VO vo);
	int updatePro0026(Out0030VO vo);
	int deleteOut0011(Out0030DelDto vo);
	int updatePro0026_2(Out0030DelDto vo);
	
}
