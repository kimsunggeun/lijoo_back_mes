package kr.co.igns.business.pop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.igns.business.mat.model.mat0040.Mat0013VO;
import kr.co.igns.business.pop.dao.postgre.Pop0010Dao;
import kr.co.igns.business.pop.model.Pop0010ReqDto;
import kr.co.igns.business.pop.model.Pop0010VO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Pop0010Service {

	private final Pop0010Dao pop0010dao;
	
	//입고번호에 의한 납품정보 상세 조회
	public List<Pop0010VO> getMat0018(Pop0010ReqDto reqDto) {
        return pop0010dao.getMat0018(reqDto);
    }
	
	//전표스캔에 의한 납품정보 상세 조회
	public List<Pop0010VO> getMat0018_Scan(Pop0010ReqDto reqDto) {
        return pop0010dao.getMat0018_Scan(reqDto);
    }
	
	//입고번호 조회
	public List<Pop0010VO> getIlno(Pop0010ReqDto reqDto) {
        return pop0010dao.getIlno(reqDto);
    }
	
	//전산번호 스캔에 의한 납품정보 상세조회
	public List<Pop0010VO> getMat0018_LotScan(Pop0010ReqDto reqDto) {
		return pop0010dao.getMat0018_LotScan(reqDto);
	}
	
	//기타/사급자재 입고 입력/수정
	@Transactional(rollbackFor = Exception.class)
	public int updateMat0018(List<Pop0010VO> voList) throws Exception {
		int price = pop0010dao.getPrice(voList.get(0));
		for(Pop0010VO vo : voList) {
			String inStatus = pop0010dao.getInStatus(vo);
			if(inStatus.equals("Y")) {
				inStatus = "30";
			} else {
				inStatus = "20";
			}
			vo.setLocCode(pop0010dao.getLocCode(vo));
			if(inStatus.equals("30")) {
				
				vo.setInStatus("30");
				pop0010dao.updateMat0012(vo);
				
			} else {
				vo.setInStatus("20");
				int amount = Integer.parseInt(vo.getQty()) * price;
				vo.setStockAmount(Integer.toString(amount));
				pop0010dao.updateMat0012(vo);
				pop0010dao.updateMat0011(vo);
				pop0010dao.updateMat0018(vo);
				pop0010dao.updateMat0020(vo);
				pop0010dao.createMat0021(vo);
			}

		}
		return 0;
		}
}


