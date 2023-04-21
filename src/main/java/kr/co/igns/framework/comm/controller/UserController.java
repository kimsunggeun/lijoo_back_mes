package kr.co.igns.framework.comm.controller;

import java.lang.annotation.Target;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.framework.comm.model.DepartmentVO;
import kr.co.igns.framework.comm.model.UserCertVO;
import kr.co.igns.framework.comm.model.UserReqDto;
import kr.co.igns.framework.comm.model.UserVO;
import kr.co.igns.framework.comm.service.UserService;
import kr.co.igns.framework.config.exception.ExceptionAdvice;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import kr.co.igns.framework.config.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;

@Tag(name = "7. UserController", description = "사원정보")
@RestController
@RequiredArgsConstructor
@RequestMapping("/com")
public class UserController {
	
	private final ResponseService responseService;
	private final JwtTokenProvider jwtTokenProvider;
	private final UserService userService;
	private final ExceptionAdvice exceptionAdvice;


	@Operation(summary="사원정보 조회 ", description="사원정보를 조회한다. param: com_code, user_id, user_name")
	@PostMapping(value="/getUser")
	public CommonResult getUser(@RequestBody UserReqDto reqDto){
		List<UserVO> list = userService.getUser(reqDto); 
		return responseService.getListResult(list);
	}
	
	@Operation(summary="ID 중복 체크 ", description="ID 중복 체크한다. param: com_code, user_id")
	@PostMapping(value="/checkByUserId")
	public CommonResult checkByUserId(@RequestBody UserReqDto reqDto){
		int result = userService.checkByUserId(reqDto);
		if(result > 0) {
			return responseService.getFailResult(-1200, "ID 중복");
		} else {
			return responseService.getSuccessResult();
		}
	}
	
	/*****수정중*******/
	@Operation(summary="비밀번호 체크(현재비번) ", description="비밀번호 체크(현재비번)한다. param: com_code, user_id, user_password")
	@PostMapping(value="/checkAdminPw")
	public CommonResult checkAdminPw(@RequestBody UserReqDto reqDto) throws Exception {
		boolean result = userService.checkAdminPw(reqDto);
		if(result) {
			return responseService.getSuccessResult();
		} else {
			return responseService.getFailResult(-1200, "비밀번호 불일치");
		}
	}
	
	@Operation(summary="사용자 비밀번호 초기화", description="사용자 비밀번호를 초기화한다. param: com_code, user_id, user_password")
	@PostMapping(value="/initUserPass")
	public CommonResult initUserPass(HttpServletRequest request, @RequestBody UserVO voList) throws Exception {
		userService.initUserPass(voList);
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="사용자 비밀번호 변경 ", description="사용자 비밀번호를 변경한다. param: com_code, user_id, user_password")
	@PostMapping(value="/updateUserPass")
	public CommonResult updateUserPass(HttpServletRequest request, @RequestBody UserVO voList) throws Exception {
		userService.updateUserPass(voList);
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="사원정보 입력/수정", description="사원정보를 입력/수정한다.(__created__ = true 입력/__modified__ = 수정)")
	@PostMapping(value = "/createUser")
	public CommonResult createUser(@ModelAttribute UserVO userVo) throws Exception {
		System.out.println("controller userVo ====" + userVo.toString());
		userService.createUser(userVo);
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="사원정보 삭제", description="도메인코드를 삭제한다.")
	@PostMapping(value = "/deleteUser")
	public CommonResult deleteUser(@RequestBody List<UserVO> voList) throws Exception{
		
		int result = userService.deleteUser(voList);
		if(result > 0) {
			return responseService.getFailResult(-1200, "ID 중복");
		} else {
			return responseService.getSuccessResult();
		}
	}
	
	@Operation(summary = "사용자정보 조회", description = "로그인 param: uuid")
    @PostMapping(value = "/findByUserId")
    public CommonResult findByUserId(@RequestBody UserReqDto reqDto) {
		List<UserCertVO> userAuthes = userService.findByUserId(reqDto);
		return responseService.getListResult(userAuthes);
    }
}

