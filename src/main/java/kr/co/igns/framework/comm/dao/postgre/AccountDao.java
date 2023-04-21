package kr.co.igns.framework.comm.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.framework.comm.model.AccountReqDto;
import kr.co.igns.framework.comm.model.AccountVO;

@Mapper
public interface AccountDao {

	List<AccountVO> getAccount(AccountReqDto reqDto);
	int checkAccountCd(AccountReqDto reqDto);
	
	int createAccount(AccountVO vo);
	int updateAccount(AccountVO vo);
	int deleteAccount(AccountVO vo);
	
	List<AccountVO> custDeleteCheck_Bas(AccountVO vo);
	List<AccountVO> custDeleteCheck_Sal(AccountVO vo);
	List<AccountVO> custDeleteCheck_Mat(AccountVO vo);
	List<AccountVO> custDeleteCheck_Pro(AccountVO vo);
}
