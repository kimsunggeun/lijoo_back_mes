package kr.co.igns.business.out.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.igns.business.out.dao.postgre.Out0030Dao;
import kr.co.igns.business.out.model.out0030.Out0030DelDto;
import kr.co.igns.business.out.model.out0030.Out0030ReqDto;
import kr.co.igns.business.out.model.out0030.Out0030VO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Out0030Service {
	
	@Autowired
	private final Out0030Dao out0030Dao;
	
	//공정외주 정보상세 조회
	public List<Out0030VO> getPro0026(Out0030ReqDto reqDto) {
        return out0030Dao.getPro0026(reqDto);
    }
	
	//공정외주 납품등록 조회
	public List<Out0030VO> getOut0011(Out0030ReqDto reqDto) {
        return out0030Dao.getOut0011(reqDto);
    }
	
	//공정외주발주등록 등록/수정
	public int createOut0011(List<Out0030VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		int inNo = 1;
		for(Out0030VO vo : voList) {
			vo.setQty(vo.getMakeQty());
			vo.setInIlno(out0030Dao.getIlno(vo));
			for(int i = 1; i <= Integer.parseInt(vo.getBoxQty()); i++) {
				
				if (i == Integer.parseInt(vo.getBoxQty())) {
					int inQty = Integer.parseInt(vo.getInQty());
					int makeQty = Integer.parseInt(vo.getMakeQty());
					int qty = 0;
					if(inQty % makeQty != 0) {
						qty = inQty % makeQty;
					} else {
						qty = Integer.parseInt(vo.getInQty())/Integer.parseInt(vo.getBoxQty());
					}
					vo.setQty(Integer.toString(qty));		
				}
				int inAmount = Integer.parseInt(vo.getQty()) * Integer.parseInt(vo.getProCost());
				vo.setInAmount(Integer.toString(inAmount));
				vo.setInNo(Integer.toString(inNo));
				inNo++;
				if(vo.getProCost().equals("") || vo.getProCost() == null) {
					vo.setInPrice("0");
				} else {
					vo.setInPrice(vo.getProCost());
				}
				
				
				out0030Dao.createOut0011(vo);
				
			}
			out0030Dao.updatePro0026(vo);
		}
		return 0;
    }
	
	public int deleteOut0011(List<Out0030DelDto> voList) {
		
		for(Out0030DelDto vo : voList) {
			vo.setInQty(out0030Dao.getSumQty(vo));
			out0030Dao.deleteOut0011(vo);
			out0030Dao.updatePro0026_2(vo);
		}
		return 0;
	}
}