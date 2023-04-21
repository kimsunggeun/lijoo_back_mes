package kr.co.igns.business.baseInfo.bas0420.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.baseInfo.bas0420.model.Bas0420CopyDto;
import kr.co.igns.business.baseInfo.bas0420.model.Bas0420Dto;
import kr.co.igns.business.baseInfo.bas0420.model.Bas0420PartVO;
import kr.co.igns.business.baseInfo.bas0420.model.Bas0420VO;

@Mapper
public interface Bas0420Dao {
	//검사유형 조회
	List<Bas0420VO> getInspecType(Bas0420Dto dto);
	//품질기준정보 조회
	List<Bas0420VO> getQuaStanInfo(Bas0420Dto dto);
	//품질기준정보 set
	void setQuaStanInfo(Bas0420VO vo);
	//품질기준정보 삭제체크
	List<Bas0420VO> getInsCheck(Bas0420Dto vo);
	//품질기준정보 삭제
	void delQuaStanInfo(Bas0420Dto vo);
	
	//품질기준정보 품목 리스트
	List<Bas0420PartVO> getPartList(Bas0420Dto dto);
	//품질기준정보 마스터 복사
	void setPartCopy(Bas0420CopyDto partNo);

}
