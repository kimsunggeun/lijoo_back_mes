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
import kr.co.igns.business.ProdManage.model.pro0050.Bas0034VO;
import kr.co.igns.business.ProdManage.model.pro0050.Bas0035VO;
import kr.co.igns.business.ProdManage.model.pro0050.Pro0050PartInfoVO;
import kr.co.igns.business.ProdManage.model.pro0050.Pro0050PathDto;
import kr.co.igns.business.ProdManage.model.pro0050.Pro0050PathVO;
import kr.co.igns.business.ProdManage.model.pro0050.Pro0050ReqDto;
import kr.co.igns.business.ProdManage.model.pro0050.Pro0050VO;
import kr.co.igns.business.ProdManage.service.Pro0050Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Pro0050Controller", description = "작업지시관리")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Pro0050Controller {

	@Autowired
	private final ResponseService responseService;
	@Autowired
	private final Pro0050Service pro0050Service;
	
	@Operation(summary="작업지시관리 정보 조회", description="작업지시관리 조회한다 param: comCode")
	@PostMapping(value="/getPro0050")
	public CommonResult getPro0050(@RequestBody Pro0050ReqDto reqDto){
		System.out.println("getPro0050");
		List<Pro0050VO> vo = pro0050Service.getPro0050(reqDto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="작업장 코드", description="작업지시관리 작업장 정보 param: comCode, facCode")
	@PostMapping(value="/getBas0034")
	public CommonResult getBas0034(@RequestBody Pro0050ReqDto reqDto){
		System.out.println("getBas0034");
		List<Bas0034VO> vo = pro0050Service.getBas0034(reqDto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="작업반 코드", description="작업지시관리작업반 정보 param: comCode, facCode, workCode")
	@PostMapping(value="/getBas0035")
	public CommonResult getBas0035(@RequestBody Pro0050ReqDto reqDto){
		List<Bas0035VO> vo = pro0050Service.getBas0035(reqDto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="품목정보 팝업", description="작업지시관리 품목선택 팝업 param: comCode")
	@PostMapping(value="/getPartInfo")
	public CommonResult getPartInfo(@RequestBody Pro0050ReqDto reqDto){
		List<Pro0050PartInfoVO> vo = pro0050Service.getPartInfo(reqDto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="라우팅정보 ", description="작업지시관리 라우징정보 param: comCode, partNo")
	@PostMapping(value="/getPathInfo")
	public CommonResult getPathInfo(@RequestBody Pro0050PathDto reqDto){
		List<Pro0050PathVO> vo = pro0050Service.getPathInfo(reqDto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="라우팅정보 ", description="작업지시관리 라우징정보 param: comCode, partNo")
	@PostMapping(value="/getPathWorkInfo")
	public CommonResult getPathWorkInfo(@RequestBody Pro0050ReqDto reqDto){
		List<Pro0050PathVO> vo = pro0050Service.getPathWorkInfo(reqDto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="작업지시관리 상태 변경", description="작업지시관리 삭제 param: comCode")
	@PostMapping(value="/ordState")
	public CommonResult ordState(@NotNull @RequestBody List<Pro0050VO> voList){
		pro0050Service.ordState(voList);
		return responseService.getSuccessResult();
//		if(pro0050Service.ordState(voList) != 0) {
//		return responseService.getFailResult(1, voList.) + "를 상태 변경 할 수 없습니다.");
//	}
    }

	@Operation(summary="작업지시관리 등록/수정", description="작업지시관리 등록/수정(__created__ = true 등록/__modified__ = true 수정)")
	@PostMapping(value = "/createPro0050")
	private CommonResult createPro0010(@NotNull @RequestBody List<Pro0050VO> voList) throws Exception {
		pro0050Service.createPro0050(voList);
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="작업지시관리 정보 삭제", description="작업지시관리 삭제 param: comCode")
	@PostMapping(value="/delPro0050")
	public CommonResult delPro0050(@RequestBody List<Pro0050ReqDto> reqDto){
		pro0050Service.delPro0050(reqDto);
		return responseService.getSuccessResult();
    }
	

	
}
