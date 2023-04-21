package kr.co.igns.business.out.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.out.model.out0030.Out0030DelDto;
import kr.co.igns.business.out.model.out0030.Out0030ReqDto;
import kr.co.igns.business.out.model.out0030.Out0030VO;
import kr.co.igns.business.out.service.Out0030Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Out0040Controller", description = "공정외주출하검사")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/out0030")
public class Out0030Controller {
	
	private final ResponseService responseService;
	private final Out0030Service out0030Service;
	
	@Operation(summary="공정외주 정보상세 조회", description="공정외주 정보상세를 조회한다.")
	@PostMapping(value="/getPro0026")
	public CommonResult getPro0026(@RequestBody Out0030ReqDto reqDto){
		List<Out0030VO> vo = out0030Service.getPro0026(reqDto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="공정외주 납품등록 조회", description="공정외주 납품등록을 조회한다.")
	@PostMapping(value="/getOut0011")
	public CommonResult getOut0011(@RequestBody Out0030ReqDto reqDto){
		List<Out0030VO> vo = out0030Service.getOut0011(reqDto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="공정외주 납품등록 데이터 추가", description="공정외주 납품등록 테이블에 데이터를 추가한다.")
	@PostMapping(value = "/createOut0011")
	private CommonResult createOut0011(@NotNull @RequestBody List<Out0030VO> voList) throws Exception {
		out0030Service.createOut0011(voList);
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="공정외주 납품등록 데이터 삭제", description="공정외주 납품등록 테이블의 데이터를 삭제한다.")
	@PostMapping(value = "/deleteOut0011")
	private CommonResult deleteOut0011(@NotNull @RequestBody List<Out0030DelDto> voList) throws Exception {
		out0030Service.deleteOut0011(voList);
		return responseService.getSuccessResult();
	}
}
