package kr.co.igns.business.pop.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import kr.co.igns.business.pop.model.Pop0350VO;
import kr.co.igns.business.pop.model.Pop0350ReqDto;

@Mapper
@Repository
public interface Pop0350Dao {

	List<Pop0350VO> getPathCode(Pop0350ReqDto reqDto);
	List<Pop0350VO> getProCode(Pop0350ReqDto reqDto);
	List<Pop0350VO> getWorkDecode(Pop0350ReqDto reqDto);
	List<Pop0350VO> getWorkDecode2(Pop0350ReqDto reqDto);
	int createPro0026(Pop0350VO vo);

}
