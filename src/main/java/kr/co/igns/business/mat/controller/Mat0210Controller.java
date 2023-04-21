package kr.co.igns.business.mat.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.mat.model.mat0210.Mat0210ReqDto;
import kr.co.igns.business.mat.model.mat0210.Mat0210ReqDtoDetail;
import kr.co.igns.business.mat.model.mat0210.Mat0210VO;
import kr.co.igns.business.mat.service.Mat0210Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Mat0210Controller", description = "창고별 재고현황")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Mat0210Controller {
	
	private final ResponseService responseService;
	private final Mat0210Service mat0210Service;
	
	@Operation(summary="재고 정보(MASTER) 조회", description="재고 정보(MASTER)를 조회한다 param: comCode")
	@PostMapping(value="/getMat0210")
	public CommonResult getMat0210(@RequestBody Mat0210ReqDto reqDto) {
		List<Mat0210VO> vo = mat0210Service.getMat0210(reqDto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="재고 정보(MASTER) 엄격한 조회", description="재고 정보(MASTER)를 엄격하게 조회한다 param: comCode")
	@PostMapping(value="/getStrictMat0210")
	public CommonResult getStrictMat0210(@RequestBody Mat0210ReqDto reqDto) {
		Mat0210VO mat0210VO = mat0210Service.getStrictMat0210(reqDto);
		return responseService.getSingleResult(mat0210VO);
    }	
	
	@Operation(summary="재고 정보(MASTER) 입력/수정", description="재고 정보(MASTER)를 입력/수정한다.(__created__ = true 입력/__modified__ = true 수정)")
	@PostMapping(value = "/createMat0210")
	private CommonResult createMat0210(@NotNull @RequestBody List<Mat0210VO> voList) throws Exception {
		mat0210Service.createMat0210(voList);
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="재고 정보(DETAIL) 조회", description="재고 정보(DETAIL)을 조회한다 param: comCode")
	@PostMapping(value="/getMat0210Detail")
	public CommonResult getMat0210Detail(@RequestBody Mat0210ReqDto reqDto) {
		List<Mat0210VO> vo = mat0210Service.getMat0210Detail(reqDto);
		return responseService.getListResult(vo);
	}
	
	@Operation(summary="재고 정보(DETAIL) 엄격한 조회", description="재고 정보(DETAIL)을 엄격하게 조회한다 param: comCode")
	@PostMapping(value="/getStrictMat0210Detail")
	public CommonResult getStrictMat0210Detail(@RequestBody Mat0210ReqDtoDetail reqDto) {
		Mat0210VO mat0210VO = mat0210Service.getStrictMat0210Detail(reqDto);
		return responseService.getSingleResult(mat0210VO);
    }	
	
	@Operation(summary="재고 정보(DETAIL) 입력/수정", description="재고 정보(DETAIL)을 입력/수정한다.(__created__ = true 입력/__modified__ = true 수정)")
	@PostMapping(value="/createMat0210Detail")
	public CommonResult createMat0210Detail(@NotNull @RequestBody List<Mat0210VO> voList) throws Exception {
		mat0210Service.createMat0210Detail(voList);
		return responseService.getSuccessResult();
	}
}
