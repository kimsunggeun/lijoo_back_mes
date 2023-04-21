package kr.co.igns.business.ProdManage.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.ProdManage.model.pro0050.Bas0034VO;
import kr.co.igns.business.ProdManage.model.pro0050.Bas0035VO;
import kr.co.igns.business.ProdManage.model.pro0050.Pro0050PartInfoVO;
import kr.co.igns.business.ProdManage.model.pro0050.Pro0050PathDto;
import kr.co.igns.business.ProdManage.model.pro0050.Pro0050PathVO;
import kr.co.igns.business.ProdManage.model.pro0050.Pro0050ReqDto;
import kr.co.igns.business.ProdManage.model.pro0050.Pro0050VO;

@Mapper
public interface Pro0050Dao {
	List<Pro0050VO> getPro0050(Pro0050ReqDto reqDto);
	
	//작업장
	List<Bas0034VO> getbas0034(Pro0050ReqDto reqDto);
	//작업반
	List<Bas0035VO> getbas0035(Pro0050ReqDto reqDto);
	
	List<Pro0050PartInfoVO> getPartInfo(Pro0050ReqDto reqDto);
	List<Pro0050PathVO> getPathInfo(Pro0050PathDto reqDto);
	List<Pro0050PathVO> getPathWorkInfo(Pro0050ReqDto reqDto);
	
	//작업지시 상태 변경
	int OrderState(Pro0050VO reqDto);
	
	int createPro0050(Pro0050VO insertPro0050);
	int updatePro0050(Pro0050VO updatePro0050);
	int deletePro0050(Pro0050ReqDto reqDto);
}
