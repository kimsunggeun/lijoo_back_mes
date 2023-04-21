package kr.co.igns.business.eqp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.eqp.model.eqp0060.Eqp0060Dto;
import kr.co.igns.business.eqp.model.eqp0060.Eqp0060VO;
import kr.co.igns.business.eqp.service.Eqp0060Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Eqp0060Controller", description = "수리내역등록")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Eqp0060Controller {
	
	private final ResponseService responseService;
	private final Eqp0060Service eqp0060Service;
	
	@Operation(summary="수리내역 조회", description="수리내역을 조회한다")
	@PostMapping(value="/getFacilityItem")
	public CommonResult getItemInfo2(@RequestBody Eqp0060Dto dto){
		List<Eqp0060VO> vo = eqp0060Service.getFacilityItem(dto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="수리내역 입력/수정", description="수리내역 정보를 입력/수정한다.(__created__ = true 입력/__modified__ = true 수정)")
	@PostMapping(value = "/createEqp0050")
	private CommonResult createEqp0050(@NotNull @RequestBody List<Eqp0060VO> voList) throws Exception {
		eqp0060Service.saveEqp0050(voList);
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="수리내역 삭제", description="수리내역 정보를 삭제한다")
	@PostMapping(value = "/deleteEqp0050")
	private CommonResult deleteEqp0050(@NotNull @RequestBody List<Eqp0060VO> voList) throws Exception {
		eqp0060Service.deleteEqp0050(voList);
		return responseService.getSuccessResult();
	}	
}
