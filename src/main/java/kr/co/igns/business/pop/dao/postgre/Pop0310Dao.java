package kr.co.igns.business.pop.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import kr.co.igns.business.pop.model.Pop0310VO;
import kr.co.igns.business.pop.model.Pop0310ReqDto;

@Mapper
@Repository
public interface Pop0310Dao {
	List<Pop0310VO> getPop0310(Pop0310ReqDto reqDto); //전산번호 조회
	List<Pop0310VO> getpartNo(Pop0310ReqDto reqDto); //품목코드 조회
	List<Pop0310VO> getwhNm(Pop0310ReqDto reqDto); // 창고명 조회
	List<Pop0310VO> getwork(Pop0310ReqDto reqDto); // 작업반 조회
	List<Pop0310VO> getstock(Pop0310ReqDto reqDto); // 팝업재고조회
	List<Pop0310VO> getworkprocess(Pop0310ReqDto reqDto); // 팝업재공조회
	
	int createMat0021(Pop0310VO vo); //로트분할 저장
	int updateMat0021(Pop0310VO vo); //로트분할 업데이트
}
