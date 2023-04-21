package kr.co.igns.business.mat.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.mat.model.mat0120.Mat0120ReqDto;
import kr.co.igns.business.mat.model.mat0120.Mat0120VO;
import kr.co.igns.business.mat.service.Mat0120Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Mat0120Controller", description = "재고실사 현황")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Mat0120Controller {

	private final ResponseService responseService;
	private final Mat0120Service mat0120Service;
	
	@Operation(summary="재고실사 현황 마스터 조회", description="재고실사 현황 마스터를 조회한다 param: comCode")
	@PostMapping(value="/getMat0120")
	public CommonResult getMat0120(@RequestBody Mat0120ReqDto reqDto) {
		List<Mat0120VO> vo = mat0120Service.getMat0120(reqDto);
		return responseService.getListResult(vo);
    }	
	
	@Operation(summary="재고실사 현황 상세 조회", description="재고실사 현황 상세를 조회한다 param: comCode")
	@PostMapping(value="/getMat0120Detail")
	public CommonResult getMat0120Detail(@RequestBody Mat0120ReqDto reqDto) {
		List<Mat0120VO> vo = mat0120Service.getMat0120Detail(reqDto);
		return responseService.getListResult(vo);
    }	
}
