package kr.co.igns.business.eqp.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.eqp.model.eqp0010.Eqp0010DetailVO;
import kr.co.igns.business.eqp.model.eqp0010.Eqp0010Dto;
import kr.co.igns.business.eqp.model.eqp0010.Eqp0010VO;
import kr.co.igns.business.eqp.model.eqp0070.Eqp0070DetailVO;


@Mapper
public interface Eqp0010Dao {
	List<Eqp0010VO> getMaingrd();
	List<Eqp0010DetailVO> getDetailgrd(Eqp0010Dto dto);
	int createEqp0010(Eqp0010DetailVO vo);
	int updateEqp0010(Eqp0010DetailVO vo);
	int deleteEqp0010(Eqp0010DetailVO vo);
}
