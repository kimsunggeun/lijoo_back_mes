package kr.co.igns.business.out.controller;

import java.util.List;

import org.json.JSONArray;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.out.model.out0120.Out0120ReqDto;
import kr.co.igns.business.out.model.out0120.Out0120VO;
import kr.co.igns.business.out.service.Out0120Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Out0120Controller", description = "기간별공정외주입고현황")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Out0120Controller {
	
	private final ResponseService responseService;
	private final Out0120Service out0120Service;
	
	@Operation(summary="기간별공정외주입고현황 조회", description="기간별공정외주입고현황 조회한다 param: comCode")
	@PostMapping(value="/getOut0120")
	public CommonResult getOut0120(@RequestBody Out0120ReqDto reqDto){
		List<Out0120VO> vo = out0120Service.getOut0120(reqDto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="기간별공정외주입고현황 - 일자별조회 조회", description="기간별공정외주입고현황 - 일자별조회를 조회한다 param: comCode")
	@PostMapping(value="/getOut0120byDate")
	public CommonResult getOut0120byDate(@RequestBody Out0120ReqDto reqDto){
		JSONArray vo = out0120Service.getOut0120byDate(reqDto);
		return responseService.getListResult(vo.toList());
    }
	
}
