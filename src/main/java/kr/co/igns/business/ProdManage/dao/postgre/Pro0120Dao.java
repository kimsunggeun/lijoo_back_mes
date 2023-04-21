package kr.co.igns.business.ProdManage.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.ProdManage.model.pro0120.Pro0120ReqDto;
import kr.co.igns.business.ProdManage.model.pro0120.Pro0120VO;

@Mapper
public interface Pro0120Dao {
	List<Pro0120VO> getPro0120(Pro0120ReqDto reqDto);
	List<Pro0120VO> getWorkDecode(Pro0120ReqDto reqDto);
}
