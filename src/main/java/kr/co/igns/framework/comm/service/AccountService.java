package kr.co.igns.framework.comm.service;

import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.stereotype.Service;
import kr.co.igns.framework.comm.dao.postgre.AccountDao;
import kr.co.igns.framework.comm.model.AccountReqDto;
import kr.co.igns.framework.comm.model.AccountVO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;

@RequiredArgsConstructor
@Service
public class AccountService{

	private final AccountDao accountDao;
	private final IgnsSessionUtils ignsSessionUtils;
	
	//거래처 조회
	public List<AccountVO> getAccount(AccountReqDto reqDto) {
		List<AccountVO> list = accountDao.getAccount(reqDto);
        return list;
    }
		
	//거래처코드 중복체크
	public int checkAccountCd(AccountReqDto reqDto) {
		int count = accountDao.checkAccountCd(reqDto);
        return count;
    }
	//거래처코드 입력/수정
	public int createAccount(List<AccountVO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		for(AccountVO vo : voList) {
			if(vo.is__created__()) {
				vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
				accountDao.createAccount(vo);					
			} else if(vo.is__modified__()) {
				vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
				accountDao.updateAccount(vo);
			}
		}
		return 0;
    }

	//거래처코드 삭제
	public int deleteAccount(List<AccountVO> voList) throws Exception {
		List<AccountVO> basNullCheck = accountDao.custDeleteCheck_Bas(voList.get(0));
		List<AccountVO> salNullCheck = accountDao.custDeleteCheck_Sal(voList.get(0));
		List<AccountVO> matNullCheck = accountDao.custDeleteCheck_Mat(voList.get(0));
		List<AccountVO> proNullCheck = accountDao.custDeleteCheck_Pro(voList.get(0));
		if(!basNullCheck.isEmpty() || !salNullCheck.isEmpty() || !matNullCheck.isEmpty() || !proNullCheck.isEmpty()) {
			throw new Exception("이 거래처로 생성된 데이터들이 있어 삭제가 불가능합니다. 사용유무 체크를 해제하는 것을 권장드립니다");
		}

		for(AccountVO vo : voList) {
			accountDao.deleteAccount(vo);
		}
		return 0;
	}

	
}
