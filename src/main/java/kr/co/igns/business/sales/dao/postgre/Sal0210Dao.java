package kr.co.igns.business.sales.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.sales.model.sal0210.Sal0210ReqDto;
import kr.co.igns.business.sales.model.sal0210.Sal0210VO;

@Mapper
public interface Sal0210Dao {

	List<Sal0210VO> getSal0210(Sal0210ReqDto reqDto);
}
