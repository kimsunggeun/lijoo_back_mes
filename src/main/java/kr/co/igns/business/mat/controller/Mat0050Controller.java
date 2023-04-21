package kr.co.igns.business.mat.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import kr.co.igns.business.mat.model.mat0050.Mat0012ReqDto;
import kr.co.igns.business.mat.model.mat0050.Mat0012VO;
import kr.co.igns.business.mat.model.mat0050.Mat0018VO;
import kr.co.igns.business.mat.model.mat0050.Mat0030Dto;
import kr.co.igns.business.mat.model.mat0050.Mat0030VO;

import kr.co.igns.business.mat.service.Mat0050Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Mat0050Controller", description = "반품등록")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Mat0050Controller {
	
	private final ResponseService responseService;
	private final Mat0050Service mat0050Service;
	
	@Operation(summary="입고정보 조회", description="입고정보 조회")
	@PostMapping(value="/getMat0050")
	public CommonResult getMat0012(@RequestBody Mat0012ReqDto reqDto){
		List<Mat0012VO> vo = mat0050Service.getMat0012(reqDto);
		return responseService.getListResult(vo);
    }	
	
	@Operation(summary="재고현황 조회", description="재고현황 조회")
	@PostMapping(value="/getMat0051")
	public CommonResult getMat0021(@RequestBody Mat0012VO reqDto){
		List<Mat0018VO> vo = mat0050Service.getMat0018(reqDto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="반품내역 조회", description="반품내역 조회")
	@PostMapping(value="/getMat0052")
	public CommonResult getMat0030(@RequestBody Mat0012VO reqDto){
		List<Mat0030VO> vo = mat0050Service.getMat0030(reqDto);
		return responseService.getListResult(vo);
    }	
	
	@Operation(summary="반품내역 등록", description="반품내역 등록")
	@PostMapping(value = "/insertMat0050")
	private CommonResult insertMat0030(@NotNull @RequestBody Mat0030Dto reqDto) throws Exception {
		mat0050Service.insertMat0030(reqDto);
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="반품내역 삭제", description="반품내역 삭제")
	@PostMapping(value = "/deleteMat0050")
	private CommonResult deleteMat0030(@NotNull @RequestBody Mat0030Dto reqDto) throws Exception {
		mat0050Service.deleteMat0030(reqDto);
		return responseService.getSuccessResult();
	}
	
}
