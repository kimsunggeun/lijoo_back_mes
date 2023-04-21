package kr.co.igns.business.baseInfo.bas0410.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.baseInfo.bas0410.model.Bas0410ReqDto;
import kr.co.igns.business.baseInfo.bas0410.model.Bas0410VO;

@Mapper
public interface Bas0410Dao {
	//검사유형 조회
	List<Bas0410VO> getInspecType(Bas0410ReqDto reqDto);
	//검사항목 조회
	List<Bas0410VO> getInspecItem(Bas0410ReqDto reqDto);
	
	//검사항목 등록
	void setInspecItem(Bas0410VO vo);

	//검사항목 수정
	void modiInspecItem(Bas0410VO vo);
	
	//검사항목 삭제
	void delInspItem(Bas0410ReqDto reqDto);
}
