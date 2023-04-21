package kr.co.igns.business.pop.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;
import kr.co.igns.business.pop.service.Pop0030Service;
import kr.co.igns.business.mat.service.Mat0030Service;
import kr.co.igns.business.mat.model.mat0040.Mat0013VO;
import kr.co.igns.business.mat.model.mat0040.Mat0014VO;
import kr.co.igns.business.mat.model.mat0040.Mat0040ReqDto;
import kr.co.igns.business.pop.model.Pop0010VO;
import kr.co.igns.business.pop.model.Pop0020ReqDto;
import kr.co.igns.business.pop.model.Pop0020VO;
import kr.co.igns.business.pop.model.Pop0030VO;


@Tag(name = "Pop0030Controller", description = "POP - 기타입고")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pop")

public class Pop0030Controller {
	
	private final ResponseService responseService;
	private final Pop0030Service pop0030Service;
	
	@Operation(summary="기타/사급자재 입고등록", description="기타/사급자재를 입고등록한다")
	@PostMapping(value = "/createMat0013")
	private CommonResult createMat0013(@NotNull @RequestBody List<Mat0013VO> voList) throws Exception {
		pop0030Service.createMat0013(voList);
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="기타입고 입고현황 조회", description="기타입고현황을 조회한다.")
	@PostMapping(value = "/getReceiptInfo")
	public CommonResult getReceiptInfo(@RequestBody Pop0030VO vo) {
		return responseService.getListResult(pop0030Service.getReceiptInfo(vo));
	}
	
}
