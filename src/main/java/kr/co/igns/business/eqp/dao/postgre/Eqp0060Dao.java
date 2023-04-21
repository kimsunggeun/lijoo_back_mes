package kr.co.igns.business.eqp.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.eqp.model.eqp0060.Eqp0060Dto;
import kr.co.igns.business.eqp.model.eqp0060.Eqp0060VO;

@Mapper
public interface Eqp0060Dao {
	List<Eqp0060VO> getFacilityItem(Eqp0060Dto dto);
	int createEqp0050(Eqp0060VO vo);
	int updateEqp0050(Eqp0060VO vo);
	int deleteEqp0050(Eqp0060VO vo);
}
