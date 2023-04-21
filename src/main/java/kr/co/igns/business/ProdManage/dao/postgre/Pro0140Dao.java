package kr.co.igns.business.ProdManage.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.ProdManage.model.pro0140.Pro0140ReqDto;
import kr.co.igns.business.ProdManage.model.pro0140.Pro0140VO;

@Mapper
public interface Pro0140Dao {
	List<Pro0140VO> getPro0140(Pro0140ReqDto reqDto);
}