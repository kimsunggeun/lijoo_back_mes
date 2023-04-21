package kr.co.igns.business.baseInfo.bas0240.controller;

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
import kr.co.igns.business.baseInfo.bas0240.model.Bas0070VO;
import kr.co.igns.business.baseInfo.bas0240.model.Bas0240Dto;
import kr.co.igns.business.baseInfo.bas0240.sevice.Bas0240Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Bas0240Controller", description = "작업표준서관리")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Bas0240Controller {
	
	private final ResponseService responseService;
	private final Bas0240Service bsd0240Service;
	
	//작업표준서관리 조회
	@PostMapping(value="/bas0240/getDataList")
	@Operation(summary="작업표준서관리 조회", description="작업표준서관리 정보 가져오기")
	public CommonResult getDataList(@RequestBody Bas0240Dto reqDto) {
		System.out.println("Bas0240Dto >>> " + reqDto);
		List<Bas0070VO> resultList = bsd0240Service.getDataList(reqDto);
		return responseService.getListResult(resultList);
	}
	
	//작업표준서관리 파일 조회
	@PostMapping(value="/bas0240/getDataFile")
	@Operation(summary="작업표준서관리 파일 조회", description="작업표준서관리 파일 정보 가져오기")
	public CommonResult getDataFile(@RequestBody Bas0070VO vo){
		List<Bas0070VO> resultList = bsd0240Service.getDataFile(vo);
		return responseService.getListResult(resultList);
	}
	
	//작업표준서관리 저장
	@PostMapping(value="/bas0240/saveData")
	@Operation(summary="작업표준서관리 입력/수정", description="")
	@Transactional(rollbackFor = Exception.class)
	public CommonResult saveData(@ModelAttribute Bas0070VO vo) throws Exception{
		System.out.println("vo >>"+vo);
		bsd0240Service.saveData(vo);
		return responseService.getSuccessResult();				
	}
	
	@PostMapping(value = "/bas0240/deleteData")
	@Operation(summary="작업표준서관리 삭제", description="작업표준서관리 삭제한다.")
	@Transactional(rollbackFor = Exception.class)
	public CommonResult deleteData(@RequestBody Bas0070VO vo) throws Exception{
		bsd0240Service.deleteData(vo);
		return responseService.getSuccessResult();
	}
}
