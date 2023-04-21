package kr.co.igns.business.ProdManage.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.ProdManage.model.pro0130.Pro0130GridVO;
import kr.co.igns.business.ProdManage.model.pro0130.Pro0130ReqDto;
import kr.co.igns.business.ProdManage.service.Pro0130Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Pro0130Controller", description = "공정불량현황")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Pro0130Controller {
	
	private final ResponseService responseService;
	
	private final Pro0130Service pro0130Service;
	
	@Operation(summary="공정불량현황 정보 조회", description="생산관리-공정불량현황 테이블 조회")
	@PostMapping(value="/getPro0130")
	public CommonResult getPro0130(@RequestBody Pro0130ReqDto reqDto){
		List<Pro0130GridVO> vo = pro0130Service.getPro0130(reqDto);
		return responseService.getListResult(vo);
    }
}
