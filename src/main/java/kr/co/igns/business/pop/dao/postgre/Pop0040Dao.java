package kr.co.igns.business.pop.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import kr.co.igns.business.pop.model.Pop0040VO;
import kr.co.igns.business.pop.model.Pop0020VO;
import kr.co.igns.business.pop.model.Pop0040ReqDto;

@Mapper
@Repository
public interface Pop0040Dao {
	List<Pop0040VO> getOutWh(Pop0040ReqDto reqDto);
	List<Pop0040VO> getPartNo(Pop0040ReqDto reqDto);
	List<Pop0040VO> getMat0021(Pop0040ReqDto reqDto);
	
	int createMat0020(Pop0040VO vo); 
	int updateMat0020(Pop0040VO vo);
	int deleteMat0021(Pop0040VO vo);
	int createMat0021(Pop0040VO vo);
	int createMat0031(Pop0040VO vo);
	
	
}
