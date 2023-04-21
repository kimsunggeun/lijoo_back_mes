package kr.co.igns.business.ProdManage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.ProdManage.model.pro0160.Pro0160ReqDto;
import kr.co.igns.business.ProdManage.model.pro0160.Pro0160VO;
import kr.co.igns.business.ProdManage.service.Pro0160Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Pro0160Controller", description = "생산 실적현황")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Pro0160Controller {

	@Autowired
	private final ResponseService responseService;
	@Autowired
	private final Pro0160Service pro0160svc;
	
	@Operation(summary="생산 실적현황 조회", description="생산 실적현황 조회")
	@PostMapping(value="/getPro0160")
	public CommonResult getPro0160(@RequestBody Pro0160ReqDto reqDto){
		List<Pro0160VO> list = pro0160svc.getPro0160(reqDto);
		return responseService.getListResult(list);
    }
}
