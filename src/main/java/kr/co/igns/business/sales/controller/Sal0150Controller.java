package kr.co.igns.business.sales.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.sales.model.sal0150.Sal0150ReqDto;
import kr.co.igns.business.sales.model.sal0150.Sal0120VO;
import kr.co.igns.business.sales.service.Sal0150Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Sal0150Controller", description = "매출확정")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Sal0150Controller {
	
	private final ResponseService responseService;
	private final Sal0150Service sal0150Service;
	
	@Operation(summary="매출확정 정보 조회", description="매출확정정보를 조회한다 param: comCode")
	@PostMapping(value="/getSal0150")
	public CommonResult getSal0150(@RequestBody Sal0150ReqDto reqDto){
		List<Sal0120VO> vo = sal0150Service.getSal0150(reqDto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="매출확정 입력/수정", description="매출확정정보를 입력/수정한다.(__created__ = true 입력/__modified__ = true 수정)")
	@PostMapping(value = "/createSal0150")
	private CommonResult createSal0150(@NotNull @RequestBody List<Sal0120VO> voList) throws Exception {
		sal0150Service.createSal0150(voList);
		return responseService.getSuccessResult();
	}
	
}
