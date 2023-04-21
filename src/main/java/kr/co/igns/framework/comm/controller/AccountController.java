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
import kr.co.igns.framework.comm.model.AccountReqDto;
import kr.co.igns.framework.comm.model.AccountVO;
import kr.co.igns.framework.comm.service.AccountService;
import kr.co.igns.framework.config.exception.ExceptionAdvice;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "8. AccountController", description = "거래처 정보")
@RestController
@RequiredArgsConstructor
@RequestMapping("/com")
public class AccountController {
	
	private final ResponseService responseService;
	private final ExceptionAdvice exceptionAdvice;
	private final AccountService accountService;
	
	@Operation(summary="거래처정보 조회", description="거래처정보를 조회한다 param: comCode")
	@PostMapping(value="/getAccount")
	public CommonResult getAccount(@RequestBody AccountReqDto reqDto){
		List<AccountVO> vo = accountService.getAccount(reqDto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="거래처코드 중복확인", description="거래처코드 중복확인한다 param: comCode, custCode")
	@PostMapping(value="/checkAccountCd")
	public CommonResult checkAccountCd(@RequestBody AccountReqDto reqDto){
//		int count = accountService.checkAccountCd(reqDto);
//		return responseService.getSingleResult(count);
		System.out.println("accountService ::" + accountService);
		int result = accountService.checkAccountCd(reqDto);
		if(result > 0) {
			return responseService.getFailResult(-1200, "거래처코드 중복");
		} else {
			return responseService.getSuccessResult();
		}
    }

	@Operation(summary="거래처코드 입력/수정", description="거래처코드를 입력/수정한다.(__created__ = true 입력/__modified__ = true 수정)")
	@PostMapping(value = "/createAccount")
	@Transactional(rollbackFor = Exception.class)
	public CommonResult createAccount(@NotNull @RequestBody List<AccountVO> voList) throws Exception {
		accountService.createAccount(voList);
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="거래처코드 삭제", description="거래처코드를 삭제한다.")
	@PostMapping(value = "/deleteAccount")
	@Transactional(rollbackFor = Exception.class)
	public CommonResult deleteAccount(@RequestBody List<AccountVO> voList) throws Exception{
		accountService.deleteAccount(voList);
		return responseService.getSuccessResult();
	}
    
}
