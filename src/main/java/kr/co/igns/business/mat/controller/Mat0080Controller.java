package kr.co.igns.business.mat.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.framework.config.response.ResponseService;
import kr.co.igns.business.mat.model.mat0080.Mat0080VO;
import kr.co.igns.business.mat.service.Mat0080Service;
import kr.co.igns.framework.config.response.CommonResult;
import lombok.RequiredArgsConstructor;

@Tag(name = "Mat0080Controller", description = "구매발주업로드")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Mat0080Controller{
	
	private final ResponseService responseService;
	private final Mat0080Service service;
	
	@Operation(summary="구매발주업로드", description="구매발주업로드 정보를 가져온다.")
	@PostMapping(value="/Mat0080/getPurchaseOrder")
	public CommonResult getPurchaseOrder(@RequestBody List<Mat0080VO> voList) {
		List<Mat0080VO> resultList = service.getPurchaseOrder(voList);
		return responseService.getListResult(resultList);
	}
	
	@Operation(summary="구매발주업로드 정보 저장", description="구매발주업로드 정보를 저장한다.")
	@PostMapping(value="/Mat0080/savePurchaseOrder")
	public CommonResult savePurchaseOrder(@RequestBody List<Mat0080VO> voList) throws Exception {
		service.savePurchaseOrder(voList);
		return responseService.getSuccessResult();
	}
}