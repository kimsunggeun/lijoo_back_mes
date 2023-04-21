package kr.co.igns.business.ProdManage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.ProdManage.model.pro0050.Pro0050ReqDto;
import kr.co.igns.business.ProdManage.model.pro0050.Pro0050VO;
import kr.co.igns.business.ProdManage.model.pro0070.Pro0070ReqDto;
import kr.co.igns.business.ProdManage.model.pro0070.Pro0070Vo;

import kr.co.igns.business.ProdManage.service.Pro0070Service;

import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Pro0070Controller", description = "Pro0070")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Pro0070Controller {

	@Autowired
	private final ResponseService responseService;
	@Autowired
	private final Pro0070Service pro0070svc;
	
	@Operation(summary="조회", description="공정 실적현황 조회")
	@PostMapping(value="/getPro0070")
	public CommonResult getPro0070(@RequestBody Pro0070ReqDto reqDto){
		List<Pro0070Vo> list = pro0070svc.getPro0070(reqDto);
		return responseService.getListResult(list);
    }
	
	@Operation(summary="저장", description="작업지시관리 등록/수정(__created__ = true 등록/__modified__ = true 수정)")
	@PostMapping(value = "/createPro0070")
	private CommonResult createPro0010(@NotNull @RequestBody List<Pro0070Vo> voList) throws Exception {
		pro0070svc.createPro0070(voList);
		return responseService.getSuccessResult();
	}
	
	
	@Operation(summary="삭제", description="작업지시관리 삭제 param: comCode")
	@PostMapping(value="/delPro0070")
	public CommonResult delPro0070(@RequestBody List<Pro0070ReqDto> reqDto){
		pro0070svc.delPro0070(reqDto);
		return responseService.getSuccessResult();
    }
	
	@Operation(summary="조회", description="잡셋업 설비 조회")
	@PostMapping(value="/getBas0090")
	public CommonResult getBas0090(@RequestBody Pro0070ReqDto reqDto){
		List<Pro0070Vo> list = pro0070svc.getBas0090(reqDto);
		return responseService.getListResult(list);
    }
	
	@Operation(summary="조회", description="작업지시 조회")
	@PostMapping(value="/getPro0021")
	public CommonResult getpro0021(@RequestBody Pro0070ReqDto reqDto) {
		List<Pro0070Vo> list = pro0070svc.getPro0021(reqDto);
		return responseService.getListResult(list);
	}
	
}
