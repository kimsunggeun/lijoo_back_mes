package kr.co.igns.business.pop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.igns.business.baseInfo.bas0210.dao.postgre.Bas0210Dao;
import kr.co.igns.business.baseInfo.bas0210.model.Bas0210Dto;
import kr.co.igns.business.mat.dao.postgre.Mat0210Dao;
import kr.co.igns.business.mat.model.mat0210.Mat0210ReqDto;
import kr.co.igns.business.mat.model.mat0210.Mat0210ReqDtoDetail;
import kr.co.igns.business.mat.model.mat0210.Mat0210VO;
import kr.co.igns.business.pop.dao.postgre.Pop0430Dao;

import kr.co.igns.business.pop.model.Pop0430ReqDto;
import kr.co.igns.business.pop.model.Pop0430VO;
import kr.co.igns.business.sales.model.sal0120.Sal0012VO;
import kr.co.igns.business.sales.model.sal0120.Sal0120ReqDto;
import kr.co.igns.business.sales.model.sal0120.Sal0120VO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Pop0430Service {
	
	private final Pop0430Dao pop0430Dao;
	private final Mat0210Dao mat0210Dao;
	private final Bas0210Dao bas0210Dao;
	
	// 조회
	public List<Pop0430VO> getPop0430(Pop0430ReqDto reqDto) {
		List<Pop0430VO> list = pop0430Dao.getPop0430(reqDto);
		return list;
	}
	
	// 등록
	@Transactional(rollbackFor = Exception.class)
	public int createPop0430(List<Pop0430VO> voPop0430List) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		
		for (Pop0430VO voPop0430 : voPop0430List)
		{
			Pop0430ReqDto reqDto = new Pop0430ReqDto();
			reqDto.setComCode(voPop0430.getComCode());
			reqDto.setPartNo(voPop0430.getPartNo());
			
			String strOutInsp = pop0430Dao.getOutInsp(reqDto);
			voPop0430.setOutInspYn(strOutInsp);
			voPop0430.setMaker(loginId.equals("") ? voPop0430.getMaker() : loginId);
			System.out.println("데이터 확인 :::::::::::::::::::::::::" + voPop0430);
			pop0430Dao.createPop0430(voPop0430);
		
			Mat0210ReqDto mat0210ReqDto = new Mat0210ReqDto();
			mat0210ReqDto.setComCode(voPop0430.getComCode());
			mat0210ReqDto.setFacCode(voPop0430.getFacCode());
			mat0210ReqDto.setLocCode(voPop0430.getLocCode());
			mat0210ReqDto.setPartNo(voPop0430.getPartNo());
			
			Mat0210VO voMat0210 = mat0210Dao.getStrictMat0210(mat0210ReqDto);
							
			int iMasterQty = Integer.parseInt(voMat0210.getStockQty()) - Integer.parseInt(voPop0430.getOutQty());				
			
			voMat0210.setStockQty(Integer.toString(iMasterQty));
			
			Bas0210Dto dtoBas0210 = new Bas0210Dto();
			dtoBas0210.setComCode(voPop0430.getComCode());
			dtoBas0210.setPartNo(voPop0430.getPartNo());				
			
			int iAveragePrice = 0;
			iAveragePrice = bas0210Dao.getAveragePrice(dtoBas0210);
			
			int iStockAmount = iMasterQty * iAveragePrice;
			voMat0210.setStockAmount(Integer.toString(iStockAmount));				
			
			voMat0210.setEditor(loginId.equals("") ? voPop0430.getEditor() : loginId);
			
			mat0210Dao.updateMat0210(voMat0210);
			
			Mat0210ReqDtoDetail voMat0210ReqDtoDetail = new Mat0210ReqDtoDetail();
			voMat0210ReqDtoDetail.setComCode(mat0210ReqDto.getComCode());
			voMat0210ReqDtoDetail.setFacCode(mat0210ReqDto.getFacCode());
			voMat0210ReqDtoDetail.setLocCode(mat0210ReqDto.getLocCode());
			voMat0210ReqDtoDetail.setPartNo(mat0210ReqDto.getPartNo());
			voMat0210ReqDtoDetail.setLotDetail(voPop0430.getLotDetail());
			
			Mat0210VO voMat0210Detail = mat0210Dao.getStrictMat0210Detail(voMat0210ReqDtoDetail);
			
			voMat0210Detail.setEventCd("70");		// 공통코드 -> EVENT_CD -> 70(기타출고)
			
			int iDetailQty = Integer.parseInt(voMat0210Detail.getStockQty()) - Integer.parseInt(voPop0430.getOutQty());									
			
			voMat0210Detail.setStockQty(Integer.toString(iDetailQty));
			
			int iDetailAmount = iAveragePrice * iDetailQty;
			voMat0210Detail.setStockAmount(Integer.toString(iDetailAmount));
			
			voMat0210Detail.setEditor(loginId.equals("") ? voMat0210.getMaker() : loginId);
			
			mat0210Dao.updateMat0210Detail(voMat0210Detail);
		}		
		
		return 0;
	}
	
	// 거래처별 품목 정보 조회
	public List<String> getItemListWithCustCode(Pop0430ReqDto reqDto) {
		List<String> list = pop0430Dao.getItemListWithCustCode(reqDto);
		return list;
	}
}
