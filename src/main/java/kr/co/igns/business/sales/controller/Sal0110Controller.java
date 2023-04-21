package kr.co.igns.business.sales.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.sales.model.sal0110.Sal0110ReqDto;
import kr.co.igns.business.sales.model.sal0110.Sal0110VO;
import kr.co.igns.business.sales.service.Sal0110Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;
import org.json.*;

@Tag(name = "Sal0110Controller", description = "출하계획등록")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Sal0110Controller {
	
	private final ResponseService responseService;
	private final Sal0110Service service;
	
	@Operation(summary="출하계획등록 정보 조회", description="출하계획정보를 조회한다 param: comCode")
	@PostMapping(value="/getSal0110")
	public CommonResult getSal0110(@RequestBody Sal0110ReqDto reqDto){
		JSONArray vo = service.getSal0110(reqDto);
		return responseService.getListResult(vo.toList());
    }
	
	@Operation(summary="출하계획등록 입력/수정", description="출하계획정보를 입력/수정한다.(__created__ = true 입력/__modified__ = true 수정)")
	@PostMapping(value = "/createSal0110")
	private CommonResult createSal0110(@NotNull @RequestBody List<Sal0110VO> voList) throws Exception {
		service.createSal0110(voList);
		return responseService.getSuccessResult();
	}
	
}
