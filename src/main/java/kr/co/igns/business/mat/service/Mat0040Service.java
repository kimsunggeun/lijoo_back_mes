package kr.co.igns.business.mat.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.igns.business.mat.dao.postgre.Mat0040Dao;
import kr.co.igns.business.mat.model.mat0040.Mat0040ReqDto;
import kr.co.igns.business.mat.model.mat0020.Mat0010VO;
import kr.co.igns.business.mat.model.mat0030.Mat0018VO;
import kr.co.igns.business.mat.model.mat0040.Mat0013VO;
import kr.co.igns.business.mat.model.mat0040.Mat0014VO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Mat0040Service{

	private final Mat0040Dao mat0040Dao;
	private final IgnsSessionUtils ignsSessionUtils;

	//품번 조회
	public List<Mat0013VO> getPartNo(Mat0040ReqDto reqDto) {
		List<Mat0013VO> list = mat0040Dao.getPartNo(reqDto);
        return list;
    }	
	
	//공장정보 조회
	public List<Mat0013VO> getFacCode(Mat0040ReqDto reqDto) {
		List<Mat0013VO> list = mat0040Dao.getFacCode(reqDto);
        return list;
    }
	
	//기타/사급자재 입고 조회
	public List<Mat0013VO> getMat0013(Mat0040ReqDto reqDto) {
		List<Mat0013VO> list = mat0040Dao.getMat0013(reqDto);
        return list;
    }
		
	//기타/사급자재 입고 입력/수정
	@Transactional(rollbackFor = Exception.class)
	public int createMat0013(List<Mat0013VO> voList) throws Exception {
				
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
				
		for(Mat0013VO vo : voList) {
			if(vo.is__created__()) {
				vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);

				
				String inQty = vo.getInQty();
				String makeQty = vo.getMakeQty();
				String ilno = mat0040Dao.getIlno(vo);
				vo.setIlno(ilno);
				String price = mat0040Dao.getPrice(vo);	//단가
				if(price == null){
					price = "0";
				}
				vo.setPrice(price);
				String inAmount = Integer.toString(Integer.parseInt(price) * Integer.parseInt(vo.getInQty()));
				vo.setInAmount(inAmount);
				mat0040Dao.createMat0013(vo);
				for(int i = 1; i <= Integer.parseInt(vo.getBoxQty()); i++) {	
					vo.setNo(Integer.toString(i));
					vo.setQty(makeQty);
					
					if(Integer.parseInt(inQty) < Integer.parseInt(makeQty)) {
						vo.setQty(inQty);
					}else {
						inQty = Integer.toString(Integer.parseInt(inQty) - Integer.parseInt(makeQty));
					}		
					vo.setLotDetail(mat0040Dao.getLotDetail(vo));
					mat0040Dao.createMat0014(vo);
					mat0040Dao.createMat0021(vo);

			} 

					mat0040Dao.createMat0020(vo);
		}
			
			else if(vo.is__modified__()) {
				vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
				mat0040Dao.updateMat0013(vo);
			}
		}
		
		return 0;
    }
	
	//구매 입고정보 삭제
	@Transactional(rollbackFor = Exception.class)
	public int deleteMat0013(List<Mat0013VO> voList) {
		for(Mat0013VO vo : voList) {
				vo.setStockQty(mat0040Dao.sumQty(vo));
				if(mat0040Dao.getInAmount(vo) == null) {
					vo.setInAmount("0");
				} else {
					vo.setInAmount(mat0040Dao.getInAmount(vo));
				}
				mat0040Dao.deleteMat0021(vo);
				mat0040Dao.updateMat0020_2(vo);
				mat0040Dao.deleteMat0014(vo);
				mat0040Dao.deleteMat0013(vo);
		}
		return 0;
	}
	//기타/사급자재 입고 상세 조회
	public List<Mat0014VO> getMat0014(Mat0040ReqDto reqDto) {
		List<Mat0014VO> list = mat0040Dao.getMat0014(reqDto);
        return list;
    }
	
	//입고창고 GET
		public List<Mat0013VO> getInWh(Mat0013VO vo) {
			List<Mat0013VO> list = mat0040Dao.getInWh(vo);
	        return list;
	    }	
	
		
}
