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
import kr.co.igns.business.eqp.model.eqp0020.Eqp0020Dto;
import kr.co.igns.business.eqp.model.eqp0020.Eqp0020VO;
import kr.co.igns.business.eqp.model.eqp0070.Eqp0070DetailVO;
import kr.co.igns.business.eqp.service.Eqp0010Service;
import kr.co.igns.business.eqp.service.Eqp0020Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Eqp0020Controller", description = "eqp0020")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Eqp0020Controller {
	private final ResponseService responseService;
	private final Eqp0020Service eqp0020Service;
	
	@Operation(summary="eqp0020grdMain", description="eqp0020grdMain")
	@PostMapping(value="/getEqp0020grd")
	public CommonResult getEqp0020grd(@RequestBody Eqp0020Dto dto){
		List<Eqp0020VO> vo = eqp0020Service.getEqp0020grd(dto);
		return responseService.getListResult(vo);
    }
	


	@Operation(summary="eqp0020저장", description="")
	
	@PostMapping(value = "/createEqp0020")
	private CommonResult createEqp0020(@NotNull @RequestBody List<Eqp0020VO> voList) throws Exception {
		eqp0020Service.saveEqp0020(voList);
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="eqp0020 삭제", description="")
	@PostMapping(value = "/deleteEqp0020")
	private CommonResult deleteEqp0020(@NotNull @RequestBody List<Eqp0020VO> voList) throws Exception {
		eqp0020Service.deleteEqp0020(voList);
		return responseService.getSuccessResult();
	}	

	
	
}
