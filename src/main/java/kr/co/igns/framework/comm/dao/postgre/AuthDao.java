package kr.co.igns.framework.comm.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.framework.comm.model.AuthMenuVO;
import kr.co.igns.framework.comm.model.AuthReqDto;
import kr.co.igns.framework.comm.model.AuthVO;

@Mapper
public interface AuthDao {

	List<AuthVO> getAuthGroup(AuthReqDto reqDto);
	int createAuthGroup(AuthVO vo);
	int updateAuthGroup(AuthVO vo);
	
	List<AuthMenuVO> getMenuAuthGroup(AuthReqDto reqDto);
	int createMenuAuthGroup(AuthMenuVO vo);
	int updateMenuAuthGroup(AuthMenuVO vo);
	
}
