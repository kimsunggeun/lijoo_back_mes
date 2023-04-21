package kr.co.igns.business.sales.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.mat.model.mat0070.Mat0012VO;
import kr.co.igns.business.sales.model.sal0160.Sal0160ReqDto;
import kr.co.igns.business.sales.model.sal0160.Sal0160VO;
import kr.co.igns.business.sales.service.Sal0160Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Sal0150Controller", description = "매출확정")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sal0160")
public class Sal0160Controller {
	
	private final ResponseService responseService;
	private final Sal0160Service sal0160Service;
	
	@Operation(summary="매출확정 정보 조회", description="매출확정정보를 조회한다 param: comCode")
	@PostMapping(value="/getSal0120")
	public CommonResult getSal0150(@RequestBody Sal0160ReqDto reqDto){
		List<Sal0160VO> vo = sal0160Service.getSal0120(reqDto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="거래명세서 출력", description="거래명세서 출력")
	@PostMapping(value="/exportTransRpt")
	public void exportTransRpt(HttpServletRequest request, HttpServletResponse response, @RequestBody List<Sal0160VO> reqDto) {		
		sal0160Service.exportTransRpt(request, response, reqDto);
	}
}
