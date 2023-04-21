package kr.co.igns.business.ProdManage.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.ProdManage.model.pro0020.Pro0020ReqDto;
import kr.co.igns.business.ProdManage.model.pro0020.Pro0020VO;



@Mapper
public interface Pro0020Dao {
	List<Pro0020VO> getPro0020(Pro0020ReqDto reqDto);
	int createPro0020(Pro0020VO insertPro0020);
	int updatePro0020(Pro0020VO updatePro0020);
	
	//업로드 가져오기
	List<Pro0020VO> getUpload(Pro0020VO vo);
	//업로드 저장하기
	int ctUpload(Pro0020VO vo);
	String getPrePlanQty(Pro0020VO vo);
}
