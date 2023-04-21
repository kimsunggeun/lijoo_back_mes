package kr.co.igns.business.sales.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.sales.model.sal0120.Sal0011VO;
import kr.co.igns.business.sales.model.sal0120.Sal0012VO;
import kr.co.igns.business.sales.model.sal0120.Sal0120ReqDto;
import kr.co.igns.business.sales.model.sal0120.Sal0120VO;

@Mapper
public interface Sal0120Dao {

	// 출하등록 정보 조회
	List<Sal0120VO> getSal0120(Sal0120ReqDto reqDto);
	// 출하현황 정보 조회
	List<Sal0120VO> getSal0120Status(Sal0120VO vo);
	//재고단가 조회
	String getPrice(Sal0120VO vo);	
	// 출하등록 정보 삽입
	int createSal0120(Sal0120VO vo);
	// 출하등록 정보 변경
	int updateSal0120(Sal0120VO vo);
	// 출하등록 정보 삭제
	int deleteSal0120(Sal0120VO vo);
	
	// 수주현황 조회 - 수주번호 기준
	List<Sal0012VO> getOrdStatusOnOrderNo(Sal0120ReqDto reqDto);
	// 수주현황 변경
	int updateOrdStatus(Sal0011VO vo);
	
	// 수주현황 조회 - 수주일 기준
	List<Sal0012VO> getOrdStatusOnOrderDate(Sal0120ReqDto reqDto);
	// 수주현황 조회 - 납기일 기준
	List<Sal0012VO> getOrdStatusOnDeliveryDate(Sal0120ReqDto reqDto);
	
	int updateMat0020(Sal0120VO vo);
	int updateMat0021(Sal0120VO vo);
	
	String getIlno(Sal0120VO vo);
	String getLocCode(Sal0120VO vo);
}
