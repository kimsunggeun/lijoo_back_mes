package kr.co.igns.business.out.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.out.model.out0010.Out0010ReqDto;
import kr.co.igns.business.out.model.out0010.Out0010VO;
import kr.co.igns.business.out.service.Out0010Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Out0010Controller", description = "공정외주발주등록")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Out0010Controller {
	
	private final ResponseService responseService;
	private final Out0010Service out0010Service;
	
	@Operation(summary="아이디 조회", description="아이디를 조회한다 param: comCode")
	@PostMapping(value="/out0010/getUserId")
	public CommonResult getUserId(@RequestBody Out0010ReqDto reqDto){
		List<Out0010VO> vo = out0010Service.getUserId(reqDto);
		return responseService.getListResult(vo);
    }	
	
	@Operation(summary="거래처코드 조회", description="외주업체의 거래처코드를 조회한다 param: comCode")
	@PostMapping(value="/out0010/getAccount")
	public CommonResult getAccount(@RequestBody Out0010ReqDto reqDto){
		List<Out0010VO> vo = out0010Service.getAccount(reqDto);
		return responseService.getListResult(vo);
    }	
	
	@Operation(summary="거래처코드2 조회", description="외주업체의 거래처코드2를 조회한다 param: comCode")
	@PostMapping(value="/out0010/getAccount_out0010")
	public CommonResult getAccount_out0010(@RequestBody Out0010ReqDto reqDto){
		List<Out0010VO> vo = out0010Service.getAccount_out0010(reqDto);
		return responseService.getListResult(vo);
    }	
	
	@Operation(summary="구매 발주정보 조회", description="외주납품등록을 조회한다 param: comCode")
	@PostMapping(value="/getOut0010")
	public CommonResult getOut0010(@RequestBody Out0010ReqDto reqDto){
		List<Out0010VO> vo = out0010Service.getOut0010(reqDto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="구매 발주정보  입력/수정", description="외주납품등록을 입력/수정한다.(__created__ = true 입력/__modified__ = true 수정)")
	@PostMapping(value = "/out0010/createMat0012")
	private CommonResult createOut0010(@NotNull @RequestBody List<Out0010VO> voList) throws Exception {
		out0010Service.createOut0010(voList);
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="구매 발주정보 삭제", description="구매 발주정보를 삭제한다")
	@PostMapping(value = "/out0010/deleteMat0018")
	private CommonResult deleteOut0010(@NotNull @RequestBody List<Out0010VO> voList) throws Exception {
		out0010Service.deleteOut0010(voList);
		return responseService.getSuccessResult();
	}
	
}
