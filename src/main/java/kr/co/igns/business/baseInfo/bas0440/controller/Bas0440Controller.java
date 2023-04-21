package kr.co.igns.business.baseInfo.bas0440.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.baseInfo.bas0440.model.Bas0440DepVO;
import kr.co.igns.business.baseInfo.bas0440.model.Bas0440Dto;
import kr.co.igns.business.baseInfo.bas0440.model.Bas0440VO;
import kr.co.igns.business.baseInfo.bas0440.service.Bas0440Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Bas0440Controller", description = "계측기 마스터")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Bas0440Controller {
	
	private final ResponseService responseService;
	private final Bas0440Service service;
	
	//부서정보 GET
	@PostMapping(value="/bas0440/getDepInfo")
	@Operation(summary="검사유형 조회", description="회사코드에 맞는 부서정보 가져오기")
	public CommonResult getDepInfo(@RequestBody Bas0440DepVO vo) {
		List<Bas0440DepVO> resultList = service.getDepInfo(vo);
		return responseService.getListResult(resultList);
	}
	
	//계측기정보 GET
	@PostMapping(value="/bas0440/getItemInfo")
	@Operation(summary="검사유형 조회", description="조회조건에 맞는 계측기정보 가져오기")
	public CommonResult getmeaInfo(@RequestBody Bas0440Dto dto) {
		List<Bas0440VO> resultList = service.getItemInfo(dto);
		return responseService.getListResult(resultList);
	}
	
	//계측기 등록/수정
	@PostMapping(value="/bas0440/saveItem")
	@Operation(summary="계측기 등록/수정", description="__created__ = true 등록/__modified__ = true 수정")
	private CommonResult savemeaItem(@NotNull @RequestBody List<Bas0440VO> voList)throws Exception{
		service.saveItem(voList);
		return responseService.getSuccessResult();
	}	
	
	//계측기 삭제
	@PostMapping(value="/bas0440/deleteItem")
	@Operation(summary="계측기 삭제", description="선택된 로우 삭제")
	private CommonResult deletemeaItem(@NotNull @RequestBody List<Bas0440VO> voList)throws Exception{
		service.deleteItem(voList);
		return responseService.getSuccessResult();
	}	
}
