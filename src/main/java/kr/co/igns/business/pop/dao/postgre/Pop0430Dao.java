package kr.co.igns.business.pop.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.igns.business.pop.model.Pop0430ReqDto;
import kr.co.igns.business.pop.model.Pop0430VO;

@Mapper
@Repository
public interface Pop0430Dao {
	
	// 기타출고등록 정보 조회
	List<Pop0430VO> getPop0430(Pop0430ReqDto dto);
	// 출하검사여부 조회
	String getOutInsp(Pop0430ReqDto dto); 
	// 기타출고등록 정보 삽입
	int createPop0430(Pop0430VO vo);
	// 거래처별 품목 정보 조회
	List<String> getItemListWithCustCode(Pop0430ReqDto dto);
}
