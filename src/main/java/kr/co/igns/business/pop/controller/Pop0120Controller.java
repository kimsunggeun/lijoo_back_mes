package kr.co.igns.business.pop.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.pop.model.Pop0120ReqDto;
import kr.co.igns.business.pop.model.Pop0120VO;
import kr.co.igns.business.pop.service.Pop0120Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Pop0120Controller", description = "pop 외주공정입고")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pop")
public class Pop0120Controller {

	private final ResponseService responseService;
	private final Pop0120Service pop0120Service;
	
	//거래처별 전표번호
	@Operation(summary="거래처별 전표번호", description="거래처별 전표번호 : comCode, facCode, custCode")
	@PostMapping(value="/getinIlno")
	public CommonResult getinIlno(@RequestBody Pop0120ReqDto reqDto){
		return responseService.getListResult(pop0120Service.getinIlno(reqDto));
	}
	
	@Operation(summary="외주공정 입고", description="외주공정입고 등록")
	@PostMapping(value="/getPop0120")
	public CommonResult getPop0120(@RequestBody Pop0120ReqDto reqDto){
		return responseService.getListResult(pop0120Service.getPop0120(reqDto));
    }
	
	@Operation(summary="입고정보 업데이트", description="공정외주입고 정보 업데이트")
	@PostMapping(value="/setPop0120")
	public CommonResult setPop0120(@RequestBody List<Pop0120VO> voList) throws Exception {
		pop0120Service.setPop0120(voList);
		return responseService.getSuccessResult();
	}
}
