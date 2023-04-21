package kr.co.igns.business.pop.service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashSet;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.igns.business.mat.dao.postgre.Mat0030Dao;
import kr.co.igns.business.mat.model.mat0030.Mat0012VO;
import kr.co.igns.business.pop.dao.postgre.Pop0020Dao;
import kr.co.igns.business.pop.model.Pop0010VO;
import kr.co.igns.business.pop.model.Pop0020ReqDto;
import kr.co.igns.business.pop.model.Pop0020VO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Pop0020Service {

	private final Pop0020Dao pop0020dao;
	private final Mat0030Dao mat0030Dao;
	String partNoData = "";
	String ilnoData = "";
	int serialNo = 1;
	
	//거래처 조회
	public List<Pop0020VO> getCustCode(Pop0020VO vo) {
        return pop0020dao.getCustCode(vo);
    }
	
	//발주번호 조회
	public List<Pop0020VO> getOrdNo(Pop0020VO vo) {
        return pop0020dao.getOrdNo(vo);
    }
	
	//발주번호 조회
	public List<Pop0020VO> getMat0011(Pop0020VO vo) {
        return pop0020dao.getMat0011(vo);
    }
	// 입고현황 조회
	public List<Pop0020VO> getMat0012(Pop0020VO vo) {
		return pop0020dao.getMat0012(vo);
	}
	
	//입고정보 저장
	@Transactional(rollbackFor = Exception.class)
	public int createMat0012(List<Mat0012VO> voList) throws Exception {
		ArrayList<Mat0012VO> mat0012List = new ArrayList<>();
		for(Mat0012VO vo : voList) {
			var isExists = false;
			int boxQty = 0;

			for(Mat0012VO mat0012 : mat0012List)
			{		
				
				if (mat0012.getPartNo().equals(vo.getPartNo()))
				{
					boxQty += Integer.parseInt(vo.getBoxQty()); 
					mat0012.setBoxQty(Integer.toString(boxQty));
					mat0012.setInQty(Integer.toString( Integer.parseInt(mat0012.getInQty()) + Integer.parseInt(vo.getInQty()) ));
					mat0012.setInAmount(Integer.toString( Integer.parseInt(mat0012.getInAmount()) + Integer.parseInt(vo.getAmount()) ));
					mat0012.setRemQty(Integer.toString(Integer.parseInt(mat0012.getRemQty()) - Integer.parseInt(vo.getInQty())));
					isExists = true;
				}
			}

			if (!isExists)
			{
				var mat0012 = new Mat0012VO();
				mat0012.setComCode(vo.getComCode());
				mat0012.setFacCode(vo.getFacCode());
				mat0012.setOrdNo(vo.getOrdNo());
				mat0012.setNo(vo.getNo());
				mat0012.setRegiDate(vo.getDeliDate());
				mat0012.setPartNo(vo.getPartNo());
				mat0012.setQty(vo.getQty());
				mat0012.setInQty(vo.getInQty());
				mat0012.setBoxQty(vo.getBoxQty());
				mat0012.setInPrice(vo.getPrice());
				mat0012.setInAmount(Integer.toString(Integer.parseInt(vo.getInQty()) * Integer.parseInt(vo.getPrice())));
				mat0012.setRemQty(Integer.toString(Integer.parseInt(vo.getRemQty()) - Integer.parseInt(vo.getInQty())));
				mat0012.setInStatus(vo.getInStatus());
				mat0012.setStockType(vo.getStockType());
				
				if(mat0012.getInStatus().equals("30")) {
					vo.setInInspYn("Y");
				} else {
					vo.setInInspYn("N");
				}
				mat0012List.add(mat0012);
			}		
		}

		String ilno = "";
		for (Mat0012VO mat0012vo : mat0012List) {
			for(int i = 0; i < mat0012List.size(); i++) {
				if(Integer.parseInt(mat0012List.get(i).getRemQty()) < 0) {
					throw new Exception("잔량보다 많이 입고등록 할 수 없습니다.");
				}
			};
			int cnt = 1;
			ilno = mat0030Dao.getIlNo(mat0012vo);
			mat0012vo.setIlNo(ilno);

			mat0030Dao.createMat0012(mat0012vo);
			
			if(mat0012vo.getInStatus().equals("30")) {	//만약 입고상태가 입하라면 잔량을 입고대기로 옮김
				mat0030Dao.updateMat0011_3(mat0012vo);
			} else {
				mat0030Dao.updateMat0011(mat0012vo);
				String nullCheck = "";
				nullCheck = mat0030Dao.mat0020NullCheck(mat0012vo);
				if(nullCheck == null) {
					mat0030Dao.createMat0020(mat0012vo);
				}
				else {
					mat0030Dao.updateMat0020(mat0012vo);
				}
			}

			for (Mat0012VO mat0018 : voList) {

				if(mat0012vo.getPartNo().equals(mat0018.getPartNo()) && mat0018.getInStatus().equals("30")) {
					mat0018.setIlNo(ilno);
					mat0018.setLotDetail(mat0030Dao.getLotDetail(mat0018));
					mat0018.setRegiDate(mat0018.getDeliDate());
					mat0018.setSerialNo(Integer.toString(cnt++));
					mat0030Dao.createMat0018(mat0018);
				} else if(mat0012vo.getPartNo().equals(mat0018.getPartNo()) && mat0018.getInStatus().equals("20")){
					mat0018.setIlNo(ilno);
					mat0018.setLotDetail(mat0030Dao.getLotDetail(mat0018));
					mat0018.setRegiDate(mat0018.getDeliDate());
					mat0018.setSerialNo(Integer.toString(cnt++));
					mat0030Dao.createMat0018(mat0018);
					mat0018.setQty(mat0012vo.getQty());
					mat0018.setStockAmount(Integer.toString(Integer.parseInt(mat0018.getInQty()) * Integer.parseInt(mat0012vo.getInPrice())));
					mat0018.setUserFlag("Y");
					mat0018.setPartType(mat0012vo.getStockType());
					mat0030Dao.createMat0021(mat0018);
				}
			}
		}
		return 0;
	}
}



