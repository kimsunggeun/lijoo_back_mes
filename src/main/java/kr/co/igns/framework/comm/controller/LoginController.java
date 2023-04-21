package kr.co.igns.framework.comm.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.framework.comm.model.LoginReqDto;
import kr.co.igns.framework.comm.service.LoginService;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "1. LoginController", description = "로그인")
@RestController
@RequiredArgsConstructor
@RequestMapping("/com")
public class LoginController {
	
	private static final Logger log = LogManager.getLogger("com.project");
	private final ResponseService responseService;
	private final LoginService loginService;
	private final PasswordEncoder passwordEncoder;
	
	@Operation(summary = "로그인", description = "로그인 param: comCode, userId, userPw")
    @PostMapping(value = "/login")
    public CommonResult login(@RequestBody LoginReqDto loginDto, HttpServletRequest req, HttpServletResponse res) {
        
		Map<String, String> resultMap = loginService.login(loginDto, req);
		return responseService.getMapResult(resultMap);
    }
	
	
	@Operation(summary = "로그인", description = "로그인 param: comCode, userId, userPw")
    @PostMapping(value = "/refreshToken")
    public CommonResult refreshToken(@RequestBody LoginReqDto loginDto, HttpServletRequest req, HttpServletResponse res) {
        
		Map<String, String> resultMap = loginService.login(loginDto, req);
		return responseService.getMapResult(resultMap);
    }
	
    
}

