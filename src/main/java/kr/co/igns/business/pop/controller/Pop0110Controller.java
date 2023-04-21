package kr.co.igns.business.pop.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.pop.model.Pop0110ReqDto;
import kr.co.igns.business.pop.service.Pop0110Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Pop0110Controller", description = "pop 외주공정")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pop")
public class Pop0110Controller {

	private final ResponseService responseService;
	private final Pop0110Service pop0110Service;
	
	@Operation(summary="외주출고 상세내역", description="외주출고 상세내역")
	@PostMapping(value="/getPop0110")
	public CommonResult getPop0110(@RequestBody Pop0110ReqDto reqDto){
		return responseService.getListResult(pop0110Service.getPop0110(reqDto));
    }
	
	@Operation(summary="외주출고 저장", description="외주출고 저장")
	@PostMapping(value="/setPop0110")
	public CommonResult setPop0110(@RequestBody List<Pop0110ReqDto> reqDto) throws Exception {
		pop0110Service.setPop0110(reqDto);
		return responseService.getSuccessResult();
    }
}
