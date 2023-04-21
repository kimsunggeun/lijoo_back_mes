package kr.co.igns.framework.comm.service;

import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import kr.co.igns.framework.comm.dao.postgre.CompanyDao;
import kr.co.igns.framework.comm.model.ComCustomerReqDto;
import kr.co.igns.framework.comm.model.ComCustomerVO;
import kr.co.igns.framework.comm.model.CompanyReqDto;
import kr.co.igns.framework.comm.model.CompanyVO;
import kr.co.igns.framework.comm.model.DepartmentVO;
import kr.co.igns.framework.file.model.FileVO;
import kr.co.igns.framework.file.service.FileService;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import kr.co.igns.framework.utils.file.FileManagerUtils;

@RequiredArgsConstructor
@Service
public class CompanyService{
	@Value("${spring.file.upload-dir}")
	private String FILE_DIR;
	
	private final FileService fileService;
	private final CompanyDao companyDao;
	private final IgnsSessionUtils ignsSessionUtils;
	
	//회사코드 조회
	public List<CompanyVO> getCompany(CompanyReqDto reqDto) {
		List<CompanyVO> list = companyDao.getCompany(reqDto);
		
		for(int i = 0; i < list.size(); i++) {
			try {
				CompanyVO vo = list.get(i);
				
				if(!"".equals(vo.getImgCi().trim()) && vo.getImgCi() != null) {
					String filePath = FILE_DIR + "/" + vo.getComCode() + "/" + "CI_IMAGE";
					
					String base64EncodedIMG = fileService.base64Encoding(filePath, vo.getImgCi());
					vo.setCiImageBase64(base64EncodedIMG);
					
					String fileExt = vo.getImgCi().substring(vo.getImgCi().lastIndexOf(".") + 1);
					vo.setContentType(FileManagerUtils.getMimeTypeByExt(fileExt));
				}
			} catch(Throwable e) {
				e.printStackTrace();
			}
		}
        return list;
    }

	//거래처 정보 조회
	public List<ComCustomerVO> getComCustomer(ComCustomerReqDto reqDto) {
		List<ComCustomerVO> list = companyDao.getComCustomer(reqDto);
        return list;
    }
	
	//공장코드 조회
	public List<CompanyVO> getFacCode(CompanyReqDto reqDto) {
		List<CompanyVO> list = companyDao.getFacCode(reqDto);
        return list;
    }

	//회사코드 입력/수정
	public int createCompany(CompanyVO vo) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		FileVO fileVO = new FileVO();
		String filePath = vo.getComCode() + "/CI_IMAGE";
		
		try {
			if(Boolean.valueOf(vo.getCreated())) {
				if(!"".equals(vo.getImgCi()) && vo.getFile() != null) {
					fileVO = fileService.multiUpload(vo.getFile(), filePath, vo.getComCode());
					vo.setImgCi(fileVO.getFileNm() + "." + fileVO.getFileExtension());
				}
				vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
				companyDao.createCompany(vo);
			} else {
				if(Boolean.valueOf(vo.getFileModified())) {
					fileVO = fileService.multiUpload(vo.getFile(), filePath, vo.getFileName());
					vo.setImgCi(fileVO.getFileNm() + "." + fileVO.getFileExtension());
				}
				vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
				companyDao.updateCompany(vo);

			}
		} catch(IllegalStateException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
