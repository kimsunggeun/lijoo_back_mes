package kr.co.igns.business.pop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.igns.business.ProdManage.model.pro0050.Pro0050ReqDto;
import kr.co.igns.business.ProdManage.model.pro0050.Pro0050VO;
import kr.co.igns.business.pop.dao.postgre.baseInfoDao;
import kr.co.igns.business.pop.model.Pro0021ReqDto;
import kr.co.igns.business.pop.model.baseInfo.PopupWorkerListVO;
import kr.co.igns.business.pop.model.baseInfo.bas0034ReqDto;
import kr.co.igns.business.pop.model.baseInfo.commonVO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class basInfoService {

	private final baseInfoDao baseInfoDao;
	
	//작업장정보 조회
	public List<commonVO> getBas0034(bas0034ReqDto reqDto) {
        return baseInfoDao.getBas0034(reqDto);
    }
	
	//작업반정보 조회
	public List<commonVO> getBas0035(bas0034ReqDto reqDto) {
        return baseInfoDao.getBas0035(reqDto);
    }
	
	//작업장정보 조회
	public List<Pro0050VO> getPro0010(Pro0050ReqDto reqDto) {
        return baseInfoDao.getPro0010(reqDto);
    }
	
	public List<PopupWorkerListVO> getWorkerList(Pro0021ReqDto reqDto) {
		return baseInfoDao.getWorkerList(reqDto);
	}
}
