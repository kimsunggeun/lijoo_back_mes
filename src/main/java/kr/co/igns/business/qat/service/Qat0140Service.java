package kr.co.igns.business.qat.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.igns.business.qat.dao.postgre.Qat0140Dao;
import kr.co.igns.business.qat.model.qat0140.Qat0140ReqDto;
import kr.co.igns.business.qat.model.qat0140.Qat0140VO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Qat0140Service{

	private final Qat0140Dao qat0140Dao;
	private final IgnsSessionUtils ignsSessionUtils;
	
	//반품등록 조회
	public List<Qat0140VO> getQat0140(Qat0140ReqDto reqDto) {
		List<Qat0140VO> list = qat0140Dao.getQat0140(reqDto);
        return list;
    }
		
	//반품등록 입력/수정
	public int createqat0140(List<Qat0140VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		
		for(Qat0140VO vo : voList) {
			if(vo.is__created__()) {
				vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
				qat0140Dao.createQat0140(vo);					
			} else if(vo.is__modified__()) {
				vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
				qat0140Dao.updateQat0140(vo);
			}
		}
		return 0;
    }
}
