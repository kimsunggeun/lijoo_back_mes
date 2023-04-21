package kr.co.igns.business.pop.controller;

import java.util.List;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import kr.co.igns.business.pop.model.Pop0290ReqDto;
import kr.co.igns.business.pop.model.Pop0290StopReqDto;
import kr.co.igns.business.pop.model.Pop0290VO;
import kr.co.igns.business.pop.model.Pop0291VO;
import kr.co.igns.business.pop.service.Pop0290Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Pop0029Controller", description = "설비 가동.비가동 등록")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/eqp")
public class Pop0290Controller {

	private final ResponseService responseService;
	private final Pop0290Service pop0029Service;

	@Operation(summary = "설비 가동 조회", description = "설비 가동을 조회한다")
	@PostMapping(value = "/getEqp0010")
	public CommonResult getEqp0010(@RequestBody Pop0290ReqDto reqDto) {
		return responseService.getListResult(pop0029Service.getEqp0010(reqDto));
	}
	
	@Operation(summary = "설비 가동 조회", description = "설비 가동을 조회한다")
	@PostMapping(value = "/getEqp0010Main")
	public CommonResult getEqp0010Main(@RequestBody Pop0290ReqDto reqDto) {
		return responseService.getListResult(pop0029Service.getEqp0010Main(reqDto));
	}
	
	@Operation(summary = "stoptime 조회", description = "설비 가동을 조회한다")
	@PostMapping(value = "/getStopTime")
	public CommonResult getStopTime(@RequestBody Pop0290StopReqDto reqDto) {
		return responseService.getListResult(pop0029Service.getStopTime(reqDto));
	}

	@Operation(summary = "설비 가동", description = "설비 가동으로 바꿈")
	@PostMapping(value = "/setOperating")
	public CommonResult setOperating(@RequestBody List<Pop0290VO> voList) throws Exception {
		pop0029Service.setOperating(voList);
		return responseService.getSuccessResult();
	}
	
	@Operation(summary = "공정검사", description = "공점검사 데이터 조회")
	@PostMapping(value = "/getProcess")
	public CommonResult getProcess(@RequestBody Pop0290ReqDto reqDto) {
		return responseService.getListResult(pop0029Service.getProcess(reqDto));
	}
	@Operation(summary = "공정검사 저장", description = "공정검사 저장")
	@PostMapping(value = "/setProcess")
	public CommonResult setProcess(@RequestBody List<Pop0291VO> voList) throws Exception {
		pop0029Service.setProcess(voList);
		return responseService.getSuccessResult();
	}
	
}
