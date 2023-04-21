package kr.co.igns.business.eqp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.eqp.model.eqp0050.Eqp0050Dto;
import kr.co.igns.business.eqp.model.eqp0050.Eqp0050VO;
import kr.co.igns.business.eqp.service.Eqp0050Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Eqp0050Controller", description = "설비현황관리")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Eqp0050Controller {
	
	private final ResponseService responseService;
	private final Eqp0050Service eqp0050Service;
	
	@Operation(summary="수리내역 조회", description="수리내역을 조회한다")
	@PostMapping(value="/getFacilityStatusItem")
	public CommonResult getItemInfo2(@RequestBody Eqp0050Dto dto){
		List<Eqp0050VO> vo = eqp0050Service.getFacilityStatusItem(dto);
		return responseService.getListResult(vo);
    }
	
	//점검항목 조회
	@Operation(summary="점검항목 조회", description="점검항목을 조회한다")
	@PostMapping(value="/getChecklistItem")
	public CommonResult getChecklistItem(@RequestBody Eqp0050Dto dto){
		List<Eqp0050VO> vo = eqp0050Service.getChecklistItem(dto);
		return responseService.getListResult(vo);
    }
	
	//예비품정보 조회
	@PostMapping(value="getSparpartInfo")
	@Operation(summary="예비품정보 조회", description="회사코드에 맞는 예비품정보 가져오기")
	public CommonResult getMainList(@RequestBody Eqp0050Dto dto) {
		List<Eqp0050VO> resultList = eqp0050Service.getSparpartInfo(dto);
		return responseService.getListResult(resultList);
	}
	
	//예비품별 자원정보 조회
	@PostMapping(value="getSparpartResInfo")
	@Operation(summary="예비품별 자원정보 조회", description="품번에 맞는 예비품별 자원정보 가져오기")
	public CommonResult getDetailList(@RequestBody Eqp0050Dto dto) {
		List<Eqp0050VO> resultList = eqp0050Service.getSparpartResInfo(dto);
		return responseService.getListResult(resultList);
	}
}
