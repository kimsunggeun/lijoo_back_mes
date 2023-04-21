package kr.co.igns.business.baseInfo.bas0230.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.baseInfo.bas0230.model.Bas0230Dto;
import kr.co.igns.business.baseInfo.bas0230.model.Bas0230VO_BOM;
import kr.co.igns.business.baseInfo.bas0230.model.Bas0230VO_ITEM;
import kr.co.igns.business.baseInfo.bas0230.service.Bas0230Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Bas0230Controller", description = "Bom역전개")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Bas0230Controller {
	
	private final ResponseService responseService;
	private final Bas0230Service service;
	
	//품목선택 조회
	@PostMapping(value="/bas0230/getItemSelect")
	@Operation(summary="품목선택 조회", description="회사코드에 맞는 품목정보 가져오기")
	public CommonResult getItemSelect(@RequestBody Bas0230Dto dto) {
		List<Bas0230VO_ITEM> resultList = service.getItemSelect(dto);
		return responseService.getListResult(resultList);
	}
	
	//BOM 역전개
	@PostMapping(value="/bas0230/getBomImplosion")
	@Operation(summary="BOM 역전개", description="품번에 맞는 BOM역전개 정보 가져오기")
	public CommonResult getBomImplosion(@RequestBody Bas0230Dto dto) {
		List<Bas0230VO_BOM> resultList = service.getBomImplosion(dto);
		return responseService.getListResult(resultList);
	}
	

}
