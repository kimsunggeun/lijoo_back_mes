package kr.co.igns.framework.comm.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.framework.comm.model.ConstInfoVO;
import kr.co.igns.framework.comm.model.DashboardInfoVO;
import kr.co.igns.framework.comm.model.MenuReqDto;
import kr.co.igns.framework.comm.model.MenuVO;
import kr.co.igns.framework.comm.model.OverflowInfoVO;
import kr.co.igns.framework.comm.model.PrintInfoVO;
import kr.co.igns.framework.comm.model.SystemReqDto;
import kr.co.igns.framework.comm.model.UserMenuVO;

@Mapper
public interface SystemDao {
	List<PrintInfoVO> getPrintInfo(SystemReqDto dto);
	List<ConstInfoVO> getConstInfo(SystemReqDto dto);
	List<OverflowInfoVO> getOverflowInfo(SystemReqDto dto);
	List<DashboardInfoVO> getDashboardInfo(SystemReqDto dto);
	
	void updatePrintInfo(List<PrintInfoVO> voList);
	void updateConstInfo(List<ConstInfoVO> voList);
	void updateOverflowInfo(List<OverflowInfoVO> voList);
	void updateDashboardInfo(List<DashboardInfoVO> voList);
}
