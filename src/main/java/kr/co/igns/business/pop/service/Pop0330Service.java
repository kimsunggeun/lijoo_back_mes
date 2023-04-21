package kr.co.igns.business.pop.service;

import java.util.List;

import org.springframework.stereotype.Service;


import kr.co.igns.business.pop.dao.postgre.Pop0330Dao;
import kr.co.igns.business.pop.model.Pop0330Dto;
import kr.co.igns.business.pop.model.Pop0330PopUpVO;
import kr.co.igns.business.pop.model.Pop0330VO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Pop0330Service {

	private final Pop0330Dao pop0330dao;

	

	
	public List<Pop0330VO> getPop0330(Pop0330Dto dto) {//??
		System.out.println(dto);
		List<Pop0330VO> list = pop0330dao.getPop0330(dto);
		System.out.println(list);
		return list;
		
    }
	
	public List<Pop0330PopUpVO> getPopup0330(Pop0330Dto dto) {//??
		System.out.println(dto);
		List<Pop0330PopUpVO> listpopup = pop0330dao.getPopup0330(dto);
		System.out.println(listpopup);
		return listpopup;
		
    }

	
	
	
}
