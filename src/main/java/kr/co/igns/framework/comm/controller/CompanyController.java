package kr.co.igns.framework.comm.controller;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.framework.comm.model.CompanyReqDto;
import kr.co.igns.framework.comm.model.CompanyVO;
import kr.co.igns.framework.comm.model.DepartmentVO;
import kr.co.igns.framework.comm.service.CompanyService;
import kr.co.igns.framework.config.exception.ExceptionAdvice;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "5. CompanyController", description = "회사정보")
@RestController
@RequiredArgsConstructor
@RequestMapping("/com")
public class CompanyController {
	
	private final ResponseService responseService;
	private final CompanyService companyService;
	private final ExceptionAdvice exceptionAdvice;
	
	@Operation(summary = "회사정보 조회", description = "회사정보를 조회한다 param: com_code")
	@PostMapping(value="/getCompany")
	public CommonResult getCompany(@RequestBody CompanyReqDto reqDto){
		List<CompanyVO> commonCodeVo = companyService.getCompany(reqDto);
		return responseService.getListResult(commonCodeVo);
    }
	
	@Operation(summary = "공장정보 조회", description = "공장정보를 조회한다 param: com_code")
	@PostMapping(value="/getFacCode")
	public CommonResult getFacCode(@RequestBody CompanyReqDto reqDto){
		List<CompanyVO> commonCodeVo = companyService.getFacCode(reqDto);
		return responseService.getListResult(commonCodeVo);
    }
	
	@Operation(summary="회사정보 수정", description="회사정보를 입력/수정한다.(__created__ = true 입력/__modified__ = true 수정)")
	@PostMapping(value = "/createCompany")
	@Transactional(rollbackFor = Exception.class)
	public CommonResult createCompany(@ModelAttribute CompanyVO vo) throws Exception {
		companyService.createCompany(vo);
		return responseService.getSuccessResult();

	}
}
