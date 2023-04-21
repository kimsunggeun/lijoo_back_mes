package kr.co.igns.framework.comm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.igns.framework.comm.dao.postgre.SystemDao;
import kr.co.igns.framework.comm.model.ConstInfoVO;
import kr.co.igns.framework.comm.model.DashboardInfoVO;
import kr.co.igns.framework.comm.model.OverflowInfoVO;
import kr.co.igns.framework.comm.model.PrintInfoVO;
import kr.co.igns.framework.comm.model.SystemReqDto;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class SystemService{

	private final SystemDao systemDao;
	private final IgnsSessionUtils ignsSessionUtils;
	
	
	public List<PrintInfoVO> getPrintInfo(SystemReqDto dto) {
        return systemDao.getPrintInfo(dto);
    }
	
	public List<ConstInfoVO> getConstInfo(SystemReqDto dto) {
		return systemDao.getConstInfo(dto);
	}
	
	public List<OverflowInfoVO> getOverflowInfo(SystemReqDto dto) {
		return systemDao.getOverflowInfo(dto);
	}
	
	public List<DashboardInfoVO> getDashboardInfo(SystemReqDto dto) {
		return systemDao.getDashboardInfo(dto);
	}

	public void updatePrintInfo(List<PrintInfoVO> voList) {
		systemDao.updatePrintInfo(voList);
	}

	public void updateConstInfo(List<ConstInfoVO> voList) {
		systemDao.updateConstInfo(voList);
	}

	public void updateOverflowInfo(List<OverflowInfoVO> voList) {
		systemDao.updateOverflowInfo(voList);
	}

	public void updateDashboardInfo(List<DashboardInfoVO> voList) {
		systemDao.updateDashboardInfo(voList);
	}
	
	
}
