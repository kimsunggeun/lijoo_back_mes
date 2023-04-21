package kr.co.igns.framework.comm.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.framework.comm.model.ConstInfoVO;
import kr.co.igns.framework.comm.model.DashboardInfoVO;
import kr.co.igns.framework.comm.model.MenuReqDto;
import kr.co.igns.framework.comm.model.MenuStatisticsReqDto;
import kr.co.igns.framework.comm.model.MenuStatisticsVO;
import kr.co.igns.framework.comm.model.MenuVO;
import kr.co.igns.framework.comm.model.OverflowInfoVO;
import kr.co.igns.framework.comm.model.PrintInfoVO;
import kr.co.igns.framework.comm.model.SystemReqDto;
import kr.co.igns.framework.comm.model.UserMenuVO;

@Mapper
public interface MenuStatisticsDao {
	
	List<MenuStatisticsVO> getMenuStatistics(MenuStatisticsReqDto dto);
	int saveMenuStatistics(MenuStatisticsReqDto dto);
}
