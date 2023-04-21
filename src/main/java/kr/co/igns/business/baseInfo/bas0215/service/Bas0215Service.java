package kr.co.igns.business.baseInfo.bas0215.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.igns.business.baseInfo.bas0215.dao.postgre.Bas0215Dao;
import kr.co.igns.business.baseInfo.bas0215.model.Bas0040VO;
import kr.co.igns.business.baseInfo.bas0215.model.Bas0041VO;
import kr.co.igns.business.baseInfo.bas0215.model.Bas0042VO;
import kr.co.igns.business.baseInfo.bas0215.model.Bas0043VO;
import kr.co.igns.business.baseInfo.bas0215.model.Bas0044VO;
import kr.co.igns.business.baseInfo.bas0215.model.Bas0045VO;
import kr.co.igns.business.baseInfo.bas0215.model.Bas0215Dto;
import kr.co.igns.business.baseInfo.bas0215.model.Bas0215VO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Bas0215Service {
	
	private final Bas0215Dao bas0215dao;
	private int result = 0;
	
	//품목선택 GET
	public List<Bas0040VO> getItemSelect(Bas0215Dto dto){
		List<Bas0040VO> list = bas0215dao.getItemSelect(dto);
		return list;
	}
	
	//품목정보 GET
	public List<Bas0040VO> getItemInfo(Bas0215Dto dto){
		List<Bas0040VO> list = bas0215dao.getItemInfo(dto);
		return list;
	}
	
	//경로유형 GET
	public List<Bas0041VO> getPathType(Bas0215Dto dto){
		List<Bas0041VO> list = bas0215dao.getPathType(dto);
		return list;
	}
	
	//경로정보 GET
	public List<Bas0042VO> getRouteInfo(Bas0215Dto dto){
		List<Bas0042VO> list = bas0215dao.getRouteInfo(dto);
		return list;
	}
	
	//BOM정보 GET
	public List<Bas0043VO> getBomInfo(Bas0215Dto dto){
		List<Bas0043VO> list = bas0215dao.getBomInfo(dto);
		return list;
	}
	
	//품목별거래처정보 GET
	public List<Bas0044VO> getItemCustomInfo(Bas0215Dto dto){
		List<Bas0044VO> list = bas0215dao.getItemCustomInfo(dto);
		return list;
	}
	
	//단가정보 GET
	public List<Bas0045VO> getPriceInfo(Bas0215Dto dto){
		List<Bas0045VO> list = bas0215dao.getPriceInfo(dto);
		return list;
	}
	
	//품목정보 입력
	public int saveItemInfo(Bas0040VO vo) {
		int dupleCode = bas0215dao.dupleItemCode(vo);
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
			bas0215dao.ctItemInfo(vo);
			result = 1;
		}
		
		return result;
	}
	
	//품목정보 수정
	public int updateItemInfo(List<Bas0040VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		for(Bas0040VO vo : voList) {
			vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
			result = bas0215dao.utItemInfo(vo);
		}		
		return result;
	}
	
	//경로유형 입력
	public int savePathType(List<Bas0041VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();		
		for(Bas0041VO vo : voList) {
			if(vo.is__created__()) {
				int dupleCode = bas0215dao.duplePathCode(vo);
				
				if(dupleCode > 0) {
					result = -1;
				}else {
					vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
					bas0215dao.ctPathType(vo);
					bas0215dao.ctPathInfo(vo);
					result = 1;
				}
			}else if(vo.is__modified__()) {
				vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
				result = bas0215dao.utPathType(vo);
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
			result = bas0215dao.utRouteInfo(vo);
			result = 1;			
		}
		return result;
	}	

	//BOM정보 입력/수정
	public int saveBomInfo(List<Bas0043VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		for (Bas0043VO vo : voList) {
			if (vo.is__created__()) {
				int dupleCode = bas0215dao.dupleBomInfo(vo);
				
				if (dupleCode > 0) {
					result = -1;
				} else {
					vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
					bas0215dao.ctBomInfo(vo);
					result = 1;
				}
			} else if (vo.is__modified__()) {
				vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
				bas0215dao.utBomInfo(vo);
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
				int dupleCode = bas0215dao.dupleItemCustomInfo(vo);
				
				if(dupleCode > 0) {
					result = -1;
				}else {
					vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
					bas0215dao.ctItemCustomInfo(vo);
					result = 1;
				}				
			}else if(vo.is__modified__()) {
				vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
				bas0215dao.utItemCustomInfo(vo);
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
				
				int dupleCode = bas0215dao.duplePriceInfo(vo);
				int priceCnt = bas0215dao.getPriceCnt(vo);
				
				if(dupleCode > 0) {
					result = -1;
				}else {					
					vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
					if(priceCnt > 0) {
						bas0215dao.utPriceDate(vo);
					}
					bas0215dao.ctPriceInfo(vo);
					result = 1;
				}
			}else if(vo.is__modified__()) {
				vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
				bas0215dao.utPriceInfo(vo);
				result = 1;
			}
		}
		return result;
	}
	
	//품목정보 삭제
	public int deleteItemInfo(List<Bas0040VO> voList) {
		for(Bas0040VO vo : voList) {
			int partNoChk = bas0215dao.getPartChk(vo);
			if(partNoChk > 0) {
				result = -1;
			}else {
				bas0215dao.dtItemInfo(vo);
				result = 1;
			}
		}
		return result;
	}
	
	//경로유형 삭제
	public int deletePathType(List<Bas0041VO> voList) {
		for(Bas0041VO vo : voList) {
			bas0215dao.dtPathType(vo);
			bas0215dao.dtPathInfo(vo);
		}
		return 0;
	}
	
	//BOM정보 삭제
	public int deleteBomInfo(List<Bas0043VO> voList) {
		for(Bas0043VO vo : voList) {
			bas0215dao.dtBomInfo(vo);
		}
		return 0;
	}
	
	//품목별 거래처 정보 삭제
	public int deleteCustomInfo(List<Bas0044VO> voList) {
		for(Bas0044VO vo : voList) {
			int priceChk = bas0215dao.getPriceChk(vo);
			if(priceChk > 0) {
				result = -1;
			}else {
				bas0215dao.dtItemCustomInfo(vo);
				result = 1;
			}			
		}
		return result;
	}
	
	//단가 정보 삭제
	public int deletePriceInfo(List<Bas0045VO> voList) {
		for(Bas0045VO vo : voList) {
			bas0215dao.dtPriceInfo(vo);
		}
		return 0;
	}
	
	//경로명 가져오기
	public List<Bas0215VO> getPathCode(Bas0215Dto dto){
		List<Bas0215VO> list = bas0215dao.getPathCode(dto);
		return list;
	}
	
	//입고창고명 가져오기
	public List<Bas0215VO> getInWhcode(Bas0215Dto dto){
		List<Bas0215VO> list = bas0215dao.getInWhcode(dto);
		return list;
	}
	
	//거래처명 가져오기
	public List<Bas0215VO> getCustCode(Bas0215Dto dto){
		List<Bas0215VO> list = bas0215dao.getCustCode(dto);
		return list;
	}
	
	//거래처명 가져오기
	public List<Bas0215VO> getProCode(Bas0215Dto dto){
		List<Bas0215VO> list = bas0215dao.getProCode(dto);
		return list;
	}
	
	//[팝업] 거래처 정보 가져오기
	public List<Bas0215VO> getCustPop(Bas0215Dto dto){
		List<Bas0215VO> list = bas0215dao.getCustPop(dto);
		return list;
	}
	
	//공장명 가져오기
	public List<Bas0215VO> getFacCode(Bas0215Dto dto){
		List<Bas0215VO> list = bas0215dao.getFacCode(dto);
		return list;
	}
	
	//경로코드에 맞는 공정코드명 가져오기
	public List<Bas0215VO> getProCodeNameWithPathCode(Bas0215Dto dto){
		List<Bas0215VO> list = bas0215dao.getProCodeNameWithPathCode(dto);
		
		if (list != null && list.size() > 0) 
			System.out.println(list);
		
		return list;
	}	
}
