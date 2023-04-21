package kr.co.igns.business.sales.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.igns.business.sales.dao.postgre.Sal0220Dao;
import kr.co.igns.business.sales.model.sal0220.Sal0220ReqDto;
import kr.co.igns.business.sales.model.sal0220.Sal0220VO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Sal0220Service{

	private final Sal0220Dao sal0220Dao;
	private final IgnsSessionUtils ignsSessionUtils;
	
	// 수주진행현황 조회
	public List<Sal0220VO> getSal0220(Sal0220ReqDto reqDto) {
		List<Sal0220VO> list = sal0220Dao.getSal0220(reqDto);
        return list;
    }
	
	// 기타출고현황 조회
	public List<Sal0220VO> getSal0220OtherRelease(Sal0220ReqDto reqDto) {
		List<Sal0220VO> list = sal0220Dao.getSal0220OtherRelease(reqDto);
		return list;
	}
	
	//출하등록 삭제
	@Transactional(rollbackFor = Exception.class)
	public int deleteSal0220OhterRelease(List<Sal0220VO> voSal0220List) {
		for (Sal0220VO voSal0220 : voSal0220List)
		{
			//창고코드 조회 및 세팅
			String locCode = sal0220Dao.getLocCode(voSal0220);
			voSal0220.setLocCode(locCode);
			//출하등록 테이블 삭제
			sal0220Dao.deleteSal0220OhterRelease(voSal0220);
			//상세 재고량 업데이트 (수량, 금액)
			voSal0220.setQty(String.valueOf(Integer.parseInt(voSal0220.getQty()) * -1));
			voSal0220.setAmount(String.valueOf(Integer.parseInt(voSal0220.getAmount()) * -1));
			System.out.println("삭제할때 데이터 :::::::::::::::: " + voSal0220);
			sal0220Dao.updateMat0021(voSal0220);
			sal0220Dao.updateMat0020(voSal0220);			
		}
		
		return 0;
	}
}
