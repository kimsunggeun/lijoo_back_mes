package kr.co.igns.business.pop.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.pop.model.Pop0110ReqDto;
import kr.co.igns.business.pop.model.Pop0110VO;

@Mapper
public interface Pop0110Dao {
	List<Pop0110VO> getPop0110(Pop0110ReqDto reqDto);
	
	int setPop0110(Pop0110ReqDto reqDto);
}
