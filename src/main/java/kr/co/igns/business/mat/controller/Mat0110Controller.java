package kr.co.igns.business.mat.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.mat.model.mat0110.Mat0110ReqDto;
import kr.co.igns.business.mat.model.mat0110.Mat0110VO;
import kr.co.igns.business.mat.service.Mat0110Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Mat0110Controller", description = "재고실사")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Mat0110Controller {
	
	private final ResponseService responseService;
	private final Mat0110Service mat0110Service;
	
	@Operation(summary="재고실사 조회", description="재고실사를 조회한다 param: comCode")
	@PostMapping(value="/getMat0110")
	public CommonResult getMat0110(@RequestBody Mat0110ReqDto reqDto) {
		List<Mat0110VO> vo = mat0110Service.getMat0110(reqDto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="재고실사 입력", description="재고실사를 입력한다.(__created__ = true 입력/__modified__ = true 수정)")
	@PostMapping(value = "/insertMat0110")
	private CommonResult insertMat0110(@NotNull @RequestBody List<Mat0110VO> voList) throws Exception {
		mat0110Service.insertMat0110(voList);
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="재고실사 찾기 : 전산번호", description="재고실사를 검색한다 param: comCode")
	@PostMapping(value="/getMat0110FromLotDetail")
	public CommonResult getMat0110FromLotDetail(@RequestBody Mat0110VO reqVO) {
		List<Mat0110VO> vo = mat0110Service.getMat0110FromLotDetail(reqVO);
		return responseService.getListResult(vo);
    }
}
