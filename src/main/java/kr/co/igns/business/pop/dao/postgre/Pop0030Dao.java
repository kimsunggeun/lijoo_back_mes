package kr.co.igns.business.pop.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import kr.co.igns.business.pop.model.Pop0030VO;
@Mapper
@Repository
public interface Pop0030Dao {
	List<Pop0030VO> getReceiptInfo(Pop0030VO vo);
}
