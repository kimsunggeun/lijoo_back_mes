package kr.co.igns.business.pop.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.ProdManage.model.pro0050.Pro0050ReqDto;
import kr.co.igns.business.pop.model.Pro0021ReqDto;
import kr.co.igns.business.pop.model.baseInfo.bas0034ReqDto;
import kr.co.igns.business.pop.service.basInfoService;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "baseInfoController", description = "pop 공통정보")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pop")
public class baseInfoController {

	private final ResponseService responseService;
	private final basInfoService basInfoService;
	
	@Operation(summary="작업장 조회", description="pop 화면에서 선택할 작업장 조회")
	@PostMapping(value="/getBas0034")
	public CommonResult getbas0034(@RequestBody bas0034ReqDto reqDto){
		return responseService.getListResult(basInfoService.getBas0034(reqDto));
    }
	
	@Operation(summary="작업반 조회", description="pop 화면에서 선택할 작업반 조회")
	@PostMapping(value="/getBas0035")
	public CommonResult getbas0035(@RequestBody bas0034ReqDto reqDto){
		return responseService.getListResult(basInfoService.getBas0035(reqDto));
    }
	
	@Operation(summary="작업지시 팝업 조회", description="작업지시 팝업 조회 para : comCode, facCode")
	@PostMapping(value="/getPro0010")
	public CommonResult getPro0010(@RequestBody Pro0050ReqDto reqDto){
		return responseService.getListResult(basInfoService.getPro0010(reqDto));
    }
	
	@Operation(summary="popup 사용자 정보 조회", description="popup 사용자 조회 para:comCode")
	@PostMapping(value="/getWorkerList")
	public CommonResult getWorkerList(@RequestBody Pro0021ReqDto reqDto){
		return responseService.getListResult(basInfoService.getWorkerList(reqDto));
    }
}
