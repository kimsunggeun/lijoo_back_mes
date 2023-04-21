package kr.co.igns.business.baseInfo.bas0240.sevice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import kr.co.igns.business.baseInfo.bas0240.dao.postgre.Bas0240Dao;
import kr.co.igns.business.baseInfo.bas0240.model.Bas0070VO;
import kr.co.igns.business.baseInfo.bas0240.model.Bas0240Dto;
import kr.co.igns.framework.file.model.FileVO;
import kr.co.igns.framework.file.service.FileService;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import kr.co.igns.framework.utils.file.FileManagerUtils;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Bas0240Service {
	
	private final Bas0240Dao bas0240Dao;
	private final FileService fileService;
	
	@Value("${spring.file.upload-dir}")
	private String FILE_DIR;
	
	//작업표준서관리 조회
	public List<Bas0070VO> getDataList(Bas0240Dto dto){
		List<Bas0070VO> list = bas0240Dao.getDataList(dto);
//		if(list.size() > 0) {
//			for(int i = 0; i < list.size(); i++) {			
//	    		try {	
//	    			Bas0070VO vo = list.get(i);
//					String filePath = FILE_DIR + "/" + vo.getComCode() 
//					+ "/FAC01/" + vo.getUpType() + "/" + vo.getProCode();
//			
//					String base64EncodedIMG = fileService.base64Encoding(filePath, vo.getUpFileName());
//					list.get(i).setImageBase64(base64EncodedIMG);
//					
//					String fileExt = vo.getUpFileName().substring(vo.getUpFileName().lastIndexOf(".") + 1);
//					vo.setContentType(FileManagerUtils.getMimeTypeByExt(fileExt));
//		    	} catch (Throwable e) {	
//				      e.printStackTrace();	
//			    } finally {	
//			
//			    }
//		    }
//		}
		return list;
	}

	public List<Bas0070VO> getDataFile(Bas0070VO vo){
		List<Bas0070VO> list = new ArrayList<>();
		
		String filePath = FILE_DIR + "/" + vo.getComCode() 
		+ "/FAC01/" + vo.getUpType() + "/" + vo.getProCode();

		String base64EncodedIMG = fileService.base64Encoding(filePath, vo.getUpFileName());
		vo.setImageBase64(base64EncodedIMG);
		
		String fileExt = vo.getUpFileName().substring(vo.getUpFileName().lastIndexOf(".") + 1);
		vo.setContentType(FileManagerUtils.getMimeTypeByExt(fileExt));
		list.add(vo);
		System.out.println("vo >" +vo);
		return list;
	}
	//작업표준서관리 입력/수정
	public int saveData(Bas0070VO vo) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		String filePath = vo.getComCode() + "/FAC01/" + vo.getUpType() + "/" + vo.getProCode();
		
		try {
			FileVO fileVO = new FileVO();
			if(Boolean.valueOf(vo.getCreated())) {
				if(!"".equals(vo.getUpFileName()) && vo.getFile() != null) {
					fileVO = fileService.multiUpload(vo.getFile(), filePath, vo.getUpFileName());
//					vo.setUpFileName(fileVO.getFileNm() + "." + fileVO.getFileExtension());
				}
				vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
				bas0240Dao.createData(vo);					
			} /*
				 * else if(Boolean.valueOf(vo.getModified())) {
				 * if(Boolean.valueOf(vo.getFileModified())) { fileVO =
				 * fileService.multiUpload(vo.getFile(), filePath, vo.getModFileName()); //
				 * vo.setUserImage(fileVO.getFileNm() + "." + fileVO.getFileExtension()); }
				 * vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
				 * bas0240Dao.updateData(vo); }
				 */
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	//작업표준서관리 삭제
	public int deleteData(Bas0070VO vo) {
		bas0240Dao.deleteData(vo);
		String filePath = vo.getComCode() + "/FAC01/" + vo.getUpType() + "/" + vo.getProCode();
		fileService.deleteLocalFile(filePath, vo.getUpFileName());	
		return 0;
	}
}
