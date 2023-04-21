package kr.co.igns.business.sales.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.sales.model.sal0140.Sal0120ReqDto;
import kr.co.igns.business.sales.model.sal0140.Sal0120VO;
import kr.co.igns.business.sales.model.sal0140.Sal0140ReqDto;
import kr.co.igns.business.sales.model.sal0140.Sal0140VO;
import kr.co.igns.business.sales.service.Sal0140Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Sal0140Controller", description = "반품등록")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sal0140")
public class Sal0140Controller {
	
	private final ResponseService responseService;
	private final Sal0140Service sal0140Service;
	
	@Operation(summary="반품등록 출하정보상세 조회", description="반품등록정보를 조회한다")
	@PostMapping(value="/getSal0120")
	public CommonResult getSal0120(@RequestBody Sal0120ReqDto reqDto){
		List<Sal0120VO> vo = sal0140Service.getSal0120(reqDto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="반품내역 정보 조회", description="반품내역정보를 조회한다")
	@PostMapping(value="/getSal0140")
	public CommonResult getSal0140(@RequestBody Sal0140ReqDto reqDto){
		List<Sal0140VO> vo = sal0140Service.getSal0140(reqDto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="반품내역 등록", description="반품내역 등록")
	@PostMapping(value = "/insertSal0140")
	private CommonResult insertSal0140(@NotNull @RequestBody List<Sal0140VO> voList) throws Exception {
		sal0140Service.insertSal0140(voList);
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="반품내역 삭제", description="반품내역 삭제")
	@PostMapping(value = "/deleteSal0140")
	private CommonResult deleteSal0140(@NotNull @RequestBody List<Sal0140VO> voList) throws Exception {
		sal0140Service.deleteSal0140(voList);
		return responseService.getSuccessResult();
	}
}
