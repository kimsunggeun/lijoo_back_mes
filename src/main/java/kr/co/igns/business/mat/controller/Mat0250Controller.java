package kr.co.igns.business.mat.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.mat.model.mat0250.Mat0014ReqDto;
import kr.co.igns.business.mat.model.mat0250.Mat0014VO;
import kr.co.igns.business.mat.model.mat0250.Mat0250ReqDto;
import kr.co.igns.business.mat.model.mat0250.Mat0250VO;
import kr.co.igns.business.mat.service.Mat0250Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Mat0250Controller", description = "기타입고현황조회")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Mat0250Controller {
	private final ResponseService responseService;
	private final Mat0250Service mat0250Service;
	
	@Operation(summary="기타 입고 현황 조회", description="기타 입고 현황 조회")
	@PostMapping(value="/getMat0250")
	public CommonResult getMat0230(@RequestBody Mat0250ReqDto reqDto){
		List<Mat0250VO> vo = mat0250Service.getMat0250(reqDto);
		return responseService.getListResult(vo);
    }	
	
	@Operation(summary="기타 입고 상세현황 조회", description="기타 입고 상세현황 조회")
	@PostMapping(value="/getMat0250Detail")
	public CommonResult getMat0230Detail(@RequestBody Mat0014ReqDto reqDto){
		List<Mat0014VO> vo = mat0250Service.getMat0250Detail(reqDto);
		return responseService.getListResult(vo);
    }	
}
