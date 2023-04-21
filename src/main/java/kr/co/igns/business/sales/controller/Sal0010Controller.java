package kr.co.igns.business.sales.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.baseInfo.bas0120.model.Bas0030VO;
import kr.co.igns.business.sales.model.sal0010.Sal0010ReqDto;
import kr.co.igns.business.sales.model.sal0010.Sal0010VO;
import kr.co.igns.business.sales.model.sal0010.Sal0011VO;
import kr.co.igns.business.sales.service.Sal0010Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Sal0010Controller", description = "고객주문등록")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Sal0010Controller {
	
	private final ResponseService responseService;
	private final Sal0010Service sal0010Service;
	
	@Operation(summary="품목 정보 조회", description="품목 정보를 조회한다")
	@PostMapping(value="/getItemInfo")
	public CommonResult getItemInfo(@RequestBody Sal0010ReqDto reqDto){
		List<Sal0010VO> vo = sal0010Service.getItemInfo(reqDto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="고객주문등록 정보 조회", description="고객주문정보를 조회한다 param: comCode")
	@PostMapping(value="/getSal0010")
	public CommonResult getSal0010(@RequestBody Sal0010ReqDto reqDto){
		List<Sal0010VO> vo = sal0010Service.getSal0010(reqDto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="고객주문등록 입력/수정", description="고객주문정보를 입력/수정한다.(__created__ = true 입력/__modified__ = true 수정)")
	@PostMapping(value = "/createSal0010")
	private CommonResult createSal0010(@NotNull @RequestBody List<Sal0010VO> voList) throws Exception {
		sal0010Service.createSal0010(voList);
		return responseService.getSuccessResult();
	}
    
	@Operation(summary="고객주문등록 확정", description="고객주문등록 정보를  확정한다")
	@PostMapping(value="/confirmSal0010")
	private CommonResult confirmSal0010(@NotNull @RequestBody List<Sal0010VO> voList) throws Exception {
		sal0010Service.confirmSal0010(voList);
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="고객주문등록 확정취소", description="확정되어 있는 고객주문등록 정보를 확정 취소한다")
	@PostMapping(value="/confirmCancelSal0010")
	private CommonResult confirmCancelSal0010(@NotNull @RequestBody List<Sal0010VO> voList) throws Exception {
		sal0010Service.confirmCancelSal0010(voList);
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="고객주문상세 정보 조회", description="고객주문정보를 조회한다 param: comCode")
	@PostMapping(value="/getSal0011")
	public CommonResult getSal0011(@RequestBody Sal0010ReqDto reqDto){
		List<Sal0011VO> vo = sal0010Service.getSal0011(reqDto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="고객주문상세 입력/수정", description="고객주문정보를 입력/수정한다.(__created__ = true 입력/__modified__ = true 수정)")
	@PostMapping(value = "/createSal0011")
	private CommonResult createSal0011(@NotNull @RequestBody List<Sal0011VO> voList) throws Exception {
		sal0010Service.createSal0011(voList);
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="수주정보 삭제", description="수주정보를 삭제한다.")
	@PostMapping(value = "/deleteSal0010")
	private CommonResult deleteSal0010(@NotNull @RequestBody List<Sal0010VO> voList) throws Exception {
		sal0010Service.deleteSal0010(voList);
		return responseService.getSuccessResult();
		
	}
	@Operation(summary="수주정보상세 삭제", description="수주정보상세를 삭제한다.")
	@PostMapping(value = "/deleteSal0011")
	private CommonResult deleteSal0011(@NotNull @RequestBody List<Sal0011VO> voList) throws Exception {
		sal0010Service.deleteSal0011(voList);
		return responseService.getSuccessResult();
		
	}
	
}
