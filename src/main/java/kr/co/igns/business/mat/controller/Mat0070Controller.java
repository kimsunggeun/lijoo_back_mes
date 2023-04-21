package kr.co.igns.business.mat.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.framework.config.response.ResponseService;
import kr.co.igns.business.mat.model.mat0070.Mat0012VO;
import kr.co.igns.business.mat.model.mat0070.Mat0018VO;
import kr.co.igns.business.mat.model.mat0070.Mat0070ReqDto;
import kr.co.igns.business.mat.service.Mat0070Service;
import kr.co.igns.framework.config.response.CommonResult;
import lombok.RequiredArgsConstructor;

@Tag(name = "Mat0070Controller", description = "구매입고 등록")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Mat0070Controller{
	
	private final ResponseService responseService;
	private final Mat0070Service mat0070Service;
	
	@Operation(summary="구매 입고등록 조회", description="구매 입고등록을 조회한다")
	@PostMapping(value="/Mat0070/getMat0012")
	public CommonResult getMat0012(@RequestBody Mat0070ReqDto reqDto) {
		List<Mat0012VO> vo = mat0070Service.getMat0012(reqDto);
		return responseService.getListResult(vo);
	}
	
	@Operation(summary="구매 입고등록 상세 조회", description="구매 입고등록상세를 조회한다")
	@PostMapping(value="/Mat0070/getMat0018")
	public CommonResult getMat0018(@RequestBody Mat0070ReqDto reqDto) {
		List<Mat0018VO> vo = mat0070Service.getMat0018(reqDto);
		return responseService.getListResult(vo);
	}

	@Operation(summary="거래명세서 출력", description="거래명세서 출력")
	@PostMapping(value="/Mat0070/exportTransRpt")
	public void exportTransRpt(HttpServletRequest request, HttpServletResponse response, @RequestBody List<Mat0012VO> reqDto) {		
		mat0070Service.exportTransRpt(request, response, reqDto);
	}


	@Operation(summary="납품TAG 출력", description="거래명세서 출력")
	@PostMapping(value="/Mat0070/exportTransTagRpt")
	public void exportTransTagRpt(HttpServletRequest request, HttpServletResponse response, @RequestBody Mat0012VO reqDto) {	
		System.out.println("========exportTransTagRpt");
		mat0070Service.exportTransTagRpt(request, response, reqDto);
	}
	
}