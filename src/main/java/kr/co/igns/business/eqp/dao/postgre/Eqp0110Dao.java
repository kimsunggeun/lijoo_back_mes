package kr.co.igns.business.eqp.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import kr.co.igns.business.eqp.model.eqp0110.Eqp0110Dto;
import kr.co.igns.business.eqp.model.eqp0110.Eqp0110VO;


@Mapper
public interface Eqp0110Dao {
	List<Eqp0110VO> getEqp0032(Eqp0110Dto dto);

}
