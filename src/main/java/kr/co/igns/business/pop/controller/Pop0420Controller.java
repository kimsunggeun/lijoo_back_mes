package kr.co.igns.business.pop.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.pop.model.Pop0420ReqDto;
import kr.co.igns.business.pop.service.Pop0420Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Pop0420Controller", description = "pop 미계획출하")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pop")
public class Pop0420Controller {

	private final ResponseService responseService;
	private final Pop0420Service pop0420Service;
	
	@Operation(summary="POP 수주번호 획득", description="POP 수주번호를 획득한다")
	@PostMapping(value="getPop0420OrderNo")
	public CommonResult getPop0420OrderNo(@RequestBody Pop0420ReqDto reqDto){
		return responseService.getListResult(pop0420Service.getPop0420OrderNo(reqDto));
    }
	
	@Operation(summary="POP 미계획출하정보 조회", description="POP 계획출하정보를 조회한다")
	@PostMapping(value="getPop0420UnPlannedShipmentInfo")
	public CommonResult getPop0420UnPlannedShipmentInfo(@RequestBody Pop0420ReqDto reqDto){
		return responseService.getListResult(pop0420Service.getPop0420UnPlannedShipmentInfo(reqDto));
    }
}