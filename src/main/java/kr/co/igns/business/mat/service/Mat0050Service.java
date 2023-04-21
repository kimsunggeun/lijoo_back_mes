package kr.co.igns.business.mat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.igns.business.mat.dao.postgre.Mat0050Dao;
import kr.co.igns.business.mat.model.mat0050.Mat0012VO;
import kr.co.igns.business.mat.model.mat0050.Mat0018VO;
import kr.co.igns.business.mat.model.mat0050.Mat0021VO;
import kr.co.igns.business.mat.model.mat0050.Mat0030Dto;
import kr.co.igns.business.mat.model.mat0050.Mat0030VO;
import kr.co.igns.business.mat.model.mat0050.Mat0012ReqDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Mat0050Service {

	private final Mat0050Dao mat0050Dao;
	
	//입고정보 조회
	public List<Mat0012VO> getMat0012(Mat0012ReqDto reqDto){
		List<Mat0012VO> result = new ArrayList<Mat0012VO>();
		try {
			result = mat0050Dao.getMat0012(reqDto);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//재고현황 조회
	public List<Mat0018VO> getMat0018(Mat0012VO reqDto){
		List<Mat0018VO> result = new ArrayList<Mat0018VO>();
		try {
			if (reqDto.getInType().equals("30")) {
				result = mat0050Dao.getMat0018(reqDto);
			}
			else {
				result = mat0050Dao.getMat0018_2(reqDto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//반품내역 조회
	public List<Mat0030VO> getMat0030(Mat0012VO reqDto){
		List<Mat0030VO> result = new ArrayList<Mat0030VO>();
		try {
			if (reqDto.getInType().equals("30")) {
				result = mat0050Dao.getMat0030(reqDto);
			} else {
				result = mat0050Dao.getMat0030_2(reqDto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//반품등록->반품내역 등록
	@Transactional(rollbackFor = Exception.class)
	public int insertMat0030(Mat0030Dto reqDto) throws Exception{
		int result = 0;
		try {
			
			var inType = reqDto.getInType(); 

			for(Mat0030VO vo : reqDto.getList()) {
				//반품테이블 insert
				mat0050Dao.insertMat0030(vo);

				//입고테이블 반품수량을 플러스해준  다음 재고는 마이너스값으로 반영할것  
				if (inType == "30") {

					//구매입고 업데이트 parameter 객체 생성
					Mat0012VO vo12 = Mat0012VO.builder()
							.comCode(vo.getComCode())
							.facCode(vo.getFacCode())
							.no(vo.getNo())
							.ilno(vo.getIlno())
							.ordNo(vo.getOrdNo())
							.retAmount(vo.getRetQty())
							.build();
					//구매입고 테이블 반품량 업데이트
					String inPrice = mat0050Dao.updateMat0012(vo12);	
					//구매상세 반품량 업데이트
					vo.setInPrice(inPrice);
					mat0050Dao.updateRetMat0018(vo);
				}

				
				vo.setRetQty(String.valueOf(Integer.parseInt(vo.getRetQty()) * -1));
				vo.setRetAmount(String.valueOf(Integer.parseInt(vo.getRetAmount()) * -1));
				//재고상세 테이블 재고량 업데이트
				Mat0021VO locInfo = mat0050Dao.updateMat0021(vo);
				//창고 재고량 및 금액 업데이트
				locInfo.setRetQty(vo.getRetQty());
				locInfo.setRetAmount(String.valueOf(Integer.parseInt(vo.getRetAmount())));
				mat0050Dao.updateMat0020(locInfo);
			}
			
			result = 1;
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		return result;
	}
	
	//반품내역 삭제
	@Transactional(rollbackFor = Exception.class)
	public int deleteMat0030(Mat0030Dto reqDto) throws Exception {
		int result = 0;
		try {
			var inType = reqDto.getInType(); 

			for(Mat0030VO vo : reqDto.getList()) {
				System.out.println("삭제할때  vo :::::::::" + vo);
				//반품 테이블 삭제
				mat0050Dao.deleteMat0030(vo);
				
				System.out.println("e--------" + vo.toString());
				
				vo.setRetQty(String.valueOf(Integer.parseInt(vo.getRetQty())));
				vo.setRetAmount(String.valueOf(Integer.parseInt(vo.getRetAmount())));
				//재고상세 테이블 재고량 업데이트
				Mat0021VO locInfo = mat0050Dao.updateMat0021(vo);
				//창고 재고량 및 금액 업데이트
				locInfo.setRetQty(vo.getRetQty());
				locInfo.setRetAmount(String.valueOf(Integer.parseInt(vo.getRetAmount())));
				mat0050Dao.updateMat0020(locInfo);
				
				//반품내역 삭제시에는 재고먼저 플러스 해준 다음  반품수량을 마이너스로 바꿔줄 것
				if (inType == "30") {

					//구매입고 업데이트 parameter 객체 생성
					Mat0012VO vo12 = Mat0012VO.builder()
							.comCode(vo.getComCode())
							.facCode(vo.getFacCode())
							.no(vo.getNo())
							.ilno(vo.getIlno())
							.ordNo(vo.getOrdNo())
							.retAmount(String.valueOf(Integer.parseInt(vo.getRetQty()) * -1))
							.build();
					//구매입고 테이블 반품량 업데이트
					String inPrice = mat0050Dao.updateMat0012(vo12);	
					//구매상세 반품량 업데이트
					vo.setInPrice(inPrice);
					mat0050Dao.updateRetMat0018(vo);
				}
			}
			result = 1;
			
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		return result;
	}
}
