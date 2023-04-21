package kr.co.igns.framework.comm.dao.postgre;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.framework.comm.model.UserCertVO;
import kr.co.igns.framework.comm.model.UserReqDto;
import kr.co.igns.framework.comm.model.UserVO;

@Mapper
public interface UserDao {

	List<UserVO> getUser(UserReqDto reqDto);
	ArrayList<UserCertVO> findByUserId(int uuid);
	// 아이디 중복체크
	int checkByUserId(UserReqDto vo);
		
	int createUser(UserVO vo);
	int updateUser(UserVO vo);
	int updateUserPass(UserVO vo);
	int deleteUser(UserVO vo);
	
	
	List<UserVO> userDeleteCheck_Bas(UserVO vo);
	List<UserVO> userDeleteCheck_Sal(UserVO vo);
	List<UserVO> userDeleteCheck_Mat(UserVO vo);
	List<UserVO> userDeleteCheck_Pro(UserVO vo);
}
