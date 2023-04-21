package kr.co.igns.business.ProdManage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.igns.business.ProdManage.dao.postgre.Pro0070Dao;
import kr.co.igns.business.ProdManage.model.pro0050.Pro0050ReqDto;
import kr.co.igns.business.ProdManage.model.pro0050.Pro0050VO;
import kr.co.igns.business.ProdManage.model.pro0070.Pro0070ReqDto;
import kr.co.igns.business.ProdManage.model.pro0070.Pro0070Vo;
import kr.co.igns.business.baseInfo.bas0120.model.Bas0030VO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Pro0070Service {

	@Autowired
	private final Pro0070Dao pro0070Dao;
	
	//공정실적현황  조회
	public List<Pro0070Vo> getPro0070(Pro0070ReqDto reqDto) {
        return pro0070Dao.getPro0070(reqDto);
    }
	
	//잡셋업 설비 조회
	public List<Pro0070Vo> getBas0090(Pro0070ReqDto reqDto) {
	    return pro0070Dao.getBas0090(reqDto);
	}
	
	//작업지시 조회
	public List<Pro0070Vo> getPro0021(Pro0070ReqDto reqDto) {
		return pro0070Dao.getPro0021(reqDto);
	}
	
	
	//작업지시관리 저장/수정
	//작업지시관리 등록/수정
	public int createPro0070(List<Pro0070Vo> voList) throws Exception {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
				
		for(Pro0070Vo s : voList){
			if(s.is__created__()) {
				s.setMaker(loginId.equals("") ? "" : loginId);
				int eqCodeEndTime = pro0070Dao.getEqCodeEndTime(s);
				if(eqCodeEndTime > 0) {
					throw new Exception("미입력된 비가동종료시간이 있습니다." + "[" + s.getEqName() + "]");
				}
				pro0070Dao.createPro0070(s);					
			} else if(s.is__modified__()) {
				s.setEditor(loginId.equals("") ? "" : loginId);
				pro0070Dao.updatePro0070(s);
			}
		}
		return 0;
	}
	
	
	//삭제
	public int delPro0070(List<Pro0070ReqDto> reqDto) {
		
		reqDto.forEach(s -> pro0070Dao.deletePro0070(s));
		
        return 0;
    }
}
