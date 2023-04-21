package kr.co.igns.business.eqp.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.eqp.model.eqp0070.Eqp0070Dto;
import kr.co.igns.business.eqp.model.eqp0070.Eqp0070VO;
import kr.co.igns.business.eqp.model.eqp0070.Eqp0070DetailVO;

@Mapper
public interface Eqp0070Dao {
	List<Eqp0070VO> getHeaderItem(Eqp0070Dto dto);
	List<Eqp0070DetailVO> getDetailItem(Eqp0070Dto dto);
	int createEqp0020(Eqp0070DetailVO vo);
	int updateEqp0020(Eqp0070DetailVO vo);
	int deleteEqp0020(Eqp0070DetailVO vo);
}
