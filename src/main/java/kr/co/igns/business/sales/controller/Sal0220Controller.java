package kr.co.igns.business.sales.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.sales.model.sal0120.Sal0120VO;
import kr.co.igns.business.sales.model.sal0220.Sal0220ReqDto;
import kr.co.igns.business.sales.model.sal0220.Sal0220VO;
import kr.co.igns.business.sales.service.Sal0220Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Sal0220Controller", description = "기간별출하현황")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Sal0220Controller {
	
	private final ResponseService responseService;
	private final Sal0220Service sal0220Service;
	
	@Operation(summary="기간별출하현황/출하실적 조회", description="기간별출하현황/출하실적을 조회한다 param: comCode")
	@PostMapping(value="/getSal0220")
	public CommonResult getSal0220(@RequestBody Sal0220ReqDto reqDto){
		List<Sal0220VO> vo = sal0220Service.getSal0220(reqDto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="기간별출하현황/기타출고 조회", description="기간별출하현황/기타출고를 조회한다 param: comCode")
	@PostMapping(value="/getSal0220OtherRelease")
	public CommonResult getSal0220OtherRelease(@RequestBody Sal0220ReqDto reqDto){
		List<Sal0220VO> vo = sal0220Service.getSal0220OtherRelease(reqDto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="기간별출하현황/기타출고 삭제", description="기간별출하현황/기타출고를 삭제한다.")
	@PostMapping(value="/deleteSal0220OhterRelease")
	private CommonResult deleteSal0220OhterRelease(@NotNull @RequestBody List<Sal0220VO> voList) throws Exception {
		sal0220Service.deleteSal0220OhterRelease(voList);
		return responseService.getSuccessResult(); 
	}	
}
