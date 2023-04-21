package kr.co.igns.business.mat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.igns.business.mat.dao.postgre.Mat0080Dao;
import kr.co.igns.business.mat.model.mat0080.Mat0080VO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Mat0080Service{

	private final Mat0080Dao mat0080Dao;
	private int result = 0;
	
	//구매발주업로드 정보 가져오기
	public List<Mat0080VO> getPurchaseOrder(List<Mat0080VO> voList){
		System.out.println("컨펌버튼 누름");
		ArrayList<Mat0080VO> list = new ArrayList<Mat0080VO>();

		int idCnt = 0;
		for(Mat0080VO vo : voList) {
			System.out.println("확인");
			vo.setId(Integer.toString(idCnt));
			list.add(mat0080Dao.getPurchaseOrder(vo).get(0));
			idCnt++;
		}
		return list;
	}
	
	//구매발주 업로드 정보 저장하기
	@Transactional(rollbackFor = Exception.class)
	public int savePurchaseOrder(List<Mat0080VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		for(Mat0080VO vo : voList) {
			vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
			mat0080Dao.insertPurchaseOrder(vo);
			mat0080Dao.insertDetailPurchaseOrder(vo);
			result = 1;
		}
		return result;
	}

}
