package kr.co.igns.business.baseInfo.bas0020.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.baseInfo.bas0020.model.Bas0023VO;
import kr.co.igns.business.baseInfo.bas0020.model.Bas0040VO;
import kr.co.igns.business.baseInfo.bas0020.model.Bas0043VO;
import kr.co.igns.business.baseInfo.bas0020.model.Bas0044VO;
import kr.co.igns.business.baseInfo.bas0020.service.Bas0020Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "bas0020Controller", description = "기준정보엑셀관리")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Bas0020Controller {
	
	private final ResponseService responseService;
	private final Bas0020Service service;
	
	/*----- 거래처 정보 ----- */
	
	//거래처 업로드 가져오기
	@Operation(summary="거래처정보 업로드", description="거래처 업로드 정보를 가져온다.")
	@PostMapping(value="/bas0020/getAccountInfo")
	public CommonResult getAccountInfo(@RequestBody List<Bas0023VO> voList) {
		List<Bas0023VO> resultList = service.getAccountInfo(voList);
		return responseService.getListResult(resultList);
	}
	
	//거래처 업로드 중복값
	@Operation(summary="거래처 업로드 중복값", description="거래처 업로드 중복값을 확인한다.")
	@PostMapping(value="/bas0020/getCustCode")
	public CommonResult getCustCode(@RequestBody Bas0023VO vo) {
		List<Bas0023VO> resultList = service.getCustCode(vo);
		return responseService.getListResult(resultList);
	}
	
	
	//거래처 업로드 저장하기
	@Operation(summary="거래처 업로드 정보 저장", description="거래처 업로드 정보를 저장한다.")
	@PostMapping(value="/bas0020/saveAccountInfo")
	public CommonResult saveAccountInfo(@RequestBody List<Bas0023VO> voList) throws Exception {
		service.saveAccountInfo(voList);
		return responseService.getSuccessResult();
	}
	
	/*----- 품목 정보 ----- */
	
	//품목 업로드 가져오기
	@Operation(summary="품목정보 업로드", description="품목정보업로드 정보를 가져온다.")
	@PostMapping(value="/bas0020/getPartTypeInfo")
	public CommonResult getPartTypeInfo(@RequestBody List<Bas0040VO> voList) {
		List<Bas0040VO> resultList = service.getPartTypeInfo(voList);
		return responseService.getListResult(resultList);
	}
	
	//품목정보 중복값
	@Operation(summary="품목정보 업로드 중복값", description="품목정보의 중복값을 확인한다.")
	@PostMapping(value="/bas0020/partTypeOverlap")
	public CommonResult partTypeOverlap(@RequestBody Bas0040VO vo) {
		List<Bas0040VO> resultList = service.partTypeOverlap(vo);
		return responseService.getListResult(resultList);
	}
	
	//품목정보 업로드 저장하기
	@Operation(summary="품목정보 업로드 저장", description="품목정보업로드 정보를 저장한다.")
	@PostMapping(value="/bas0020/savePartTypeInfo")
	public CommonResult savePartTypeInfo(@RequestBody List<Bas0040VO> voList) throws Exception {
		service.savePartTypeInfo(voList);
		return responseService.getSuccessResult();
	}
	
	/*----- BOM정보 ----- */
	
	//BOM정보 업로드 가져오기
	@Operation(summary="BOM정보 업로드", description="BOM업로드 정보를 가져온다.")
	@PostMapping(value="/bas0020/getBomInfo")
	public CommonResult getBomInfo(@RequestBody List<Bas0043VO> voList) {
		List<Bas0043VO> resultList = service.getBomInfo(voList);
		return responseService.getListResult(resultList);
	}
	
	//BOM정보 업로드 저장하기
	@Operation(summary="BOM정보 업로드 저장", description="BOM정보업로드 정보를 저장한다.")
	@PostMapping(value="/bas0020/saveBomInfo")
	public CommonResult saveBomInfo(@RequestBody List<Bas0043VO> voList) throws Exception {
		service.saveBomInfo(voList);
		return responseService.getSuccessResult();
	}
	
	/*----- 거래처별 품목 정보 ----- */
	
	//거래처별 품목정보 업로드 가져오기
	@Operation(summary="거래처별 품목정보 업로드", description="거래처별 품목정보를 가져온다.")
	@PostMapping(value="/bas0020/getItemByCustInfo")
	public CommonResult getItemByCustInfo(@RequestBody List<Bas0044VO> voList) {
		List<Bas0044VO> resultList = service.getItemByCustInfo(voList);
		return responseService.getListResult(resultList);
	}
	
	//거래처별 품목정보 저장하기
	@Operation(summary="거래처별 품목정보 저장", description="거래처별 품목정보를 저장한다.")
	@PostMapping(value="/bas0020/saveItemByCustInfo")
	public CommonResult saveItemByCustInfo(@RequestBody List<Bas0044VO> voList) throws Exception {
		service.saveItemByCustInfo(voList);
		return responseService.getSuccessResult();
	}
	
	//거래처별 품목정보 중복값
	@Operation(summary="거래처별 품목정보 중복값", description="거래처별 품목정보의 중복값을 확인한다.")
	@PostMapping(value="/bas0020/itemByCustOverlap")
	public CommonResult itemByCustOverlap(@RequestBody Bas0044VO vo) {
		List<Bas0044VO> resultList = service.itemByCustOverlap(vo);
		return responseService.getListResult(resultList);
	}
}
