package kr.co.igns.business.pop.service;

import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.igns.business.mat.model.mat0020.Mat0010VO;
import kr.co.igns.business.mat.model.mat0040.Mat0013VO;
import kr.co.igns.business.pop.dao.postgre.Pop0040Dao;
import kr.co.igns.business.pop.model.Pop0040ReqDto;
import kr.co.igns.business.pop.model.Pop0040VO;
import kr.co.igns.business.pop.model.Pop0310VO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Pop0040Service {

	private final Pop0040Dao pop0040dao;
	
	// 창고위치 코드, 창고위치 명 조회
	public List<Pop0040VO> getOutWh(Pop0040ReqDto reqDto) {
		return pop0040dao.getOutWh(reqDto);
	}
	
	//품번, 품명 조회
	public List<Pop0040VO> getPartNo(Pop0040ReqDto reqDto) {
		System.out.println("품명 조회시작");
		System.out.println("품명 조회 ::::" + reqDto);
		return pop0040dao.getPartNo(reqDto);
	}
	//입고번호에 의한 납품정보 상세 조회
	public List<Pop0040VO> getMat0021(Pop0040ReqDto reqDto) {
        return pop0040dao.getMat0021(reqDto);
    }
	
	//창고이동내역 저장
	@Transactional(rollbackFor = Exception.class)
	public int createMat0031(List<Pop0040VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		for(Pop0040VO vo : voList) {
					vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);			
					pop0040dao.createMat0031(vo);
		}
		return 0;
	}
	
	//입고정보 저장
	@Transactional(rollbackFor = Exception.class)
	public int createMat0020(List<Pop0040VO> voList) throws Exception {
		System.out.println("입고정보 저장 시작");
		ArrayList<Pop0040VO> pop0040List = new ArrayList<>();
		for(Pop0040VO vo : voList) {
			System.out.println("포문 진입");
			var isExists = false;		
			for(Pop0040VO pop0040 : pop0040List) {	
				if(pop0040.getPartNo().equals(vo.getPartNo()) && pop0040.getLocCode().equals(vo.getLocCode())) {
					pop0040.setMat0020Qty(Integer.toString(Integer.parseInt(pop0040.getMat0020Qty()) + Integer.parseInt(vo.getStockQty())));		  //mat0020의 현 재고량 +
					pop0040.setMat0020Amount(Integer.toString(Integer.parseInt(pop0040.getMat0020Amount()) + Integer.parseInt(vo.getStockAmount()))); //mat0020의 재고금액 +
					isExists = true;
				}
			}
			if(!isExists) {
				System.out.println("새로운 vo 생성");
				var pop0040vo = new Pop0040VO();
				pop0040vo.setComCode(vo.getComCode()); 			 //회사코드
				pop0040vo.setFacCode(vo.getFacCode());			 //공장코드
				pop0040vo.setPartNo(vo.getPartNo());			 //품번
				pop0040vo.setLocCode(vo.getLocCode());			 //창고코드
				pop0040vo.setMat0020Qty(vo.getStockQty());		 // mat0020 현재고량
				pop0040vo.setMat0020Amount(vo.getStockAmount()); // mat0020 재고금액
				pop0040vo.setMakeDate(vo.getMakeDate());		 //등록일
				pop0040vo.setMaker(vo.getMaker());				 //등록자
				pop0040vo.setEditDate(vo.getMakeDate());		 //수정일
				pop0040vo.setEditor(vo.getMaker());				 //수정자
				pop0040vo.setNewLocCode(vo.getInWh());			 //옮길 창고 코드
				pop0040List.add(pop0040vo);					     //담은 정보들을 pop0040List에 추가
			}
		}		
		for(Pop0040VO pop0040vo : pop0040List) {
			System.out.println("새로 만들어질 mat0020 :: " + pop0040vo);
			pop0040dao.updateMat0020(pop0040vo); // 데이터 이동 전 창고의 데이터를 업데이트하고
			pop0040dao.createMat0020(pop0040vo); // 이동하는 창고에 그 데이터를 새로 집어넣어 만든다  
			for(Pop0040VO vo : voList) {
				if(pop0040vo.getPartNo().equals(vo.getPartNo())) {
					vo.setNewLocCode(pop0040vo.getNewLocCode());
					System.out.println("삭제될 mat0021데이터" + vo);
					pop0040dao.deleteMat0021(vo);
					pop0040dao.createMat0021(vo);
				}
			}
		}	
		return 0;
	}

}


