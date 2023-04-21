package kr.co.igns.business.mat.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.mat.model.mat0270.Mat0270ReqDto;
import kr.co.igns.business.mat.model.mat0270.Mat0270VO;
import kr.co.igns.business.mat.service.Mat0270Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Mat0270Controller", description = "반품현황")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Mat0270Controller {

	private final ResponseService responseService;
	private final Mat0270Service mat0270Service;
	
	@Operation(summary="반품현황조회", description="반품현황조회.")
	@PostMapping(value="/getMat0270")
	public CommonResult getMat0270(@RequestBody Mat0270ReqDto reqDto) {
		List<Mat0270VO> resultList = mat0270Service.getMat0270(reqDto);
		return responseService.getListResult(resultList);
	}
}
