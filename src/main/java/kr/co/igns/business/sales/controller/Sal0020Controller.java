package kr.co.igns.business.sales.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.igns.business.sales.model.sal0020.Sal0020VO;
import kr.co.igns.business.sales.service.Sal0020Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Sal0020Controller {
	
	private final ResponseService responseService;
	private final Sal0020Service service;
	
	//고객주문업로드 정보 가져오기
	@PostMapping(value="/sal0020/getCustOrder")
	public CommonResult getCustOrder(@RequestBody List<Sal0020VO> voList) {
		List<Sal0020VO> resultList = service.getCustOrder(voList);
		return responseService.getListResult(resultList);
	}
	
	//고객주문 업로드 정보 저장하기
	@PostMapping(value="/sal0020/saveCustOrder")
	public CommonResult saveCustOrder(@RequestBody List<Sal0020VO> voList) throws Exception {
		service.saveCustOrder(voList);
		return responseService.getSuccessResult();
	}
	
	

}
