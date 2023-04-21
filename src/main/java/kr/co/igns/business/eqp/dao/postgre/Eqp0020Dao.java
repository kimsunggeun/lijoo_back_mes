package kr.co.igns.business.eqp.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.eqp.model.eqp0010.Eqp0010DetailVO;
import kr.co.igns.business.eqp.model.eqp0010.Eqp0010Dto;
import kr.co.igns.business.eqp.model.eqp0010.Eqp0010VO;
import kr.co.igns.business.eqp.model.eqp0020.Eqp0020Dto;
import kr.co.igns.business.eqp.model.eqp0020.Eqp0020VO;
import kr.co.igns.business.eqp.model.eqp0070.Eqp0070DetailVO;


@Mapper
public interface Eqp0020Dao {
	List<Eqp0020VO> getEqp0020grd(Eqp0020Dto dto);
	int createEqp0020(Eqp0020VO vo);
	int updateEqp0020(Eqp0020VO vo);
	int deleteEqp0020(Eqp0020VO vo);
}
