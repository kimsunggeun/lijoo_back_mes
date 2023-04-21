package kr.co.igns.business.sales.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.igns.business.sales.dao.postgre.Sal0140Dao;
import kr.co.igns.business.sales.model.sal0140.Mat0020Dto;
import kr.co.igns.business.sales.model.sal0140.Sal0120CountReqDto;
import kr.co.igns.business.sales.model.sal0140.Sal0120ReqDto;
import kr.co.igns.business.sales.model.sal0140.Sal0120VO;
import kr.co.igns.business.sales.model.sal0140.Sal0140ReqDto;
import kr.co.igns.business.sales.model.sal0140.Sal0140VO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Sal0140Service{

	private final Sal0140Dao sal0140Dao;
	
	//출하정보상세 조회
	public List<Sal0120VO> getSal0120(Sal0120ReqDto reqDto) {
		List<Sal0120VO> list = sal0140Dao.getSal0120(reqDto);
        return list;
    }
	
	//반품내역 조회
	public List<Sal0140VO> getSal0140(Sal0140ReqDto reqDto) {
		List<Sal0140VO> list = sal0140Dao.getSal0140(reqDto);
        return list;
    }
		
	//반품등록 
	@Transactional
	public int insertSal0140(List<Sal0140VO> voList) throws Exception{
		int result = 0;
		try {
			String retNo = sal0140Dao.getRetNo(voList.get(0));
			for(Sal0140VO vo : voList) {
				//반품등록 정보 세팅
				String retLotDetail = sal0140Dao.getRetLotDetail(vo);
				vo.setRetLotDetail(retLotDetail);
				vo.setRetNo(retNo);
				//반품등록 테이블 삽입
				sal0140Dao.insertSal0140(vo);
				//창고 정보 수정을 위한 DTO
				Mat0020Dto dto = Mat0020Dto.builder()
						.comCode(vo.getComCode())
						.facCode(vo.getFacCode())
						.locCode(vo.getLocCode())
						.partNo(vo.getPartNo())
						.lotNo(vo.getLotNo())
						.lotDetail(retLotDetail)
						.stockQty(vo.getRetQty())
						.stockAmount(String.valueOf(Integer.parseInt(vo.getPrice()) * Integer.parseInt(vo.getRetQty())))
						.maker(vo.getMaker())
						.editor(vo.getMaker())
						.build();
				//창고 정보 수정
				sal0140Dao.upsertMat0020(dto);
				sal0140Dao.insertMat0021(dto);
			}
			result = 1;
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return result;
	}
	
	//반품내역삭제
	@Transactional
	public int deleteSal0140(List<Sal0140VO> voList) throws Exception{
		int result=0;
		try {
			for(Sal0140VO vo : voList) {
				//출하정보 삭제
				sal0140Dao.deleteSal0140(vo);
				//창고 정보 수정을 위한 DTO
				String price = sal0140Dao.getPrice(vo);
				Mat0020Dto dto = Mat0020Dto.builder()
						.comCode(vo.getComCode())
						.facCode(vo.getFacCode())
						.locCode(vo.getLocCode())
						.partNo(vo.getPartNo())
						.lotNo(vo.getLotNo())
						.lotDetail(vo.getLotDetail())
						.retLotDetail(vo.getRetLotDetail())
						.stockQty(String.valueOf(Integer.parseInt(vo.getRetQty()) * -1))
						.stockAmount(String.valueOf(Integer.parseInt(price) * Integer.parseInt(vo.getRetQty()) * -1))
						.editor(vo.getMaker())
						.build();
				//재고정보 마스터 수정
				sal0140Dao.updateMat0020(dto);
				//재고정보 상세 삭제
				sal0140Dao.deleteMat0021(dto);
			}
			result = 1;
		}catch(Exception e) {
			System.out.println(e);
			throw new Exception(e.getMessage());
		}
		return result;
	}
	
	//출하등록 수치를 변경하기위한 조회
	public int updateSal0120(Sal0120CountReqDto reqDto) {
		int result = 0;
		try {
			sal0140Dao.updateSal0140(reqDto);
			result = 1;
		}catch(Exception e) {
			result = -1;
			e.printStackTrace();
		}
		return result;
		
	}
}
