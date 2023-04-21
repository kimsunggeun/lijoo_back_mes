package kr.co.igns.business.pop.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.pop.model.Pop0290ReqDto;
import kr.co.igns.business.pop.model.Pop0290StopReqDto;
import kr.co.igns.business.pop.model.Pop0290VO;
import kr.co.igns.business.pop.model.Pop0291VO;

@Mapper
public interface Pop0290Dao {
	List<Pop0290VO> getEqp0010(Pop0290ReqDto reqDto);
	
	List<Pop0290VO> getEqp0010Main(Pop0290ReqDto reqDto);

	List<Pop0290VO> getProcess(Pop0290ReqDto reqDto);
	
	List<Pop0290VO>getStopTime(Pop0290StopReqDto reqDto);

	public int startOperating(Pop0290VO vo);

	public int stopOperating(Pop0290VO vo);

	public int insertProcess(Pop0291VO vo);

	public int updateProcess(Pop0291VO vo);
}
