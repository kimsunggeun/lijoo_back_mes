package kr.co.igns.business.qat.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.qat.model.qat0110.Qat0110Dto;
import kr.co.igns.business.qat.model.qat0110.Qat0110VO;

@Mapper
public interface Qat0110Dao {
	//납품정보 조회
	List<Qat0110VO> getQat0010(Qat0110Dto dto);

}
