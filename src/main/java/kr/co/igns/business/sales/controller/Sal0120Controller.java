package kr.co.igns.business.sales.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.sales.model.sal0120.Sal0012VO;
import kr.co.igns.business.sales.model.sal0120.Sal0120ReqDto;
import kr.co.igns.business.sales.model.sal0120.Sal0120VO;
import kr.co.igns.business.sales.service.Sal0120Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Sal0120Controller", description = "출하등록")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Sal0120Controller {
	
	private final ResponseService responseService;
	private final Sal0120Service sal0120Service;
	
	@Operation(summary="출하등록 정보 조회", description="출하등록 정보를 조회한다 param: comCode")
	@PostMapping(value="/sal0120/getSal0120")
	public CommonResult getSal0120(@RequestBody Sal0120ReqDto reqDto){
		List<Sal0120VO> vo = sal0120Service.getSal0120(reqDto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="출하현황 정보 조회", description="출하현황 정보를 조회한다 param: comCode")
	@PostMapping(value="/sal0120/getSal0120Status")
	public CommonResult getSal0120Status(@RequestBody Sal0120VO reqVO){
		List<Sal0120VO> vo = sal0120Service.getSal0120Status(reqVO);
		return responseService.getListResult(vo);
    }	
	
	@Operation(summary="출하등록 삽입", description="출하등록 정보를 삽입한다.")
	@PostMapping(value = "/sal0120/createSal0120")
	private CommonResult createSal0120(@NotNull @RequestBody List<Sal0120VO> voList) throws Exception {
		sal0120Service.createSal0120(voList);
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="출하등록 삭제", description="출하등록 정보를 삭제한다.")
	@PostMapping(value = "/sal0120/deleteSal0120")
	private CommonResult deleteSal0120(@NotNull @RequestBody List<Sal0120VO> voList) throws Exception {
		sal0120Service.deleteSal0120(voList);
		return responseService.getSuccessResult();
	}	
	
	@Operation(summary="수주현황 조회 - 수주일 기준", description="수주일 기준으로 수주현황 조회한다")
	@PostMapping(value="/sal0120/getOrdStatusOnOrderDate")
	public CommonResult getOrdStatusOnOrderDate(@RequestBody Sal0120ReqDto reqDto){
		List<Sal0012VO> vo = sal0120Service.getOrdStatusOnOrderDate(reqDto);
		return responseService.getListResult(vo);
    }

	@Operation(summary="수주현황 조회 - 납기일 기준", description="납기일 기준으로 수주현황 조회한다")
	@PostMapping(value="/sal0120/getOrdStatusOnDeliveryDate")
	public CommonResult getOrdStatusOnDeliveryDate(@RequestBody Sal0120ReqDto reqDto){
		List<Sal0012VO> vo = sal0120Service.getOrdStatusOnDeliveryDate(reqDto);
		return responseService.getListResult(vo);
    }	
	
}
