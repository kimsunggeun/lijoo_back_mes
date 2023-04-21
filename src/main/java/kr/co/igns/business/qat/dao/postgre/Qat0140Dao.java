package kr.co.igns.business.qat.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.qat.model.qat0140.Qat0140ReqDto;
import kr.co.igns.business.qat.model.qat0140.Qat0140VO;

@Mapper
public interface Qat0140Dao {

	List<Qat0140VO> getQat0140(Qat0140ReqDto reqDto);
	
	int createQat0140(Qat0140VO vo);
	int updateQat0140(Qat0140VO vo);
}
