package kr.co.igns.business.pop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import kr.co.igns.business.pop.model.Pop0310VO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import kr.co.igns.business.pop.dao.postgre.Pop0320Dao;

@RequiredArgsConstructor
@Service
public class Pop0320Service {
	
	private final Pop0320Dao pop0320dao;

	//로트병합 저장
	@Transactional(rollbackFor = Exception.class)
	public int createPro0019(List<Pop0310VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		int qty = 0;
		for(Pop0310VO vo : voList) {
					vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
					qty += Integer.parseInt(vo.getOldQty());
					vo.setQty(Integer.toString(qty));
					pop0320dao.createPro0019(vo);
		}
		return 0;
	}

	//로트병합 업데이트
	@Transactional(rollbackFor = Exception.class)
	public int updateMat0021(List<Pop0310VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		for(Pop0310VO vo : voList) {
					vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
					pop0320dao.updateMat0021(vo);
		}
		return 0;
	}
	
	//로트병합될 데이터 업데이트
	@Transactional(rollbackFor = Exception.class)
	public int mergedUpdateMat0021(List<Pop0310VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		for(Pop0310VO vo : voList) {
			vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
			pop0320dao.mergedUpdateMat0021(vo);
		}
		return 0;
	}
}
