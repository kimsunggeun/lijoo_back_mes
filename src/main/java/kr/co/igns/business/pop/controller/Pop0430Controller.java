package kr.co.igns.business.pop.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.pop.model.Pop0430ReqDto;
import kr.co.igns.business.pop.model.Pop0430VO;
import kr.co.igns.business.pop.service.Pop0430Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Pop0430Controller", description = "pop 기타출고")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pop")
public class Pop0430Controller {

	private final ResponseService responseService;
	private final Pop0430Service pop0430Service;
	
	@Operation(summary="기타출고등록 정보 조회", description="기타출고등록 정보를 조회한다")
	@PostMapping(value="/getPop0430")
	public CommonResult getPop0430(@RequestBody Pop0430ReqDto reqDto){
		List<Pop0430VO> vo = pop0430Service.getPop0430(reqDto);
		return responseService.getListResult(vo);
    }	
	
	@Operation(summary="기타출고등록 정보 입력", description="기타출고등록 정보를 입력한다")
	@PostMapping(value="/createPop0430")
	public CommonResult createPop0430(@RequestBody List<Pop0430VO> voList) throws Exception {
		pop0430Service.createPop0430(voList);
		return responseService.getSuccessResult();
    }
	
	@Operation(summary="거래처별 품목 정보 조회", description="거래처별 품목 정보를 조회한다")
	@PostMapping(value="/getItemListWithCustCode")
	public CommonResult getItemListWithCustCode(@RequestBody Pop0430ReqDto reqDto){
		List<String> vo = pop0430Service.getItemListWithCustCode(reqDto);
		return responseService.getListResult(vo);
    }	
}
