package kr.co.igns.business.qat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.igns.business.mat.model.mat0030.Mat0018VO;
import kr.co.igns.business.qat.dao.postgre.Qat0010Dao;
import kr.co.igns.business.qat.model.qat0010.Bas0061VO;
import kr.co.igns.business.qat.model.qat0010.Mat0012VO;
import kr.co.igns.business.qat.model.qat0010.Qat0010Dto;
import kr.co.igns.business.qat.model.qat0010.Qat0010VO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Qat0010Service {

	private final Qat0010Dao qat0010dao;
	private int result = 0;
	private int cnt = 0;

	// 납품정보 조회
	public List<Mat0012VO> getDelInfo(Qat0010Dto dto) {
		List<Mat0012VO> list = qat0010dao.getDelInfo(dto);
		return list;
	}

	// 납품정보 조회
	public List<Qat0010VO> getMat0018_Qat0010(Qat0010Dto dto) {
		List<Qat0010VO> list = qat0010dao.getMat0018_Qat0010(dto);
		return list;
	}

	// 검사내역 가져오기
	public List<Bas0061VO> getInsDetails(Qat0010Dto dto) {
		List<Bas0061VO> list = qat0010dao.getInsDetails(dto);
		return list;
	}

	// 검사내역 정보 저장
	@Transactional(rollbackFor = Exception.class)
	public int saveInsDetails(List<Qat0010VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		voList.forEach(a -> { // 검사내역 테이블의 모든 정보를 갖고와서 forEach 시킴
			if (a.getJudge().equals("20")) { // 그 중에 판정이 불합격(20)이라면
				cnt++; // cnt를 1 올림
			}
		});
		String ordNo = qat0010dao.maxOrdNo(voList.get(0));
		for (Qat0010VO vo : voList) {
			vo.setMaxOrdNo(ordNo);
			vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
			vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
			// 검사내역 저장
			qat0010dao.saveInsDetails(vo); // qat0010에 데이터 저장
		}

		// 입고상태 수정
		if (cnt > 0) { // 만약 cnt가 1보다 크면 (불합격이 하나라도 있다는 의미)
			voList.get(0).setInStatus("50"); // mat0012의 InStatus의 값을 50(검사불량)으로 넣음
			// 구매 입고 등록 입고상태 update
			qat0010dao.utMat0012(voList.get(0)); // mat0011의 입고량, 구성량에 영향 끼치지 않고 mat0012의 입고상태만 업데이트 됨
			cnt = 0;
		} else { // 만약 모두 합격이라면
			voList.get(0).setInStatus("40"); // 모두 합격이라면 입고상태를 검사입고로 바꾸고
			qat0010dao.utMat0018(voList.get(0));
			// 구매 입고 등록 입고상태 update
			qat0010dao.utMat0012(voList.get(0)); // mat0012 입고상태 업데이트
			// 구매발주정보 상세 Update
			qat0010dao.utMat0011(voList.get(0)); // mat0011의 입고량, 잔량에 영향을 끼침
			// 재고정보마스터 upsert
			qat0010dao.upsertMat0020(voList.get(0)); // 데이터가 존재하지 않으면 insert, 데이터가 존재한다면 수량, 가격만 업데이트 됨

			// 리스트 가져오기
			ArrayList<Qat0010VO> list = new ArrayList<Qat0010VO>();
			list.addAll(qat0010dao.getLotDetail(voList.get(0))); // qat0010dao.getLotDetail = mat0018데이터의 lotDetail
			int price = 0;
			for (int i = 1; i <= Integer.parseInt(voList.get(0).getBoxQty()); i++) {
				var qty = voList.get(0).getMakeQty();
				price = Integer.parseInt(voList.get(0).getInPrice()) * Integer.parseInt(qty);
				if (i == Integer.parseInt(voList.get(0).getBoxQty())) { // 마지막 개수
					var a = Integer.parseInt(voList.get(0).getInQty()); // 17
					var b = Integer.parseInt(voList.get(0).getMakeQty());// 10
					if (a % b == 0) {
						qty = voList.get(0).getMakeQty();
					} else {
						qty = Integer.toString(a % b);
					}
					price = Integer.parseInt(voList.get(0).getInPrice()) * Integer.parseInt(qty);
				}
				voList.get(0).setStockQty(qty);
				voList.get(0).setInAmount(Integer.toString(price));
				voList.get(0).setLotDetail(list.get(i - 1).getLotDetail()); // 리스트 0번째의 getLotDetail(0001) 값을 LotDetail에
																			// 담음, 리스트 1번째의 getLotDetail(0002) 값을
																			// LotDetail에 담음
				qat0010dao.ctMat0021(voList.get(0));
			}
			cnt = 0;
		}

		result = 1;

		return result;
	}
	
	//검사번호 채번
	public String getMaxOrdNo(Qat0010VO dao) {
		String list = qat0010dao.maxOrdNo(dao);
		return list;
	}

	// 입고내역 삭제
	@Transactional(rollbackFor = Exception.class)
	public int deleteQat0010(List<Qat0010VO> voList){
		qat0010dao.maxOrdNo(voList.get(0));
		for(Qat0010VO vo : voList) {
			qat0010dao.deleteQat0010(vo);
			qat0010dao.updateMat0012(vo);
			qat0010dao.updateMat0018(vo);			
			qat0010dao.deleteMat0021_2(vo);			
		}
		qat0010dao.updateMat0011_2(voList.get(0));
		qat0010dao.updateMat0020(voList.get(0));
		return 1;
	}
}
