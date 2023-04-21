package kr.co.igns.business.sales.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.igns.business.sales.dao.postgre.Sal0020Dao;
import kr.co.igns.business.sales.model.sal0020.Sal0020VO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Sal0020Service {
	
	private final Sal0020Dao sal0020Dao;
	private int result = 0;
	
	//고객주문업로드 정보 가져오기
	public List<Sal0020VO> getCustOrder(List<Sal0020VO> voList){
		ArrayList<Sal0020VO> list = new ArrayList<Sal0020VO>();
		int idCnt = 0;
		for(Sal0020VO vo : voList ) {
			vo.setId(Integer.toString(idCnt));
			list.add(sal0020Dao.getCustOrder(vo).get(0));	
			idCnt++;
		}
		return list;
	}
	
	//고객주문 업로드 정보 저장하기
	@Transactional(rollbackFor = Exception.class)
	public int saveCustOrder(List<Sal0020VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		for(Sal0020VO vo : voList) {
			vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
			sal0020Dao.ctCustOrder(vo);
			sal0020Dao.ctCustOrderDetail(vo);
			result = 1;
		}
		return result;
	}
	
	

}
