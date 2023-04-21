package kr.co.igns.business.baseInfo.bas0120.controller;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
import kr.co.igns.business.baseInfo.bas0120.service.Bas0120Service;
import kr.co.igns.framework.comm.model.UserVO;
import kr.co.igns.framework.config.exception.ExceptionAdvice;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "9. bas0120Controller", description = "공장정보")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Bas0120Controller {
	
	
	private final ResponseService responseService;	
	private final Bas0120Service service;	
	private final ExceptionAdvice exceptionAdvice;

	//자동투입창고
	@PostMapping(value="/bas0120/getAutoStorage")
	@Operation(summary="자동투입창고 조회", description="자동투입창고 정보 가져오기")
	public CommonResult getAutoStorage(@RequestBody Bas0120Dto dto) {		
		List<Bas0033VO> resultList = service.getAutoStorage(dto);
		return responseService.getListResult(resultList);
	}
	
	//공정명
	@PostMapping(value="/bas0120/getProcessName")
	@Operation(summary="공정명 조회", description="공정명 정보 가져오기")
	public CommonResult getProcessName(@RequestBody Bas0120Dto dto) {		
		List<Bas0031VO> resultList = service.getProcessName(dto);
		return responseService.getListResult(resultList);
	}
	
	//공장명 가져오기
	@PostMapping(value="/bas0120/getFacName")
	@Operation(summary="공장명 조회", description="공장명 정보 가져오기")
	public CommonResult getFacName(@RequestBody Bas0120Dto dto) {		
		List<Bas0030VO> resultList = service.getFacName(dto);
		return responseService.getListResult(resultList);
	}

	//공장정보 가져오기
	@PostMapping(value="/bas0120/getFacInfo")
	@Operation(summary="공장정보 조회", description="회사코드에 맞는 공장정보 가져오기")
	public CommonResult getFacInfo(@RequestBody Bas0120Dto dto) {		
		List<Bas0030VO> resultList = service.getFacInfo(dto);
		return responseService.getListResult(resultList);
	}
	
	//공정정보 가져오기
	@PostMapping(value="/bas0120/getProcInfo")
	@Operation(summary="공정정보 조회", description="회사코드에 맞는 공정정보 가져오기")
	public CommonResult getProcInfo(@RequestBody Bas0120Dto dto) {		
		List<Bas0031VO> resultList = service.getProcInfo(dto);
		return responseService.getListResult(resultList);
	}
	
	//창고정보 가져오기
	@PostMapping(value="/bas0120/getWareHouseInfo")
	@Operation(summary="창고정보 조회", description="회사코드에 맞는 창고정보 가져오기")
	public CommonResult getWareHouseInfo(@RequestBody Bas0120Dto dto) {
		List<Bas0032VO> resultList = service.getWareHouseInfo(dto);
		return responseService.getListResult(resultList);
	}
	
	//창고위치정보 가져오기
	@PostMapping(value="/bas0120/getWareHouseLocInfo")
	@Operation(summary="창고위치정보 조회", description="회사코드에 맞는 창고위치정보 가져오기")
	public CommonResult getWareHouseLocInfo(@RequestBody Bas0120Dto dto) {
		List<Bas0033VO> resultList = service.getWareHouseLocInfo(dto);
		return responseService.getListResult(resultList);
	}
	
	//작업장정보 가져오기
	@PostMapping(value="/bas0120/getWorkShopInfo")
	@Operation(summary="작업장정보 조회", description="회사코드에 맞는 작업장정보 가져오기")
	public CommonResult getWorkShopInfo(@RequestBody Bas0120Dto dto) {
		List<Bas0034VO> resultList = service.getWorkShopInfo(dto);
		return responseService.getListResult(resultList);
	}
	
	//작업반정보 가져오기
	@PostMapping(value="/bas0120/getWorkPartyInfo")
	@Operation(summary="작업반정보 조회", description="회사코드에 맞는 작업반정보 가져오기")
	public CommonResult getWorkPartyInfo(@RequestBody Bas0120Dto dto) {
		List<Bas0035VO> resultList = service.getWorkPartyInfo(dto);
		return responseService.getListResult(resultList);
	}
	
	//설비정보 가져오기
	@PostMapping(value="/bas0120/getFacilityInfo")
	@Operation(summary="설비정보 조회", description="회사코드에 맞는 설비정보 가져오기")
	public CommonResult getFacilityInfo(@RequestBody Bas0120Dto dto) {
		List<Bas0036VO> resultList = service.getFacilityInfo(dto);
		return responseService.getListResult(resultList);
	}
	
	//경로정보(라우팅) 가져오기
	@PostMapping(value="/bas0120/getRoutingInfo")
	@Operation(summary="경로정보(라우팅) 조회", description="회사코드에 맞는 경로정보 가져오기")
	public CommonResult getRoutingInfo(@RequestBody Bas0120Dto dto) {
		List<Bas0037VO> resultList = service.getRoutingInfo(dto);
		return responseService.getListResult(resultList);
	}
	
	//경로정보 가져오기
	@PostMapping(value="/bas0120/getRouteInfo")
	@Operation(summary="경로정보 조회", description="회사코드에 맞는 경로정보 가져오기")
	public CommonResult getRouteInfo(@RequestBody Bas0120Dto dto) {
		List<Bas0038VO> resultList = service.getRouteInfo(dto);
		return responseService.getListResult(resultList);
	}
	
	//공장정보 입력/수정
	@PostMapping(value="/bas0120/saveFacInfo")
	@Transactional(rollbackFor = Exception.class)
	@Operation(summary="공장정보 입력/수정", description="__created__ = true 입력/__modified__ = true 수정")
	public CommonResult saveFacInfo(@NotNull @RequestBody List<Bas0030VO> voList)throws Exception{
		service.saveFacInfo(voList);
		return responseService.getSuccessResult();				
	}
	
	//공정정보 입력/수정
	@PostMapping(value="/bas0120/saveProcInfo")
	@Transactional(rollbackFor = Exception.class)
	@Operation(summary="공정정보 입력/수정", description="__created__ = true 입력/__modified__ = true 수정")
	public CommonResult saveProcInfo(@NotNull @RequestBody List<Bas0031VO> voList)throws Exception{
		service.saveProcInfo(voList);
		return responseService.getSuccessResult();				
	}
	
	//창고정보 입력/수정
	@PostMapping(value="/bas0120/saveWareHouseInfo")
	@Transactional(rollbackFor = Exception.class)
	@Operation(summary="창고정보 입력/수정", description="__created__ = true 입력/__modified__ = true 수정")
	public CommonResult saveWareHouseInfo(@NotNull @RequestBody List<Bas0032VO> voList)throws Exception{
		service.saveWareHouseInfo(voList);
		return responseService.getSuccessResult();				
	}
	
	//창고위치정보 입력/수정
	@PostMapping(value="/bas0120/saveWareHouseLocInfo")
	@Transactional(rollbackFor = Exception.class)
	@Operation(summary="창고위치정보 입력/수정", description="__created__ = true 입력/__modified__ = true 수정")
	public CommonResult saveWareHouseLocInfo(@NotNull @RequestBody List<Bas0033VO> voList)throws Exception{
		service.saveWareHouseLocInfo(voList);
		return responseService.getSuccessResult();				
	}
	
	//작업장정보 입력/수정
	@PostMapping(value="/bas0120/saveWorkShopInfo")
	@Transactional(rollbackFor = Exception.class)
	@Operation(summary="작업장정보 입력/수정", description="__created__ = true 입력/__modified__ = true 수정")
	public CommonResult saveWorkShopInfo(@NotNull @RequestBody List<Bas0034VO> voList)throws Exception{
		service.saveWorkShopInfo(voList);
		return responseService.getSuccessResult();				
	}
	
	//작업반정보 입력/수정
	@PostMapping(value="/bas0120/saveWorkPartyInfo")
	@Transactional(rollbackFor = Exception.class)
	@Operation(summary="작업반정보 입력/수정", description="__created__ = true 입력/__modified__ = true 수정")
	public CommonResult saveWorkPartyInfo(@NotNull @RequestBody List<Bas0035VO> voList)throws Exception{
		service.saveWorkPartyInfo(voList);
		return responseService.getSuccessResult();				
	}
	
	//설비정보 입력/수정
	@Operation(summary="설비정보 입력/수정", description="__created__ = true 입력/__modified__ = true 수정")
	@PostMapping(value="/bas0120/saveFacilityInfo")
	@Transactional(rollbackFor = Exception.class)
//	public CommonResult saveFacilityInfo(@NotNull @RequestBody List<Bas0036VO> voList)throws Exception{
	public CommonResult createUser(@ModelAttribute Bas0036VO vo) throws Exception {
		System.out.println("saveFacilityInfo ::: "+vo);
		service.saveFacilityInfo(vo);
		return responseService.getSuccessResult();				
	}
	
	//경로정보(라우팅) 입력/수정
	@Operation(summary="경로정보(라우팅) 입력/수정", description="__created__ = true 입력/__modified__ = true 수정")
	@PostMapping(value="/bas0120/saveRoutingInfo")
	@Transactional(rollbackFor = Exception.class)
	public CommonResult saveRoutingInfo(@NotNull @RequestBody List<Bas0037VO> voList)throws Exception{
		service.saveRoutingInfo(voList);
		return responseService.getSuccessResult();				
	}
	
	//경로정보 입력/수정
	@Operation(summary="경로정보(라우팅) 입력/수정", description="__created__ = true 입력/__modified__ = true 수정")
	@PostMapping(value="/bas0120/saveRouteInfo")
	@Transactional(rollbackFor = Exception.class)
	public CommonResult saveRouteInfo(@NotNull @RequestBody List<Bas0038VO> voList)throws Exception{
		service.saveRouteInfo(voList);
		return responseService.getSuccessResult();				
	}	
	
	@Operation(summary="공장정보 삭제", description="공장정보를 삭제한다.")
	@PostMapping(value = "/bas0120/deleteFacInfo")
	@Transactional(rollbackFor = Exception.class)
	public CommonResult deleteFac(@RequestBody List<Bas0030VO> voList) throws Exception{
		service.deleteFac(voList);
		return responseService.getSuccessResult();

	}
	
	@Operation(summary="공정정보 삭제", description="공정정보를 삭제한다.")
	@PostMapping(value = "/bas0120/deleteProcInfo")
	@Transactional(rollbackFor = Exception.class)
	public CommonResult deleteProc(@RequestBody List<Bas0031VO> voList) throws Exception{
		service.deleteProc(voList);
		return responseService.getSuccessResult();

	}
	
	@Operation(summary="창고정보 삭제", description="창고정보를 삭제한다.")
	@PostMapping(value = "/bas0120/deleteWareHouseInfo")
	@Transactional(rollbackFor = Exception.class)
	public CommonResult deleteWareHouse(@RequestBody List<Bas0032VO> voList) throws Exception{
		service.deleteWareHouse(voList);
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="창고위치정보 삭제", description="창고위치정보를 삭제한다.")
	@PostMapping(value = "/bas0120/deleteWareHouseLocInfo")
	@Transactional(rollbackFor = Exception.class)
	public CommonResult WareHouseLoc(@RequestBody List<Bas0033VO> voList) throws Exception{
		service.deleteWareHouseLoc(voList);
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="작업장정보 삭제", description="작업장정보를 삭제한다.")
	@PostMapping(value = "/bas0120/deleteWorkShopInfo")
	@Transactional(rollbackFor = Exception.class)
	public CommonResult deleteWorkShop(@RequestBody List<Bas0034VO> voList) throws Exception{
		service.deleteWorkShop(voList);
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="작업반정보 삭제", description="작업반정보를 삭제한다.")
	@PostMapping(value = "/bas0120/deleteWorkPartyInfo")
	@Transactional(rollbackFor = Exception.class)
	public CommonResult deleteWorkParty(@RequestBody List<Bas0035VO> voList) throws Exception{
		service.deleteWorkParty(voList); 
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="설비정보 삭제", description="설비정보를 삭제한다.")
	@PostMapping(value = "/bas0120/deleteFacilityInfo")
	@Transactional(rollbackFor = Exception.class)
	public CommonResult deleteFacility(@RequestBody List<Bas0036VO> voList) throws Exception{
		service.deleteFacility(voList);  
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="경로정보(라우팅) 삭제", description="경로정보(라우팅)를 삭제한다.")
	@PostMapping(value = "/bas0120/deleteRoutingInfo")
	@Transactional(rollbackFor = Exception.class)
	public CommonResult deleteRouting(@RequestBody List<Bas0037VO> voList) throws Exception{
		service.deleteRouting(voList);  
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="경로정보 삭제", description="경로정보를 삭제한다.")
	@PostMapping(value = "/bas0120/deleteRouteInfo")
	@Transactional(rollbackFor = Exception.class)
	public CommonResult deleteRoute(@RequestBody List<Bas0038VO> voList) throws Exception{
		service.deleteRoute(voList);   
		return responseService.getSuccessResult();
	}
}
