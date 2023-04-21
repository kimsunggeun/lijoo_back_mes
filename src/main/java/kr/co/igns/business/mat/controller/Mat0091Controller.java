package kr.co.igns.business.mat.controller;

import org.json.JSONArray;
import org.postgresql.util.PSQLException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.mat.model.mat0091.Mat0091ReqDto;
import kr.co.igns.business.mat.service.Mat0091Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Mat0091Controller", description = "자재소요량(생산계획기준)")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Mat0091Controller {
	
	private final ResponseService responseService;
	private final Mat0091Service mat0091Service;
	
	@Operation(summary="자재소요현황 생성 및 조회", description="자재소요량(생산계획기준)를 생성 및 조회한다 param: comCode, facCode, fromDate, toDate")
	@PostMapping(value="/createMat0091")
	@Transactional(rollbackFor = Exception.class)
	public CommonResult createMat0091(@RequestBody Mat0091ReqDto reqDto) throws Exception {
		mat0091Service.createMat0091(reqDto);
		return responseService.getSuccessResult();
    }
	
	@Operation(summary="자재소요현황 조회", description="자재소요량(생산계획기준)를 조회한다 param: comCode, facCode, regiDate, partNo")
	@PostMapping(value="/getMat0091")
	public CommonResult createMat0016(@RequestBody Mat0091ReqDto reqDto) throws Exception {
		JSONArray vo = mat0091Service.getMat0091(reqDto);
		return responseService.getListResult(vo.toList());
    }
}
