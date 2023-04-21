package kr.co.igns.business.baseInfo.bas0310.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.baseInfo.bas0310.model.Bas0310PartDto;
import kr.co.igns.business.baseInfo.bas0310.model.Bas0310PriceDto;
import kr.co.igns.business.baseInfo.bas0310.model.Bas0310PriceVO;
import kr.co.igns.business.baseInfo.bas0310.model.Bas0310ReqDto;
import kr.co.igns.business.baseInfo.bas0310.model.Bas0310VO;
import kr.co.igns.business.baseInfo.bas0310.service.Bas0310Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Bas0310Controller", description = "거래처별품목")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Bas0310Controller {
	
	private final ResponseService responseService;
	private final Bas0310Service service;
	
	//거래처명 GET
	@PostMapping("value=/bas0310/getCustomName")
	@Operation(summary="거래처명 조회", description="회사코드에 맞는 거래처명 가져오기")
	public CommonResult getCustomName(@RequestBody Bas0310ReqDto reqdto) {
		return responseService.getListResult(service.getCustomName(reqdto));
	}
	
	//품목정보 GET
	@PostMapping("value=/bas0310/getItem")	  
	@Operation(summary="거래처별 품목정보 조회", description="회사코드,거래처코드에 맞는 품목정보 가져오기") 
	public CommonResult getItemInfo(@RequestBody Bas0310ReqDto dto) { 
		List<Bas0310VO> rsList = service.getItemInfo(dto); 
		return responseService.getListResult(rsList); 
	}
	
	//품목정보 마스터
	@PostMapping("value=/bas0310/getPart")	  
	@Operation(summary="품목정보 조회", description="회사코드로 품목정보 마스터 가져오기") 
	public CommonResult getPartList(@RequestBody Bas0310ReqDto dto) { 
		List<Bas0310VO> rsList = service.getPartList(dto); 
		return responseService.getListResult(rsList); 
	}
	
	//거래처별 품목정보 등록
	@PostMapping("value=/bas0310/setCustPart")	  
	@Operation(summary="거래처별 품목 등록/수정", description="거래처별 품목 등록/수정") 
	public CommonResult setCustPart(@RequestBody List<Bas0310PartDto> partDto) throws Exception { 
		service.setCustPart(partDto); 
		return responseService.getSuccessResult(); 
	}
		
	//거래처별 품목정보 삭제
	@PostMapping("value=/bas0310/delCustPart")	  
	@Operation(summary="거래처별 품목 삭제", description="회사코드, 품번, 거래처코드 필수입력 대상 삭제") 
	public CommonResult delCustPart(@RequestBody List<Bas0310ReqDto> reqDto) throws Exception { 
		service.delCustPart(reqDto); 
		return responseService.getSuccessResult(); 
	}
	
	//단가정보 GET	
	@PostMapping("value=/bas0310/getPriceInfo")
	@Operation(summary="단가정보 조회", description="회사코드, 거래처코드, 품번 필수") 
	public CommonResult getPriceInfo(@RequestBody Bas0310ReqDto reqDto) { 
		return responseService.getListResult(service.getPriceInfo(reqDto)); 
	}
	
	//단가정보 set	
	@PostMapping("value=/bas0310/setPriceInfo")
	@Operation(summary="단가정보 등록/수정", description="회사코드, 거래처코드, 품번 필수, 단가적용시작일 필수 입력") 
	public CommonResult getPriceInfo(@RequestBody List<Bas0310PriceDto> reqDto) {
		service.setPriceInfo(reqDto);
		return responseService.getSuccessResult(); 
	}
	
	//단가 정보 삭제
	@PostMapping("value=/bas0310/delPriceInfo")	  
	@Operation(summary="단가 정보 삭제", description="삭제") 
	public CommonResult delPriceInfo(@RequestBody List<Bas0310PriceDto> reqDto) throws Exception { 
		service.delPriceInfo(reqDto); 
		return responseService.getSuccessResult(); 
	}
}
