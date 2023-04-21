package kr.co.igns.framework.comm.controller;

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
import kr.co.igns.framework.comm.model.LoginReqDto;
import kr.co.igns.framework.comm.model.TokenDto;
import kr.co.igns.framework.comm.model.TokenVO;
import kr.co.igns.framework.comm.service.TokenService;
import kr.co.igns.framework.config.exception.ExceptionAdvice;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "TokenController", description = "Refresh Token")
@RestController
@RequiredArgsConstructor
@RequestMapping(value="/com")
public class TokenController {
	
	private final ResponseService responseService;
	private final TokenService tokenService;
	private final ExceptionAdvice exceptionAdvice;
	
	
	@Operation(summary = "refresh token 발급", description = "리프레쉬토큰 재발급 param: token, refreshToken, userId, comCode")
    @PostMapping(value = "/reissue")
    public CommonResult reissue(@RequestBody TokenDto tokenDto, HttpServletRequest req, HttpServletResponse res) {
        System.out.println("***/reissue");
		TokenVO result = tokenService.reissue(tokenDto, req);
		return responseService.getSingleResult(result);
    }
	
	
	@Operation(summary = "refresh token 조회", description = "리프레쉬토큰조회 param: comCode, userId")
    @PostMapping(value = "/findBykey")
    public CommonResult findBykey(@RequestBody LoginReqDto loginDto, HttpServletRequest req, HttpServletResponse res) {
        
		String result = tokenService.findBykey(loginDto);
		return responseService.getSingleResult(result);
    }
	
	@Operation(summary="refresh token 생성", description="INSERT refresh token")
	@PostMapping(value = "/createRefreshToken")
	public CommonResult createRefreshToken(@NotNull @RequestBody TokenVO vo) throws Exception {
//		int resultCode = tokenService.createRefreshToken(vo);
//		return responseService.getSuccessResult();
		int result = tokenService.createRefreshToken(vo);
		if(result < 1) {
			return responseService.getFailResult(Integer.valueOf(exceptionAdvice.getMessage("codeDuplicateError.code")), exceptionAdvice.getMessage("codeDuplicateError.msg"));
		}
		return responseService.getSuccessResult();
	}
	
	
	@Operation(summary="refresh token 삭제", description="DELETE refresh token.")
	@PostMapping(value = "/deleteRefreshToken")
	public CommonResult deleteRefreshToken(HttpServletRequest request, @RequestBody List<TokenVO> voList) {
//		tokenService.deleteRefreshToken(voList);
//		return responseService.getSuccessResult();
		int result = tokenService.deleteRefreshToken(voList);
		if(result < 1) {
			return responseService.getFailResult(Integer.valueOf(exceptionAdvice.getMessage("codeDuplicateError.code")), exceptionAdvice.getMessage("codeDuplicateError.msg"));
		}
		return responseService.getSuccessResult();
	}
	
    
    
}

