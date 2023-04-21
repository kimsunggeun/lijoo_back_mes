package kr.co.igns.business.baseInfo.bas0260.dao.postgre;

import java.util.List;

import kr.co.igns.business.baseInfo.bas0260.model.Bas0260DetailVO;
import kr.co.igns.business.baseInfo.bas0260.model.Bas0260Dto;
import kr.co.igns.business.baseInfo.bas0260.model.Bas0260VO;

public interface Bas0260Dao {
	//조회
	List<Bas0260VO> getMainList(Bas0260Dto dto);
	List<Bas0260VO> getDetailList(Bas0260Dto dto);
	
	//저장
	int ctReserveStockInfo(Bas0260VO vo);
	int ctReserveStockDetailInfo(Bas0260DetailVO vo);
	
	//수정
	int utReserveStockInfo(Bas0260VO vo);
	int utReserveStockDetailInfo(Bas0260DetailVO vo);
	
	//삭제
	int deleteReserveStockInfo(Bas0260VO vo);
	int deleteReserveStockDetailInfo(Bas0260DetailVO vo);
}
