package kr.co.igns.business.out.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.out.model.out0010.Out0010ReqDto;
import kr.co.igns.business.out.model.out0010.Out0010VO;

@Mapper
public interface Out0010Dao {

	List<Out0010VO> getOut0010(Out0010ReqDto reqDto);
	List<Out0010VO> getAccount(Out0010ReqDto reqDto);
	List<Out0010VO> getAccount_out0010(Out0010ReqDto reqDto);
	List<Out0010VO> getUserId(Out0010ReqDto reqDto);
	int createMat0012(Out0010VO vo);
	int createMat0018(Out0010VO vo);
	String getIlNo(Out0010VO vo);

	int updateMat0011(Out0010VO vo);
	int updateMat0011_2(Out0010VO vo);
	int updateMat0011_3(Out0010VO vo);
	int deleteMat0012(Out0010VO vo);
	int deleteMat0018(Out0010VO vo);
	int updateMat0020_2(Out0010VO vo);
	int deleteMat0021(Out0010VO vo);
	int deleteQat0010(Out0010VO vo);
	
}
