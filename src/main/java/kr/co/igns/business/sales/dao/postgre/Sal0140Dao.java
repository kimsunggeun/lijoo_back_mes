package kr.co.igns.business.sales.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.sales.model.sal0140.Mat0020Dto;
import kr.co.igns.business.sales.model.sal0140.Sal0120CountReqDto;
import kr.co.igns.business.sales.model.sal0140.Sal0120ReqDto;
import kr.co.igns.business.sales.model.sal0140.Sal0120VO;
import kr.co.igns.business.sales.model.sal0140.Sal0140ReqDto;
import kr.co.igns.business.sales.model.sal0140.Sal0140VO;

@Mapper
public interface Sal0140Dao {

	List<Sal0120VO> getSal0120(Sal0120ReqDto reqDto);
	List<Sal0140VO> getSal0140(Sal0140ReqDto reqDto);
	
	int insertSal0140(Sal0140VO vo);
	int deleteSal0140(Sal0140VO vo);
	int updateSal0140(Sal0120CountReqDto reqDto);
	String getRetNo(Sal0140VO vo);
	String getRetLotDetail(Sal0140VO vo);
	String getPrice(Sal0140VO vo);
	int upsertMat0020(Mat0020Dto dto);
	int updateMat0021(Mat0020Dto dto);
	int insertMat0021(Mat0020Dto dto);
	
	int updateMat0020(Mat0020Dto dto);
	int deleteMat0021(Mat0020Dto dto);
	
}
