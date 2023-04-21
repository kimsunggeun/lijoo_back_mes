package kr.co.igns.business.pop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import kr.co.igns.business.pop.model.Pop0310VO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import kr.co.igns.business.pop.dao.postgre.Pop0310Dao;
import kr.co.igns.business.pop.model.Pop0310ReqDto;

@RequiredArgsConstructor
@Service
public class Pop0310Service {
	
	private final Pop0310Dao pop0310dao;
	
	// 전산번호조회
	public List<Pop0310VO> getPop0310(Pop0310ReqDto reqDto) {
        return pop0310dao.getPop0310(reqDto);
    }
	//품목코드 조회
	public List<Pop0310VO> getpartNo(Pop0310ReqDto reqDto) {
        return pop0310dao.getpartNo(reqDto);
    }
	
	//창고명 조회
	public List<Pop0310VO> getwhNm(Pop0310ReqDto reqDto) {
        return pop0310dao.getwhNm(reqDto);
    }
	
	//작업반 조회
	public List<Pop0310VO> getwork(Pop0310ReqDto reqDto) {
        return pop0310dao.getwork(reqDto);  
	}
	
	//팝업재고 조회
	public List<Pop0310VO> getstock(Pop0310ReqDto reqDto) {
        return pop0310dao.getstock(reqDto);  
	}
	
	//팝업재공 조회
	public List<Pop0310VO> getworkprocess(Pop0310ReqDto reqDto) {
        return pop0310dao.getworkprocess(reqDto);  
	}
	
	//로트분할 저장
	@Transactional(rollbackFor = Exception.class)
	public int createMat0021(List<Pop0310VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		for(Pop0310VO vo : voList) {
					vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
					pop0310dao.createMat0021(vo);
		}
		return 0;
	}
	
	//로트분할 업데이트
	@Transactional(rollbackFor = Exception.class)
	public int updateMat0021(List<Pop0310VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		for(Pop0310VO vo : voList) {
					vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
					pop0310dao.updateMat0021(vo);
		}
		return 0;
	}
}
