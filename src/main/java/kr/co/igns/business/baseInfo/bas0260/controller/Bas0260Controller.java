package kr.co.igns.business.baseInfo.bas0260.controller;

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
import kr.co.igns.business.baseInfo.bas0120.model.Bas0036VO;
import kr.co.igns.business.baseInfo.bas0260.model.Bas0260DetailVO;
import kr.co.igns.business.baseInfo.bas0260.model.Bas0260Dto;
import kr.co.igns.business.baseInfo.bas0260.model.Bas0260VO;
import kr.co.igns.business.baseInfo.bas0260.service.Bas0260Service;
import kr.co.igns.framework.config.exception.ExceptionAdvice;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Bas0260Controller", description = "예비품 정보")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Bas0260Controller {
	
	private final ResponseService responseService;
	private final ExceptionAdvice exceptionAdvice;
	private final Bas0260Service service;
	
	//예비품정보 조회
	@PostMapping(value="/bas0260/getMainList")
	@Operation(summary="예비품정보 조회", description="회사코드에 맞는 예비품정보 가져오기")
	public CommonResult getMainList(@RequestBody Bas0260Dto dto) {
		List<Bas0260VO> resultList = service.getMainList(dto);
		return responseService.getListResult(resultList);
	}
	
	//예비품별 자원정보 조회
	@PostMapping(value="/bas0260/getDetailList")
	@Operation(summary="예비품별 자원정보 조회", description="품번에 맞는 예비품별 자원정보 가져오기")
	public CommonResult getDetailList(@RequestBody Bas0260Dto dto) {
		List<Bas0260VO> resultList = service.getDetailList(dto);
		return responseService.getListResult(resultList);
	}
	
	//예비품정보 입력/수정
	@Operation(summary="예비품 정보 입력/수정", description="__created__ = true 입력/__modified__ = true 수정")
	@PostMapping(value="/bas0260/saveReserveStockInfo")
	@Transactional(rollbackFor = Exception.class)
	public CommonResult saveReserveStockInfo(@ModelAttribute Bas0260VO vo) throws Exception {
		System.out.println("saveReserveStockInfo ::: "+vo);
		service.saveReserveStockInfo(vo);
		return responseService.getSuccessResult();				
	}
	
	//예비품정보 입력/수정
	@Operation(summary="예비품별 자원정보 입력/수정", description="__created__ = true 입력/__modified__ = true 수정")
	@PostMapping(value="/bas0260/saveReserveStockDetailInfo")
	@Transactional(rollbackFor = Exception.class)
	public CommonResult saveReserveStockDetailInfo(@NotNull @RequestBody List<Bas0260DetailVO> voList) throws Exception {
		System.out.println("saveReserveStockDetailInfo ::: "+voList);
		service.saveReserveStockDetailInfo(voList);
		return responseService.getSuccessResult();				
	}
	
	@Operation(summary="예비품정보 삭제", description="예비품정보를 삭제한다.")
	@PostMapping(value = "/bas0260/deleteReserveStockInfo")
	@Transactional(rollbackFor = Exception.class)
	public CommonResult deleteReserveStockInfo(@RequestBody List<Bas0260VO> voList) throws Exception{
		service.deleteReserveStockInfo(voList);  
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="예비품별 자원정보 삭제", description="예비품별 자원정보를 삭제한다.")
	@PostMapping(value = "/bas0260/deleteReserveStockDetailInfo")
	@Transactional(rollbackFor = Exception.class)
	public CommonResult deleteReserveStockDetailInfo(@RequestBody List<Bas0260DetailVO> voList) throws Exception{
		service.deleteReserveStockDetailInfo(voList);  
		return responseService.getSuccessResult();
	}
}
