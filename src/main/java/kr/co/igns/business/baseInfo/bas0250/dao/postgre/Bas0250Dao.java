package kr.co.igns.business.baseInfo.bas0250.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.baseInfo.bas0250.model.Bas0250ReqDto;
import kr.co.igns.business.baseInfo.bas0250.model.Bas0250VO;

@Mapper
public interface Bas0250Dao {
	//잡셋업유형 조회
	List<Bas0250VO> getInspecType(Bas0250ReqDto reqDto);
	
	//잡셋업항목 조회
	List<Bas0250VO> getFacItem(Bas0250ReqDto reqDto);
	//작업반 콤보박 조회
	List<Bas0250VO> getWorkShopInfo(Bas0250ReqDto reqDto);
	//설비코드 콤보박 조회
	List<Bas0250VO> getFacilityInfo(Bas0250ReqDto reqDto);
	
	//잡셋업항목 등록
	void setInspecItem(Bas0250VO vo);

	//잡셋업항목 수정
	void modiInspecItem(Bas0250VO vo);
	
	//잡셋업항목 삭제
	void delInspecItem(Bas0250ReqDto reqDto);
}
