package kr.co.igns.framework.comm.controller;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.framework.comm.model.MenuStatisticsReqDto;
import kr.co.igns.framework.comm.model.MenuStatisticsVO;
import kr.co.igns.framework.comm.service.MenuStatisticsService;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;



@Tag(name = "10. MenuStatisticsController", description = "메뉴 접속 통계")
@RestController
@RequiredArgsConstructor
@RequestMapping("/com")
public class MenuStatisticsController {
	
	private final ResponseService responseService;
	private final MenuStatisticsService menuStatisticsService;
	
	@Operation(summary="메뉴 접속 통계 조회", description="메뉴 접속 통계 조회")
	@PostMapping(value="/getMenuStatistics")
	public CommonResult getMenuStatistics(@RequestBody MenuStatisticsReqDto dto) {
		List<MenuStatisticsVO> list = menuStatisticsService.getMenuStatistics(dto);
		return responseService.getListResult(list);
	}
	
	@Operation(summary="메뉴 접속 통계 수집", description="메뉴 접속 통계 수집")
	@Transactional(rollbackFor = Exception.class)
	@PostMapping(value="/saveMenuStatistics")
	public CommonResult saveMenuStatistics(@NotNull @RequestBody MenuStatisticsReqDto dto) throws UnknownHostException, SocketException {
		menuStatisticsService.saveMenuStatistics(dto);
		return responseService.getSuccessResult();
	}
	
}
