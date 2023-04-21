package kr.co.igns.framework.comm.service;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.igns.framework.comm.dao.postgre.LoginDao;
import kr.co.igns.framework.comm.dao.postgre.UserDao;
import kr.co.igns.framework.comm.model.LoginReqDto;
import kr.co.igns.framework.comm.model.LoginVO;
import kr.co.igns.framework.comm.model.UserCertVO;
import kr.co.igns.framework.comm.model.UserReqDto;
import kr.co.igns.framework.comm.model.UserVO;
import kr.co.igns.framework.config.exception.CEmailSigninFailedException;
import kr.co.igns.framework.config.exception.CUserDefinedException;
import kr.co.igns.framework.file.model.FileVO;
import kr.co.igns.framework.file.service.FileService;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import kr.co.igns.framework.utils.file.FileManagerUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


@RequiredArgsConstructor
@Service
@Log4j2
public class UserService{

	//yml에서 설정
	@Value("${spring.file.max-size}")
	private long FILE_MAX_SIZE;

	@Value("${spring.file.upload-dir}")
	private String FILE_DIR;
		
	private final UserDao userDao;
	private final LoginDao loginDao;
	private final FileService fileService;
	private final PasswordEncoder passwordEncoder;
	private final IgnsSessionUtils ignsSessionUtils;
	
	public List<UserVO> getUser(UserReqDto reqDto) {
//		System.out.println("getUser : " + reqDto);
		List<UserVO> userInfo = userDao.getUser(reqDto);
		
		for(int i = 0; i < userInfo.size(); i++) {			
			UserVO vo = userInfo.get(i);
			//String base64EncodedIMG = null;
			if(!"".equals(vo.getUserImage().trim()) && vo.getUserImage() != null) {
				String filePath = FILE_DIR + "/" + vo.getComCode() + "/" + vo.getFacCode() + "/bas0110";
				String fileExt = vo.getUserImage().substring(vo.getUserImage().lastIndexOf(".") + 1);
				String base64EncodedIMG = fileService.base64Encoding(filePath, vo.getUserId() + "." + fileExt);
				vo.setUserImageBase64(base64EncodedIMG);
				vo.setContentType(FileManagerUtils.getMimeTypeByExt(fileExt));
			}
	    }
        return userInfo;
    }
	
	public List<UserCertVO> findByUserId(UserReqDto reqDto) {
		List<UserCertVO> userInfo = userDao.findByUserId(reqDto.getUuid());
        return userInfo;
    }
	
	public int checkByUserId(UserReqDto reqDto) {
		int result = userDao.checkByUserId(reqDto);
		return result;
	}

	@Transactional(rollbackFor = Exception.class)
	public boolean checkAdminPw(UserReqDto reqDto) throws Exception {
		//System.out.println("checkAdminPw");
		if(reqDto.getComCode().equals("") || reqDto.getUserId().equals("")
				|| reqDto.getComCode() == null || reqDto.getUserId() == null) {
			throw new CUserDefinedException("필수 입력값이 없습니다.");
		}
		List<UserVO> userInfo = userDao.getUser(reqDto);
		if(userInfo.size() > 0) {
			//if(!reqDto.getUserPw().equals(userInfo.get(0).getUserPw())) {
			if (!passwordEncoder.matches(reqDto.getUserPassword(), userInfo.get(0).getUserPassword())) { //pw 디코딩
				return false; 
	     	}
		} else {
			throw new CUserDefinedException("해당 회사 계정이 없습니다.");
		}
		
		
        return true;
    }

	//유저정보 입력/수정
	@Transactional(rollbackFor = Exception.class)
	public int createUser(UserVO vo) throws Exception {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		String filePath = vo.getComCode() + "/" + vo.getFacCode() + "/bas0110";
		FileVO fileVO = new FileVO();
		
		if(Boolean.valueOf(vo.getCreated())) {
			if(!"".equals(vo.getUserImage()) && vo.getFile() != null) {
				fileVO = fileService.multiUpload(vo.getFile(), filePath, vo.getUserId());
				vo.setUserImage(fileVO.getFileNm() + "." + fileVO.getFileExtension());
			}	
			userDao.createUser(vo);		
		} else {
			if(Boolean.valueOf(vo.getFileModified())) {
				fileVO = fileService.multiUpload(vo.getFile(), filePath, vo.getUserId());
				vo.setUserImage(fileVO.getFileNm() + "." + fileVO.getFileExtension());
			}
			vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
			//vo.setUserPw(passwordEncoder.encode(vo.getUserPw()));
			userDao.updateUser(vo);
		
		}
		
		return 0;
    }
	
	//유저정보 삭제
	@Transactional(rollbackFor = Exception.class)
	public int deleteUser(List<UserVO> voList) throws Exception {
		int result = 1;
		List<UserVO> basNullCheck = userDao.userDeleteCheck_Bas(voList.get(0));
		List<UserVO> salNullCheck = userDao.userDeleteCheck_Sal(voList.get(0));
		List<UserVO> matNullCheck = userDao.userDeleteCheck_Mat(voList.get(0));
		List<UserVO> proNullCheck = userDao.userDeleteCheck_Pro(voList.get(0));

		if(!basNullCheck.isEmpty() || !salNullCheck.isEmpty() || !matNullCheck.isEmpty() || !proNullCheck.isEmpty()) {
			throw new Exception("이 사용자로 생성된 데이터들이 있어 삭제가 불가능합니다. 사용유무 체크를 해제하는 것을 권장드립니다");
		}
		for(UserVO vo : voList) {
			
			result = userDao.deleteUser(vo);
			if(!"".equals(vo.getUserImage())) {
				String filePath = vo.getComCode() 
						+ "/" + vo.getFacCode() + "/bas0110";
				fileService.deleteLocalFile(filePath, vo.getUserId() + vo.getUserImage().substring(vo.getUserImage().lastIndexOf('.')));	
			}
		}
		return result;
	}
		
	//유저정보 비밀번호 초기화
	@Transactional(rollbackFor = Exception.class)
	public int initUserPass(UserVO vo) throws Exception {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
 		vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
		vo.setUserChangePassword(passwordEncoder.encode(vo.getUserPassword()));
		System.out.println("initUserPass ::::" + vo);
    	userDao.updateUserPass(vo);
		
		return 0;
    }
	
	//유저정보 비밀번호 수정
	@Transactional(rollbackFor = Exception.class)
	public int updateUserPass(UserVO vo) throws Exception {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		
		LoginReqDto loginDto = new LoginReqDto();
		loginDto.setComCode(vo.getComCode());
		loginDto.setUserId(vo.getUserId());
		loginDto.setPerCode("");
		LoginVO loginVo = loginDao.login(loginDto);
		
    	//비밀번호 체크
 		if (!passwordEncoder.matches(vo.getUserPassword(), loginVo.getUserPassword())) { //pw 디코딩
     		log.error("==== Incorrect password");
         	throw new CEmailSigninFailedException("Incorrect password");
     	}
 		
 		vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
		vo.setUserChangePassword(passwordEncoder.encode(vo.getUserChangePassword()));
    	userDao.updateUserPass(vo);
		
		return 0;
    }
	
}
