package kr.co.igns.business.baseInfo.bas0310.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.igns.business.baseInfo.bas0310.dao.postgre.Bas0310Dao;
import kr.co.igns.business.baseInfo.bas0310.model.Bas0310PartDto;
import kr.co.igns.business.baseInfo.bas0310.model.Bas0310PriceDto;
import kr.co.igns.business.baseInfo.bas0310.model.Bas0310PriceVO;
import kr.co.igns.business.baseInfo.bas0310.model.Bas0310ReqDto;
import kr.co.igns.business.baseInfo.bas0310.model.Bas0310VO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Bas0310Service {
	
	private final Bas0310Dao bas0310dao;
	
	//거래처명 조회
	public List<Bas0310VO> getCustomName(Bas0310ReqDto reqDto){
		List<Bas0310VO> list = bas0310dao.getCustomName(reqDto);
		return list;
	}
	
	//품목정보 조회
	public List<Bas0310VO> getItemInfo(Bas0310ReqDto dto){ 
		return bas0310dao.getItemInfo(dto); 
	}
	
	//품목정보 마스터 리스트
	public List<Bas0310VO> getPartList(Bas0310ReqDto dto){ 
		return bas0310dao.getPartList(dto); 
	}
	
	//거래처별 품목 등록/수정
	public void setCustPart(List<Bas0310PartDto> partDto){ 
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		
		partDto.forEach(s -> {
			if(s.is__created__()) {
				s.setMaker(loginId.equals("") ? "" : loginId);
				s.setEditor(loginId.equals("") ? "" : loginId);
				bas0310dao.setCustPart(s);					
			} else if(s.is__modified__()) {
				s.setEditor(loginId.equals("") ? "" : loginId);
				bas0310dao.updateCustPart(s);
			}
		});
	}
	
	//거래처별 품목 삭제
	public void delCustPart(List<Bas0310ReqDto> reqDto){
		reqDto.forEach(s -> bas0310dao.delCustPart(s));
	}
	
	//단가정보 조회
	public List<Bas0310PriceVO> getPriceInfo(Bas0310ReqDto dto){
	  return bas0310dao.getPriceInfo(dto);
	}
	
	//단가정보 등록/수정
	public void setPriceInfo(List<Bas0310PriceDto> priceVO){
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		
		priceVO.forEach(s -> {
			if(s.is__created__()) {
				s.setMaker(loginId.equals("") ? "" : loginId);
				s.setEditor(loginId.equals("") ? "" : loginId);
				bas0310dao.createPriceInfo(s);					
			} else if(s.is__modified__()) {
				s.setEditor(loginId.equals("") ? "" : loginId);
				bas0310dao.updatePriceInfo(s);
			}
		});
	}
	
	//단가정보 삭제
	public void delPriceInfo(List<Bas0310PriceDto> reqDto){
		reqDto.forEach(s -> bas0310dao.delPriceInfo(s));
	}

}
