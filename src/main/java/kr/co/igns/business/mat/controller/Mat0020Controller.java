package kr.co.igns.business.mat.controller;

import java.util.List;

import org.json.JSONArray;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.mat.model.mat0020.Mat0010VO;
import kr.co.igns.business.mat.model.mat0020.Mat0011VO;
import kr.co.igns.business.mat.model.mat0020.Mat0020ReqDto;
import kr.co.igns.business.mat.service.Mat0020Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Mat0020Controller", description = "구매발주 생성")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Mat0020Controller {
	
	private final ResponseService responseService;
	private final Mat0020Service mat0020Service;
	
	@Operation(summary="품목정보 조회", description="품목정보를 조회한다")
	@PostMapping(value="/getItemInfo2")
	public CommonResult getItemInfo2(@RequestBody Mat0020ReqDto reqDto){
		List<Mat0010VO> vo = mat0020Service.getItemInfo2(reqDto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="구매 발주정보 조회", description="구매 발주정보를 조회한다 param: comCode")
	@PostMapping(value="/getMat0010")
	public CommonResult getMat0010(@RequestBody Mat0020ReqDto reqDto){
		List<Mat0010VO> vo = mat0020Service.getMat0010(reqDto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="구매 발주정보 입력/수정", description="구매 발주정보를 입력/수정한다.(__created__ = true 입력/__modified__ = true 수정)")
	@PostMapping(value = "/createMat0010")
	private CommonResult createMat0010(@NotNull @RequestBody List<Mat0010VO> voList) throws Exception {
		mat0020Service.createMat0010(voList);
		return responseService.getSuccessResult();
	}
    
	@Operation(summary="구매 발주정보 확정", description="구매 발주정보를 확정한다")
	@PostMapping(value = "/confirmMat0010")
	private CommonResult confirmMat0010(@NotNull @RequestBody List<Mat0010VO> voList) throws Exception {
		mat0020Service.confirmMat0010(voList);
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="구매 발주정보 확정취소", description="확정된 구매 발주정보를 취소한다")
	@PostMapping(value = "/confirmCancelMat0010")
	private CommonResult confirmCancelMat0010(@NotNull @RequestBody List<Mat0010VO> voList) throws Exception {
		mat0020Service.confirmCancelMat0010(voList);
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="기간별외주발주현황(거래처별) 조회", description="기간별외주발주현황(거래처별)을 조회한다 param: comCode")
	@PostMapping(value="/getMat0011toOut0110")
	public CommonResult getMat0011toOut0110(@RequestBody Mat0020ReqDto reqDto){
		List<Mat0011VO> vo = mat0020Service.getMat0011toOut0110(reqDto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="기간별외주발주현황(거래처별) - 일자별조회 조회", description="기간별외주발주현황(거래처별) - 일자별조회를 조회한다 param: comCode")
	@PostMapping(value="/getMat0011byDate")
	public CommonResult getMat0011byDate(@RequestBody Mat0020ReqDto reqDto){
		JSONArray vo = mat0020Service.getMat0011byDate(reqDto);
		return responseService.getListResult(vo.toList());
    }
	
	@Operation(summary="구매 발주정보 상세 조회", description="구매 발주정보 상세를 조회한다 param: comCode")
	@PostMapping(value="/getMat0011")
	public CommonResult getMat0011(@RequestBody Mat0020ReqDto reqDto){
		List<Mat0011VO> vo = mat0020Service.getMat0011(reqDto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="구매 발주정보 상세 입력/수정", description="구매 발주정보 상세를 입력/수정한다.(__created__ = true 입력/__modified__ = true 수정)")
	@PostMapping(value = "/createMat0011")
	private CommonResult createMat0011(@NotNull @RequestBody List<Mat0011VO> voList) throws Exception {
		mat0020Service.createMat0011(voList);
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="구매 발주정보 삭제", description="구매 발주정보를 삭제한다")
	@PostMapping(value = "/deleteMat0010")
	private CommonResult deleteMat0010(@NotNull @RequestBody List<Mat0010VO> voList) throws Exception {
		mat0020Service.deleteMat0010(voList);
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="구매 발주정보 상세 삭제", description="구매 발주정보 상세를 삭제한다")
	@PostMapping(value = "/deleteMat0011")
	private CommonResult deleteMat0011(@NotNull @RequestBody List<Mat0011VO> voList) throws Exception {
		mat0020Service.deleteMat0011(voList);
		return responseService.getSuccessResult();
	}
}
