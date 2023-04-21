package kr.co.igns.business.baseInfo.bas0440.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.baseInfo.bas0440.model.Bas0440DepVO;
import kr.co.igns.business.baseInfo.bas0440.model.Bas0440Dto;
import kr.co.igns.business.baseInfo.bas0440.model.Bas0440VO;

@Mapper
public interface Bas0440Dao {
	//부서정보 조회
	List<Bas0440DepVO> getDepInfo(Bas0440DepVO vo);
	// 계측기정보 조회 
	List<Bas0440VO> getItemInfo(Bas0440Dto dto);
	// 계측기정보 저장
	int createBas0440(Bas0440VO vo);
	int updateBas0440(Bas0440VO vo);
	// 계측기정보 삭제
	int deleteBas0440(Bas0440VO vo);
}
