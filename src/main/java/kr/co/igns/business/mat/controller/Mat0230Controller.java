package kr.co.igns.business.mat.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.mat.model.mat0230.Mat0230ReqDto;
import kr.co.igns.business.mat.model.mat0230.Mat0230VO;
import kr.co.igns.business.mat.service.Mat0230Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Mat0220Controller", description = "구매발주 현황 상세")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")


public class Mat0230Controller {
	private final ResponseService responseService;
	private final Mat0230Service service;
	
	@Operation(summary="구매 입고 현황 조회", description="구매 입고 현황 조회 param: comCode")
	@PostMapping(value="/getMat0230")
	public CommonResult getMat0230(@RequestBody Mat0230ReqDto reqDto){
		List<Mat0230VO> vo = service.getMat0230(reqDto);
		return responseService.getListResult(vo);
    }	
}
