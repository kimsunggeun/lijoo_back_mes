package kr.co.igns.business.pop.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.pop.model.Pop0410ReqDto;
import kr.co.igns.business.pop.service.Pop0410Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Pop0410Controller", description = "POP 계획출하")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pop")
public class Pop0410Controller {

	private final ResponseService responseService;
	private final Pop0410Service pop0410Service; 
	
	@Operation(summary="POP 수주번호 획득", description="POP 수주번호를 획득한다")
	@PostMapping(value="getPop0410OrderNo")
	public CommonResult getPop0410OrderNo(@RequestBody Pop0410ReqDto reqDto){
		return responseService.getListResult(pop0410Service.getPop0410OrderNo(reqDto));
    }
	
	@Operation(summary="POP 계획출하정보 조회", description="POP 계획출하정보를 조회한다")
	@PostMapping(value="getPop0410PlannedShipmentInfo")
	public CommonResult getPop0410PlannedShipmentInfo(@RequestBody Pop0410ReqDto reqDto){
		return responseService.getListResult(pop0410Service.getPop0410PlannedShipmentInfo(reqDto));
    }
}
