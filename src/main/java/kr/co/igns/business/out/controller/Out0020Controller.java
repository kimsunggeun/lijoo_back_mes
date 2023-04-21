package kr.co.igns.business.out.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.out.model.out0020.Out0020ReqDto;
import kr.co.igns.business.out.model.out0020.Out0020VO;
import kr.co.igns.business.out.service.Out0020Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Out0020Controller", description = "공정외주납품등록")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Out0020Controller {
	
	private final ResponseService responseService;
	private final Out0020Service out0020Service;
	
	@Operation(summary="공정외주납품등록 조회", description="공정외주납품등록 조회한다 param: comCode")
	@PostMapping(value="/getOut0020")
	public CommonResult getOut0020(@RequestBody Out0020ReqDto reqDto){
		List<Out0020VO> vo = out0020Service.getOut0020(reqDto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="공정외주납품등록 입력/수정", description="공정외주납품등록를 입력/수정한다.(__created__ = true 입력/__modified__ = true 수정)")
	@PostMapping(value = "/createOut0020")
	private CommonResult createOut0020(@NotNull @RequestBody List<Out0020VO> voList) throws Exception {
		out0020Service.createOut0020(voList);
		return responseService.getSuccessResult();
	}
	
}
