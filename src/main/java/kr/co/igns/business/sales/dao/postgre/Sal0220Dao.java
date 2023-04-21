package kr.co.igns.business.sales.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.sales.model.sal0220.Sal0220ReqDto;
import kr.co.igns.business.sales.model.sal0220.Sal0220VO;

@Mapper
public interface Sal0220Dao {

	// 출하실적현황 조회
	List<Sal0220VO> getSal0220(Sal0220ReqDto reqDto);
	
	// 기타출고현황 조회
	List<Sal0220VO> getSal0220OtherRelease(Sal0220ReqDto reqDto);
	
	// 창고코드 획득
	String getLocCode(Sal0220VO vo);
	// 재고 정보 마스터 업데이트
	int updateMat0020(Sal0220VO vo);
	// 재고 정보 상세 업데이트
	int updateMat0021(Sal0220VO vo);
	
	// 기타출고실적 삭제
	int deleteSal0220OhterRelease(Sal0220VO vo); 
}
