package kr.co.igns.business.eqp.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.eqp.model.eqp0140.Eqp0140Dto;
import kr.co.igns.business.eqp.model.eqp0140.Eqp0140VO;

@Mapper
public interface Eqp0140Dao {
	List<Eqp0140VO> getEqp0140(Eqp0140Dto dto);
}
