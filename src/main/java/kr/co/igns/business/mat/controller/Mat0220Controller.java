package kr.co.igns.business.mat.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.mat.model.mat0020.Mat0020ReqDto;
import kr.co.igns.business.mat.model.mat0220.Mat0220ReqDto;
import kr.co.igns.business.mat.model.mat0220.Mat0220VO;
import kr.co.igns.business.mat.model.mat0020.Mat0010VO;
import kr.co.igns.business.mat.model.mat0020.Mat0011VO;
import kr.co.igns.business.mat.service.Mat0020Service;
import kr.co.igns.business.mat.service.Mat0220Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Mat0220Controller", description = "구매발주 현황 상세")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Mat0220Controller {
	
	private final ResponseService responseService;
	private final Mat0220Service service;
	
	@Operation(summary="구매 발주 현황상세", description="구매 발주현황 상세 param: comCode")
	@PostMapping(value="/getMat0220")
	public CommonResult getMat0010(@RequestBody Mat0220ReqDto reqDto){
		List<Mat0220VO> vo = service.getMat0220(reqDto);
		return responseService.getListResult(vo);
    }	
}
