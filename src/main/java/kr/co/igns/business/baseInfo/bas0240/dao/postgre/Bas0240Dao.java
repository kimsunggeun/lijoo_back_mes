package kr.co.igns.business.baseInfo.bas0240.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.baseInfo.bas0240.model.Bas0240Dto;
import kr.co.igns.business.baseInfo.bas0240.model.Bas0070VO;

@Mapper
public interface Bas0240Dao {
	List<Bas0070VO> getDataList(Bas0240Dto dto);

	int createData(Bas0070VO vo);
	int updateData(Bas0070VO vo);
	int deleteData(Bas0070VO vo);

}
