package kr.co.igns.business.pop.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import kr.co.igns.business.pop.model.Pop0020VO;
import kr.co.igns.business.pop.model.Pop0020ReqDto;

@Mapper
@Repository
public interface Pop0020Dao {
	List<Pop0020VO> getOrdNo(Pop0020VO vo);
	List<Pop0020VO>getCustCode(Pop0020VO vo);
	List<Pop0020VO> getMat0011(Pop0020VO vo);
	List<Pop0020VO> getMat0012(Pop0020VO vo);
	String getIlno(Pop0020VO vo);
	String getLotDetail(Pop0020VO vo);
	
	
	int createMat0012(Pop0020VO vo);  //mat0030Mapper.xml
	int createMat0018(Pop0020VO vo);
	
}
