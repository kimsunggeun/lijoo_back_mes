package kr.co.igns.business.baseInfo.bas0260.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import kr.co.igns.business.baseInfo.bas0260.dao.postgre.Bas0260Dao;
import kr.co.igns.business.baseInfo.bas0260.model.Bas0260DetailVO;
import kr.co.igns.business.baseInfo.bas0260.model.Bas0260Dto;
import kr.co.igns.business.baseInfo.bas0260.model.Bas0260VO;
import kr.co.igns.framework.file.model.FileVO;
import kr.co.igns.framework.file.service.FileService;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import kr.co.igns.framework.utils.file.FileManagerUtils;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Bas0260Service {
	
	@Value("${spring.file.max-size}")
	private long FILE_MAX_SIZE;

	@Value("${spring.file.upload-dir}")
	private String FILE_DIR;

	private final Bas0260Dao bas0260dao;
	private int result = 0;
	private final FileService fileService;
	
	//예비품정보 GET
	public List<Bas0260VO> getMainList(Bas0260Dto dto) {
		List<Bas0260VO> list = bas0260dao.getMainList(dto);
		
		for (int i = 0; i < list.size(); i++) {
			try {
				Bas0260VO vo = list.get(i);
				if (!"".equals(vo.getSpareImage().trim()) && vo.getSpareImage() != null) {
					String filePath = FILE_DIR + "/" + vo.getComCode() + "/" + vo.getFacCode() + "/bas0260";
					
					String fileExt = vo.getSpareImage().substring(vo.getSpareImage().lastIndexOf(".") + 1);
					vo.setContentType(FileManagerUtils.getMimeTypeByExt(fileExt));
					
					String base64EncodedIMG = fileService.base64Encoding(filePath, vo.getPartNo() + "." + fileExt);
					list.get(i).setSpareImageBase64(base64EncodedIMG);

				}
			} catch (Throwable e) {
				e.printStackTrace();
			} finally {
				
			}
		}
		return list;
	}
	
	//예비품별 자원정보 GET
	public List<Bas0260VO> getDetailList(Bas0260Dto dto) {
		List<Bas0260VO> list = bas0260dao.getDetailList(dto);
		return list;
	}
	
	//예비품정보 입력/수정
	public int saveReserveStockInfo(Bas0260VO vo) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		
		String filePath = vo.getComCode() + "/" + vo.getFacCode() + "/bas0260";
		try {
			FileVO fileVO = new FileVO();
			if(vo.is__created__() || Boolean.valueOf(vo.getCreated())) {
				vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
				bas0260dao.ctReserveStockInfo(vo);
				if(!"".equals(vo.getSpareImage()) && vo.getFile() != null) {
					fileVO = fileService.multiUpload(vo.getFile(), filePath, vo.getPartNo());
					vo.setSpareImage(vo.getPartNo() + "." + fileVO.getFileExtension());
				}
			} else if(vo.is__modified__() || Boolean.valueOf(vo.getModified())) {
				vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
				bas0260dao.utReserveStockInfo(vo);
				if(Boolean.valueOf(vo.getFileModified())) {
					fileVO = fileService.multiUpload(vo.getFile(), filePath, vo.getPartNo());
					vo.setSpareImage(vo.getPartNo() + "." + fileVO.getFileExtension());
				}
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
	
	//예비품별 자원정보 입력/수정
	public int saveReserveStockDetailInfo(List<Bas0260DetailVO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		
		for(Bas0260DetailVO vo : voList) {
			if(vo.is__created__()) {
				vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
				bas0260dao.ctReserveStockDetailInfo(vo);
			} else if(vo.is__modified__()) {
				vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
				bas0260dao.utReserveStockDetailInfo(vo);
			}
		}
		return 0;
	}
	
	//예비품정보 삭제
	public int deleteReserveStockInfo(List<Bas0260VO> voList) {
		for(Bas0260VO vo : voList) {
			bas0260dao.deleteReserveStockInfo(vo);
			if(!"".equals(vo.getSpareImage())) {
				String filePath = vo.getComCode() + "/" + vo.getFacCode() + "/bas0260";
				fileService.deleteLocalFile(filePath, vo.getPartNo() + vo.getSpareImage().substring(vo.getSpareImage().lastIndexOf('.')));
			}
		}
		return 0;
	}
	
	//예비품정보 삭제
	public int deleteReserveStockDetailInfo(List<Bas0260DetailVO> voList) {
		for(Bas0260DetailVO vo : voList) {
			bas0260dao.deleteReserveStockDetailInfo(vo);
		}
		return 0;
	}
}
