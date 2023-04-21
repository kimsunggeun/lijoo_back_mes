package kr.co.igns.business.out.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.igns.business.out.dao.postgre.Out0020Dao;
import kr.co.igns.business.out.model.out0020.Out0020ReqDto;
import kr.co.igns.business.out.model.out0020.Out0020VO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Out0020Service {
	
	@Autowired
	private final Out0020Dao out0020Dao;
	
	//공정외주발주등록 조회
	public List<Out0020VO> getOut0020(Out0020ReqDto reqDto) {
        return out0020Dao.getOut0020(reqDto);
    }
	
	//공정외주발주등록 등록/수정
	public int createOut0020(List<Out0020VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
			
		voList.forEach(s -> {
			if(s.is__created__()) {
				s.setMaker(loginId.equals("") ? "" : loginId);
				out0020Dao.createOut0020(s);					
			} else if(s.is__modified__()) {
				s.setEditor(loginId.equals("") ? "" : loginId);
				out0020Dao.updateOut0020(s);
			}
		});

		return 0;
    }
}