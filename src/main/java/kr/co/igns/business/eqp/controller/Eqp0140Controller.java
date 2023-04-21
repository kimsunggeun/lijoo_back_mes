package kr.co.igns.business.eqp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.eqp.model.eqp0140.Eqp0140Dto;
import kr.co.igns.business.eqp.model.eqp0140.Eqp0140VO;
import kr.co.igns.business.eqp.service.Eqp0140Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Eqp0140Controller", description = "계측기 검교정 현황")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Eqp0140Controller {
	
	private final ResponseService responseService;
	private final Eqp0140Service eqp0140Service;
	
	@Operation(summary="계측기 조회", description="계측기 정보를 조회한다")
	@PostMapping(value="/getEqp0140")
	public CommonResult getItemInfo2(@RequestBody Eqp0140Dto dto){
		List<Eqp0140VO> vo = eqp0140Service.getEqp0140(dto);
		return responseService.getListResult(vo);
    }
}
