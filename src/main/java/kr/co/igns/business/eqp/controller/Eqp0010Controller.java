package kr.co.igns.business.eqp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.eqp.model.eqp0010.Eqp0010DetailVO;
import kr.co.igns.business.eqp.model.eqp0010.Eqp0010Dto;
import kr.co.igns.business.eqp.model.eqp0010.Eqp0010VO;
import kr.co.igns.business.eqp.model.eqp0070.Eqp0070DetailVO;
import kr.co.igns.business.eqp.service.Eqp0010Service;

import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Eqp0010Controller", description = "eqp0010")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Eqp0010Controller {
	private final ResponseService responseService;
	private final Eqp0010Service eqp0010Service;
	
	@Operation(summary="eqp0010grdMain", description="eqp0010grdMain")
	@PostMapping(value="/getMaingrd")
	public CommonResult getMaingrd(){
		List<Eqp0010VO> vo = eqp0010Service.getMaingrd();
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="eqp0010Detailgrd", description="eqp0010Detailgrd")
	@PostMapping(value="/getDetailgrd")
	public CommonResult getDetailgrd(@RequestBody Eqp0010Dto dto){
		List<Eqp0010DetailVO> vo = eqp0010Service.getDetailgrd(dto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="eqp0010저장", description="")
	
	@PostMapping(value = "/createEqp0010")
	private CommonResult createEqp0010(@NotNull @RequestBody List<Eqp0010DetailVO> voList) throws Exception {
		eqp0010Service.saveEqp0010(voList);
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="eqp0010 삭제", description="")
	@PostMapping(value = "/deleteEqp0010")
	private CommonResult deleteEqp0010(@NotNull @RequestBody List<Eqp0010DetailVO> voList) throws Exception {
		eqp0010Service.deleteEqp0010(voList);
		return responseService.getSuccessResult();
	}	
	
	
	
}
