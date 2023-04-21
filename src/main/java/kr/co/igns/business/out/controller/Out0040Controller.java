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
import kr.co.igns.business.mat.model.mat0070.Mat0012VO;
import kr.co.igns.business.out.model.out0040.Out0040ReqDto;
import kr.co.igns.business.out.model.out0040.Out0040VO;
import kr.co.igns.business.out.service.Out0040Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Out0040Controller", description = "공정외주 납품서출력")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/out0040")
public class Out0040Controller {
	
	private final ResponseService responseService;
	private final Out0040Service out0040Service;
	
	@Operation(summary="공정외주 납품서출력 조회", description="공정외주출하검사 조회한다 param: comCode")
	@PostMapping(value="/getOut0011")
	public CommonResult getOut0011(@RequestBody Out0040ReqDto reqDto){
		List<Out0040VO> vo = out0040Service.getOut0011(reqDto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="거래명세서 출력", description="거래명세서 출력")
	@PostMapping(value="/exportTransRpt")
	public void exportTransRpt(HttpServletRequest request, HttpServletResponse response, @RequestBody List<Out0040VO> reqDto) {		
		out0040Service.exportTransRpt(request, response, reqDto);
	}
	
		@Operation(summary="외주자재출고증 출력", description="외주자재출고증 출력")
		@PostMapping(value="/exportMatOutputRpt")
		public void exportMatOutputRpt(HttpServletRequest request, HttpServletResponse response, @RequestBody List<Out0040VO> reqDto) {		
			out0040Service.exportMatOutputRpt(request, response, reqDto);
		}
	
}
