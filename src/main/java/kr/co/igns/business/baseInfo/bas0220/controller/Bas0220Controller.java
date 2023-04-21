package kr.co.igns.business.baseInfo.bas0220.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.baseInfo.bas0220.model.Bas0220Dto;
import kr.co.igns.business.baseInfo.bas0220.model.Bas0220VO_ITEM;
import kr.co.igns.business.baseInfo.bas0220.model.Bas0220VO_BOM;
import kr.co.igns.business.baseInfo.bas0220.service.Bas0220Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Bas0220Controller", description = "Bom정전개")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Bas0220Controller {
	
	private final ResponseService responseService;
	private final Bas0220Service service;
	
	//품목선택 조회
	@PostMapping(value="/bas0220/getItemSelect")
	@Operation(summary="품목선택 조회", description="회사코드에 맞는 품목정보 가져오기")
	public CommonResult getItemSelect(@RequestBody Bas0220Dto dto) {
		List<Bas0220VO_ITEM> resultList = service.getItemSelect(dto);
		return responseService.getListResult(resultList);
	}
	
	//BOM 정전개
	@PostMapping(value="/bas0220/getBomExplosion")
	@Operation(summary="BOM 정전개", description="품번에 맞는 BOM정전개 정보 가져오기")
	public CommonResult getBomExplosion(@RequestBody Bas0220Dto dto) {
		List<Bas0220VO_BOM> resultList = service.getBomExplosion(dto);
		return responseService.getListResult(resultList);
	}

}
