package kr.co.igns.business.pop.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.igns.business.pop.model.Pop0420ReqDto;
import kr.co.igns.business.pop.model.Pop0420VO;


@Mapper
@Repository
public interface Pop0420Dao {
	// 수주번호 획득
	List<Pop0420VO> getPop0420OrderNo(Pop0420ReqDto reqDto); 
	
	// 전체 조회
	List<Pop0420VO> getPop0420UnPlannedShipmentInfo(Pop0420ReqDto reqDto);
}