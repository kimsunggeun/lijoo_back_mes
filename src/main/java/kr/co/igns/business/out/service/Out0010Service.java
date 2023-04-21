package kr.co.igns.business.out.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.igns.business.mat.dao.postgre.Mat0030Dao;
import kr.co.igns.business.mat.model.mat0030.Mat0012VO;
import kr.co.igns.business.mat.model.mat0030.Mat0018VO;
import kr.co.igns.business.out.dao.postgre.Out0010Dao;
import kr.co.igns.business.out.model.out0010.Out0010ReqDto;
import kr.co.igns.business.out.model.out0010.Out0010VO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Out0010Service {
	
	@Autowired
	private final Out0010Dao out0010Dao;
	//ID 체크
	public List<Out0010VO> getUserId(Out0010ReqDto reqDto) {
        return out0010Dao.getUserId(reqDto);
    }
	
	//외주업체 거래처코드 조회
	public List<Out0010VO> getAccount(Out0010ReqDto reqDto) {
        return out0010Dao.getOut0010(reqDto);
    }
	
	//외주업체 거래처코드 조회2
	public List<Out0010VO> getAccount_out0010(Out0010ReqDto reqDto) {
        return out0010Dao.getAccount_out0010(reqDto);
    }
	
	//공정외주발주등록 조회
	public List<Out0010VO> getOut0010(Out0010ReqDto reqDto) {
        return out0010Dao.getOut0010(reqDto);
    }
	
	//공정외주발주등록 등록/수정
	public int createOut0010(List<Out0010VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();

		String ilNo = "";
		ilNo = out0010Dao.getIlNo(voList.get(0));

		for(Out0010VO vo : voList) {
			if(vo.is__created__()) {
				
				
				vo.setIlNo(ilNo);

				vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
				out0010Dao.createMat0012(vo);
				
				for (int i=1; i <= Integer.parseInt(vo.getBoxQty()); i++ )
				{
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
					out0010Dao.updateMat0011(vo);
					out0010Dao.createMat0018(vo);
		
				}
				
			}
		}
		return 0;
    }
	
	//구매 입고정보 상세 삭제
	@Transactional(rollbackFor = Exception.class)
	public int deleteOut0010(List<Out0010VO> voList) throws Exception {

		for(Out0010VO vo : voList) {
			if(vo.getInStatus().equals("40")) {
				throw new Exception("입고검사된 데이터는 이곳에서 삭제할 수 없습니다.");
			}
			if(vo.getInInspYn().equals("N")) { //입고대기유무가 N이라면
				out0010Dao.deleteQat0010(vo);
				out0010Dao.updateMat0011_3(vo);
				out0010Dao.updateMat0020_2(vo);
				out0010Dao.deleteMat0021(vo);
				out0010Dao.deleteMat0018(vo);
				out0010Dao.deleteMat0012(vo);
			} else if(vo.getInInspYn().equals("Y")){
				out0010Dao.updateMat0011_2(vo);
				out0010Dao.deleteMat0018(vo);
				out0010Dao.deleteMat0012(vo);
			}		
			
			

		}
		return 0;
	}
}