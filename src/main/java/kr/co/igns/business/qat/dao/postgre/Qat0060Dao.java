package kr.co.igns.business.qat.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.qat.model.qat0060.Qat0060Dto;
import kr.co.igns.business.qat.model.qat0060.Qat0060VO;
import kr.co.igns.business.qat.model.qat0060.QatOutStatusDto;

@Mapper
public interface Qat0060Dao {
	//납품정보 조회
	List<Qat0060VO> getQat0060(Qat0060Dto dto);

	//출하검사 검사내역 조회
	List<Qat0060VO> getInspection(QatOutStatusDto dto);	
	
	//출하검사 저장
	int createQat0060(Qat0060VO vo);
	
	//출하검사 취소(삭제)
	int deleteQat0060(Qat0060VO vo);

	String selectIlno(Qat0060VO voList);
}
