package kr.co.igns.business.qat.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.qat.model.qat0140.Qat0140ReqDto;
import kr.co.igns.business.qat.model.qat0140.Qat0140VO;
import kr.co.igns.business.qat.service.Qat0140Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "qat0140Controller", description = "반품등록")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Qat0140Controller {
	
	private final ResponseService responseService;
	private final Qat0140Service qat0140Service;
	
	@Operation(summary="반품등록 정보 조회", description="반품등록정보를 조회한다 param: comCode")
	@PostMapping(value="/getqat0140")
	public CommonResult getqat0140(@RequestBody Qat0140ReqDto reqDto){
		List<Qat0140VO> vo = qat0140Service.getQat0140(reqDto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="반품등록 입력/수정", description="반품등록정보를 입력/수정한다.(__created__ = true 입력/__modified__ = true 수정)")
	@PostMapping(value = "/createqat0140")
	private CommonResult createqat0140(@NotNull @RequestBody List<Qat0140VO> voList) throws Exception {
		qat0140Service.createqat0140(voList);
		return responseService.getSuccessResult();
	}
	
}
