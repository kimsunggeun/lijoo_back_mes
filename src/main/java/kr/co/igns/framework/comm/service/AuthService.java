package kr.co.igns.framework.comm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.igns.framework.comm.dao.postgre.AuthDao;
import kr.co.igns.framework.comm.model.AuthMenuVO;
import kr.co.igns.framework.comm.model.AuthReqDto;
import kr.co.igns.framework.comm.model.AuthVO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthService{

	private final AuthDao authDao;
	private final IgnsSessionUtils ignsSessionUtils;
	
	//권한그룹 조회
	public List<AuthVO> getAuthGroup(AuthReqDto reqDto) {
		List<AuthVO> list = authDao.getAuthGroup(reqDto);
        return list;
    }
	//권한그룹 입력/수정
	public int createAuthGroup(List<AuthVO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		for(AuthVO vo : voList) {
			if(vo.is__created__()) {
				vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
				authDao.createAuthGroup(vo);					
			} else if(vo.is__modified__()) {
				vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
				authDao.updateAuthGroup(vo);
			}
		}
		return 0;
    }

	//권한메뉴그룹 조회
	public List<AuthMenuVO> getMenuAuthGroup(AuthReqDto reqDto) {
		List<AuthMenuVO> list = authDao.getMenuAuthGroup(reqDto);
        return list;
    }
	//권한메뉴그룹 입력/수정
	public int createMenuAuthGroup(List<AuthMenuVO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		for(AuthMenuVO vo : voList) {
			if(vo.is__created__()) {
				vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
				authDao.createMenuAuthGroup(vo);					
			} else if(vo.is__modified__()) {
				vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
				authDao.updateMenuAuthGroup(vo);
			}
		}
		return 0;
    }
}
