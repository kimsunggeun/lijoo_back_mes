package kr.co.igns.framework.comm.controller;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.framework.comm.model.AuthMenuVO;
import kr.co.igns.framework.comm.model.AuthReqDto;
import kr.co.igns.framework.comm.model.AuthVO;
import kr.co.igns.framework.comm.service.AuthService;
import kr.co.igns.framework.config.exception.ExceptionAdvice;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "3. AuthController", description = "권한그룹 & 권한메뉴")
@RestController
@RequiredArgsConstructor
@RequestMapping("/com")
public class AuthController {
	
	private final ResponseService responseService;
	private final AuthService authService;
	private final ExceptionAdvice exceptionAdvice;
	
	@Operation(summary = "권한그룹 조회", description = "권한그룹을 조회한다. param : comCode ")
	@PostMapping(value="/getAuthGroup")
	public CommonResult getAuthGroup(@RequestBody AuthReqDto reqDto){
		List<AuthVO> vo = authService.getAuthGroup(reqDto);
		return responseService.getListResult(vo);
    }
	

	@Operation(summary = "권한그룹 입력/수정", description = "권한그룹을 입력/수정한다.(__created__ = true 입력/__modified__ = 수정)")
	@PostMapping(value = "/createAuthGroup")
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public CommonResult createAuthGroup(@NotNull @RequestBody List<AuthVO> voList) throws Exception {
		authService.createAuthGroup(voList);
		return responseService.getSuccessResult();

	}
	
	@Operation(summary = "권한메뉴 조회", description = "권한메뉴를 조회한다 param : perCode")
	@PostMapping(value="/getMenuAuthGroup")
	public CommonResult getMenuAuthGroup(@RequestBody AuthReqDto reqDto){
		List<AuthMenuVO> vo = authService.getMenuAuthGroup(reqDto);
		return responseService.getListResult(vo);
    }
	

	@Operation(summary="권한메뉴 입력/수정", description="권한메뉴를 입력/수정한다.(__created__ = true 입력/__modified__ = 수정)")
	@PostMapping(value = "/createMenuAuthGroup")
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public CommonResult createMenuAuthGroup(@NotNull @RequestBody List<AuthMenuVO> voList) throws Exception {
		authService.createMenuAuthGroup(voList);
		return responseService.getSuccessResult();

	}
}
