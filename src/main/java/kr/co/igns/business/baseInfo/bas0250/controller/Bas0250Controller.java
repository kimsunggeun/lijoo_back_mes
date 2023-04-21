package kr.co.igns.business.baseInfo.bas0250.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.baseInfo.bas0250.model.Bas0250ReqDto;
import kr.co.igns.business.baseInfo.bas0250.model.Bas0250VO;
import kr.co.igns.business.baseInfo.bas0250.service.Bas0250Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Bas0250Controller", description = "잡셋업유형")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Bas0250Controller {
	
	private final ResponseService responseService;
	private final Bas0250Service service;
	
	//잡셋업유형 GET
	@PostMapping("summary=/bas0250/getInspecType")
	@Operation(summary="잡셋업유형 조회", description="공통코드에서 잡셋업 항목 가져오기")
	public CommonResult getInspecType(@RequestBody Bas0250ReqDto dto) {		
		return responseService.getListResult(service.getInspecType(dto));
	}
		
	//잡셋업항목 GET
	@PostMapping("summary=/bas0250/getFacItem")
	@Operation(summary="잡셋업항목 조회", description="잡셋업유형 코드에 맞는 잡셋업항목 가져오기")
	public CommonResult getFacItem(@RequestBody Bas0250ReqDto dto) {
		List<Bas0250VO> resultList = service.getFacItem(dto);
		return responseService.getListResult(resultList);
	}
	
	//작업반 콤보박스 GET
	@PostMapping("summary=/bas0250/getWorkShopInfo")
	@Operation(summary="작업반 콤보박스 조회", description="작업반 콤보박스 목록 가져오기")
	public CommonResult getWorkShopInfo(@RequestBody Bas0250ReqDto dto) {
		List<Bas0250VO> resultList = service.getWorkShopInfo(dto);
		return responseService.getListResult(resultList);
	}
	
	//설비코드 콤보박스 GET
	@PostMapping("summary=/bas0250/getFacilityInfo")
	@Operation(summary="작업반 콤보박스 조회", description="설비코드 콤보박스 목록 가져오기")
	public CommonResult getFacilityInfo(@RequestBody Bas0250ReqDto dto) {
		List<Bas0250VO> resultList = service.getFacilityInfo(dto);
		return responseService.getListResult(resultList);
	}
	
	//잡셋업항목 입력/수정
	@PostMapping("summary=/bas0250/saveInspecItem")
	@Operation(summary="잡셋업항목 입력/수정", description="__created__ = true 입력/__modified__ = true 수정")
	public CommonResult saveInspecItem(@NotNull @RequestBody List<Bas0250VO> voList)throws Exception{
		service.saveInspecItem(voList);
		return responseService.getSuccessResult();
	}
	
	//잡셋업항목 삭제
	@PostMapping("summary=/bas0250/delInspecItem")
	@Operation(summary="잡셋업항목 삭제", description="회사코드, 잡셋업유형코드, 잡셋업항목 코드, 측정방법코드 필수 입력")
	public CommonResult delInspecItem(@NotNull @RequestBody List<Bas0250ReqDto> voList)throws Exception{
		service.delInspecItem(voList);
		return responseService.getSuccessResult();
	}

}
