package kr.co.igns.framework.comm.controller;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.framework.comm.model.ConstInfoVO;
import kr.co.igns.framework.comm.model.DashboardInfoVO;
import kr.co.igns.framework.comm.model.OverflowInfoVO;
import kr.co.igns.framework.comm.model.PrintInfoVO;
import kr.co.igns.framework.comm.model.SystemReqDto;
import kr.co.igns.framework.comm.service.SystemService;
import kr.co.igns.framework.config.exception.ExceptionAdvice;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;



@Tag(name = "9. SystemController", description = "설정 관리")
@RestController
@RequiredArgsConstructor
@RequestMapping("/com")
public class SystemController {
	
	private final ResponseService responseService;
	private final ExceptionAdvice exceptionAdvice;
	private final SystemService systemService;
	
	@Operation(summary="출력물설정 조회", description="출력물설정 조회")
	@PostMapping(value="/getPrintInfo")
	public CommonResult getPrintInfo(@RequestBody SystemReqDto dto) {
		List<PrintInfoVO> list = systemService.getPrintInfo(dto);
		return responseService.getListResult(list);
	}
	
	@Operation(summary="실적등록 제약조건 조회", description="실적등록 제약조건 조회")
	@PostMapping(value="/getConstInfo")
	public CommonResult getConstInfo(@RequestBody SystemReqDto dto) {
		List<ConstInfoVO> list = systemService.getConstInfo(dto);
		return responseService.getListResult(list);
	}
	
	@Operation(summary="과입출비율 조회", description="과입출비율 조회")
	@PostMapping(value="/getOverflowInfo")
	public CommonResult getOverflowInfo(@RequestBody SystemReqDto dto) {
		List<OverflowInfoVO> list = systemService.getOverflowInfo(dto);
		return responseService.getListResult(list);
	}

	@Operation(summary="대시보드관리 조회", description="대시보드관리 조회")
	@PostMapping(value="/getDashboardInfo")
	public CommonResult getDashboardInfo(@RequestBody SystemReqDto dto) {
		List<DashboardInfoVO> list = systemService.getDashboardInfo(dto);
		return responseService.getListResult(list);
	}
	
	@Operation(summary="출력물설정 수정", description="출력물설정 수정")
	@Transactional(rollbackFor = Exception.class)
	@PostMapping(value="/updatePrintInfo")
	public CommonResult updatePrintInfo(@NotNull @RequestBody List<PrintInfoVO> voList) {
		systemService.updatePrintInfo(voList);
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="실적등록 제약조건 수정", description="실적등록 제약조건 수정")
	@Transactional(rollbackFor = Exception.class)
	@PostMapping(value="/updateConstInfo")
	public CommonResult updateConstInfo(@NotNull @RequestBody List<ConstInfoVO> voList) {
		systemService.updateConstInfo(voList);
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="과입출비율 수정", description="과입출비율 수정")
	@Transactional(rollbackFor = Exception.class)
	@PostMapping(value="/updateOverflowInfo")
	public CommonResult updateOverflowInfo(@NotNull @RequestBody List<OverflowInfoVO> voList) {
		systemService.updateOverflowInfo(voList);
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="대시보드관리 수정", description="대시보드관리 수정")
	@Transactional(rollbackFor = Exception.class)
	@PostMapping(value="/updateDashboardInfo")
	public CommonResult updateDashboardInfo(@NotNull @RequestBody List<DashboardInfoVO> voList) {
		systemService.updateDashboardInfo(voList);
		return responseService.getSuccessResult();
	}
}
