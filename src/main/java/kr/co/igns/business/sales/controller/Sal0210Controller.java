package kr.co.igns.business.sales.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.sales.model.sal0210.Sal0210ReqDto;
import kr.co.igns.business.sales.model.sal0210.Sal0210VO;
import kr.co.igns.business.sales.service.Sal0210Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Sal0210Controller", description = "수주진행현황")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Sal0210Controller {
	
	private final ResponseService responseService;
	private final Sal0210Service sal0210Service;
	
	@Operation(summary="수주진행현황 조회", description="수주진행현황을 조회한다 param: comCode")
	@PostMapping(value="/getSal0210")
	public CommonResult getSal0210(@RequestBody Sal0210ReqDto reqDto){
		List<Sal0210VO> vo = sal0210Service.getSal0210(reqDto);
		return responseService.getListResult(vo);
    }	
}
