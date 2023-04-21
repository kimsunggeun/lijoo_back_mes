package kr.co.igns.business.out.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.out.model.out0020.Out0020ReqDto;
import kr.co.igns.business.out.model.out0020.Out0020VO;

@Mapper
public interface Out0020Dao {

	List<Out0020VO> getOut0020(Out0020ReqDto reqDto);
	
	int createOut0020(Out0020VO vo);
	int updateOut0020(Out0020VO vo);
	
}
