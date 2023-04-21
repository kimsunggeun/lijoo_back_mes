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
import kr.co.igns.framework.comm.model.DepartmentReqDto;
import kr.co.igns.framework.comm.model.DepartmentVO;
import kr.co.igns.framework.comm.service.DepartmentService;
import kr.co.igns.framework.config.exception.ExceptionAdvice;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "6. DepartmentController", description = "부서 정보")
@RestController
@RequiredArgsConstructor
@RequestMapping("/com")
public class DepartmentController {
	
	private final ResponseService responseService;
	private final DepartmentService departmentService;
	private final ExceptionAdvice exceptionAdvice;
	
	@Operation(summary="부서정보 조회", description="부서정보를 조회한다 param: comCode")
	@PostMapping(value="/getDepartment")
	public CommonResult getDepartment(@RequestBody DepartmentReqDto reqDto){
		List<DepartmentVO> vo = departmentService.getDepartment(reqDto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="부서코드 중복확인", description="부서코드 중복확인한다 param: comCode, depCode")
	@PostMapping(value="/checkDepartmentCd")
	public CommonResult checkDepartmentCd(@RequestBody DepartmentReqDto reqDto){
//		int count = departmentService.checkDepartmentCd(reqDto);
//		return responseService.getSingleResult(count);
		int result = departmentService.checkDepartmentCd(reqDto);
		if(result > 0) {
			return responseService.getFailResult(-1200, "ID 중복");
		} else {
			return responseService.getSuccessResult();
		}
    }

	@Operation(summary="부서코드 입력/수정", description="부서코드를 입력/수정한다.(__created__ = true 입력/__modified__ = true 수정)")
	@PostMapping(value = "/createDepartment")
	@Transactional(rollbackFor = Exception.class)
	public CommonResult createDepartment(@NotNull @RequestBody List<DepartmentVO> voList) throws Exception {
		departmentService.createDepartment(voList);
		return responseService.getSuccessResult();
	}
    
	@Operation(summary="부서코드 삭제", description="도메인코드를 삭제한다.")
	@PostMapping(value = "/deleteDepartment")
	@Transactional(rollbackFor = Exception.class)
	public CommonResult deleteDepartment(@RequestBody List<DepartmentVO> voList) throws Exception{
		departmentService.deleteDepartment(voList);
		return responseService.getSuccessResult();
	}

}
