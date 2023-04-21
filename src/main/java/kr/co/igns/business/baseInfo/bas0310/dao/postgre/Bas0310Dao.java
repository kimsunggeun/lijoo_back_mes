package kr.co.igns.business.baseInfo.bas0310.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.baseInfo.bas0310.model.Bas0310PartDto;
import kr.co.igns.business.baseInfo.bas0310.model.Bas0310PriceDto;
import kr.co.igns.business.baseInfo.bas0310.model.Bas0310PriceVO;
import kr.co.igns.business.baseInfo.bas0310.model.Bas0310ReqDto;
import kr.co.igns.business.baseInfo.bas0310.model.Bas0310VO;

@Mapper
public interface Bas0310Dao {
	//거래처명 조회
	List<Bas0310VO> getCustomName(Bas0310ReqDto reqDto);
	
	//품목정보
	List<Bas0310VO> getItemInfo(Bas0310ReqDto reqDto);
	//품목마스터
	List<Bas0310VO> getPartList(Bas0310ReqDto reqDto);
	
	//거래처별 품목정보 등록
	void setCustPart(Bas0310PartDto partDto);
	//거래처별 품목정보 수정
	void updateCustPart(Bas0310PartDto partDto);	
	//거래처별 품목정보 삭제
	void delCustPart(Bas0310ReqDto reqDto);
	
	//단가정보
	List<Bas0310PriceVO> getPriceInfo(Bas0310ReqDto reqDto);
	//변경단가 등록
	void createPriceInfo(Bas0310PriceDto reqDto);
	//변경단가 수정
	void updatePriceInfo(Bas0310PriceDto reqDto);	
	//변경단가 삭제
	void delPriceInfo(Bas0310PriceDto reqDto);
}
