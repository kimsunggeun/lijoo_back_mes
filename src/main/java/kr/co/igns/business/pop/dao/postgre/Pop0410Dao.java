package kr.co.igns.business.pop.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.igns.business.pop.model.Pop0410ReqDto;
import kr.co.igns.business.pop.model.Pop0410VO;

@Mapper
@Repository
public interface Pop0410Dao {
	// 수주번호 획득
	List<Pop0410VO> getPop0410OrderNo(Pop0410ReqDto reqDto); 
	
	// 출하일별 조회
	List<Pop0410VO> getPop0410PlannedShipmentInfo(Pop0410ReqDto reqDto);
}
