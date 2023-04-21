package kr.co.igns.business.mat.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.igns.business.baseInfo.bas0210.dao.postgre.Bas0210Dao;
import kr.co.igns.business.baseInfo.bas0210.model.Bas0210Dto;
import kr.co.igns.business.mat.dao.postgre.Mat0110Dao;
import kr.co.igns.business.mat.model.mat0110.Mat0110ReqDto;
import kr.co.igns.business.mat.model.mat0110.Mat0110VO;

import kr.co.igns.business.mat.dao.postgre.Mat0210Dao;
import kr.co.igns.business.mat.model.mat0210.Mat0210ReqDto;
import kr.co.igns.business.mat.model.mat0210.Mat0210ReqDtoDetail;
import kr.co.igns.business.mat.model.mat0210.Mat0210VO;

import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Mat0110Service{

	private final Mat0110Dao mat0110Dao;
	private final Mat0210Dao mat0210Dao;
	private final Bas0210Dao bas0210Dao;
	private final IgnsSessionUtils ignsSessionUtils;
	
	//재고실사 조회
	public List<Mat0110VO> getMat0110(Mat0110ReqDto reqDto) {
		List<Mat0110VO> list = mat0110Dao.getMat0110(reqDto);
        return list;
    }
		
	//재고실사 처리
	@Transactional(rollbackFor = Exception.class)
	public int insertMat0110(List<Mat0110VO> voMat0110List) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();

		for(Mat0110VO voMat0110 : voMat0110List) 
		{
			if(voMat0110.is__created__()) 
			{
				Mat0210ReqDto mat0210ReqDto = new Mat0210ReqDto();
				mat0210ReqDto.setComCode(voMat0110.getComCode());
				mat0210ReqDto.setFacCode(voMat0110.getFacCode());
				mat0210ReqDto.setLocCode(voMat0110.getLocCode());
				mat0210ReqDto.setPartNo(voMat0110.getPartNo());
				
				Mat0210VO voMat0210 = mat0210Dao.getStrictMat0210(mat0210ReqDto);
				
				if (voMat0210 != null)
				{
					int iChangeQty = Integer.parseInt(voMat0110.getRealQty()) - Integer.parseInt(voMat0110.getStockQty());
					int iMasterQty = Integer.parseInt(voMat0210.getStockQty()) + iChangeQty;
										
					voMat0210.setStockQty(Integer.toString(iMasterQty));
					
					Bas0210Dto dtoBas0210 = new Bas0210Dto();
					dtoBas0210.setComCode(voMat0110.getComCode());
					dtoBas0210.setPartNo(voMat0110.getPartNo());
					
					int iAveragePrice = 0;
					iAveragePrice = bas0210Dao.getAveragePrice(dtoBas0210);
					int iStockAmount = iMasterQty * iAveragePrice;
					voMat0210.setStockAmount(Integer.toString(iStockAmount));
					
					voMat0210.setEditor(loginId.equals("") ? voMat0210.getMaker() : loginId);
					
					mat0210Dao.updateMat0210(voMat0210);
					
					Mat0210ReqDtoDetail voMat0210ReqDtoDetail = new Mat0210ReqDtoDetail();
					voMat0210ReqDtoDetail.setComCode(mat0210ReqDto.getComCode());
					voMat0210ReqDtoDetail.setFacCode(mat0210ReqDto.getFacCode());
					voMat0210ReqDtoDetail.setLocCode(mat0210ReqDto.getLocCode());
					voMat0210ReqDtoDetail.setPartNo(mat0210ReqDto.getPartNo());
					voMat0210ReqDtoDetail.setLotDetail(voMat0110.getLotDetail());
					
					Mat0210VO voMat0210Detail = mat0210Dao.getStrictMat0210Detail(voMat0210ReqDtoDetail);
					
					if (voMat0210Detail != null)
					{
						voMat0210Detail.setEventCd("50");		// 공통코드 -> EVENT_CD -> 50(재고실사)
						int iDetailQty = Integer.parseInt(voMat0210Detail.getStockQty()) + iChangeQty;
						voMat0210Detail.setStockQty(Integer.toString(iDetailQty));
						
						int iDetailAmount = iAveragePrice * iDetailQty;
						voMat0210Detail.setStockAmount(Integer.toString(iDetailAmount));
						
						voMat0210Detail.setEditor(loginId.equals("") ? voMat0210.getMaker() : loginId);
						
						mat0210Dao.updateMat0210Detail(voMat0210Detail);
						
						voMat0110.setMaker(loginId.equals("") ? voMat0110.getMaker() : loginId);
						mat0110Dao.insertMat0110(voMat0110);
					}
				}					
			}
		}
		
		return 0;
    }

	//재고실사 찾기 : 전산번호
	public List<Mat0110VO> getMat0110FromLotDetail(Mat0110VO vo) {
		List<Mat0110VO> list = mat0110Dao.getMat0110FromLotDetail(vo);
        return list;
    }
}
