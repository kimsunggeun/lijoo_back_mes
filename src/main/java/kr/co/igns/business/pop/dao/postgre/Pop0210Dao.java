package kr.co.igns.business.pop.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.igns.business.ProdManage.model.pro0050.Pro0050VO;
import kr.co.igns.business.pop.model.Pop0023VO;
import kr.co.igns.business.pop.model.Pro0010ReqDto;
import kr.co.igns.business.pop.model.Pro0021ReqDto;
import kr.co.igns.business.pop.model.Pro0021VO;
import kr.co.igns.business.pop.model.Pro0022VO;
import kr.co.igns.business.pop.model.Pro0023ReqDto;
import kr.co.igns.business.pop.model.Pro0023VO;
import kr.co.igns.business.pop.model.Pro0024VO;
import kr.co.igns.business.pop.model.Pro0025ReqDto;
import kr.co.igns.business.pop.model.Pro0025VO;
import kr.co.igns.business.pop.model.pro0020ReqDto;
import kr.co.igns.business.pop.model.pro0020VO;
import kr.co.igns.business.pop.model.Pro0025errorVO;

@Mapper
@Repository
public interface Pop0210Dao {
	List<pro0020VO> getPop0020(pro0020ReqDto reqDto);
	void setPop0020(List<pro0020VO> reqDto);
	void delPop0020(pro0020VO reqDto);
	
	Pro0021VO getPop0021(Pro0021ReqDto reqDto);
	void setPop0021(Pro0021VO reqDto);

	List<Pro0022VO> getPro0022(Pro0021ReqDto reqDto);
	int setPro0022(Pro0021VO reqDto);
	
	//작업지시팝업 조회
	List<Pro0050VO> getPro0050 (Pro0010ReqDto reqDto);
	
	//작업지시 상태 버튼 (현재 진행중인 작업을 보류 시킴)
	int setPro0050_before(Pro0010ReqDto reqDto);
	//작업지시 상태 버튼(작업반 작업정보 업데이트)
	int setPro0050(Pro0010ReqDto reqDto);
	
	//실적등록
	int setPro0025(Pro0025ReqDto reqDto);
	
	
	//자재투입
	void setPro0023(Pro0023ReqDto reqDto);
	
	//선택자재 투입 팝업
	List<Pop0023VO> getPro23Select(Pro0023ReqDto reqDto);
	
	//공정재고 조회
	List<Pro0023VO> getPro0023(Pro0023ReqDto reqDto);
	
	List<Pro0025VO> getPro0025(Pro0025ReqDto reqDto);
	List<Pro0024VO> getPro0024(Pro0025ReqDto reqDto);
	List<Pro0025VO> getPro0026(Pro0025ReqDto reqDto);
	
	//실적등록 취소 
	void getBack(Pro0023ReqDto reqDto);
	
	// 이전 실적 체크
	Pro0025errorVO getProcChk (Pro0025ReqDto reqDto);	
	// 다음 실적 체크
	Pro0025errorVO getafProcChk (Pro0023ReqDto reqDto);
	
	// 자동불출 = 'Y' 자재 수량 체크
	Pro0025errorVO getMatChk (Pro0025ReqDto reqDto);
}
