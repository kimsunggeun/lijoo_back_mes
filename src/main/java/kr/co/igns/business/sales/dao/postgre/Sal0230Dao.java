package kr.co.igns.business.sales.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.sales.model.sal0230.Sal0230ReqDto;
import kr.co.igns.business.sales.model.sal0230.Sal0230VO;


@Mapper
public interface Sal0230Dao {

	List<Sal0230VO> getSal0230(Sal0230ReqDto reqDto);
}
