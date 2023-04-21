package kr.co.igns.business.sales.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.igns.business.baseInfo.bas0210.dao.postgre.Bas0210Dao;

import kr.co.igns.business.sales.dao.postgre.Sal0120Dao;
import kr.co.igns.business.sales.model.sal0120.Sal0012VO;
import kr.co.igns.business.sales.model.sal0120.Sal0120ReqDto;
import kr.co.igns.business.sales.model.sal0120.Sal0120VO;
import kr.co.igns.business.sales.model.sal0120.Sal0011VO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Sal0120Service{

	private final Sal0120Dao sal0120Dao;
	private final Bas0210Dao bas0210Dao;
	private final IgnsSessionUtils ignsSessionUtils;
	
	//출하등록 정보 조회
	public List<Sal0120VO> getSal0120(Sal0120ReqDto reqDto) {
		List<Sal0120VO> list = sal0120Dao.getSal0120(reqDto);		
        return list;
    }
	
	//출하현황 정보 조회
	public List<Sal0120VO> getSal0120Status(Sal0120VO vo) {
		List<Sal0120VO> list = sal0120Dao.getSal0120Status(vo);
		
		System.out.println(String.format("result count : %d", list.size()));
		
		for (Sal0120VO res : list)
		{		
			System.out.println(String.format("ord_no:%s, ord_turn:%s, ilno:%s, no:%s, out_date:%s, cust_name:%s, part_no:%s, lot_detail:%s",
					res.getOrdNo(), res.getOrdTurn(), res.getIlno(), res.getNo(), res.getOutDate(), res.getCustName(), res.getPartNo(), res.getLotDetail()));
		}
		
        return list;
    }	
		
	//출하등록 삽입
	@Transactional(rollbackFor = Exception.class)
	public int createSal0120(List<Sal0120VO> voSal0120List) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		
		//출하번호 생성
		String ilno = sal0120Dao.getIlno(voSal0120List.get(0));
		int iShipmentNo = 0;
		
		for (Sal0120VO voSal0120 : voSal0120List)
		{
			//set maker
			voSal0120.setMaker(loginId.equals("") ? voSal0120.getMaker() : loginId);
			
			//출하일련번호, 출하순번 셋팅
			voSal0120.setIlno(ilno);
			voSal0120.setNo(Integer.toString(++iShipmentNo));
			
			//재고단가, 금액을 가져와 셋팅한다.
			voSal0120.setPrice(voSal0120.getPrice());
			voSal0120.setAmount(String.valueOf(Integer.parseInt(voSal0120.getOutQty()) * Integer.parseInt(voSal0120.getPrice())));
			
			if (voSal0120.getOutInspYn().equals("") == true)
				voSal0120.setOutInspYn("N");
			
			//출하등록 sal0120
			System.out.println("출하데이터 확인 :::::::::::::::::::::: " + voSal0120);
			sal0120Dao.createSal0120(voSal0120);
			
			//상세 재고량 업데이트 (수량, 금액)
			sal0120Dao.updateMat0020(voSal0120);
			sal0120Dao.updateMat0021(voSal0120);
			
			//주문 상세 정보 수정을 위한 VO
			Sal0011VO vo = Sal0011VO.builder()
					.comCode(voSal0120.getComCode())
					.facCode(voSal0120.getFacCode())
					.ordNo(voSal0120.getOrdNo())
					.no(voSal0120.getOrdTurn())
					.outQty(voSal0120.getOutQty())
					.nowQty(String.valueOf(Integer.parseInt(voSal0120.getOutQty()) * -1))
					.build();
			
			//고객주문상세 출하량, 잔량)
			System.out.println("최종 확인 :::::::::::::::::::::: " + vo);
			sal0120Dao.updateOrdStatus(vo); 
		}
		
		return 0;	
	}
		
	//출하등록 삭제
	@Transactional(rollbackFor = Exception.class)
	public int deleteSal0120(List<Sal0120VO> voSal0120List) {
		for (Sal0120VO voSal0120 : voSal0120List)
		{
			//창고코드 조회 및 세팅
			String locCode = sal0120Dao.getLocCode(voSal0120);
			voSal0120.setLocCode(locCode);
			//출하등록 테이블 삭제
			sal0120Dao.deleteSal0120(voSal0120);
			//상세 재고량 업데이트 (수량, 금액)
			voSal0120.setOutQty(String.valueOf(Integer.parseInt(voSal0120.getQty()) * -1));
			voSal0120.setAmount(String.valueOf(Integer.parseInt(voSal0120.getStockAmount()) * -1));
			System.out.println("삭제할때 데이터 :::::::::::::::: " + voSal0120);
			sal0120Dao.updateMat0021(voSal0120);
			sal0120Dao.updateMat0020(voSal0120);
			//상세 정보 수정을 위한 VO
			Sal0011VO vo = Sal0011VO.builder()
					.comCode(voSal0120.getComCode())
					.facCode(voSal0120.getFacCode())
					.ordNo(voSal0120.getOrdNo())
					.no(voSal0120.getOrdTurn())
					.outQty(voSal0120.getOutQty())
					.build();
			//고객주문상세 (출하량, 잔량)
			sal0120Dao.updateOrdStatus(vo);
		}
		return 0;
	}
			
	//수주현황 조회 - 납기일 기준
	public List<Sal0012VO> getOrdStatusOnDeliveryDate(Sal0120ReqDto reqDto){
		List<Sal0012VO> list = sal0120Dao.getOrdStatusOnDeliveryDate(reqDto);
		return list;
	}	
	
	//수주현황 조회 - 수주일 기준
	public List<Sal0012VO> getOrdStatusOnOrderDate(Sal0120ReqDto reqDto){
		List<Sal0012VO> list = sal0120Dao.getOrdStatusOnOrderDate(reqDto);
		return list;
	}
}
