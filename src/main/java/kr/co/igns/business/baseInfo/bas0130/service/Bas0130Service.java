package kr.co.igns.business.baseInfo.bas0130.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.igns.business.baseInfo.bas0130.dao.postgre.Bas0130Dao;
import kr.co.igns.business.baseInfo.bas0130.model.Bas0130Dto;
import kr.co.igns.business.baseInfo.bas0130.model.Bas0080VO;
import kr.co.igns.business.baseInfo.bas0130.model.Bas0081VO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Bas0130Service {
	
	private final Bas0130Dao bas0130dao;
	
	//근무시간/휴게시간 조회
	public List<Bas0080VO> getWorkTime(Bas0130Dto dto){
		List<Bas0080VO> list = bas0130dao.getWorkTime(dto);
		return list;
	}
	
	//근무시간/휴게시간 입력/수정
	public void setWorkTime(List<Bas0080VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		
		voList.forEach(s -> {
			s.setMaker(loginId);
			s.setEditor(loginId);
			bas0130dao.setWorkTime(s);
		});
	}
	
	//근무시간/휴게시간 삭제
	public void delWorkTime(List<Bas0130Dto> reqDto) {
		reqDto.forEach(s -> bas0130dao.delWorkTime(s));
	}
	
	//근무일 조회
	public List<Bas0081VO> getWorkDate(Bas0130Dto dto){
		List<Bas0081VO> list = bas0130dao.getWorkDate(dto);
		return list;
	}
	
	//근무일 수정
	public void setWorkDate(List<Bas0081VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		
		voList.forEach(s -> {
			s.setMaker(loginId);
			s.setEditor(loginId);
			bas0130dao.setWorkDate(s);
		});
	}
	
	//월별 날짜 Data 생성
	public void setMonthData(Bas0130Dto reqDto) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		reqDto.setMaker(loginId.toString());
		bas0130dao.setMonthData(reqDto);
	}
}
