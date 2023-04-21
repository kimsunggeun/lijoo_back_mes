package kr.co.igns.business.ProdManage.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.ProdManage.model.pro0130.Pro0130GridVO;
import kr.co.igns.business.ProdManage.model.pro0130.Pro0130ReqDto;

@Mapper
public interface Pro0130Dao {
	List<Pro0130GridVO> getPro0130(Pro0130ReqDto reqDto);
}
