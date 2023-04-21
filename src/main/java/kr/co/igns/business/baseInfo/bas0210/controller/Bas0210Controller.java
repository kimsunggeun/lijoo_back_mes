package kr.co.igns.business.baseInfo.bas0210.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.baseInfo.bas0210.model.Bas0040VO;
import kr.co.igns.business.baseInfo.bas0210.model.Bas0041VO;
import kr.co.igns.business.baseInfo.bas0210.model.Bas0042VO;
import kr.co.igns.business.baseInfo.bas0210.model.Bas0043VO;
import kr.co.igns.business.baseInfo.bas0210.model.Bas0044VO;
import kr.co.igns.business.baseInfo.bas0210.model.Bas0045VO;
import kr.co.igns.business.baseInfo.bas0210.model.Bas0210Dto;
import kr.co.igns.business.baseInfo.bas0210.model.Bas0210VO;
import kr.co.igns.business.baseInfo.bas0210.service.Bas0210Service;
import kr.co.igns.framework.config.exception.ExceptionAdvice;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Bas0210Controller", description = "품목정보/경로정보/BOM정보/거래처정보")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Bas0210Controller {
	
	private final ResponseService responseService;
	private final ExceptionAdvice exceptionAdvice;
	private final Bas0210Service service;
	
	//품목선택 GET
	@PostMapping(value="/bas0210/getItemSelect")
	@Operation(summary="품목정보 조회", description="회사코드에 맞는 품목정보 가져오기")
	public CommonResult getItemSelect(@RequestBody Bas0210Dto dto) {
		List<Bas0040VO> resultList = service.getItemSelect(dto);
		return responseService.getListResult(resultList);
	}
	
	//품목정보 GET
	@PostMapping(value="/bas0210/getItemInfo")
	@Operation(summary="품목별 거래처정보 조회", description="회사코드에 맞는 품목별 거래처정보 가져오기")
	public CommonResult getItemInfo(@RequestBody Bas0210Dto dto) {
		List<Bas0040VO> resultList = service.getItemInfo(dto);
		return responseService.getListResult(resultList);
	}
	
	//경로유형 GET
	@PostMapping(value="/bas0210/getPathType")
	@Operation(summary="경로유형 정보 조회", description="회사코드에 맞는 경로유형 정보 가져오기")
	public CommonResult getPathType(@RequestBody Bas0210Dto dto) {
		List<Bas0041VO> resultList = service.getPathType(dto);
		return responseService.getListResult(resultList);
	}
	
	//경로정보 GET
	@PostMapping(value="/bas0210/getRouteInfo")
	@Operation(summary="경로정보 정보 조회", description="회사코드에 맞는 경로정보 정보 가져오기")
	public CommonResult getRouteInfo(@RequestBody Bas0210Dto dto) {
		List<Bas0042VO> resultList = service.getRouteInfo(dto);
		return responseService.getListResult(resultList);
	}
	
	//BOM정보 GET
	@PostMapping(value="/bas0210/getBomInfo")
	@Operation(summary="BOM정보 정보 조회", description="회사코드에 맞는 BOM정보 정보 가져오기")
	public CommonResult getBomInfo(@RequestBody Bas0210Dto dto) {
		List<Bas0043VO> resultList = service.getBomInfo(dto);
		return responseService.getListResult(resultList);
	}
	
	//품목별거래처정보 GET
	@PostMapping(value="/bas0210/getItemCustomInfo")
	@Operation(summary="품목별거래처정보 정보 조회", description="회사코드에 맞는 품목별거래처정보 가져오기")
	public CommonResult getItemCustomInfo(@RequestBody Bas0210Dto dto) {
		List<Bas0044VO> resultList = service.getItemCustomInfo(dto);
		return responseService.getListResult(resultList);
	}
	
	//단가정보 GET
	@PostMapping(value="/bas0210/getPriceInfo")
	@Operation(summary="단가정보 정보 조회", description="회사코드에 맞는 단가정보 가져오기")
	public CommonResult getPriceInfo(@RequestBody Bas0210Dto dto) {
		List<Bas0045VO> resultList = service.getPriceInfo(dto);
		return responseService.getListResult(resultList);
	}
	
	//품목정보 SAVE
	@PostMapping(value="/bas0210/saveItemInfo")
	@Operation(summary="품목정보 입력", description="품목정보 저장")
	public CommonResult saveItemInfo(@NotNull @RequestBody Bas0040VO vo)throws Exception{
		int resultCode = service.saveItemInfo(vo);
		if(resultCode < 1) {
			return responseService.getFailResult(Integer.valueOf(exceptionAdvice.getMessage("codeDuplicateError.code")), exceptionAdvice.getMessage("codeDuplicateError.msg"));
		}
		return responseService.getSuccessResult();
	}
	
	//품목정보 UPDATE
	@PostMapping(value="/bas0210/updateItemInfo")
	@Operation(summary="품목정보 입력", description="품목정보 수정")
	public CommonResult updateItemInfo(@NotNull @RequestBody List<Bas0040VO> voList)throws Exception{
		int resultCode = service.updateItemInfo(voList);
		if(resultCode < 1) {
			return responseService.getFailResult(Integer.valueOf(exceptionAdvice.getMessage("dbConnectError.code")), exceptionAdvice.getMessage("dbConnectError.msg"));
		}
		return responseService.getSuccessResult();
	}
	
	//경로유형 입력/수정
	@PostMapping(value="/bas0210/savePathType")
	@Operation(summary="경로유형 입력/수정", description="__created__ = true 입력/__modified__ = true 수정")
	public CommonResult savePathType(@NotNull @RequestBody List<Bas0041VO> voList)throws Exception{		
		int resultCode = service.savePathType(voList);
		if(resultCode < 1) {
			return responseService.getFailResult(Integer.valueOf(exceptionAdvice.getMessage("codeDuplicateError.code")), exceptionAdvice.getMessage("codeDuplicateError.msg"));
		}
		return responseService.getSuccessResult();
	}
	
	//경로정보 수정
	@PostMapping(value="/bas0210/updateRouteInfo")
	@Operation(summary="경로정보 수정", description="경로정보 update")
	public CommonResult updateRouteInfo(@NotNull @RequestBody List<Bas0042VO> voList)throws Exception{
		service.updateRouteInfo(voList);		
		return responseService.getSuccessResult();
	}
	
	//BOM정보 입력/수정
	@PostMapping(value="/bas0210/saveBomInfo")
	@Operation(summary="BOM정보 입력/수정", description="__created__ = true 입력/__modified__ = true 수정")
	public CommonResult saveBomInfo(@NotNull @RequestBody List<Bas0043VO> voList)throws Exception{
		int resultCode = service.saveBomInfo(voList);
		if(resultCode < 1) {
			return responseService.getFailResult(Integer.valueOf(exceptionAdvice.getMessage("codeDuplicateError.code")), exceptionAdvice.getMessage("codeDuplicateError.msg"));
		}
		return responseService.getSuccessResult();
	}
	
	//품목별 거래처정보 입력/수정
	@PostMapping(value="/bas0210/saveItemCustomInfo")
	@Operation(summary="품목별 거래처정보 입력/수정", description="__created__ = true 입력/__modified__ = true 수정")
	public CommonResult saveItemCustomInfo(@NotNull @RequestBody List<Bas0044VO> voList)throws Exception{
		int resultCode = service.saveItemCustomInfo(voList);
		if(resultCode < 1) {
			return responseService.getFailResult(Integer.valueOf(exceptionAdvice.getMessage("codeDuplicateError.code")), exceptionAdvice.getMessage("codeDuplicateError.msg"));
		}
		return responseService.getSuccessResult();
	}
	
	//단가정보 입력/수정
	@PostMapping(value="/bas0210/savePriceInfo")
	@Operation(summary="단가정보 입력/수정", description="__created__ = true 입력/__modified__ = true 수정")
	public CommonResult savePriceInfo(@NotNull @RequestBody List<Bas0045VO> voList)throws Exception{
		int resultCode = service.savePriceInfo(voList);
		if(resultCode < 1) {
			return responseService.getFailResult(Integer.valueOf(exceptionAdvice.getMessage("codeDuplicateError.code")), exceptionAdvice.getMessage("codeDuplicateError.msg"));
		}
		return responseService.getSuccessResult();
	}
	
	//품목정보 DELETE
	@PostMapping(value="/bas0210/deleteItemInfo")
	@Operation(summary="품목정보 삭제", description="품목정보 삭제")
	public CommonResult deleteItemInfo(@RequestBody List<Bas0040VO> voList)throws Exception{
		int resultCode = service.deleteItemInfo(voList);
		if(resultCode < 1) {
			return responseService.getFailResult(Integer.valueOf(exceptionAdvice.getMessage("usedCode.code")), exceptionAdvice.getMessage("usedCode.msg"));
		}
		return responseService.getSuccessResult();
	}
	
	//경로유형 DELETE
	@PostMapping(value="/bas0210/deletePathType")
	@Operation(summary="경로유형 삭제", description="경로유형 삭제")
	public CommonResult deletePathType(@RequestBody List<Bas0041VO> voList){
		service.deletePathType(voList);
		return responseService.getSuccessResult();
	}
	
	//BOM정보 DELETE
	@PostMapping(value="/bas0210/deleteBomInfo")
	@Operation(summary="BOM정보 삭제", description="BOM정보 삭제")
	public CommonResult deleteBomInfo(@RequestBody List<Bas0043VO> voList){
		service.deleteBomInfo(voList);
		return responseService.getSuccessResult();
	}
	
	//품목별 거래처 정보 DELETE
	@PostMapping(value="/bas0210/deleteCustomInfo")
	@Operation(summary="품목별 거래처 정보 삭제", description="품목별 거래처 정보 삭제")
	public CommonResult deleteCustomInfo(@RequestBody List<Bas0044VO> voList){
		int resultCode = service.deleteCustomInfo(voList);
		if(resultCode < 1) {
			return responseService.getFailResult(Integer.valueOf(exceptionAdvice.getMessage("usedCode.code")), exceptionAdvice.getMessage("usedCode.msg"));
		}
		return responseService.getSuccessResult();
	}
	
	//단가 정보 DELETE
	@PostMapping(value="/bas0210/deletePriceInfo")
	@Operation(summary="단가 정보 삭제", description="단가 정보 삭제")
	public CommonResult deletePriceInfo(@RequestBody List<Bas0045VO> voList){
		service.deletePriceInfo(voList);
		return responseService.getSuccessResult();
	}
	
	//경로명 GET
	@PostMapping(value="/bas0210/getPathCodeName")
	@Operation(summary="경로명 가져오기", description="selectList 경로코드, 경로명 가져오기")
	public CommonResult getPathCode(@RequestBody Bas0210Dto dto) {
		List<Bas0210VO> resultList = service.getPathCode(dto);
		return responseService.getListResult(resultList);
	}
	
	//입고창고명 GET
	@PostMapping(value="/bas0210/getInWhcodeName")
	@Operation(summary="창고명 가져오기", description="selectList 창고코드, 창고명 가져오기")
	public CommonResult getInWhcode(@RequestBody Bas0210Dto dto) {
		List<Bas0210VO> resultList = service.getInWhcode(dto);
		return responseService.getListResult(resultList);
	}
	
	//거래처명 GET
	@PostMapping(value="/bas0210/getCustCodeName")
	@Operation(summary="거래처명 가져오기", description="selectList 거래처코드, 거래처명 가져오기")
	public CommonResult getCustCode(@RequestBody Bas0210Dto dto) {
		List<Bas0210VO> resultList = service.getCustCode(dto);
		return responseService.getListResult(resultList);
	}
	
	//공정명 GET
	@PostMapping(value="/bas0210/getProCodeName")
	@Operation(summary="공정명 가져오기", description="selectList 공정코드, 공정명 가져오기")
	public CommonResult getProCode(@RequestBody Bas0210Dto dto) {
		List<Bas0210VO> resultList = service.getProCode(dto);
		return responseService.getListResult(resultList);
	}
	
	//[팝업]거래처 정보  GET
	@PostMapping(value="/bas0210/getCustPop")
	@Operation(summary="거래처 조회", description="거래처 팝업 조회 API")
	public CommonResult getCustPop(@RequestBody Bas0210Dto dto) {
		List<Bas0210VO> resultList = service.getCustPop(dto);
		return responseService.getListResult(resultList);
	}


}
