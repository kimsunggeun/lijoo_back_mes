package kr.co.igns.business.eqp.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.baseInfo.bas0260.model.Bas0260Dto;
import kr.co.igns.business.baseInfo.bas0260.model.Bas0260VO;
import kr.co.igns.business.eqp.model.eqp0050.Eqp0050Dto;
import kr.co.igns.business.eqp.model.eqp0050.Eqp0050VO;

@Mapper
public interface Eqp0050Dao {
	List<Eqp0050VO> getFacilityStatusItem(Eqp0050Dto dto);
	List<Eqp0050VO> getChecklistItem(Eqp0050Dto dto);
	List<Eqp0050VO> getSparpartInfo(Eqp0050Dto dto);
	List<Eqp0050VO> getSparpartResInfo(Eqp0050Dto dto);
}
