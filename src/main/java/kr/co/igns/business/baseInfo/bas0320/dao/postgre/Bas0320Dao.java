package kr.co.igns.business.baseInfo.bas0320.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.baseInfo.bas0320.model.Bas0320Dto;
import kr.co.igns.business.baseInfo.bas0320.model.Bas0320VO;

@Mapper
public interface Bas0320Dao {
	//환율정보관리 조회
	List<Bas0320VO> getExrateInfoManage(Bas0320Dto dto);
	
	int setExrateInfoManage(Bas0320VO vo);
}
