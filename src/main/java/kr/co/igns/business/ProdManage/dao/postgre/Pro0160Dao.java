package kr.co.igns.business.ProdManage.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.ProdManage.model.pro0160.Pro0160ReqDto;
import kr.co.igns.business.ProdManage.model.pro0160.Pro0160VO;

@Mapper
public interface Pro0160Dao {
	List<Pro0160VO> getPro0160(Pro0160ReqDto reqDto);
}
