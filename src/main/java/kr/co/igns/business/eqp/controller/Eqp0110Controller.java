package kr.co.igns.business.eqp.controller;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.eqp.model.eqp0110.Eqp0110Dto;
import kr.co.igns.business.eqp.model.eqp0110.Eqp0110VO;
import kr.co.igns.business.eqp.service.Eqp0110Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;


@Tag(name = "Eqp0110Controller", description = "설비 점검 현황")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/eqp0110")
public class Eqp0110Controller {
	private final ResponseService responseService;
	private final Eqp0110Service eqp0110Service;
	
	@Operation(summary="설비 점검 현황 조회", description="설비 점검 현황 정보를 조회한다")
	@PostMapping(value="/getEqp0032")
	public CommonResult getEqp0032(@RequestBody Eqp0110Dto dto){
		List<Eqp0110VO> vo = eqp0110Service.getEqp0032(dto);
		return responseService.getListResult(vo);
    }
}
