package kr.co.igns.business.mat.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.mat.model.mat0040.Mat0040ReqDto;
import kr.co.igns.business.mat.model.mat0030.Mat0018VO;
import kr.co.igns.business.mat.model.mat0040.Mat0013VO;
import kr.co.igns.business.mat.model.mat0040.Mat0014VO;
import kr.co.igns.business.mat.service.Mat0040Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Mat0040Controller", description = "입고등록(기타/사급자재)")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Mat0040Controller {
	
	private final ResponseService responseService;
	private final Mat0040Service mat0040Service;
	
	@Operation(summary="품번 정보 조회", description="품번 정보를 조회한다 param: comCode")
	@PostMapping(value="/getPartNo")
	public CommonResult getPartNo(@RequestBody Mat0040ReqDto reqDto){
		List<Mat0013VO> vo = mat0040Service.getPartNo(reqDto);
		return responseService.getListResult(vo);
    }	
	
	@Operation(summary="공장 정보 조회", description="공장 정보를 조회한다 param: comCode")
	@PostMapping(value="/getFacCode")
	public CommonResult getFacCode(@RequestBody Mat0040ReqDto reqDto){
		List<Mat0013VO> vo = mat0040Service.getFacCode(reqDto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="기타/사급자재 입고정보 조회", description="기타/사급자재 입고정보를 조회한다 param: comCode")
	@PostMapping(value="/getMat0013")
	public CommonResult getMat0013(@RequestBody Mat0040ReqDto reqDto){
		List<Mat0013VO> vo = mat0040Service.getMat0013(reqDto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="기타/사급자재 입고정보 입력/수정", description="기타/사급자재 입고정보를 입력/수정한다.(__created__ = true 입력/__modified__ = true 수정)")
	@PostMapping(value = "/createMat0013")
	private CommonResult createMat0013(@NotNull @RequestBody List<Mat0013VO> voList) throws Exception {
		mat0040Service.createMat0013(voList);
		return responseService.getSuccessResult();
	}
	@Operation(summary="기타/사급자재 입고정보 삭제", description="기타/사급자재 입고정보를 삭제한다")
	@PostMapping(value = "/deleteMat0013")
	private CommonResult deleteMat0013(@NotNull @RequestBody List<Mat0013VO> voList) throws Exception {
		mat0040Service.deleteMat0013(voList);
		return responseService.getSuccessResult();
	}
    
	@Operation(summary="기타/사급자재 입고정보 상세 조회", description="기타/사급자재 입고정보 상세를 조회한다 param: comCode")
	@PostMapping(value="/getMat0014")
	public CommonResult getMat0014(@RequestBody Mat0040ReqDto reqDto){
		List<Mat0014VO> vo = mat0040Service.getMat0014(reqDto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="입고창고 조회", description="입고창고 조회한다.")
	@PostMapping(value="/getInWh")
	public CommonResult getInWh(@RequestBody Mat0013VO voList){
		List<Mat0013VO> vo = mat0040Service.getInWh(voList);
		return responseService.getListResult(vo);
    }
}
