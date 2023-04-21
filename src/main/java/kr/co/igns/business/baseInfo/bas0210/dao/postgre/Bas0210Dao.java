package kr.co.igns.business.baseInfo.bas0210.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.baseInfo.bas0210.model.Bas0040VO;
import kr.co.igns.business.baseInfo.bas0210.model.Bas0041VO;
import kr.co.igns.business.baseInfo.bas0210.model.Bas0042VO;
import kr.co.igns.business.baseInfo.bas0210.model.Bas0043VO;
import kr.co.igns.business.baseInfo.bas0210.model.Bas0044VO;
import kr.co.igns.business.baseInfo.bas0210.model.Bas0045VO;
import kr.co.igns.business.baseInfo.bas0210.model.Bas0210Dto;
import kr.co.igns.business.baseInfo.bas0210.model.Bas0210VO;

@Mapper
public interface Bas0210Dao {
	//조회
	List<Bas0040VO> getItemSelect(Bas0210Dto dto);
	List<Bas0040VO> getItemInfo(Bas0210Dto dto);
	List<Bas0041VO> getPathType(Bas0210Dto dto);
	List<Bas0042VO> getRouteInfo(Bas0210Dto dto);
	List<Bas0043VO> getBomInfo(Bas0210Dto dto);
	List<Bas0044VO> getItemCustomInfo(Bas0210Dto dto);
	List<Bas0045VO> getPriceInfo(Bas0210Dto dto);
	
	//생성
	int ctItemInfo(Bas0040VO vo);
	int ctPathType(Bas0041VO vo);
	int ctPathInfo(Bas0041VO vo);
	int ctBomInfo(Bas0043VO vo);
	int ctItemCustomInfo(Bas0044VO vo);
	int ctPriceInfo(Bas0045VO vo);
	
	//수정
	int utItemInfo(Bas0040VO vo);
	int utPathType(Bas0041VO vo);
	int utRouteInfo(Bas0042VO vo);
	int utBomInfo(Bas0043VO vo);
	int utItemCustomInfo(Bas0044VO vo);
	int utPriceInfo(Bas0045VO vo);
	int utPriceDate(Bas0045VO vo);
	
	//삭제
	int dtItemInfo(Bas0040VO vo);
	int dtPathType(Bas0041VO vo);
	int dtPathInfo(Bas0041VO vo);
	int dtBomInfo(Bas0043VO vo);
	int dtItemCustomInfo(Bas0044VO vo);
	int dtPriceInfo(Bas0045VO vo);
	
	//품목 중복체크
	public int dupleItemCode(Bas0040VO vo);
	//경로 중복체크
	public int duplePathCode(Bas0041VO vo);
	//BOM 중복체크
	public int dupleBomInfo(Bas0043VO vo);
	//품목별거래처정보 중복체크
	public int dupleItemCustomInfo(Bas0044VO vo);
	//단가정보 중복체크
	public int duplePriceInfo(Bas0045VO vo);
	
	//경로명 가져오기
	List<Bas0210VO> getPathCode(Bas0210Dto dto);
	//입고창고명 가져오기
	List<Bas0210VO> getInWhcode(Bas0210Dto dto);
	//거래처명 가져오기
	List<Bas0210VO> getCustCode(Bas0210Dto dto);	
	//공정명 가져오기
	List<Bas0210VO> getProCode(Bas0210Dto dto);
	
	//품번 사용 체크
	public int getPartChk(Bas0040VO vo);
	//단가정보 사용 체크
	public int getPriceChk(Bas0044VO vo);
	//단가정보 Cnt
	public int getPriceCnt(Bas0045VO vo);
	//평균단가 가져오기
	public int getAveragePrice(Bas0210Dto dto);
	
	//거래처 팝업 
	List<Bas0210VO> getCustPop(Bas0210Dto dto);
}
