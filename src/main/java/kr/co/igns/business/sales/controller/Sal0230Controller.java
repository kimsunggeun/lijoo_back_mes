package kr.co.igns.business.sales.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.sales.model.sal0230.Sal0230ReqDto;
import kr.co.igns.business.sales.model.sal0230.Sal0230VO;
import kr.co.igns.business.sales.service.Sal0230Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Sal0230Controller", description = "출하반품현황")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Sal0230Controller {
	
	private final ResponseService responseService;
	private final Sal0230Service sal0230Service;
	
	@Operation(summary="출하반품현황 조회", description="출하반품현황 조회한다")
	@PostMapping(value="/getSal0230")
	public CommonResult getSal0230(@RequestBody Sal0230ReqDto reqDto){
		List<Sal0230VO> vo = sal0230Service.getSal0230(reqDto);
		return responseService.getListResult(vo);
    }
}
