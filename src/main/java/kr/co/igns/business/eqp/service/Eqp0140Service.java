package kr.co.igns.business.eqp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import kr.co.igns.business.baseInfo.bas0120.model.Bas0036VO;
import kr.co.igns.business.eqp.dao.postgre.Eqp0140Dao;
import kr.co.igns.business.eqp.model.eqp0140.Eqp0140Dto;
import kr.co.igns.business.eqp.model.eqp0140.Eqp0140VO;
import kr.co.igns.framework.file.service.FileService;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import kr.co.igns.framework.utils.file.FileManagerUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Eqp0140Service{

	private final Eqp0140Dao eqp0140Dao;
	private final IgnsSessionUtils ignsSessionUtils;

	private final FileService fileService;
	
	@Value("${spring.file.upload-dir}")
	private String FILE_DIR;
	
	//계측기 마스터 조회
	public List<Eqp0140VO> getEqp0140(Eqp0140Dto dto) {
		List<Eqp0140VO> list = eqp0140Dao.getEqp0140(dto);
		for(int i = 0; i < list.size(); i++) {			
    		try {	
    			Eqp0140VO vo = list.get(i);
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
	
}
