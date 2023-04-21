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
import kr.co.igns.business.pop.service.Pop0350Service;
import kr.co.igns.business.pop.model.Pop0350VO;
import kr.co.igns.business.pop.model.Pop0350ReqDto;


@Tag(name = "Pop0030Controller", description = "pop 환경")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pop0350")

public class Pop0350Controller {
	
	private final ResponseService responseService;
	private final Pop0350Service pop0350Service;
	
	@Operation(summary="경로유형(조회조건) 조회", description="경로유형(조회조건)을 조회한다")
	@PostMapping(value = "/getPathCode")
	public CommonResult getPathCode(@RequestBody Pop0350ReqDto reqDto){
		return responseService.getListResult(pop0350Service.getPathCode(reqDto));
    }
	
	@Operation(summary="공정코드(조회조건) 조회", description="공정코드(조회조건)를 조회한다")
	@PostMapping(value = "/getProCode")
	public CommonResult getProCode(@RequestBody Pop0350ReqDto reqDto){
		return responseService.getListResult(pop0350Service.getProCode(reqDto));
    }
	
	@Operation(summary="작업반코드(조회조건) 조회", description="작업반코드(조회조건)를 조회한다")
	@PostMapping(value = "/getWorkDecode")
	public CommonResult getWorkDecode(@RequestBody Pop0350ReqDto reqDto){
		return responseService.getListResult(pop0350Service.getWorkDecode(reqDto));
    }
	
	@Operation(summary="작업반코드(LookUp) 조회", description="작업반코드(LookUp)를 조회한다")
	@PostMapping(value = "/getWorkDecode2")
	public CommonResult getWorkDecode2(@RequestBody Pop0350ReqDto reqDto){
		return responseService.getListResult(pop0350Service.getWorkDecode2(reqDto));
    }
	
	@Operation(summary="로트정보 추가", description="로트정보를 추가한다")
	@PostMapping(value = "/createPro0026")
	private CommonResult createPro0026(@NotNull @RequestBody List<Pop0350VO> voList) throws Exception {
		pop0350Service.createPro0026(voList);
		return responseService.getSuccessResult();
	}
	
}
