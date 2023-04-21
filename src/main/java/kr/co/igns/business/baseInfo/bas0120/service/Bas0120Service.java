package kr.co.igns.business.baseInfo.bas0120.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import kr.co.igns.business.baseInfo.bas0120.dao.postgre.Bas0120Dao;
import kr.co.igns.business.baseInfo.bas0120.model.Bas0030VO;
import kr.co.igns.business.baseInfo.bas0120.model.Bas0031VO;
import kr.co.igns.business.baseInfo.bas0120.model.Bas0032VO;
import kr.co.igns.business.baseInfo.bas0120.model.Bas0033VO;
import kr.co.igns.business.baseInfo.bas0120.model.Bas0034VO;
import kr.co.igns.business.baseInfo.bas0120.model.Bas0035VO;
import kr.co.igns.business.baseInfo.bas0120.model.Bas0036VO;
import kr.co.igns.business.baseInfo.bas0120.model.Bas0037VO;
import kr.co.igns.business.baseInfo.bas0120.model.Bas0038VO;
import kr.co.igns.business.baseInfo.bas0120.model.Bas0120Dto;
import kr.co.igns.framework.comm.model.DepartmentVO;
import kr.co.igns.framework.comm.model.UserVO;
import kr.co.igns.framework.file.model.FileVO;
import kr.co.igns.framework.file.service.FileService;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import kr.co.igns.framework.utils.file.FileManagerUtils;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Bas0120Service {
		
	private final Bas0120Dao bas0120dao;
	private final FileService fileService;
	
	@Value("${spring.file.upload-dir}")
	private String FILE_DIR;
	
	//자동투입창고정보 GET
	public List<Bas0033VO> getAutoStorage(Bas0120Dto dto){
		List<Bas0033VO> list = bas0120dao.getAutoStorage(dto); 
		return list;
	}
	
	//공정명정보 GET
	public List<Bas0031VO> getProcessName(Bas0120Dto dto){
		List<Bas0031VO> list = bas0120dao.getProcessName(dto); 
		return list;
	}
	
	//공장명정보 GET
	public List<Bas0030VO> getFacName(Bas0120Dto dto){
		List<Bas0030VO> list = bas0120dao.getFacName(dto); 
		return list;
	}
	
	//공장정보 GET
	public List<Bas0030VO> getFacInfo(Bas0120Dto dto){
		List<Bas0030VO> list = bas0120dao.getFacInfo(dto); 
		return list;
	}
	
	//공정정보 GET
	public List<Bas0031VO> getProcInfo(Bas0120Dto dto){		
		List<Bas0031VO> list = bas0120dao.getProcInfo(dto);
		return list;
	}
	
	//창고정보	GET
	public List<Bas0032VO> getWareHouseInfo(Bas0120Dto dto){
		List<Bas0032VO> list = bas0120dao.getWareHouseInfo(dto);
		return list;
	}
	
	//창고위치정보 GET
	public List<Bas0033VO> getWareHouseLocInfo(Bas0120Dto dto){
		List<Bas0033VO> list = bas0120dao.getWareHouseLocInfo(dto);
		return list;
	}
	
	//작업장정보 GET
	public List<Bas0034VO> getWorkShopInfo(Bas0120Dto dto){
		List<Bas0034VO> list = bas0120dao.getWorkShopInfo(dto);
		return list;
	}
	
	//작업반정보 GET
	public List<Bas0035VO> getWorkPartyInfo(Bas0120Dto dto){
		List<Bas0035VO> list = bas0120dao.getWorkPartyInfo(dto);
		return list;
	}
	
	//설비정보 GET
	public List<Bas0036VO> getFacilityInfo(Bas0120Dto dto){
		List<Bas0036VO> list = bas0120dao.getFacilityInfo(dto);
		for(int i = 0; i < list.size(); i++) {			
    		try {	
    			Bas0036VO vo = list.get(i);
    			//String base64EncodedIMG = null;
    			if(!"".equals(vo.getEqpImage().trim()) && vo.getEqpImage() != null) {
    				String filePath = FILE_DIR + "/" + vo.getComCode() 
					+ "/" + vo.getFacCode() + "/bas0120";
			
					String base64EncodedIMG = fileService.base64Encoding(filePath, vo.getEqpImage());
					list.get(i).setImageBase64(base64EncodedIMG);
					
					String fileExt = vo.getEqpImage().substring(vo.getEqpImage().lastIndexOf(".") + 1);
					vo.setContentType(FileManagerUtils.getMimeTypeByExt(fileExt));
    			}
	    	} catch (Throwable e) {	
			      e.printStackTrace();	
		    } finally {	
		
		    }
	    }
		return list;
	}
	
	//경로정보(라우팅) GET
	public List<Bas0037VO> getRoutingInfo(Bas0120Dto dto){
		List<Bas0037VO> list = bas0120dao.getRoutingInfo(dto);
		return list;
	}
	
	//경로정보 GET
	public List<Bas0038VO> getRouteInfo(Bas0120Dto dto){
		List<Bas0038VO> list = bas0120dao.getRouteInfo(dto);
		return list;
	}
	
	//공장정보 입력/수정
	public int saveFacInfo(List<Bas0030VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		for(Bas0030VO vo : voList) {
			if(vo.is__created__()) {
				vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
				bas0120dao.ctFacInfo(vo);
			}else if(vo.is__modified__()) {
				vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
				bas0120dao.utFacInfo(vo);
			}
		}
		return 0;		
	}
	
	//공정정보 입력/수정
	public int saveProcInfo(List<Bas0031VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		for(Bas0031VO vo : voList) {
			if(vo.is__created__()) {
				vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
				bas0120dao.ctProcInfo(vo);
			}else if(vo.is__modified__()) {
				vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
				bas0120dao.utProcInfo(vo);
			}
		}
		return 0;		
	}
	
	//창고정보 입력/수정
	public int saveWareHouseInfo(List<Bas0032VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		for(Bas0032VO vo : voList) {
			if(vo.is__created__()) {
				vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
				bas0120dao.ctWareHouseInfo(vo);
			}else if(vo.is__modified__()) {
				vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
				bas0120dao.utWareHouseInfo(vo);
			}
		}
		return 0;		
	}
	
	//창고위치정보 입력/수정
	public int saveWareHouseLocInfo(List<Bas0033VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		for(Bas0033VO vo : voList) {
			if(vo.is__created__()) {
				vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
				bas0120dao.ctWareHouseLocInfo(vo);
			}else if(vo.is__modified__()) {
				vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
				bas0120dao.utWareHouseLocInfo(vo);
			}
		}
		return 0;		
	}
	
	//작업장정보 입력/수정
	public int saveWorkShopInfo(List<Bas0034VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		for(Bas0034VO vo : voList) {
			if(vo.is__created__()) {
				vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
				bas0120dao.ctWorkShopInfo(vo);
			}else if(vo.is__modified__()) {
				vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
				bas0120dao.utWorkShopInfo(vo);
			}
		}
		return 0;		
	}
	
	//작업반정보 입력/수정
	public int saveWorkPartyInfo(List<Bas0035VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		for(Bas0035VO vo : voList) {
			if(vo.is__created__()) {
				vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
				bas0120dao.ctWorkPartyInfo(vo);
			}else if(vo.is__modified__()) {
				vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
				bas0120dao.utWorkPartyInfo(vo);
			}
		}
		return 0;		
	}
	
	//설비정보 입력/수정
	public int saveFacilityInfo(Bas0036VO vo) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		
		String filePath = vo.getComCode() 
				+ "/" + vo.getFacCode() + "/bas0120";
		try {
			FileVO fileVO = new FileVO();
			if(vo.is__created__() || Boolean.valueOf(vo.getCreated())) {
				if(!"".equals(vo.getEqpImage()) && vo.getFile() != null) {
					fileVO = fileService.multiUpload(vo.getFile(), filePath, vo.getEqCode());
					//vo.setEqpImage(fileVO.getFileNm() + "." + fileVO.getFileExtension());
					vo.setEqpImage(vo.getEqCode() + "." + fileVO.getFileExtension());
				}
				vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
				bas0120dao.ctFacilityInfo(vo);				
			} else if(vo.is__modified__() || Boolean.valueOf(vo.getModified())) {
				if(Boolean.valueOf(vo.getFileModified())) {
					fileVO = fileService.multiUpload(vo.getFile(), filePath, vo.getEqCode());
					//vo.setEqpImage(fileVO.getFileNm() + "." + fileVO.getFileExtension());
					vo.setEqpImage(vo.getEqCode() + "." + fileVO.getFileExtension());
				}
				vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
				bas0120dao.utFacilityInfo(vo);
			}
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			if(vo.is__created__()) {
				
			}else if(vo.is__modified__()) {
				
			}
		return 0;		
	}
	
	//경로정보(라우팅) 입력/수정
	public int saveRoutingInfo(List<Bas0037VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		for(Bas0037VO vo : voList) {
			if(vo.is__created__()) {
				vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
				bas0120dao.ctRoutingInfo(vo);
			}else if(vo.is__modified__()) {
				vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
				bas0120dao.utRoutingInfo(vo);
			}
		}
		return 0;		
	}
	
	//경로정보 입력/수정
	public int saveRouteInfo(List<Bas0038VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		for(Bas0038VO vo : voList) {
			if(vo.is__created__()) {
				vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
				bas0120dao.ctRouteInfo(vo);
			}else if(vo.is__modified__()) {
				vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
				bas0120dao.utRouteInfo(vo);
			}
		}
		return 0;		
	}
	
	//공장정보 삭제
	public int deleteFac(List<Bas0030VO> voList) {
		for(Bas0030VO vo : voList) {
			bas0120dao.deleteFac(vo);
		}
		return 0;
	}
	
	//공정정보 삭제
	public int deleteProc(List<Bas0031VO> voList) {
		for(Bas0031VO vo : voList) {
			bas0120dao.deleteProc(vo);
		}
		return 0;
	}
	
	//창고정보 삭제
	public int deleteWareHouse(List<Bas0032VO> voList) {
		for(Bas0032VO vo : voList) {
			bas0120dao.deleteWareHouse(vo);
		}
		return 0;
	}
	
	//창고위치정보 삭제
	public int deleteWareHouseLoc(List<Bas0033VO> voList) {
		for(Bas0033VO vo : voList) {
			bas0120dao.deleteWareHouseLoc(vo);
		}
		return 0;
	}
	
	//작업장정보 삭제
	public int deleteWorkShop(List<Bas0034VO> voList) {
		for(Bas0034VO vo : voList) {
			bas0120dao.deleteWorkShop(vo);
		}
		return 0;
	}
	
	//작업반정보 삭제
	public int deleteWorkParty(List<Bas0035VO> voList) {
		for(Bas0035VO vo : voList) {
			bas0120dao.deleteWorkParty(vo);
		}
		return 0;
	}
	
	//설비정보 삭제
	public int deleteFacility(List<Bas0036VO> voList) {
		for(Bas0036VO vo : voList) {
			bas0120dao.deleteFacility(vo);
			if(!"".equals(vo.getEqpImage())) {
				String filePath = vo.getComCode() 
						+ "/" + vo.getFacCode() + "/bas0120";
				fileService.deleteLocalFile(filePath, vo.getEqpImage());	
			}
		}
		return 0;
	}
	
	//경로정보(라우팅) 삭제
	public int deleteRouting(List<Bas0037VO> voList) {
		for(Bas0037VO vo : voList) {
			bas0120dao.deleteRouting(vo);
		}
		return 0;
	}
	
	//경로정보 삭제
	public int deleteRoute(List<Bas0038VO> voList) {
		for(Bas0038VO vo : voList) {
			bas0120dao.deleteRoute(vo);
		}
		return 0;
	}

	
}
