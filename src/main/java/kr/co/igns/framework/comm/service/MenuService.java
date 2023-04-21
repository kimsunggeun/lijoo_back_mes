package kr.co.igns.framework.comm.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import kr.co.igns.framework.comm.dao.postgre.MenuDao;
import kr.co.igns.framework.comm.model.CompanyVO;
import kr.co.igns.framework.comm.model.MenuReqDto;
import kr.co.igns.framework.comm.model.MenuVO;
import kr.co.igns.framework.comm.model.UserMenuVO;
import kr.co.igns.framework.config.security.JwtTokenProvider;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RequiredArgsConstructor
@Service
public class MenuService{

	private final MenuDao menuDao;
	private final IgnsSessionUtils ignsSessionUtils;
	
	
	public List<UserMenuVO> getRouterMenu(MenuReqDto reqDto) {
		List<UserMenuVO> menu = menuDao.getRouterMenu(reqDto);
        return menu;
    }
	
	public List<UserMenuVO> getAllMenu(MenuReqDto reqDto) {
		List<UserMenuVO> menu = menuDao.getAllMenu(reqDto);
        return menu;
    }
	
	public List<UserMenuVO> getUserMenu(MenuReqDto reqDto) {
		List<UserMenuVO> menu = menuDao.getUserMenu(reqDto);
        return menu;
    }
	
	public int createMenu(List<MenuVO> dataList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		for(MenuVO vo : dataList) {
			if(vo.is__created__()) {
				vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
				menuDao.createMenu(vo);					
			} else if(vo.is__modified__()) {
				vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
				menuDao.updateMenu(vo);
			}
		}
		
		return 0;
	}
}
