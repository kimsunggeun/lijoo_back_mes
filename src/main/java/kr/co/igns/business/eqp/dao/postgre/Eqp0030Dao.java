package kr.co.igns.business.eqp.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import kr.co.igns.business.eqp.model.eqp0030.Eqp0030DetailVO;
import kr.co.igns.business.eqp.model.eqp0030.Eqp0030Dto;
import kr.co.igns.business.eqp.model.eqp0030.Eqp0030VO;




@Mapper
public interface Eqp0030Dao {
	List<Eqp0030VO> getEqp0030(Eqp0030Dto dto);
	List<Eqp0030DetailVO> getEqp0030Detail(Eqp0030Dto dto);
	

	public int createEqp0030(Eqp0030DetailVO svo);


	public int deleteEqp0030(Eqp0030DetailVO vo);
}
