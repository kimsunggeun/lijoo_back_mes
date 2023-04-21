package kr.co.igns.business.sales.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.sales.model.sal0130.Sal0130ReqDto;
import kr.co.igns.business.sales.model.sal0130.Sal0130VO;
import kr.co.igns.business.sales.model.sal0130.SalOutStatusDto;
import kr.co.igns.business.sales.service.Sal0130Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Sal0130Controller", description = "출하검사")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Sal0130Controller {
	
	private final ResponseService responseService;
	private final Sal0130Service sal0130Service;
	
	@Operation(summary="출하검사 정보 조회", description="출하검사정보를 조회한다 param: comCode")
	@PostMapping(value="/getSal0130")
	public CommonResult getSal0130(@RequestBody Sal0130ReqDto reqDto){
		List<Sal0130VO> vo = sal0130Service.getSal0130(reqDto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="출하로트현황 조회", description="출하로트현황을 조회한다")
	@PostMapping(value="/getOutStatus")
	public CommonResult getOutStatus(@RequestBody SalOutStatusDto dto) {
		List<Sal0130VO> list = sal0130Service.getOutStatus(dto);
		return responseService.getListResult(list);
	}

	@Operation(summary="출하검사 검사내역 조회", description="검사내역을 조회한다")
	@PostMapping(value="/getInspection")
	public CommonResult getInspection(@RequestBody SalOutStatusDto dto) {
		List<Sal0130VO> list = sal0130Service.getInspection(dto);
		return responseService.getListResult(list);
	}	
	
	
	@Operation(summary="검사내역 저장", description="검사내역을 저장한다.")
	@PostMapping(value = "/createSal0130")
	private CommonResult createSal0130(@NotNull @RequestBody List<Sal0130VO> voList) throws Exception {
		sal0130Service.createSal0130(voList);
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="검사내역 삭제", description="검사내역을 삭제한다.")
	@PostMapping(value = "/delSal0130")
	private CommonResult delSal0130(@NotNull @RequestBody List<Sal0130VO> voList) throws Exception {
		sal0130Service.delSal0130(voList);
		return responseService.getSuccessResult();
	}	
	
}
