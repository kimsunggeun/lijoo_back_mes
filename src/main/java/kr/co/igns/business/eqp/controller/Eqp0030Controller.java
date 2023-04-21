package kr.co.igns.business.eqp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import kr.co.igns.business.eqp.model.eqp0030.Eqp0030DetailVO;
import kr.co.igns.business.eqp.model.eqp0030.Eqp0030Dto;
import kr.co.igns.business.eqp.model.eqp0030.Eqp0030VO;
import kr.co.igns.business.eqp.service.Eqp0030Service;

import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Eqp0030Controller", description = "eqp0030")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Eqp0030Controller {
	
	private final ResponseService responseService;
	private final Eqp0030Service eqp0030Service;
	
	@Operation(summary="eqp0030grdMain", description="eqp0030grdMain")
	@PostMapping(value="/getEqp0030")
	public CommonResult getEqp0030(@RequestBody Eqp0030Dto dto){
		List<Eqp0030VO> vo = eqp0030Service.getEqp0030(dto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="eqp0030Detailgrd", description="eqp0030Detailgrd")
	@PostMapping(value="/getEqp0030Detail")
	public CommonResult getEqp0030Detail(@RequestBody Eqp0030Dto dto){
		List<Eqp0030DetailVO> vo = eqp0030Service.getEqp0030Detail(dto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="eqp0030저장", description="")
	
	@PostMapping(value = "/createEqp0030")
	private CommonResult createEqp0030(@NotNull @RequestBody List<Eqp0030DetailVO> voList) throws Exception {
		eqp0030Service.createEqp0030(voList);
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="eqp0030 삭제", description="")
	@PostMapping(value = "/deleteEqp0030")
	private CommonResult deleteEqp0030(@NotNull @RequestBody List<Eqp0030DetailVO> voList) throws Exception {
		eqp0030Service.deleteEqp0030(voList);
		return responseService.getSuccessResult();
	}	
	
	
	
}
