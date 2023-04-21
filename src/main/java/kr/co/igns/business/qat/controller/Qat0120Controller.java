package kr.co.igns.business.qat.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;
import kr.co.igns.business.qat.service.Qat0120Service;
import kr.co.igns.business.qat.model.qat0120.Qat0120VO;
import kr.co.igns.business.qat.model.qat0120.Qat0120Dto;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Qat0120Controller {
	
	private final ResponseService responseService;
	private final Qat0120Service service;

	@PostMapping(value="/qat0120/getdefStatus")
	@Operation(summary="불량현황 조회", description="불량현황을 조회한다.")
	public CommonResult getdefStatus(@RequestBody Qat0120Dto dto) {
		List<Qat0120VO> resultList = service.getdefStatus(dto);
		return responseService.getListResult(resultList);
	}
	
	@PostMapping(value="/qat0120/getDefDetail")
	@Operation(summary="불량상세 조회", description="불량상세정보를 조회한다.")
	public CommonResult getDefDetail(@RequestBody Qat0120Dto dto) {
		List<Qat0120VO> resultList = service.getDefDetail(dto);
		return responseService.getListResult(resultList);
	}
	
	@PostMapping(value="/qat0120/getDefQtyDetail")
	@Operation(summary="불량수량 상세조회", description="불량수량 상세정보를 조회한다.")
	public CommonResult getDefQtyDetail(@RequestBody Qat0120Dto dto) {
		List<Qat0120VO> resultList = service.getDefQtyDetail(dto);
		return responseService.getListResult(resultList);
	}


	

}
