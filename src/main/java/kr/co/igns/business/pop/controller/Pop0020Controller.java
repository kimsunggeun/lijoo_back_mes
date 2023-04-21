package kr.co.igns.business.pop.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;
import kr.co.igns.business.pop.service.Pop0020Service;
import kr.co.igns.business.mat.service.Mat0030Service;
import kr.co.igns.business.mat.model.mat0030.Mat0012VO;
import kr.co.igns.business.mat.model.mat0030.Mat0018VO;
import kr.co.igns.business.pop.model.Pop0010VO;
import kr.co.igns.business.pop.model.Pop0020ReqDto;
import kr.co.igns.business.pop.model.Pop0020VO;


@Tag(name = "Pop0020Controller", description = "POP - 미납품 입고")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pop")

public class Pop0020Controller {
	
	private final ResponseService responseService;
	private final Pop0020Service pop0020Service;
	private final Mat0030Service mat0020Service;
	
	@Operation(summary="거래처코드 조회", description="거래처코드 조회")
	@PostMapping(value="/getCustCode")
	public CommonResult getCustCode(@RequestBody Pop0020VO vo){
		return responseService.getListResult(pop0020Service.getCustCode(vo));
    }
	
	@Operation(summary="거래처코드에 의한 발주번호 조회", description="거래처코드에 의한 발주번호 조회")
	@PostMapping(value="/getOrdNo")
	public CommonResult getOrdNo(@RequestBody Pop0020VO vo){
		return responseService.getListResult(pop0020Service.getOrdNo(vo));
    }
	
	@Operation(summary="발주번호에 의한 발주정보 상세 조회", description="발주번호에 의한 발주정보 상세 조회")
	@PostMapping(value="/getMat0011")
	public CommonResult getMat0011(@RequestBody Pop0020VO vo){
		return responseService.getListResult(pop0020Service.getMat0011(vo));
    }
	
	@Operation(summary="발주번호에 의한 입고현황 조회", description="발주번호에 의한 입고현황을 조회")
	@PostMapping(value="/getMat0012")
	public CommonResult getMat0012(@RequestBody Pop0020VO vo) {
		return responseService.getListResult(pop0020Service.getMat0012(vo));
	}
	
	@Operation(summary="구매 입고정보 입력/수정", description="구매 입고정보를 입력/수정한다.(__created__ = true 입력/__modified__ = true 수정)")
	@PostMapping(value = "/createMat0012")
	private CommonResult createMat0012(@NotNull @RequestBody List<Mat0012VO> voList) throws Exception {
		pop0020Service.createMat0012(voList);
		return responseService.getSuccessResult();
	}
	
	
}
