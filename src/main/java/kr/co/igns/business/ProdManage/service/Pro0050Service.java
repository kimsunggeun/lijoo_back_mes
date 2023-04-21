package kr.co.igns.business.ProdManage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.igns.business.ProdManage.dao.postgre.Pro0050Dao;
import kr.co.igns.business.ProdManage.model.pro0050.Bas0034VO;
import kr.co.igns.business.ProdManage.model.pro0050.Bas0035VO;
import kr.co.igns.business.ProdManage.model.pro0050.Pro0050PartInfoVO;
import kr.co.igns.business.ProdManage.model.pro0050.Pro0050PathDto;
import kr.co.igns.business.ProdManage.model.pro0050.Pro0050PathVO;
import kr.co.igns.business.ProdManage.model.pro0050.Pro0050ReqDto;
import kr.co.igns.business.ProdManage.model.pro0050.Pro0050VO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Pro0050Service {

	@Autowired
	private final Pro0050Dao pro0050Dao;
	
	//작업지시  조회
	public List<Pro0050VO> getPro0050(Pro0050ReqDto reqDto) {
		System.out.println(reqDto.getComCode());
        return pro0050Dao.getPro0050(reqDto);
    }
	
	//작업장 정보
	public List<Bas0034VO> getBas0034(Pro0050ReqDto reqDto) {
		System.out.println(reqDto.getComCode());
        return pro0050Dao.getbas0034(reqDto);
    }
	
	//작업반 정보
	public List<Bas0035VO> getBas0035(Pro0050ReqDto reqDto) {
		System.out.println(reqDto.getComCode());
        return pro0050Dao.getbas0035(reqDto);
    }
	
	//품목 선택 팝업
	public List<Pro0050PartInfoVO> getPartInfo(Pro0050ReqDto reqDto) {
		System.out.println(reqDto.getComCode());
        return pro0050Dao.getPartInfo(reqDto);
    }
	
	//품목 선택 팝업
	public List<Pro0050PathVO> getPathInfo(Pro0050PathDto reqDto) {
		System.out.println(reqDto.getComCode());
        return pro0050Dao.getPathInfo(reqDto);
    }
	
	public List<Pro0050PathVO> getPathWorkInfo(Pro0050ReqDto reqDto) {
		System.out.println(reqDto.getComCode());
        return pro0050Dao.getPathWorkInfo(reqDto);
    }
	
	//작업지시 상태 변경
	public int ordState(List<Pro0050VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		for(Pro0050VO vo : voList) {
			vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
			pro0050Dao.OrderState(vo);
		}
		return 0;
    }
	
	//작업지시관리 등록/수정
	public int createPro0050(List<Pro0050VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
			
		voList.forEach(s -> {
			if(s.is__created__()) {
				s.setMaker(loginId.equals("") ? "" : loginId);
				pro0050Dao.createPro0050(s);					
			} else if(s.is__modified__()) {
				s.setEditor(loginId.equals("") ? "" : loginId);
				pro0050Dao.updatePro0050(s);
			}
		});

		return 0;
    }
	
	//작업지시  삭제
	public int delPro0050(List<Pro0050ReqDto> reqDto) {
		
		reqDto.forEach(s -> pro0050Dao.deletePro0050(s));
		
        return 0;
    }
	
}
