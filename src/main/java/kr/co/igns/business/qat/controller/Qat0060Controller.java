package kr.co.igns.business.qat.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.qat.model.qat0060.Qat0060Dto;
import kr.co.igns.business.qat.model.qat0060.Qat0060VO;
import kr.co.igns.business.qat.model.qat0060.QatOutStatusDto;
import kr.co.igns.business.qat.service.Qat0060Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Qat0060Controller", description = "출하검사")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Qat0060Controller {
	
	private final ResponseService responseService;
	private final Qat0060Service service;
	
	//납품정보 GET
	@Operation(summary="납품정보 조회", description="입고상태정보를 보기위해 가져오기")
	@PostMapping(value="/qat0060/getQat0060")
	public CommonResult getQat0060(@RequestBody Qat0060Dto dto) {
		List<Qat0060VO> resultList = service.getQat0060(dto);
		return responseService.getListResult(resultList);
	}
	
    //검사내역 가져오기	
	@PostMapping(value="/qat0060/getInspection")
	@Operation(summary="검사내역 가져오기	", description="검사내역 가져오기")
	public CommonResult getInspection(@RequestBody QatOutStatusDto dto) {
		List<Qat0060VO> resultList = service.getInspection(dto);
		return responseService.getListResult(resultList);
	}
	
	//검사내역 저장하기
	@PostMapping(value="/qat0060/createQat0060")
	@Operation(summary="검사내역 저장", description="검사내역 저장하기")
	public CommonResult createQat0060(@NotNull @RequestBody List<Qat0060VO> voList)throws Exception{
		service.createQat0060(voList);
		return responseService.getSuccessResult();
	}
	
	
	
	//검사내역 취소(삭제)
	@PostMapping(value="/qat0060/deleteQat0060")
	@Operation(summary="입고내역 삭제", description="입고내역 삭제하기")
	public CommonResult deleteQat0060(@NotNull @RequestBody List<Qat0060VO> voList)throws Exception{
		service.deleteQat0060(voList);
		return responseService.getSuccessResult();
	}
	
}
