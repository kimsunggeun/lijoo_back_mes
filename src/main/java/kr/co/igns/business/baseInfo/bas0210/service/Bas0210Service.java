package kr.co.igns.business.baseInfo.bas0210.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.igns.business.baseInfo.bas0210.dao.postgre.Bas0210Dao;
import kr.co.igns.business.baseInfo.bas0210.model.Bas0040VO;
import kr.co.igns.business.baseInfo.bas0210.model.Bas0041VO;
import kr.co.igns.business.baseInfo.bas0210.model.Bas0042VO;
import kr.co.igns.business.baseInfo.bas0210.model.Bas0043VO;
import kr.co.igns.business.baseInfo.bas0210.model.Bas0044VO;
import kr.co.igns.business.baseInfo.bas0210.model.Bas0045VO;
import kr.co.igns.business.baseInfo.bas0210.model.Bas0210Dto;
import kr.co.igns.business.baseInfo.bas0210.model.Bas0210VO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Bas0210Service {
	
	private final Bas0210Dao bas0210dao;
	private int result = 0;
	
	//품목선택 GET
	public List<Bas0040VO> getItemSelect(Bas0210Dto dto){
		List<Bas0040VO> list = bas0210dao.getItemSelect(dto);
		return list;
	}
	
	//품목정보 GET
	public List<Bas0040VO> getItemInfo(Bas0210Dto dto){
		List<Bas0040VO> list = bas0210dao.getItemInfo(dto);
		return list;
	}
	
	//경로유형 GET
	public List<Bas0041VO> getPathType(Bas0210Dto dto){
		List<Bas0041VO> list = bas0210dao.getPathType(dto);
		return list;
	}
	
	//경로정보 GET
	public List<Bas0042VO> getRouteInfo(Bas0210Dto dto){
		List<Bas0042VO> list = bas0210dao.getRouteInfo(dto);
		return list;
	}
	
	//BOM정보 GET
	public List<Bas0043VO> getBomInfo(Bas0210Dto dto){
		List<Bas0043VO> list = bas0210dao.getBomInfo(dto);
		return list;
	}
	
	//품목별거래처정보 GET
	public List<Bas0044VO> getItemCustomInfo(Bas0210Dto dto){
		List<Bas0044VO> list = bas0210dao.getItemCustomInfo(dto);
		return list;
	}
	
	//단가정보 GET
	public List<Bas0045VO> getPriceInfo(Bas0210Dto dto){
		List<Bas0045VO> list = bas0210dao.getPriceInfo(dto);
		return list;
	}
	
	//품목정보 입력
	public int saveItemInfo(Bas0040VO vo) {
		int dupleCode = bas0210dao.dupleItemCode(vo);
		if(dupleCode > 0) {
			result = -1;
		}else {
			System.out.println("vovovovo:"+vo);
			if(vo.getUserFlag().equals("ture")) {
				vo.setUserFlag("Y");
			}else {
				vo.setUserFlag("N");
			}
			String loginId = IgnsSessionUtils.getCurrentLoginUserCd();		
			vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
			bas0210dao.ctItemInfo(vo);
			result = 1;
		}
		
		return result;
	}
	
	//품목정보 수정
	public int updateItemInfo(List<Bas0040VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		for(Bas0040VO vo : voList) {
			vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
			result = bas0210dao.utItemInfo(vo);
		}		
		return result;
	}
	
	//경로유형 입력
	public int savePathType(List<Bas0041VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();		
		for(Bas0041VO vo : voList) {
			if(vo.is__created__()) {
				int dupleCode = bas0210dao.duplePathCode(vo);
				
				if(dupleCode > 0) {
					result = -1;
				}else {
					vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
					bas0210dao.ctPathType(vo);
					bas0210dao.ctPathInfo(vo);
					result = 1;
				}
			}else if(vo.is__modified__()) {
				vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
				result = bas0210dao.utPathType(vo);
				result = 1;
			}
		}
		return result;
	}
	
	//경로정보 수정
	public int updateRouteInfo(List<Bas0042VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();		
		for(Bas0042VO vo : voList) {
			vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
			result = bas0210dao.utRouteInfo(vo);
			result = 1;			
		}
		return result;
	}	

	//BOM정보 입력/수정
	public int saveBomInfo(List<Bas0043VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		for(Bas0043VO vo : voList) {
			if(vo.is__created__()) {
				int dupleCode = bas0210dao.dupleBomInfo(vo);
				
				if(dupleCode > 0) {
					result = -1;
				}else {
					vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
					bas0210dao.ctBomInfo(vo);
					result = 1;
				}
			}else if(vo.is__modified__()) {
				vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
				bas0210dao.utBomInfo(vo);
				result = 1;
			}
		}
		return result;
	}
	
	//품목별 거래처정보 입력/수정
	public int saveItemCustomInfo(List<Bas0044VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		for(Bas0044VO vo : voList) {
			if(vo.is__created__()) {
				int dupleCode = bas0210dao.dupleItemCustomInfo(vo);
				
				if(dupleCode > 0) {
					result = -1;
				}else {
					vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
					bas0210dao.ctItemCustomInfo(vo);
					result = 1;
				}				
			}else if(vo.is__modified__()) {
				vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
				bas0210dao.utItemCustomInfo(vo);
				result = 1;
			}
		}
		return result;
	}
	
	//단가정보 입력/수정
	public int savePriceInfo(List<Bas0045VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		for(Bas0045VO vo : voList) {
			if(vo.is__created__()) {
				
				String appStartDate = vo.getAppStartDate().length() >= 10 ? vo.getAppStartDate().substring(0,10) : "";
				String appEndDate = vo.getAppEndDate().length() >= 10 ? vo.getAppEndDate().substring(0,10) : "";
				vo.setAppStartDate(appStartDate);
				vo.setAppEndDate(appEndDate);
				
				int dupleCode = bas0210dao.duplePriceInfo(vo);
				int priceCnt = bas0210dao.getPriceCnt(vo);
				
				if(dupleCode > 0) {
					result = -1;
				}else {					
					vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
					if(priceCnt > 0) {
						bas0210dao.utPriceDate(vo);
					}
					bas0210dao.ctPriceInfo(vo);
					result = 1;
				}
			}else if(vo.is__modified__()) {
				vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
				bas0210dao.utPriceInfo(vo);
				result = 1;
			}
		}
		return result;
	}
	
	//품목정보 삭제
	public int deleteItemInfo(List<Bas0040VO> voList) {
		for(Bas0040VO vo : voList) {
			int partNoChk = bas0210dao.getPartChk(vo);
			if(partNoChk > 0) {
				result = -1;
			}else {
				bas0210dao.dtItemInfo(vo);
				result = 1;
			}
		}
		return result;
	}
	
	//경로유형 삭제
	public int deletePathType(List<Bas0041VO> voList) {
		for(Bas0041VO vo : voList) {
			bas0210dao.dtPathType(vo);
			bas0210dao.dtPathInfo(vo);
		}
		return 0;
	}
	
	//BOM정보 삭제
	public int deleteBomInfo(List<Bas0043VO> voList) {
		for(Bas0043VO vo : voList) {
			bas0210dao.dtBomInfo(vo);
		}
		return 0;
	}
	
	//품목별 거래처 정보 삭제
	public int deleteCustomInfo(List<Bas0044VO> voList) {
		for(Bas0044VO vo : voList) {
			int priceChk = bas0210dao.getPriceChk(vo);
			if(priceChk > 0) {
				result = -1;
			}else {
				bas0210dao.dtItemCustomInfo(vo);
				result = 1;
			}			
		}
		return result;
	}
	
	//단가 정보 삭제
	public int deletePriceInfo(List<Bas0045VO> voList) {
		for(Bas0045VO vo : voList) {
			bas0210dao.dtPriceInfo(vo);
		}
		return 0;
	}
	
	//경로명 가져오기
	public List<Bas0210VO> getPathCode(Bas0210Dto dto){
		List<Bas0210VO> list = bas0210dao.getPathCode(dto);
		return list;
	}
	
	//입고창고명 가져오기
	public List<Bas0210VO> getInWhcode(Bas0210Dto dto){
		List<Bas0210VO> list = bas0210dao.getInWhcode(dto);
		return list;
	}
	
	//거래처명 가져오기
	public List<Bas0210VO> getCustCode(Bas0210Dto dto){
		List<Bas0210VO> list = bas0210dao.getCustCode(dto);
		return list;
	}
	
	//거래처명 가져오기
	public List<Bas0210VO> getProCode(Bas0210Dto dto){
		List<Bas0210VO> list = bas0210dao.getProCode(dto);
		return list;
	}
	
	//[팝업] 거래처 정보 가져오기
	public List<Bas0210VO> getCustPop(Bas0210Dto dto){
		List<Bas0210VO> list = bas0210dao.getCustPop(dto);
		return list;
	}
}
