package kr.co.igns.business.pop.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.igns.business.pop.model.Pop0012VO;


@Mapper
@Repository
public interface Pop0012Dao {
	public List<Pop0012VO> getPop0012(Pop0012VO vo);
}
