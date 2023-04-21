package kr.co.igns.business.sales.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.sales.model.sal0130.Sal0130ReqDto;
import kr.co.igns.business.sales.model.sal0130.Sal0130VO;
import kr.co.igns.business.sales.model.sal0130.SalOutStatusDto;

@Mapper
public interface Sal0130Dao {

	List<Sal0130VO> getSal0130(Sal0130ReqDto reqDto);
	List<Sal0130VO> getOutStatus(SalOutStatusDto dto);
	//출하검사 검사내역 조회
	List<Sal0130VO> getInspection(SalOutStatusDto dto);
	
	int createSal0130(Sal0130VO vo);
	int updateSal0130(Sal0130VO vo);
	int delSal0130(Sal0130VO vo);
}
