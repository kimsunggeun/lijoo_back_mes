package kr.co.igns.business.baseInfo.bas0020.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.baseInfo.bas0020.model.Bas0023VO;
import kr.co.igns.business.baseInfo.bas0020.model.Bas0040VO;
import kr.co.igns.business.baseInfo.bas0020.model.Bas0043VO;
import kr.co.igns.business.baseInfo.bas0020.model.Bas0044VO;


@Mapper
public interface Bas0020Dao {
	//거래처 업로드 가져오기
	List<Bas0023VO> getAccountInfo(Bas0023VO vo);
	
	//거래처코드 중복 찾기(조회)
	List<Bas0023VO> getCustCode(Bas0023VO vo);
	
	//거래처 저장하기
	int ctAccountInfo(Bas0023VO vo);
		
	//품목정보 업로드 가져오기
	List<Bas0040VO> getPartTypeInfo(Bas0040VO vo);

	//품목정보 중복 찾기(조회)
	List<Bas0040VO> partTypeOverlap(Bas0040VO vo);
	
	//품목정보 저장하기
	int ctPartTypeInfo(Bas0040VO vo);
	
	//BOM정보 업로드 가져오기
	List<Bas0043VO> getBomInfo(Bas0043VO vo);
	
	//BOM정보 저장하기
	int ctBomInfo(Bas0043VO vo);
	
	//BOM 경로정보상세 저장하기
	int ctBomPathDetailInfo(Bas0043VO vo);
	
	//BOM 경로유형 저장하기
	int ctBomPathTypeInfo(Bas0043VO vo);
	
	//거래처별 품목 업로드 가져오기
	List<Bas0044VO> getItemByCustInfo(Bas0044VO vo);
	
	//거래처별 품목정보 저장하기
	int ctItemByCustInfo(Bas0044VO vo);
	
	//거래처별 품목정보 중복 찾기(조회)
	List<Bas0044VO> itemByCustOverlap(Bas0044VO vo);
}
