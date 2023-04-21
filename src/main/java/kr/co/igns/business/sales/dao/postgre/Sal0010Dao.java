package kr.co.igns.business.sales.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.sales.model.sal0010.Sal0010ReqDto;
import kr.co.igns.business.sales.model.sal0010.Sal0010VO;
import kr.co.igns.business.sales.model.sal0010.Sal0011VO;

@Mapper
public interface Sal0010Dao {

	List<Sal0010VO> getSal0010(Sal0010ReqDto reqDto);
	List<Sal0010VO> getItemInfo(Sal0010ReqDto reqDto);
	List<Sal0010VO> NullCheck_Sal0011(Sal0010VO vo);
	int createSal0010(Sal0010VO vo);
	int updateSal0010(Sal0010VO vo);
	int deleteSal0010(Sal0010VO vo);
	int confirmSal0010(Sal0010VO vo);
	int confirmCancelSal0010(Sal0010VO vo);
	
	List<Sal0011VO> getSal0011(Sal0010ReqDto reqDto);
	
	int createSal0011(Sal0011VO vo);
	int updateSal0011(Sal0011VO vo);
	int deleteSal0011(Sal0011VO vo);
	
	int outQtyCheck(Sal0011VO vo);
	
	
}
