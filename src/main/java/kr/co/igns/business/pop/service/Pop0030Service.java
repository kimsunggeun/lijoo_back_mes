package kr.co.igns.business.pop.service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashSet;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.igns.business.mat.dao.postgre.Mat0040Dao;
import kr.co.igns.business.mat.model.mat0040.Mat0013VO;
import kr.co.igns.business.mat.model.mat0040.Mat0014VO;
import kr.co.igns.business.pop.dao.postgre.Pop0030Dao;
import kr.co.igns.business.pop.model.Pop0030VO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Pop0030Service {

	private final Mat0040Dao mat0040Dao;
	private final Pop0030Dao pop0030Dao;

	//입고정보 저장
	@Transactional(rollbackFor = Exception.class)
	public int createMat0013(List<Mat0013VO> voList) throws Exception {
		
		ArrayList<Mat0013VO> mat0013List = new ArrayList<>();
		int boxQty = 0;
		for(Mat0013VO vo : voList) {
			var isExists = false;

			for(Mat0013VO mat0013 : mat0013List) {
				if (mat0013.getPartNo().equals(vo.getPartNo())) {
					 
					mat0013.setBoxQty(Integer.toString(Integer.parseInt(mat0013.getBoxQty()) + boxQty)); //박스 수량
					mat0013.setInQty(Integer.toString(Integer.parseInt(mat0013.getInQty()) + Integer.parseInt(vo.getMakeQty())));	// 구성량을 더하여 입고량으로 보냄
					isExists = true;
				}
			}
			
			if(!isExists) {
				boxQty = 1;
				var mat0013vo = new Mat0013VO();
				mat0013vo.setComCode(vo.getComCode());			//회사코드
				mat0013vo.setFacCode(vo.getFacCode());			//공장코드
				mat0013vo.setCustCode(vo.getCustCode());		//거래처코드
				mat0013vo.setPartNo(vo.getPartNo());			//품번
				mat0013vo.setInType(vo.getInType());			//입고구분
				mat0013vo.setInCate(vo.getInCate());			//입고유형
				mat0013vo.setRemark(vo.getRemark());			//비고
				mat0013vo.setLotNo(vo.getLotNo());				//Lot No
				mat0013vo.setInQty(vo.getMakeQty());			//입고량
				mat0013vo.setBoxQty(Integer.toString(boxQty));	//박스수량
				mat0013vo.setMaker(vo.getMaker());				//작성자
				mat0013vo.setRegiDate(vo.getRegiDate());
				if(vo.getPrice() == null) {
					vo.setPrice("0");
				}
				mat0013vo.setPrice(mat0040Dao.getPrice(vo));
				mat0013List.add(mat0013vo);
			}
		}
		String ilno = "";
		
		for(Mat0013VO mat0013vo : mat0013List) {
			int noCnt = 1;
			ilno = mat0040Dao.getIlno(mat0013vo);
			mat0013vo.setIlno(ilno);
			if(mat0013vo.getPrice() == null) {
				mat0013vo.setPrice("0");
			}
			mat0013vo.setInAmount(Integer.toString(Integer.parseInt(mat0013vo.getInQty()) * Integer.parseInt(mat0013vo.getPrice())));
			mat0040Dao.createMat0013(mat0013vo);
			mat0040Dao.createMat0020(mat0013vo);
			
			for(Mat0013VO vo : voList) {
				if(mat0013vo.getPartNo().equals(vo.getPartNo())) {
					vo.setNo(Integer.toString(noCnt++));
					vo.setIlno(ilno);
					vo.setQty(vo.getMakeQty());
					vo.setLotDetail(mat0040Dao.getLotDetail(mat0013vo));
					vo.setPrintType("N");
					vo.setUserFlag("Y");
					vo.setPrice(mat0013vo.getPrice());
					mat0040Dao.createMat0014(vo);
					mat0040Dao.createMat0021(vo);
				}
				
			}
		}
		
		return 0;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public List<Pop0030VO> getReceiptInfo(Pop0030VO vo) {
		return pop0030Dao.getReceiptInfo(vo);
	}
	
}



