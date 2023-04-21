package kr.co.igns.business.pop.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.pop.model.Pop0012VO;
import kr.co.igns.business.pop.service.Pop0012Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Pop0012Controller", description = "pop 환경")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pop")
public class Pop0012Controller {
	
	private final ResponseService responseService;
	private final Pop0012Service pop0012Service;
	
	@Operation(summary="pop 작업반 설정 저장 조회", description="pop 설정 저장")
	@PostMapping(value="/getPop0012")
	public CommonResult getPop0012(@RequestBody Pop0012VO vo){
		return responseService.getListResult(pop0012Service.getPop0012(vo));
    }
}
