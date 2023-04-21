package kr.co.igns.business.ProdManage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.ProdManage.model.pro0020.Pro0020ReqDto;
import kr.co.igns.business.ProdManage.model.pro0020.Pro0020VO;
import kr.co.igns.business.ProdManage.service.Pro0020Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Pro0020Controller", description = "생산계획등록")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Pro0020Controller {
	@Autowired
	private final ResponseService responseService;
	@Autowired
	private final Pro0020Service pro0020svc;
	
	@Operation(summary="생산계획 조회", description="생산계획 조회")
	@PostMapping(value="/getPro0020")
	public CommonResult getPro0020(@RequestBody Pro0020ReqDto reqDto){
		List<Pro0020VO> list = pro0020svc.getPro0020(reqDto);
		return responseService.getListResult(list);
    }
	
	@Operation(summary="생산계획 등록/수정", description="생산계획 등록/수정(__created__ = true 등록/__modified__ = true 수정)")
	@PostMapping(value = "/createPro0020")
	private CommonResult createPro0020(@NotNull @RequestBody List<Pro0020VO> voList) throws Exception {
		pro0020svc.createPro0020(voList);
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="생산계획(기간별)", description="업로드 가져오기")
	@PostMapping(value="/getProUpload")
	public CommonResult getUpload(@RequestBody List<Pro0020VO> voList){
		List<Pro0020VO> list = pro0020svc.getUpload(voList);
		return responseService.getListResult(list);
    }
	
	@Operation(summary="생산계획(기간별) 저장", description="업로드 저장하기")
	@PostMapping(value="/saveProUpload")
	public CommonResult saveUpload(@RequestBody List<Pro0020VO> voList){
		pro0020svc.saveUpload(voList);
		return responseService.getSuccessResult();
	}
    	
}
