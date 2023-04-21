package kr.co.igns.business.eqp.dao.postgre;

import java.util.List;

import kr.co.igns.business.eqp.model.eqp0100.Eqp0100Dto;
import kr.co.igns.business.eqp.model.eqp0100.Eqp0100VO;

public interface Eqp0100Dao {
	//조회
	List<Eqp0100VO> getMainList(Eqp0100Dto dto);
	List<Eqp0100VO> getReceiptDetailList(Eqp0100Dto dto);
	List<Eqp0100VO> getDeliDetailList(Eqp0100Dto dto);
	
	//저장
	int ctDetailInfo(Eqp0100VO vo);
	
	//수정
	int utDetailInfo(Eqp0100VO vo);
	int ctHeaderInfo(Eqp0100VO vo);
	int utHeaderInfo(Eqp0100VO vo);
}
