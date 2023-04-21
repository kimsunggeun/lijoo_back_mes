package kr.co.igns.business.sales.dao.postgre;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.mat.model.mat0070.TransRptSubVO;
import kr.co.igns.business.mat.model.mat0070.TransRptVO;
import kr.co.igns.business.sales.model.sal0160.Sal0160ReqDto;
import kr.co.igns.business.sales.model.sal0160.Sal0160VO;

@Mapper
public interface Sal0160Dao {
	List<Sal0160VO>getSal0120(Sal0160ReqDto reqDto);
	List<TransRptVO> getTransRptHeader(HashMap<String, Object> param);
	List<TransRptSubVO> getTransRptSub(HashMap<String, Object> param);
}
