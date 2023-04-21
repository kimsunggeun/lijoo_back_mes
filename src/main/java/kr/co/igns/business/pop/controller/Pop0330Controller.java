package kr.co.igns.business.pop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.eqp.model.eqp0030.Eqp0030Dto;
import kr.co.igns.business.eqp.model.eqp0030.Eqp0030VO;
import kr.co.igns.business.pop.model.Pop0330Dto;
import kr.co.igns.business.pop.model.Pop0330PopUpVO;
import kr.co.igns.business.pop.model.Pop0330VO;
import kr.co.igns.business.pop.service.Pop0330Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Pop0330Controller", description = "pop 환경")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pop")
public class Pop0330Controller {
	@Autowired
	private final ResponseService responseService;
	@Autowired
	private final Pop0330Service pop0330Service;
	
	@Operation(summary="pop0330조회", description="pop0330")
	@PostMapping(value="/getPop0330")

	public CommonResult getPop0330(@RequestBody Pop0330Dto dto){ 
	    System.out.println(dto);
		List<Pop0330VO> vo = pop0330Service.getPop0330(dto);
		return responseService.getListResult(vo); // 
    }
	@Operation(summary="pop0330팝업조회", description="pop0330popUp")
	@PostMapping(value="/getPopUp0330")

	public CommonResult getPopup0330(@RequestBody Pop0330Dto dto){ 
	    System.out.println(dto);
		List<Pop0330PopUpVO> vo = pop0330Service.getPopup0330(dto);
		return responseService.getListResult(vo); // 
    }
}