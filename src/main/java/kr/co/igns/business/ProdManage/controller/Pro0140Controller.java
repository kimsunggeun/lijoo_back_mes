package kr.co.igns.business.ProdManage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.ProdManage.model.pro0140.Pro0140ReqDto;
import kr.co.igns.business.ProdManage.model.pro0140.Pro0140VO;
import kr.co.igns.business.ProdManage.service.Pro0140Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Pro0140Controller", description = "비가동현황 현황")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Pro0140Controller {

	@Autowired
	private final ResponseService responseService;
	
	@Autowired
	private final Pro0140Service pro0140Service;
	
	@Operation(summary="비가동현황 조회", description="비가동현황조회한다")
	@PostMapping(value="/getPro0140")
	public CommonResult getPro0140(@RequestBody Pro0140ReqDto reqDto){
		List<Pro0140VO> vo = pro0140Service.getPro0140(reqDto);
		return responseService.getListResult(vo);
    }
}
