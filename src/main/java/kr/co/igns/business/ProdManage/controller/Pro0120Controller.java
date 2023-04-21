package kr.co.igns.business.ProdManage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.ProdManage.model.pro0120.Pro0120ReqDto;
import kr.co.igns.business.ProdManage.model.pro0120.Pro0120VO;
import kr.co.igns.business.ProdManage.service.Pro0120Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Pro0120Controller", description = "생산실적현황")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Pro0120Controller {
	
	@Autowired
	private final ResponseService responseService;
	
	@Autowired
	private final Pro0120Service pro0120Svc;
	
	@Operation(summary="생산실적현황 정보 조회", description="생산실적현황 조회한다")
	@PostMapping(value="/getPro0120")
	public CommonResult getPro0120(@RequestBody Pro0120ReqDto reqDto){
		List<Pro0120VO> vo = pro0120Svc.getPro0120(reqDto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="생산실적현황-작업반 조회", description="생산실적현황의 작업반을 조회한다")
	@PostMapping(value="/getWorkDecode")
	public CommonResult getWorkDecode(@RequestBody Pro0120ReqDto reqDto){
		List<Pro0120VO> vo = pro0120Svc.getWorkDecode(reqDto);
		return responseService.getListResult(vo);
    }
	
}
