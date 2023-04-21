package kr.co.igns.business.ProdManage.controller;

import java.util.List;

import org.json.JSONArray;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.ProdManage.model.pro0010.Bas0040ReqDto;
import kr.co.igns.business.ProdManage.model.pro0010.Bas0040VO;
import kr.co.igns.business.ProdManage.model.pro0010.Pro0010ReqDto;
import kr.co.igns.business.ProdManage.model.pro0010.Pro0010VO;
import kr.co.igns.business.ProdManage.model.pro0050.Pro0050VO;
import kr.co.igns.business.ProdManage.service.Pro0010Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Pro0010Controller", description = "생산계획관리")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Pro0010Controller {
	
	private final ResponseService responseService;
	private final Pro0010Service pro0010svc;
	
	@Operation(summary="생산계획 조회", description="생산계획을 조회한다. param: comCode")
	@PostMapping(value="/getPro0010")
	public CommonResult getPro0010(@RequestBody Pro0010ReqDto reqDto){
		JSONArray vo = pro0010svc.getPro0010(reqDto);
		return responseService.getListResult(vo.toList());
    }
	
	@Operation(summary="작지대상품목 정보 조회", description="작지대상품목을 조회")
	@PostMapping(value="/getPro0010Detail")
	public CommonResult getPro0050(@RequestBody Pro0010ReqDto reqDto){
		System.out.println("getPro0050");
		List<Pro0050VO> vo = pro0010svc.getPro0010Detail(reqDto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="작지대상 품목 등록/수정", description="작지대상 품목을 등록/수정한다.")
	@PostMapping(value = "/upsertPro0010")
	public CommonResult upsertPro0010(@NotNull @RequestBody List<Pro0010VO> voList) throws Exception {
		pro0010svc.upsertPro0010(voList);
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="작지대상 품목 삭제", description="작지대상 품목을 삭제한다.")
	@PostMapping(value = "/deletePro0010")
	public CommonResult deletePro0010(@NotNull @RequestBody List<Pro0010VO> voList) throws Exception {
		pro0010svc.deletePro0010(voList);
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="품목군,제품군 조회", description="품목군,제품군을 조회한다.")
	@PostMapping(value="/getBas0040")
	public CommonResult getBas0040(@RequestBody Bas0040ReqDto reqDto){
		List<Bas0040VO> voList = pro0010svc.getBas0040(reqDto);
		return responseService.getListResult(voList);
    }
}
