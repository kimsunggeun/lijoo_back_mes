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
import kr.co.igns.framework.comm.model.MenuReqDto;
import kr.co.igns.framework.comm.model.MenuVO;
import kr.co.igns.framework.comm.model.UserMenuVO;
import kr.co.igns.framework.comm.service.MenuService;
import kr.co.igns.framework.config.exception.ExceptionAdvice;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;



@Tag(name = "2. MenuController", description = "메뉴 관리")
@RestController
@RequiredArgsConstructor
@RequestMapping("/com")
public class MenuController {
	
	private final ResponseService responseService;
	private final ExceptionAdvice exceptionAdvice;
	private final MenuService menuService;
	
	@Operation(summary="Router 메뉴 조회", description="세션정보로 메뉴 조회 param: comCode")
	@PostMapping(value="/getRouterMenu")
	public CommonResult getRouterMenu(@RequestBody MenuReqDto reqDto){
		//사용자별 메뉴권한
		List<UserMenuVO> menuList = menuService.getRouterMenu(reqDto);
		if (menuList.size() < 1) {
			return responseService.getFailResult(Integer.valueOf(exceptionAdvice.getMessage("noResultFound.code")), exceptionAdvice.getMessage("noResultFound.msg"));
		}
		return responseService.getListResult(menuList);
	}
	
	@Operation(summary="메뉴 조회", description="세션정보로 메뉴 조회 param: comCode")
	@PostMapping(value="/getAllMenu")
	public CommonResult getAllMenu(@RequestBody MenuReqDto reqDto){
		//사용자별 메뉴권한
		List<UserMenuVO> menuList = menuService.getAllMenu(reqDto);
		if (menuList.size() < 1) {
			return responseService.getFailResult(Integer.valueOf(exceptionAdvice.getMessage("noResultFound.code")), exceptionAdvice.getMessage("noResultFound.msg"));
		}
		return responseService.getListResult(menuList);
	}
	
	@Operation(summary="사용자 메뉴 조회", description="세션정보로 메뉴 조회 param: comCode, userId")
	@PostMapping(value="/getUserMenu")
	public CommonResult getUserMenu(@RequestBody MenuReqDto reqDto){
		//사용자별 메뉴권한
		List<UserMenuVO> menuList = menuService.getUserMenu(reqDto);
		if (menuList.size() < 1) {
			return responseService.getFailResult(Integer.valueOf(exceptionAdvice.getMessage("noResultFound.code")), exceptionAdvice.getMessage("noResultFound.msg"));
		}
		return responseService.getListResult(menuList);
	}

	@Operation(summary="메뉴리스트 입력/수정", description="메뉴리스트를 입력/수정한다.(__created__ = true 입력/__modified__ = 수정)")
	@PostMapping(value = "/createMenu")
	@Transactional(rollbackFor = Exception.class)
	public CommonResult createMenu(@NotNull @RequestBody List<MenuVO> voList) throws Exception {
		menuService.createMenu(voList);
		return responseService.getSuccessResult();
	}
}

