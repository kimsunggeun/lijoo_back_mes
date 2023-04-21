package kr.co.igns.business.baseInfo.bas0420.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.igns.business.baseInfo.bas0420.dao.postgre.Bas0420Dao;
import kr.co.igns.business.baseInfo.bas0420.model.Bas0420CopyDto;
import kr.co.igns.business.baseInfo.bas0420.model.Bas0420Dto;
import kr.co.igns.business.baseInfo.bas0420.model.Bas0420PartVO;
import kr.co.igns.business.baseInfo.bas0420.model.Bas0420VO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Bas0420Service {
	
	private final Bas0420Dao bas0420dao;
	
	//검사유형 조회
	public List<Bas0420VO> getInspecType(Bas0420Dto dto){
		List<Bas0420VO> list = bas0420dao.getInspecType(dto);
		return list;
	}
	
	//품질기준정보 조회
	public List<Bas0420VO> getQuaStanInfo(Bas0420Dto dto){
		List<Bas0420VO> list = bas0420dao.getQuaStanInfo(dto);
		return list;
	}
	
	//품질기준정보 입력/수정
	public void setQuaStanInfo(List<Bas0420VO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		
		voList.forEach(s -> {
			s.setMaker(loginId);
			s.setEditor(loginId);
			bas0420dao.setQuaStanInfo(s);
		});
	}

	//품질기준정보 삭제
	@Transactional(rollbackFor = Exception.class)
	public void delQuaStanInfo(List<Bas0420Dto> reqDto)throws Exception {
		
		for(int i = 0; i < reqDto.size(); i++) {
			//품질기준정보 삭제 검사내역 체크
			int chk = bas0420dao.getInsCheck(reqDto.get(i)).get(0).getChk();
			if(chk > 0) {
				throw new Exception("검사내역이 존재하여 삭제 할 수 없습니다.");
			}else {
				bas0420dao.delQuaStanInfo(reqDto.get(i));
			}	
		}
	}
	
	//품질기준정보 복사대상 리스트
	public List<Bas0420PartVO> getPartList(Bas0420Dto dto){
		return bas0420dao.getPartList(dto);
	}
	
	//품질기준정보 복사하기
	public void setPartCopy(List<Bas0420CopyDto> reqDto) {
		reqDto.forEach(s-> bas0420dao.setPartCopy(s));
	}
}
