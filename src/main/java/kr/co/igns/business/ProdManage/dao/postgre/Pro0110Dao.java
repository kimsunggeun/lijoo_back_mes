package kr.co.igns.business.ProdManage.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.ProdManage.model.pro0110.Pro0110ReqDto;
import kr.co.igns.business.ProdManage.model.pro0110.Pro0110VO;

@Mapper
public interface Pro0110Dao {
	List<Pro0110VO> getPro0110(Pro0110ReqDto reqDto);
}
