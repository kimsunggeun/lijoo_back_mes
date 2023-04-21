package kr.co.igns.business.qat.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;

import kr.co.igns.business.qat.service.Qat0110Service;
import kr.co.igns.business.qat.model.qat0110.Qat0110Dto;
import kr.co.igns.business.qat.model.qat0110.Qat0110VO;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Qat0110Controller {
	
	private final ResponseService responseService;
	private final Qat0110Service service;
	
	//납품정보 GET
	@PostMapping(value="/qat0110/getQat0010")
	@Operation(summary="납품정보 조회", description="입고상태정보를 보기위해 가져오기")
	public CommonResult getQat0010(@RequestBody Qat0110Dto dto) {
		List<Qat0110VO> resultList = service.getQat0010(dto);
		return responseService.getListResult(resultList);
	}
	
}
