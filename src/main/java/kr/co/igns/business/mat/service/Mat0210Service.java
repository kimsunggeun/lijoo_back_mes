package kr.co.igns.business.mat.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.igns.business.mat.dao.postgre.Mat0210Dao;
import kr.co.igns.business.mat.model.mat0210.Mat0210ReqDto;
import kr.co.igns.business.mat.model.mat0210.Mat0210ReqDtoDetail;
import kr.co.igns.business.mat.model.mat0210.Mat0210VO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Mat0210Service{

	private final Mat0210Dao mat0210Dao;
	private final IgnsSessionUtils ignsSessionUtils;
	
	//재고정보(MASTER) 조회
	public List<Mat0210VO> getMat0210(Mat0210ReqDto reqDto) {
		List<Mat0210VO> list = mat0210Dao.getMat0210(reqDto);
        return list;
    }
	
	//재고정보(MASTER) 엄격한 조회
	public Mat0210VO getStrictMat0210(Mat0210ReqDto reqDto) {
		Mat0210VO mat0210VO = mat0210Dao.getStrictMat0210(reqDto);
		return mat0210VO;
	}
		
	//재고정보(MASTER) 입력/수정
	public int createMat0210(List<Mat0210VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		
		for(Mat0210VO vo : voList) {
			if(vo.is__created__()) {
				vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
				mat0210Dao.createMat0210(vo);					
			} else if(vo.is__modified__()) {
				vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
				mat0210Dao.updateMat0210(vo);
			}
		}
		return 0;
    }
	
	//재고정보(DETAIL) 조회
	public List<Mat0210VO> getMat0210Detail(Mat0210ReqDto reqDto) {
		List<Mat0210VO> list = mat0210Dao.getMat0210Detail(reqDto);
		return list;
	}
	
	//재고정보(DETAIL) 엄격한 조회
	public Mat0210VO getStrictMat0210Detail(Mat0210ReqDtoDetail reqDto) {
		Mat0210VO mat0210VO = mat0210Dao.getStrictMat0210Detail(reqDto);
		return mat0210VO;
	}	
	
	//재고정보(DETAIL) 입력/수정
	public int createMat0210Detail(List<Mat0210VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		
		for(Mat0210VO vo : voList) {
			if(vo.is__created__()) {
				vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
				mat0210Dao.createMat0210Detail(vo);
			} else if(vo.is__modified__()) {
				vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
				mat0210Dao.updateMat0210Detail(vo);
			}
		}
		
		return 0;
	}
}
