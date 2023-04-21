package kr.co.igns.business.baseInfo.bas0120.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.baseInfo.bas0120.model.Bas0030VO;
import kr.co.igns.business.baseInfo.bas0120.model.Bas0031VO;
import kr.co.igns.business.baseInfo.bas0120.model.Bas0032VO;
import kr.co.igns.business.baseInfo.bas0120.model.Bas0033VO;
import kr.co.igns.business.baseInfo.bas0120.model.Bas0034VO;
import kr.co.igns.business.baseInfo.bas0120.model.Bas0035VO;
import kr.co.igns.business.baseInfo.bas0120.model.Bas0036VO;
import kr.co.igns.business.baseInfo.bas0120.model.Bas0037VO;
import kr.co.igns.business.baseInfo.bas0120.model.Bas0038VO;
import kr.co.igns.business.baseInfo.bas0120.model.Bas0120Dto;

@Mapper
public interface Bas0120Dao {
	//조회
	List<Bas0033VO> getAutoStorage(Bas0120Dto dto);
	List<Bas0030VO> getFacInfo(Bas0120Dto dto);
	List<Bas0030VO> getFacName(Bas0120Dto dto);
	List<Bas0031VO> getProcInfo(Bas0120Dto dto);
	List<Bas0031VO> getProcessName(Bas0120Dto dto);
	List<Bas0032VO> getWareHouseInfo(Bas0120Dto dto);
	List<Bas0033VO> getWareHouseLocInfo(Bas0120Dto dto);
	List<Bas0034VO> getWorkShopInfo(Bas0120Dto dto);
	List<Bas0035VO> getWorkPartyInfo(Bas0120Dto dto);
	List<Bas0036VO> getFacilityInfo(Bas0120Dto dto);
	List<Bas0037VO> getRoutingInfo(Bas0120Dto dto);
	List<Bas0038VO> getRouteInfo(Bas0120Dto dto);
	
	//생성
	int ctFacInfo(Bas0030VO vo);
	int ctProcInfo(Bas0031VO vo);
	int ctWareHouseInfo(Bas0032VO vo);
	int ctWareHouseLocInfo(Bas0033VO vo);
	int ctWorkShopInfo(Bas0034VO vo);
	int ctWorkPartyInfo(Bas0035VO vo);
	int ctFacilityInfo(Bas0036VO vo);
	int ctRoutingInfo(Bas0037VO vo);
	int ctRouteInfo(Bas0038VO vo);
	
	//수정
	int utFacInfo(Bas0030VO vo);
	int utProcInfo(Bas0031VO vo);
	int utWareHouseInfo(Bas0032VO vo);
	int utWareHouseLocInfo(Bas0033VO vo);
	int utWorkShopInfo(Bas0034VO vo);
	int utWorkPartyInfo(Bas0035VO vo);
	int utFacilityInfo(Bas0036VO vo);
	int utRoutingInfo(Bas0037VO vo);
	int utRouteInfo(Bas0038VO vo);	
	
	//삭제
	int deleteFac(Bas0030VO vo);
	int deleteProc(Bas0031VO vo);
	int deleteWareHouse(Bas0032VO vo);
	int deleteWareHouseLoc(Bas0033VO vo);
	int deleteWorkShop(Bas0034VO vo);
	int deleteWorkParty(Bas0035VO vo);
	int deleteFacility(Bas0036VO vo);
	int deleteRouting(Bas0037VO vo);
	int deleteRoute(Bas0038VO vo);
	
}
