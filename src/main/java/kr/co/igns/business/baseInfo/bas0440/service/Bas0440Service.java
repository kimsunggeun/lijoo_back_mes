package kr.co.igns.business.baseInfo.bas0440.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.igns.business.baseInfo.bas0440.dao.postgre.Bas0440Dao;
import kr.co.igns.business.baseInfo.bas0440.model.Bas0440DepVO;
import kr.co.igns.business.baseInfo.bas0440.model.Bas0440Dto;
import kr.co.igns.business.baseInfo.bas0440.model.Bas0440VO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Bas0440Service {
	
	private final Bas0440Dao bas0440dao;
	
	// 부서 조회
	public List<Bas0440DepVO> getDepInfo(Bas0440DepVO vo){
		List<Bas0440DepVO> list = bas0440dao.getDepInfo(vo);
		return list;
	}
	
	// 계측기 조회
	public List<Bas0440VO> getItemInfo(Bas0440Dto dto){
		List<Bas0440VO> list = bas0440dao.getItemInfo(dto);
		return list;
	}
	
	// 계측기 입력/수정
	public int saveItem(List<Bas0440VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		
		for(Bas0440VO vo : voList) {
			if(vo.is__created__()) {
				vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
				bas0440dao.createBas0440(vo);
			} else if(vo.is__modified__()) {
				vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
				bas0440dao.updateBas0440(vo);
			}
		}
		return 0;
	}
	
	// 계측기 삭제
	public int deleteItem(List<Bas0440VO> voList) {
		for(Bas0440VO vo : voList) {
			bas0440dao.deleteBas0440(vo);
		}
		return 0;
	}
}
