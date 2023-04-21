package kr.co.igns.business.pop.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.pop.model.Pop0120ReqDto;
import kr.co.igns.business.pop.model.Pop0120VO;

@Mapper
public interface Pop0120Dao {
	//거래처별 전표번호
	List<String> getinIlno (Pop0120ReqDto reqDto);
	
	//스캔
	List<Pop0120VO> getPop0120(Pop0120ReqDto reqDto);
	
	//공정외주입고-입고정보 저장
	public int updatePop0120(Pop0120VO vo);
	public int insertPop0120(Pop0120VO vo);
	
}
