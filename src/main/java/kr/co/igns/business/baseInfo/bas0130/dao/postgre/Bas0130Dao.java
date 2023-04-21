package kr.co.igns.business.baseInfo.bas0130.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.baseInfo.bas0130.model.Bas0130Dto;
import kr.co.igns.business.baseInfo.bas0130.model.Bas0080VO;
import kr.co.igns.business.baseInfo.bas0130.model.Bas0081VO;

@Mapper
public interface Bas0130Dao {
	//근무시간/휴게시간 조회
	List<Bas0080VO> getWorkTime(Bas0130Dto dto);
	//근무시간/휴게시간 set
	void setWorkTime(Bas0080VO vo);
	//근무시간/휴게시간 삭제
	void delWorkTime(Bas0130Dto vo);
	
	//근무일 조회
	List<Bas0081VO> getWorkDate(Bas0130Dto dto);
	//근무일 set
	void setWorkDate(Bas0081VO vo);
	
	//월별 날짜 Data 생성
	void setMonthData(Bas0130Dto vo);
}
