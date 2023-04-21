package kr.co.igns.business.qat.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import kr.co.igns.business.qat.model.qat0010.Bas0061VO;
import kr.co.igns.business.qat.model.qat0010.Mat0012VO;
import kr.co.igns.business.qat.model.qat0010.Qat0010Dto;
import kr.co.igns.business.qat.model.qat0010.Qat0010VO;
import kr.co.igns.business.qat.service.Qat0010Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Qat0010Controller {
	
	private final ResponseService responseService;
	private final Qat0010Service service;
	
	//납품정보 GET
	@PostMapping(value="/qat0010/getDelInfo")
	@Operation(summary="납품정보 조회", description="입고상태정보를 보기위해 가져오기")
	public CommonResult getDelInfo(@RequestBody Qat0010Dto dto) {
		List<Mat0012VO> resultList = service.getDelInfo(dto);
		return responseService.getListResult(resultList);
	}
	
	//입고내역 GET
	@PostMapping(value="/qat0010/getMat0018_Qat0010")
	@Operation(summary="입고내역 조회", description="입고내역 가져오기")
	public CommonResult getMat0018_Qat0010(@RequestBody Qat0010Dto dto) {
		List<Qat0010VO> resultList = service.getMat0018_Qat0010(dto);
		return responseService.getListResult(resultList);
	}
    //검사내역 가져오기	
	@PostMapping(value="/qat0010/getInsDetails")
	@Operation(summary="검사내역 가져오기	", description="검사내역 가져오기")
	public CommonResult getInsDetails(@RequestBody Qat0010Dto dto) {
		System.out.println("getInsDetails ::::" + dto);
		List<Bas0061VO> resultList = service.getInsDetails(dto);
		return responseService.getListResult(resultList);
	}
	
	//검사내역 저장하기
	@PostMapping(value="/qat0010/saveInsDetails")
	@Operation(summary="검사내역 저장", description="검사내역 저장하기")
	public CommonResult saveInsDetails(@NotNull @RequestBody List<Qat0010VO> voList)throws Exception{
		service.saveInsDetails(voList);
		return responseService.getSuccessResult();
	}
	
	//입고내역 삭제하기
	@PostMapping(value="/qat0010/deleteQat0010")
	@Operation(summary="입고내역 삭제", description="입고내역 삭제하기")
	public CommonResult deleteQat0010(@NotNull @RequestBody List<Qat0010VO> voList)throws Exception{
		service.deleteQat0010(voList);
		return responseService.getSuccessResult();
	}
}
