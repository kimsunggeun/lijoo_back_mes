package kr.co.igns.business.pop.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.igns.business.pop.model.Pop0011VO;


@Mapper
@Repository
public interface Pop0011Dao {
	public List<Pop0011VO> getPop0011(Pop0011VO vo);
}
