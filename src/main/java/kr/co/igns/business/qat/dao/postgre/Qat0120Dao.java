package kr.co.igns.business.qat.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.qat.model.qat0120.Qat0120VO;
import kr.co.igns.business.qat.model.qat0120.Qat0120Dto;

@Mapper
public interface Qat0120Dao {
	//불량현황 조회
	List<Qat0120VO> getdefStatus(Qat0120Dto dto);
	//불량상세정보 조회
	List<Qat0120VO> getDefDetail(Qat0120Dto dto);
	//불량수량상세정보 조회
	List<Qat0120VO> getDefQtyDetail(Qat0120Dto dto);
}
