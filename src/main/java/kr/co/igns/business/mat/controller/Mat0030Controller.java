package kr.co.igns.business.mat.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.mat.model.mat0030.Mat0030ReqDto;
import kr.co.igns.business.mat.model.mat0030.Mat0012VO;
import kr.co.igns.business.mat.model.mat0030.Mat0018VO;
import kr.co.igns.business.mat.service.Mat0030Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Mat0030Controller", description = "구매 입고등록")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Mat0030Controller {
	
	private final ResponseService responseService;
	private final Mat0030Service mat0030Service;
	
	@Operation(summary="구매 입고정보 조회", description="구매 입고정보를 조회한다 param: comCode")
	@PostMapping(value="/getMat0012")
	public CommonResult getMat0012(@RequestBody Mat0030ReqDto reqDto){
		List<Mat0012VO> vo = mat0030Service.getMat0012(reqDto);
		return responseService.getListResult(vo);
    }
	
	
	@Operation(summary="구매 입고정보 입력/수정", description="구매 입고정보를 입력/수정한다.(__created__ = true 입력/__modified__ = true 수정)")
	@PostMapping(value = "/createMat0012")
	private CommonResult createMat0012(@NotNull @RequestBody List<Mat0012VO> voList) throws Exception {
		mat0030Service.createMat0012(voList);
		return responseService.getSuccessResult();
	}
    
	@Operation(summary="구매 입고정보 상세 조회", description="구매 입고정보 상세를 조회한다 param: comCode")
	@PostMapping(value="/getMat0018")
	public CommonResult getMat0018(@RequestBody Mat0030ReqDto reqDto){
		List<Mat0018VO> vo = mat0030Service.getMat0018(reqDto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="구매 입고정보 상세 입력/수정", description="구매 입고정보 상세를 입력/수정한다.(__created__ = true 입력/__modified__ = true 수정)")
	@PostMapping(value = "/createMat0018")
	private CommonResult createMat0018(@NotNull @RequestBody List<Mat0018VO> voList) throws Exception {
		mat0030Service.createMat0018(voList);
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="구매 입고정보 상세 삭제", description="구매 입고정보 상세를 삭제한다")
	@PostMapping(value = "/deleteMat0018")
	private CommonResult deleteMat0018(@NotNull @RequestBody List<Mat0018VO> voList) throws Exception {
		mat0030Service.deleteMat0018(voList);
		return responseService.getSuccessResult();
	}
	
}
