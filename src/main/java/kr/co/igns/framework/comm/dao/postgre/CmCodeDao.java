package kr.co.igns.framework.comm.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.framework.comm.model.CmChildCodeVO;
import kr.co.igns.framework.comm.model.CmCodeReqDto;
import kr.co.igns.framework.comm.model.CmCodeVO;

@Mapper
public interface CmCodeDao {

	List<CmCodeVO> getCmCode(CmCodeReqDto reqDto);
	int createCmCode(CmCodeVO vo);
	int updateCmCode(CmCodeVO vo);
	
	List<CmChildCodeVO> getCmChildCode(CmCodeReqDto reqDto);
	int createCmChildCode(CmChildCodeVO vo);
	int updateCmChildCode(CmChildCodeVO vo);
	
	void deleteCmCode(CmCodeReqDto reqDto);
	void deleteCmChildCode(CmCodeReqDto reqDto);
}
