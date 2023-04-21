package kr.co.igns.business.sales.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.sales.model.sal0150.Sal0150ReqDto;
import kr.co.igns.business.sales.model.sal0150.Sal0120VO;

@Mapper
public interface Sal0150Dao {

	List<Sal0120VO> getSal0150(Sal0150ReqDto reqDto);
	
	int updateSal0150(Sal0120VO vo);
}
