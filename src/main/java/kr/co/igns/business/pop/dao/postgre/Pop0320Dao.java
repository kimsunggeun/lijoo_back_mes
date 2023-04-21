package kr.co.igns.business.pop.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import kr.co.igns.business.pop.model.Pop0310VO;

@Mapper
@Repository
public interface Pop0320Dao {

	int createPro0019(Pop0310VO vo); //로트분할 저장
	int updateMat0021(Pop0310VO vo); //로트분할 업데이트
	int mergedUpdateMat0021(Pop0310VO vo); //병할될 데이터 업데이트

}
