package kr.co.igns.business.baseInfo.bas0410.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.baseInfo.bas0410.model.Bas0410ReqDto;
import kr.co.igns.business.baseInfo.bas0410.model.Bas0410VO;
import kr.co.igns.business.baseInfo.bas0410.service.Bas0410Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Bas0410Controller", description = "검사유형")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Bas0410Controller {
	
	private final ResponseService responseService;
	private final Bas0410Service service;
	
	//검사유형 GET
	@PostMapping("summary=/bas0410/getInspecType")
	@Operation(summary="검사유형 조회", description="공통코드에서 검사 항목 가져오기")
	public CommonResult getInspecType(@RequestBody Bas0410ReqDto dto) {		
		return responseService.getListResult(service.getInspecType(dto));
	}
		
	//검사항목 GET
	@PostMapping("summary=/bas0410/getInspecItem")
	@Operation(summary="검사항목 조회", description="검사유형 코드에 맞는 검사항목 가져오기")
	public CommonResult getInspecItem(@RequestBody Bas0410ReqDto dto) {
		List<Bas0410VO> resultList = service.getInspecItem(dto);
		return responseService.getListResult(resultList);
	}
	
	//검사항목 입력/수정
	@PostMapping("summary=/bas0410/saveInspecItem")
	@Operation(summary="검사항목 입력/수정", description="__created__ = true 입력/__modified__ = true 수정")
	public CommonResult saveInspecItem(@NotNull @RequestBody List<Bas0410VO> voList)throws Exception{
		service.saveInspecItem(voList);
		return responseService.getSuccessResult();
	}
	
	//검사항목 삭제
	@PostMapping("summary=/bas0410/delInspecItem")
	@Operation(summary="검사항목 삭제", description="회사코드, 검사유형코드, 검사항목 코드, 측정방법코드 필수 입력")
	public CommonResult delInspecItem(@NotNull @RequestBody List<Bas0410ReqDto> voList)throws Exception{
		service.delInspecItem(voList);
		return responseService.getSuccessResult();
	}

}
