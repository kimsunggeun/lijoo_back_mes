package kr.co.igns.business.ProdManage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.ProdManage.model.pro0190.Pro0190ReqDto;
import kr.co.igns.business.ProdManage.model.pro0190.Pro0190VO;
import kr.co.igns.business.ProdManage.service.Pro0190Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Pro0190Controller", description = "자재투입 현황")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Pro0190Controller {

	@Autowired
	private final ResponseService responseService;
	@Autowired
	private final Pro0190Service pro0190svc;
	
	@Operation(summary="자재투입 현황 조회", description="자재투입 현황 조회")
	@PostMapping(value="/getPro0190")
	public CommonResult getPro0190(@RequestBody Pro0190ReqDto reqDto){
		List<Pro0190VO> list = pro0190svc.getPro0190(reqDto);
		return responseService.getListResult(list);
    }
}
