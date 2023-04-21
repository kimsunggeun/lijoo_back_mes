package kr.co.igns.framework.comm.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.framework.comm.model.MenuReqDto;
import kr.co.igns.framework.comm.model.MenuVO;
import kr.co.igns.framework.comm.model.UserMenuVO;

@Mapper
public interface MenuDao {
	List<UserMenuVO> getRouterMenu(MenuReqDto reqDto);
	
	List<UserMenuVO> getAllMenu(MenuReqDto reqDto);
	List<UserMenuVO> getUserMenu(MenuReqDto reqDto);
	
	int createMenu(MenuVO vo);
	int updateMenu(MenuVO vo);
}
