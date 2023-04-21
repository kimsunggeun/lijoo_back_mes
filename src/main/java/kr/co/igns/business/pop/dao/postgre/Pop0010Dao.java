package kr.co.igns.business.pop.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import kr.co.igns.business.pop.model.Pop0010VO;
import kr.co.igns.business.pop.model.Pop0010ReqDto;

@Mapper
@Repository
public interface Pop0010Dao {
	List<Pop0010VO> getMat0018(Pop0010ReqDto reqDto);
	List<Pop0010VO> getIlno(Pop0010ReqDto reqDto);
	List<Pop0010VO> getMat0018_Scan(Pop0010ReqDto reqDto);
	List<Pop0010VO> getMat0018_LotScan(Pop0010ReqDto reqDto);
	int updateMat0012(Pop0010VO vo);
	int updateMat0018(Pop0010VO vo);
	int updateMat0011(Pop0010VO vo);
	int updateMat0011_2 (Pop0010VO vo);
	int updateMat0020(Pop0010VO vo);
	int createMat0021(Pop0010VO vo);
	int getPrice(Pop0010VO vo);
	
	String getInStatus(Pop0010VO vo);
	String getLocCode(Pop0010VO vo);
}
