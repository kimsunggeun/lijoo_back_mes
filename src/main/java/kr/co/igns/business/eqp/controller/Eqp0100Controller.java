package kr.co.igns.business.eqp.controller;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.baseInfo.bas0260.model.Bas0260DetailVO;
import kr.co.igns.business.eqp.model.eqp0100.Eqp0100Dto;
import kr.co.igns.business.eqp.model.eqp0100.Eqp0100VO;
import kr.co.igns.business.eqp.service.Eqp0100Service;
import kr.co.igns.framework.config.exception.ExceptionAdvice;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Eqp0100Controller", description = "설비예비품 관리")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Eqp0100Controller {
	
	private final ResponseService responseService;
	private final ExceptionAdvice exceptionAdvice;
	private final Eqp0100Service service;
	
	//예비품 정보 조회
	@PostMapping(value="/getMainList")
	@Operation(summary="예비품 정보 조회", description="회사코드에 맞는 예비품 정보 가져오기")
	public CommonResult getMainList(@RequestBody Eqp0100Dto dto) {
		List<Eqp0100VO> resultList = service.getMainList(dto);
		return responseService.getListResult(resultList);
	}
	
	//입고내역 조회
	@PostMapping(value="/getReceiptDetailList")
	@Operation(summary="입고내역 조회", description="회사코드에 맞는 예비품 정보 가져오기")
	public CommonResult getReceiptDetailList(@RequestBody Eqp0100Dto dto) {
		List<Eqp0100VO> resultList = service.getReceiptDetailList(dto);
		return responseService.getListResult(resultList);
	}
	
	//출고내역 조회
	@PostMapping(value="/getDeliDetailList")
	@Operation(summary="출고내역 조회", description="회사코드에 맞는 예비품 정보 가져오기")
	public CommonResult getDeliDetailList(@RequestBody Eqp0100Dto dto) {
		List<Eqp0100VO> resultList = service.getDeliDetailList(dto);
		return responseService.getListResult(resultList);
	}
	
	//입고내역, 출고내역 입력/수정
	@Operation(summary="입고내역, 출고내역 입력/수정", description="__created__ = true 입력/__modified__ = true 수정")
	@PostMapping(value="/saveDetailInfo")
	@Transactional(rollbackFor = Exception.class)
	public CommonResult saveDetailInfo(@NotNull @RequestBody List<Eqp0100VO> voList) throws Exception {
		System.out.println("saveDetailInfo ::: "+voList);
		service.saveDetailInfo(voList);
		return responseService.getSuccessResult();				
	}
}
