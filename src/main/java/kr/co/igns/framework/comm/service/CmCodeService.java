package kr.co.igns.framework.comm.service;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.igns.framework.comm.dao.postgre.CmCodeDao;
import kr.co.igns.framework.comm.dao.postgre.CompanyDao;
import kr.co.igns.framework.comm.model.CmChildCodeVO;
import kr.co.igns.framework.comm.model.CmCodeReqDto;
import kr.co.igns.framework.comm.model.CmCodeVO;
import kr.co.igns.framework.comm.model.CompanyReqDto;
import kr.co.igns.framework.comm.model.CompanyVO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;

@RequiredArgsConstructor
@Service
public class CmCodeService{

	private final CmCodeDao cmCodeDao;
	private final IgnsSessionUtils ignsSessionUtils;
	
	//공통코드 조회
	public List<CmCodeVO> getCmCode(CmCodeReqDto reqDto) {
		List<CmCodeVO> list = cmCodeDao.getCmCode(reqDto);
        return list;
    }
	
	//공통코드 입력/수정
	public int createCmCode(List<CmCodeVO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		
		for(CmCodeVO vo : voList) {
			if(vo.is__created__()) {
				vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
				cmCodeDao.createCmCode(vo);					
			} else if(vo.is__modified__()) {
				vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
				cmCodeDao.updateCmCode(vo);
			}
		}
		return 0;
    }
	
	//공통코드 상세 조회
	public List<CmChildCodeVO> getCmChildCode(CmCodeReqDto reqDto) {
		List<CmChildCodeVO> list = cmCodeDao.getCmChildCode(reqDto);
        return list;
    }
	
	//공통코드 상세 입력/수정
	public int createCmChildCode(List<CmChildCodeVO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		
		for(CmChildCodeVO vo : voList) {
			if(vo.is__created__()) {
				vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
				cmCodeDao.createCmChildCode(vo);					
			} else if(vo.is__modified__()) {
				vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
				cmCodeDao.updateCmChildCode(vo);
			}
		}
		return 0;
    }
	
	//공통코드 삭제
	public void delCmCode(List<CmCodeReqDto> reqDto) {
		reqDto.forEach(s -> cmCodeDao.deleteCmCode(s));
	}
	
	//공통코드 상세 삭제
	public void deleteCmChildCode(List<CmCodeReqDto> reqDto) {
		reqDto.forEach(s -> cmCodeDao.deleteCmChildCode(s));
	}
	
	
}
