package kr.co.igns.business.mat.service;

import java.util.List;

import org.json.JSONArray;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.igns.business.mat.dao.postgre.Mat0020Dao;
import kr.co.igns.business.mat.model.mat0020.Mat0010VO;
import kr.co.igns.business.mat.model.mat0020.Mat0011VO;
import kr.co.igns.business.mat.model.mat0020.Mat0020ReqDto;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Mat0020Service{

	private final Mat0020Dao mat0020Dao;
	private final IgnsSessionUtils ignsSessionUtils;
	
	//품목정보 조회
	public List<Mat0010VO> getItemInfo2(Mat0020ReqDto reqDto) {
		List<Mat0010VO> list = mat0020Dao.getItemInfo2(reqDto);
        return list;
    }
	
	//구매 발주정보 조회
	public List<Mat0010VO> getMat0010(Mat0020ReqDto reqDto) {
		List<Mat0010VO> list = mat0020Dao.getMat0010(reqDto);
        return list;
    }
	
		
	//구매 발주정보 입력/수정
	public int createMat0010(List<Mat0010VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		
		for(Mat0010VO vo : voList) {
			if(vo.is__created__()) {
				vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
				mat0020Dao.createMat0010(vo);					
			} else if(vo.is__modified__()) {
				vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
				mat0020Dao.updateMat0010(vo);
			}
		}
		return 0;
    }
	
	//구매발주정보 확정
	public int confirmMat0010(List<Mat0010VO> voList) {
		for(Mat0010VO vo : voList) {
			mat0020Dao.confirmMat0010(vo);
		}
		return 0;
	}
	
	//구매발주정보 확정 취소
	public int confirmCancelMat0010(List<Mat0010VO> voList) {
		for(Mat0010VO vo : voList) {
			mat0020Dao.confirmCancelMat0010(vo);
		}
		return 0;
	}
	
	//구매발주정보 삭제
	public int deleteMat0010(List<Mat0010VO> voList) {
		for(Mat0010VO vo : voList) {
			if(mat0020Dao.nullCheck_Mat0011(vo).isEmpty()) {
				mat0020Dao.deleteMat0010(vo);
			}
		}
		return 0;
	}
	
	//기간별외주발주현황(거래처별)
	public List<Mat0011VO> getMat0011toOut0110(Mat0020ReqDto reqDto) {
		List<Mat0011VO> list = mat0020Dao.getMat0011toOut0110(reqDto);
        return list;
    }
	
	//기간별외주발주현황(거래처별) - 일자별조회
	public JSONArray getMat0011byDate(Mat0020ReqDto reqDto) {
		JSONArray resultJobject = new JSONArray();
		resultJobject.put(new JSONArray(mat0020Dao.getMat0011byDate(reqDto)));
	    return resultJobject;
	}
	
	
	//구매 발주정보 상세 조회
	public List<Mat0011VO> getMat0011(Mat0020ReqDto reqDto) {
		List<Mat0011VO> list = mat0020Dao.getMat0011(reqDto);
        return list;
    }
		
	//구매 발주정보 상세 입력/수정
	public int createMat0011(List<Mat0011VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		
		for(Mat0011VO vo : voList) {
			if(vo.is__created__()) {
				vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
				mat0020Dao.createMat0011(vo);					
			} else if(vo.is__modified__()) {
				vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
				mat0020Dao.updateMat0011(vo);
			}
		}
		return 0;
    }
	
	//구매발주정보 상세 삭제
	@Transactional(rollbackFor = Exception.class)
	public int deleteMat0011(List<Mat0011VO> voList)throws Exception {
		for(Mat0011VO vo : voList) {
			if(!vo.getInQty().equals("0")) {
				throw new Exception("입고된 데이터는 삭제할 수 없습니다");
			}
			mat0020Dao.deleteMat0011(vo);
		}
		return 0;
	}
}
