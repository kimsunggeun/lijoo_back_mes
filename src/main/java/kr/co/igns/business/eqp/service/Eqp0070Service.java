package kr.co.igns.business.eqp.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import kr.co.igns.business.baseInfo.bas0120.model.Bas0036VO;
import kr.co.igns.business.eqp.dao.postgre.Eqp0070Dao;
import kr.co.igns.business.eqp.model.eqp0070.Eqp0070Dto;
import kr.co.igns.business.eqp.model.eqp0070.Eqp0070VO;
import kr.co.igns.business.eqp.model.eqp0070.Eqp0070DetailVO;
import kr.co.igns.framework.file.model.FileVO;
import kr.co.igns.framework.file.service.FileService;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import kr.co.igns.framework.utils.file.FileManagerUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Eqp0070Service{

	private final Eqp0070Dao eqp0070Dao;
	private final IgnsSessionUtils ignsSessionUtils;
	private final FileService fileService;
	
	@Value("${spring.file.upload-dir}")
	private String FILE_DIR;
	
	//계측기 마스터 조회
	public List<Eqp0070VO> getHeaderItem(Eqp0070Dto dto) {
		List<Eqp0070VO> list = eqp0070Dao.getHeaderItem(dto);
        return list;
    }
	
	//계측기 검교정 조회
		public List<Eqp0070DetailVO> getDetailItem(Eqp0070Dto dto) {
			List<Eqp0070DetailVO> list = eqp0070Dao.getDetailItem(dto);
			for(int i = 0; i < list.size(); i++) {			
	    		try {	
	    			Eqp0070DetailVO vo = list.get(i);
	    			//String base64EncodedIMG = null;
	    			if(!"".equals(vo.getInsImage().trim()) && vo.getInsImage() != null) {
	    				String filePath = FILE_DIR + "/" + vo.getComCode() 
						+ "/" + vo.getFacCode() + "/eqp0070";
				
						String base64EncodedIMG = fileService.base64Encoding(filePath, vo.getInsImage());
						list.get(i).setImageBase64(base64EncodedIMG);
						
						String fileExt = vo.getInsImage().substring(vo.getInsImage().lastIndexOf(".") + 1);
						vo.setContentType(FileManagerUtils.getMimeTypeByExt(fileExt));
	    			}
		    	} catch (Throwable e) {	
				      e.printStackTrace();	
			    } finally {	
			
			    }
		    }
	        return list;
	    }
		
	//계측기 검교정 입력/수정
	public int saveEqp0070(Eqp0070DetailVO vo) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		String filePath = vo.getComCode() 
				+ "/" + vo.getFacCode() + "/eqp0070";
		try {
			FileVO fileVO = new FileVO();
			String fileName = vo.getMeaCode() + vo.getCorrDate()+ vo.getCorrNo();
			if(Boolean.valueOf(vo.getCreated())) {
				if(!"".equals(vo.getInsImage()) && vo.getFile() != null) {
					fileVO = fileService.multiUpload(vo.getFile(), filePath, fileName);
					//vo.setInsImage(fileVO.getFileNm() + "." + fileVO.getFileExtension());
					vo.setInsImage(fileName + "." + fileVO.getFileExtension());
				}
				vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
				eqp0070Dao.createEqp0020(vo);				
			} else if(Boolean.valueOf(vo.getModified())) {
				
				if(Boolean.valueOf(vo.getFileModified())) {
					fileVO = fileService.multiUpload(vo.getFile(), filePath, fileName);
					//vo.setInsImage(fileVO.getFileNm() + "." + fileVO.getFileExtension());
					vo.setInsImage(fileName + "." + fileVO.getFileExtension());
				}
				vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
				eqp0070Dao.updateEqp0020(vo);
			}
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
    }
	
	//구매발주정보 삭제
	public int deleteEqp0070(List<Eqp0070DetailVO> voList) {
		for(Eqp0070DetailVO vo : voList) {
			eqp0070Dao.deleteEqp0020(vo);
		}
		return 0;
	}
	
}
