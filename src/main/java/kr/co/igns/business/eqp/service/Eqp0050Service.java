package kr.co.igns.business.eqp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import kr.co.igns.business.baseInfo.bas0260.model.Bas0260Dto;
import kr.co.igns.business.baseInfo.bas0260.model.Bas0260VO;
/*import kr.co.igns.business.baseInfo.bas0260.model.Bas0260Dto;
import kr.co.igns.business.baseInfo.bas0260.model.Bas0260VO;*/
import kr.co.igns.business.eqp.dao.postgre.Eqp0050Dao;
import kr.co.igns.business.eqp.model.eqp0050.Eqp0050Dto;
import kr.co.igns.business.eqp.model.eqp0050.Eqp0050VO;
import kr.co.igns.framework.file.service.FileService;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import kr.co.igns.framework.utils.file.FileManagerUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Eqp0050Service{

	@Value("${spring.file.max-size}")
	private long FILE_MAX_SIZE;

	@Value("${spring.file.upload-dir}")
	private String FILE_DIR;
	
	private final Eqp0050Dao eqp0050Dao;
	private final IgnsSessionUtils ignsSessionUtils;
	private final FileService fileService;
	
	//수리내역 조회
	public List<Eqp0050VO> getFacilityStatusItem(Eqp0050Dto dto) {
		List<Eqp0050VO> list = eqp0050Dao.getFacilityStatusItem(dto);
        return list;
    }
	//점검항목 조회
		public List<Eqp0050VO> getChecklistItem(Eqp0050Dto dto) {
			List<Eqp0050VO> list = eqp0050Dao.getChecklistItem(dto);
	        return list;
	    }
		
	//예비품정보 GET
	public List<Eqp0050VO> getSparpartInfo(Eqp0050Dto dto) {
		List<Eqp0050VO> list = eqp0050Dao.getSparpartInfo(dto);
		
		for (int i = 0; i < list.size(); i++) {
			try {
				Eqp0050VO vo = list.get(i);
				
				if (!"".equals(vo.getSpareImage().trim()) && vo.getSpareImage() != null) {
					String filePath = FILE_DIR + "/" + vo.getComCode() 
					+ "/" + vo.getFacCode() + "/bas0260";// + "/eqp0050";
					
					String base64EncodedIMG = fileService.base64Encoding(filePath, vo.getSpareImage());
					list.get(i).setSpareImageBase64(base64EncodedIMG);
					
					String fileExt = vo.getSpareImage().substring(vo.getSpareImage().lastIndexOf(".") + 1);
					vo.setContentType(FileManagerUtils.getMimeTypeByExt(fileExt));
				}
			} catch (Throwable e) {
				e.printStackTrace();
			} finally {
				
			}
		}
		return list;
	}
	
	//예비품별 자원정보 GET
	public List<Eqp0050VO> getSparpartResInfo(Eqp0050Dto dto) {
		List<Eqp0050VO> list = eqp0050Dao.getSparpartResInfo(dto);
		return list;
	}

}
