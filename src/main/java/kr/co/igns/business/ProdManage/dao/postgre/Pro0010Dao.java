package kr.co.igns.business.ProdManage.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.ProdManage.model.pro0010.Bas0040ReqDto;
import kr.co.igns.business.ProdManage.model.pro0010.Bas0040VO;
import kr.co.igns.business.ProdManage.model.pro0010.Bas0081VO;
import kr.co.igns.business.ProdManage.model.pro0010.Pro0010ReqDto;
import kr.co.igns.business.ProdManage.model.pro0010.Pro0010VO;
import kr.co.igns.business.ProdManage.model.pro0050.Pro0050VO;

@Mapper
public interface Pro0010Dao {
	String getPro0010(Pro0010ReqDto reqDto);
	List<Bas0081VO> getBas0081(Pro0010ReqDto reqDto);
	List<Pro0050VO> getPro0010Detail(Pro0010ReqDto reqDto);
	
	int upsertPro0010(Pro0010VO vo);
	int deletePro0010(Pro0010VO vo);
	
	List<Bas0040VO> getBas0040(Bas0040ReqDto reqDto);
}
