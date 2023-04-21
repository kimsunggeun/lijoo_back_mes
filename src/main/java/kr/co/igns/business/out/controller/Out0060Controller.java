package kr.co.igns.business.out.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.eqp.model.eqp0010.Eqp0010Dto;
import kr.co.igns.business.eqp.model.eqp0010.Eqp0010VO;
import kr.co.igns.business.mat.model.mat0070.Mat0012VO;
import kr.co.igns.business.out.model.out0040.Out0040ReqDto;
import kr.co.igns.business.out.model.out0040.Out0040VO;
import kr.co.igns.business.out.model.out0060.Out0060DVO;
import kr.co.igns.business.out.model.out0060.Out0060ReqDto;
import kr.co.igns.business.out.model.out0060.Out0060VO;
import kr.co.igns.business.out.service.Out0040Service;
import kr.co.igns.business.out.service.Out0060Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Out0060Controller")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/out0060")
public class Out0060Controller {
	
	private final ResponseService responseService;
	private final Out0060Service out0060Service;
	
	@Operation(summary="getOut0060VO")
	@PostMapping(value="/getOut0060VO")
	public CommonResult getOut0060VO(@RequestBody Out0060ReqDto dto){
		List<Out0060VO> vo = out0060Service.getOut0060VO(dto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="geOut0060DVO")
	@PostMapping(value="/geOut0060DVO")
	public CommonResult geOut0060DVO(@RequestBody Out0060ReqDto dto){
		List<Out0060DVO> vo = out0060Service.geOut0060DVO(dto);
		return responseService.getListResult(vo);
    }
	

	@Operation(summary="거래명세서 출력", description="거래명세서 출력")
	@PostMapping(value="/Out0060/exportTransRpt")
	public void exportTransRpt(HttpServletRequest request, HttpServletResponse response, @RequestBody List<Out0060VO> reqDto) {		
		out0060Service.exportTransRpt(request, response, reqDto);
	}


	@Operation(summary="납품TAG 출력", description="거래명세서 출력")
	@PostMapping(value="/Out0060/exportTransTagRpt")
	public void exportTransTagRpt(HttpServletRequest request, HttpServletResponse response, @RequestBody Out0060DVO reqDto) {	
	
		
		out0060Service.exportTransTagRpt(request, response, reqDto);
	}
	
}
