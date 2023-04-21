package kr.co.igns.business.pop.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.pop.model.Pop0011VO;
import kr.co.igns.business.pop.service.Pop0011Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Pop0011Controller", description = "pop 환경")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pop")
public class Pop0011Controller {
	
	private final ResponseService responseService;
	private final Pop0011Service pop0011Service;
	
	@Operation(summary="pop 작업반 설정 저장 조회", description="pop 설정 저장")
	@PostMapping(value="/getPop0011")
	public CommonResult getPop0011(@RequestBody Pop0011VO vo){
		return responseService.getListResult(pop0011Service.getPop0011(vo));
    }
}
