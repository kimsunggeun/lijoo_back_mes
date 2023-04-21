package kr.co.igns.business.baseInfo.bas0130.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.baseInfo.bas0130.model.Bas0130Dto;
import kr.co.igns.business.baseInfo.bas0130.model.Bas0080VO;
import kr.co.igns.business.baseInfo.bas0130.model.Bas0081VO;
import kr.co.igns.business.baseInfo.bas0130.service.Bas0130Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Bas0130Controller", description = "공장월력")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Bas0130Controller {
	
	private final ResponseService responseService;
	private final Bas0130Service service;
	
	//근무시간/휴게시간  GET
	@PostMapping("summary=/bas0130/getWorkTime")
	@Operation(summary="근무시간/휴게시간 조회", description="회사코드에 맞는 근무시간/휴게시간 가져오기")
	public CommonResult getWorkTime(@RequestBody Bas0130Dto dto) {
		List<Bas0080VO> resultList = service.getWorkTime(dto);
		return responseService.getListResult(resultList);
	}
	
	//근무시간/휴게시간 입력/수정
	@PostMapping("summary=/bas0130/setWorkTime")
	@Operation(summary="근무시간/휴게시간 입력/수정",description="__created__ = true 입력/__modified__ = true 수정")
	public CommonResult setWorkTime(@NotNull @RequestBody List<Bas0080VO> voList)throws Exception{
		service.setWorkTime(voList);
		return responseService.getSuccessResult();
	}
	
	//근무시간/휴게시간 삭제
	@PostMapping("summary=/bas0130/delWorkTime")
	@Operation(summary="근무시간/휴게시간 삭제",description="comCode, facCode, workType, workCode 필수 입력")
	public CommonResult delWorkTime(@NotNull @RequestBody List<Bas0130Dto> reqDto)throws Exception{
		service.delWorkTime(reqDto);
		return responseService.getSuccessResult();
	}
	
	//근무일  GET
	@PostMapping("summary=/bas0130/getWorkDate")
	@Operation(summary="근무일 조회", description="회사코드에 맞는 근무일자 가져오기")
	public CommonResult getWorkDate(@RequestBody Bas0130Dto dto) {
		List<Bas0081VO> resultList = service.getWorkDate(dto);
		return responseService.getListResult(resultList);
	}
	
	//근무일 입력/수정
	@PostMapping("summary=/bas0130/setWorkDate")
	@Operation(summary="근무일 입력/수정",description="__created__ = true 입력/__modified__ = true 수정")
	public CommonResult setWorkDate(@NotNull @RequestBody List<Bas0081VO> voList)throws Exception{
		service.setWorkDate(voList);
		return responseService.getSuccessResult();
	}
	
	//월별 날짜 Data 생성
	@PostMapping("summary=/bas0130/setMonthData")
	@Operation(summary="월별 날짜 Data 생성",description="__created__ = true 입력/__modified__ = true 수정")
	public CommonResult setMonthData(@NotNull @RequestBody Bas0130Dto reqDto)throws Exception{
		service.setMonthData(reqDto);
		return responseService.getSuccessResult();
	}
}
