package kr.co.igns.framework.comm.controller;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.framework.comm.model.CmChildCodeVO;
import kr.co.igns.framework.comm.model.CmCodeReqDto;
import kr.co.igns.framework.comm.model.CmCodeVO;
import kr.co.igns.framework.comm.service.CmCodeService;
import kr.co.igns.framework.config.exception.ExceptionAdvice;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "4. CmCodeController", description = "공통 코드")
@RestController
@RequiredArgsConstructor
@RequestMapping("/com")
public class CmCodeController {
	
	private final ResponseService responseService;
	private final ExceptionAdvice exceptionAdvice;
	private final CmCodeService cmCodeService;

	@Operation(summary="공통코드 조회 ", description = "공통코드를 조회한다. param: com_code")
	@PostMapping(value="/getCmCode")
	public CommonResult getCmCode(@RequestBody CmCodeReqDto reqDto){
		List<CmCodeVO> list = cmCodeService.getCmCode(reqDto); 
		return responseService.getListResult(list);
	}
	
	@Operation(summary="공통코드 입력/수정", description = "공통코드를 입력/수정한다.(__created__ = true 입력/__modified__ = 수정)")
	@PostMapping(value = "/createCmCode")
	@Transactional(rollbackFor = Exception.class)
	public CommonResult createCmCode(@NotNull @RequestBody List<CmCodeVO> voList) throws Exception {
		cmCodeService.createCmCode(voList);
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="공통코드 상세 조회 ", description = "공통코드 상세를 조회한다. param: com_code, codegr, code")
	@PostMapping(value="/getCmChildCode")
	public CommonResult getCmChildCode(@RequestBody CmCodeReqDto reqDto){
		List<CmChildCodeVO> list = cmCodeService.getCmChildCode(reqDto); 
		return responseService.getListResult(list);
	}
    
	@Operation(summary="공통코드 상세 입력/수정", description = "공통코드 상세를 입력/수정한다.(__created__ = true 입력/__modified__ = 수정)")
	@PostMapping(value = "/createChildCmCode")
	@Transactional(rollbackFor = Exception.class)
	public CommonResult createCmChildCode(@NotNull @RequestBody List<CmChildCodeVO> voList) throws Exception {
		cmCodeService.createCmChildCode(voList);
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="공통코드 삭제", description = "공통코드 마스터 삭제한다. 회사코드,코드그룹,코드 필수입력")
	@PostMapping(value = "/delCmCode")
	@Transactional(rollbackFor = Exception.class)
	public CommonResult delCmCode(@NotNull @RequestBody List<CmCodeReqDto> reqDto) throws Exception {
		cmCodeService.delCmCode(reqDto);
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="공통코드 상세 삭제", description = "공통코드 상세를 삭제한다. 회사코드,코드그룹,코드,시스템코드 필수입력")
	@PostMapping(value = "/delChildCmCode")
	public CommonResult delChildCmCode(@NotNull @RequestBody List<CmCodeReqDto> reqDto) throws Exception {
		cmCodeService.deleteCmChildCode(reqDto);
		return responseService.getSuccessResult();
	}
}

