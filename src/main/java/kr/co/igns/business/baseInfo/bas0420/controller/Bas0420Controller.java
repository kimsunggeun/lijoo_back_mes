package kr.co.igns.business.baseInfo.bas0420.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.baseInfo.bas0420.model.Bas0420CopyDto;
import kr.co.igns.business.baseInfo.bas0420.model.Bas0420Dto;
import kr.co.igns.business.baseInfo.bas0420.model.Bas0420VO;
import kr.co.igns.business.baseInfo.bas0420.service.Bas0420Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Bas0420Controller", description = "품질기준마스터 관리")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Bas0420Controller {
	
	private final ResponseService responseService;
	private final Bas0420Service service;
	
	//검사유형 GET
	@PostMapping("/bas0420/getInspecType")
	@Operation(summary="검사유형 조회", description="회사코드에 맞는 검사유형정보 가져오기")
	public CommonResult getInspecType(@RequestBody Bas0420Dto dto) {
		List<Bas0420VO> resultList = service.getInspecType(dto);
		return responseService.getListResult(resultList);
	}
	
	//품질기준정보 GET
	@PostMapping("/bas0420/getQuaStanInfo")
	@Operation(summary="품질기준정보 조회", description="회사코드에 맞는 품질기준정보 가져오기")
	public CommonResult getQuaStanInfo(@RequestBody Bas0420Dto dto) {
		List<Bas0420VO> resultList = service.getQuaStanInfo(dto);
		return responseService.getListResult(resultList);
	}
	
	//품질기준정보 입력/수정
	@PostMapping("/bas0420/setQuaStanInfo")
	@Operation(summary="품질기준정보 입력/수정",description="__created__ = true 입력/__modified__ = true 수정")
	public CommonResult setQuaStanInfo(@NotNull @RequestBody List<Bas0420VO> voList)throws Exception{
		service.setQuaStanInfo(voList);
		return responseService.getSuccessResult();
	}
		
	//품질기준정보 삭제
	@PostMapping("/bas0420/delQuaStanInfo")
	@Operation(summary="품질기준정보 삭제",description="comCode, partNo, inspNo, insCode, insType, insMeth 필수 입력")
	public CommonResult delQuaStanInfo(@NotNull @RequestBody List<Bas0420Dto> reqDto)throws Exception{
		service.delQuaStanInfo(reqDto);
		return responseService.getSuccessResult();
	}
	
	//품목기준정보 복사 대상 리스트
	@PostMapping("/bas0420/getPartList")
	@Operation(summary="품질기준정보 품목 리스트",description="comCode 필수 입력")
	public CommonResult getPartList(@RequestBody Bas0420Dto dto) {
		return responseService.getListResult(service.getPartList(dto));
	}
	
	//품목기준정보 대상 복사
	@PostMapping("/bas0420/setPartCopy")
	@Operation(summary="품질기준정보 대상 복사",description="selPartNo:기준품번, tarPartNo:대상품번")
	public CommonResult setPartCopy(@NotNull @RequestBody List<Bas0420CopyDto> reqDto)throws Exception{
		service.setPartCopy(reqDto);
		return responseService.getSuccessResult();
	}
}
