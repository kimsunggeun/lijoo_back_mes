package kr.co.igns.business.baseInfo.bas0020.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.igns.business.baseInfo.bas0020.dao.postgre.Bas0020Dao;
import kr.co.igns.business.baseInfo.bas0020.model.Bas0023VO;
import kr.co.igns.business.baseInfo.bas0020.model.Bas0040VO;
import kr.co.igns.business.baseInfo.bas0020.model.Bas0043VO;
import kr.co.igns.business.baseInfo.bas0020.model.Bas0044VO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Bas0020Service {
	
	private final Bas0020Dao bas0020Dao;
	private int result = 0;
	
	//거래처 업로드 가져오기
	@Transactional(rollbackFor = Exception.class)
	public List<Bas0023VO> getAccountInfo(List<Bas0023VO> voList) {
		ArrayList<Bas0023VO> list = new ArrayList<Bas0023VO>();
		int idCnt = 0;
		for(Bas0023VO vo : voList) {
			vo.setId(Integer.toString(idCnt));
			list.add(bas0020Dao.getAccountInfo(vo).get(0));
			idCnt++;
		}
		return list;
	}
	
	//거래처 업로드 중복값
	@Transactional(rollbackFor = Exception.class)
	public List<Bas0023VO> getCustCode(Bas0023VO vo) {
		return bas0020Dao.getCustCode(vo);
	}
	
	//거래처 업로드 저장하기
	@Transactional(rollbackFor = Exception.class)
	public int saveAccountInfo(List<Bas0023VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		for(Bas0023VO vo : voList) {
			vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
			if(!vo.isCodeChk()) {
				bas0020Dao.ctAccountInfo(vo);
			}
			result = 1;
		}		
		return result;
	}
	
	//품목정보 업로드 가져오기
	public List<Bas0040VO> getPartTypeInfo(List<Bas0040VO> voList) {
		ArrayList<Bas0040VO> list = new ArrayList<Bas0040VO>();
		int idCnt = 0;
		for(Bas0040VO vo : voList) {
			vo.setId(Integer.toString(idCnt));
			list.add(bas0020Dao.getPartTypeInfo(vo).get(0));
			idCnt++;
		}
		return list;
	}
	
	//품목정보 업로드 중복값
	@Transactional(rollbackFor = Exception.class)
	public List<Bas0040VO> partTypeOverlap(Bas0040VO vo) {
		return bas0020Dao.partTypeOverlap(vo);
	}
	
	//품목정보 업로드 저장하기
	@Transactional(rollbackFor = Exception.class)
	public int savePartTypeInfo(List<Bas0040VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		for(Bas0040VO vo : voList) {
			vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
			bas0020Dao.ctPartTypeInfo(vo);
			result = 1;
		}
		return result;
	}
	
	//BOM정보 업로드 가져오기
	@Transactional(rollbackFor = Exception.class)
	public List<Bas0043VO> getBomInfo(List<Bas0043VO> voList) {
		ArrayList<Bas0043VO> list = new ArrayList<Bas0043VO>();
		int idCnt = 0;
		for(Bas0043VO vo : voList) {
			vo.setId(Integer.toString(idCnt));
			list.add(bas0020Dao.getBomInfo(vo).get(0));
			idCnt++;
		}
		return list;
	}
	
	//BOM정보 업로드 저장하기
	@Transactional(rollbackFor = Exception.class)
	public int saveBomInfo(List<Bas0043VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		for(Bas0043VO vo : voList) {
			vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
			bas0020Dao.ctBomInfo(vo);
			bas0020Dao.ctBomPathDetailInfo(vo);
			bas0020Dao.ctBomPathTypeInfo(vo);
			result = 1;
		}
		return result;
	}
	
	//거래처별 품목정보 업로드
	@Transactional(rollbackFor = Exception.class)
	public List<Bas0044VO> getItemByCustInfo(List<Bas0044VO> voList) {
		ArrayList<Bas0044VO> list = new ArrayList<Bas0044VO>();
		int idCnt = 0;
		for(Bas0044VO vo : voList) {
			vo.setId(Integer.toString(idCnt));
			list.add(bas0020Dao.getItemByCustInfo(vo).get(0));
			idCnt++;
		}
		return list;
	}
	
	//거래처별 품목정보 저장
	@Transactional(rollbackFor = Exception.class)
	public int saveItemByCustInfo(List<Bas0044VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		for(Bas0044VO vo : voList) {
//			vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
			bas0020Dao.ctItemByCustInfo(vo);
			result = 1;
		}
		return result;
	}
	
	//거래처별 품목정보 중복값
	@Transactional(rollbackFor = Exception.class)
	public List<Bas0044VO> itemByCustOverlap(Bas0044VO vo) {
		return bas0020Dao.itemByCustOverlap(vo);
	}
}
