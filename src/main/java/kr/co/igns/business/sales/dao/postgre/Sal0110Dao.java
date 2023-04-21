package kr.co.igns.business.sales.dao.postgre;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.sales.model.sal0110.Bas0081VO;
import kr.co.igns.business.sales.model.sal0110.Sal0110ReqDto;
import kr.co.igns.business.sales.model.sal0110.Sal0110VO;

@Mapper
public interface Sal0110Dao {

	String getSal0110(Sal0110ReqDto reqDto);
	List<Bas0081VO> getBas0081(Sal0110ReqDto reqDto);
	
	int createSal0110(Sal0110VO vo);
	int updateSal0110(Sal0110VO vo);
}
