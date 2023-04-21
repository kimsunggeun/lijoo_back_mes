package kr.co.igns.business.mat.service;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.joda.time.LocalDate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.io.BigDecimalParser;

import java.util.ArrayList;
import kr.co.igns.business.mat.dao.postgre.Mat0020Dao;
import kr.co.igns.business.mat.dao.postgre.Mat0030Dao;
import kr.co.igns.business.mat.model.mat0030.Mat0030ReqDto;
import kr.co.igns.business.sales.model.sal0010.Sal0010VO;
import kr.co.igns.business.mat.model.mat0020.Mat0011VO;
import kr.co.igns.business.mat.model.mat0030.Mat0012VO;
import kr.co.igns.business.mat.model.mat0030.Mat0018VO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Mat0030Service{
	

	private final Mat0030Dao mat0030Dao;
	private final IgnsSessionUtils ignsSessionUtils;
	
	//구매 입고정보 조회
	public List<Mat0012VO> getMat0012(Mat0030ReqDto reqDto) {
		List<Mat0012VO> list = mat0030Dao.getMat0012(reqDto);

        return list;
    }
	
	public int updateMat0011(Mat0012VO vo) {
		return mat0030Dao.updateMat0011(vo);
    }
	
    
		
	//구매 입고정보 입력/수정
	@Transactional(rollbackFor = Exception.class)
	public int createMat0012(List<Mat0012VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		String ilNo = "";
		ilNo = mat0030Dao.getIlNo(voList.get(0));

		for(Mat0012VO vo : voList) {
			
			if(vo.is__created__()) {
				String lotDetail = "";
				vo.setIlNo(ilNo);	
				vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
				mat0030Dao.createMat0012(vo);
				if(!vo.getInStatus().equals("30")) { // 만약 입고상태가 입하가 아니라면
					mat0030Dao.updateMat0011(vo);
				} else {
					if(vo.getWaitQty() == null) {
						vo.setWaitQty("0");
					}
					mat0030Dao.updateMat0011_3(vo);
				}

				for (int i=1; i <= Integer.parseInt(vo.getBoxQty()); i++ )
				{
					lotDetail = mat0030Dao.getLotDetail(vo);
					vo.setLotDetail(lotDetail);
					vo.setSerialNo(Integer.toString(i));
					

					var qty = vo.getMakeQty();
					var remQty =  new BigDecimal(vo.getRemQty());
					
					if (i == Integer.parseInt(vo.getBoxQty()))
					{						
						var a = Integer.parseInt(vo.getInQty());
						var b = Integer.parseInt(vo.getMakeQty());
						if(a % b == 0) {   				
							qty = vo.getMakeQty();		
						} else {
							qty = Integer.toString(a % b); 
						}
					}				
					vo.setQty(qty);
					String stockAmount = vo.getInPrice();
					vo.setStockAmount(stockAmount);
					vo.setRemQty(remQty.toString());
					if(vo.getInStatus().equals("30")) {
						vo.setInInspYn("Y");
					} else {
						vo.setInInspYn("N");
					}
					
					mat0030Dao.createMat0018(vo);
					if(!vo.getInStatus().equals("30")) {
						String stAmount = Integer.toString(Integer.parseInt(stockAmount) * Integer.parseInt(vo.getQty())); 
						vo.setStockAmount(stAmount);
						mat0030Dao.createMat0021(vo);	
					}
		
				}
			
				
				String nullCheck = "";
				nullCheck = mat0030Dao.mat0020NullCheck(vo);
				if(!vo.getInStatus().equals("30")) {
					if(nullCheck == null) {
						mat0030Dao.createMat0020(vo);
					}
					else {
						mat0030Dao.updateMat0020(vo);
					}
				}
				
			} else if(vo.is__modified__()) {
				vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
				mat0030Dao.updateMat0012(vo);
			}
		}
		return 0;
    }
	
	
	//구매 입고정보 상세 조회
	public List<Mat0018VO> getMat0018(Mat0030ReqDto reqDto) {
		List<Mat0018VO> list = mat0030Dao.getMat0018(reqDto);
        return list;
    }
		
	//구매 입고정보 상세 입력/수정
	public int createMat0018(List<Mat0018VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		
		return 0;
    }
	
	//구매 입고정보 상세 삭제
	@Transactional(rollbackFor = Exception.class)
	public int deleteMat0018(List<Mat0018VO> voList) throws Exception {
		String price = mat0030Dao.getPrice(voList.get(0));
		String no = voList.get(0).getNo();
		for(Mat0018VO vo : voList) {
			if(vo.getInStatus().equals("40")) {
				throw new Exception("입고검사된 데이터는 이곳에서 삭제할 수 없습니다.");
			}
			if(!no.equals(vo.getNo())) {
				price = mat0030Dao.getPrice(vo);
				no = vo.getNo();
			}
			String inAmount = Integer.toString(Integer.parseInt(vo.getQty()) * Integer.parseInt(price));
			
			
			
			vo.setInQty(vo.getQty());
			vo.setStockQty(vo.getQty());
			vo.setInAmount(inAmount);
			if(vo.getInInspYn().equals("N")) { //검사품이 아니라면 삭제할 때 재고마스터에 저장되어 있는 데이터도 삭제함
				mat0030Dao.deleteQat0010(vo);
				mat0030Dao.updateMat0011_2(vo);
				mat0030Dao.updateMat0020_2(vo);
				mat0030Dao.deleteMat0021(vo);
				mat0030Dao.deleteMat0018(vo);
				mat0030Dao.deleteMat0012(vo);
			} else if(vo.getInInspYn().equals("Y")){
				mat0030Dao.updateMat0011_4(vo);
				mat0030Dao.deleteMat0018(vo);
				mat0030Dao.deleteMat0012(vo);
			}
		}
		return 0;
	}
}
