package kr.co.igns.business.ProdManage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.ProdManage.model.pro0110.Pro0110ReqDto;
import kr.co.igns.business.ProdManage.model.pro0110.Pro0110VO;
import kr.co.igns.business.ProdManage.service.Pro0110Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Pro0110Controller", description = "작업지시진행현황")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Pro0110Controller {

	@Autowired
	private final ResponseService responseService;
	
	@Autowired
	private final Pro0110Service pro0110Service;
	
	@Operation(summary="작업지시진행현황 조회", description="작업지시진행현황 조회한다")
	@PostMapping(value="/getPro0110")
	public CommonResult getPro0110(@RequestBody Pro0110ReqDto reqDto){
		List<Pro0110VO> vo = pro0110Service.getPro0110(reqDto);
		return responseService.getListResult(vo);
    }
}
