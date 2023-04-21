package kr.co.igns.business.ProdManage.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.ProdManage.model.pro0190.Pro0190ReqDto;
import kr.co.igns.business.ProdManage.model.pro0190.Pro0190VO;

@Mapper
public interface Pro0190Dao {
	List<Pro0190VO> getPro0190(Pro0190ReqDto reqDto);
}
