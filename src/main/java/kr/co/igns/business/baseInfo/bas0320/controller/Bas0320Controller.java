package kr.co.igns.business.baseInfo.bas0320.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.baseInfo.bas0320.model.Bas0320Dto;
import kr.co.igns.business.baseInfo.bas0320.model.Bas0320VO;
import kr.co.igns.business.baseInfo.bas0320.service.Bas0320Service;
import kr.co.igns.framework.config.exception.CUserDefinedException;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Bas0320Controller", description = "환율정보관리")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Bas0320Controller {
	
	private final ResponseService responseService;
	private final Bas0320Service service;
	
	//환율정보관리 GET
	@PostMapping("bas0320/getExrateInfoManage")
	@Operation(summary="환율정보관리 조회", description="조건에 맞는 환율정보 가져오기")
	public CommonResult getExrateInfoManage(@RequestBody Bas0320Dto dto) {
		List<Bas0320VO> resultList = service.getExrateInfoManage(dto);
		return responseService.getListResult(resultList);
	}

	//환율정보 공공데이터 저장
	@PostMapping(value="/bas0320/setExrateInfoManage")
	@Operation(summary="환율정보 공공데이터 저장", description="param : 회사, 날짜")
	public CommonResult saveProcInfo(@RequestBody Bas0320Dto dto) throws Exception {

		service.setExrateInfoManage(dto);
		return responseService.getSuccessResult();		
	}

}
