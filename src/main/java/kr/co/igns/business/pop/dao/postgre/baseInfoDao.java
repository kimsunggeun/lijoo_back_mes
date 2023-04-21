package kr.co.igns.business.pop.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.ProdManage.model.pro0050.Pro0050ReqDto;
import kr.co.igns.business.ProdManage.model.pro0050.Pro0050VO;
import kr.co.igns.business.pop.model.Pro0021ReqDto;
import kr.co.igns.business.pop.model.baseInfo.PopupWorkerListVO;
import kr.co.igns.business.pop.model.baseInfo.bas0034ReqDto;
import kr.co.igns.business.pop.model.baseInfo.commonVO;

@Mapper
public interface baseInfoDao {
	List<commonVO> getBas0034(bas0034ReqDto reqDto);
	List<commonVO> getBas0035(bas0034ReqDto reqDto);
	
	//작업지시정보 popup
	List<Pro0050VO> getPro0010(Pro0050ReqDto reqDto);
	
	List<PopupWorkerListVO> getWorkerList(Pro0021ReqDto reqDto);
}
