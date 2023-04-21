package kr.co.igns.business.ProdManage.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.ProdManage.model.pro0050.Pro0050ReqDto;
import kr.co.igns.business.ProdManage.model.pro0050.Pro0050VO;
import kr.co.igns.business.ProdManage.model.pro0070.Pro0070ReqDto;
import kr.co.igns.business.ProdManage.model.pro0070.Pro0070Vo;


@Mapper
public interface Pro0070Dao {
	List<Pro0070Vo> getPro0070(Pro0070ReqDto reqDto);
	
	List<Pro0070Vo> getBas0090(Pro0070ReqDto reqDto);
	
	List<Pro0070Vo> getPro0021(Pro0070ReqDto reqDto);
	
	int createPro0070(Pro0070Vo insertPro0070);
	
	int updatePro0070(Pro0070Vo updatePro0070);
	//삭제
	int deletePro0070(Pro0070ReqDto reqDto);
	
	int getEqCodeEndTime(Pro0070Vo vo);
}
