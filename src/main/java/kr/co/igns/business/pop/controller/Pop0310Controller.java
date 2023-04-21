package kr.co.igns.business.pop.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.pop.model.Pop0310ReqDto;
import kr.co.igns.business.pop.model.Pop0310VO;
import kr.co.igns.business.pop.service.Pop0310Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Pop0310Controller", description = "로트분할")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pop")
public class Pop0310Controller {

	private final ResponseService responseService;
	private final Pop0310Service pop0310Service;

	
	@Operation(summary="pop0310 로트분할", description="전산번호조회")
	@PostMapping(value="/getPop0310")
	
	public CommonResult getPop0310(@RequestBody Pop0310ReqDto reqDto){
		return responseService.getListResult(pop0310Service.getPop0310(reqDto));
    }
	
	@Operation(summary="pop0310 로트분할", description="품목코드조회")
	@PostMapping(value="/getpartNo")
	 public CommonResult getpartNo(@RequestBody Pop0310ReqDto reqDto) {
		 return responseService.getListResult(pop0310Service.getpartNo(reqDto));
	 }
	
	@Operation(summary="pop0310 로트분할", description="창고명조회")
	@PostMapping(value="/getwhNm")
	 public CommonResult getwhNm(@RequestBody Pop0310ReqDto reqDto) {
		 return responseService.getListResult(pop0310Service.getwhNm(reqDto));
	 }
	
	@Operation(summary="pop0310 로트분할", description="작업장조회")
	@PostMapping(value="/getwork")
	 public CommonResult getwork(@RequestBody Pop0310ReqDto reqDto) {
		 return responseService.getListResult(pop0310Service.getwork(reqDto));
	 }
	
	@Operation(summary="pop0310 로트분할", description="팝업재고조회")
	@PostMapping(value="/getstock")
	 public CommonResult getstock(@RequestBody Pop0310ReqDto reqDto) {
		 return responseService.getListResult(pop0310Service.getstock(reqDto));
	 }
	
	@Operation(summary="pop0310 로트분할", description="팝업재공조회")
	@PostMapping(value="/getWorkProcess")
	 public CommonResult getworkprocess(@RequestBody Pop0310ReqDto reqDto) {
		 return responseService.getListResult(pop0310Service.getworkprocess(reqDto));
	 }
	
	@Operation(summary="pop0310 로트분할", description="로트분할을저장한다.(__created__ = true 입력/__modified__ = true 수정)")
	@PostMapping(value = "/createMat0021")
	private CommonResult createMat0021(@NotNull @RequestBody List<Pop0310VO> voList) throws Exception {
		pop0310Service.createMat0021(voList);
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="pop0310 로트분할", description="로트분할을저장한다.(__created__ = true 입력/__modified__ = true 수정)")
	@PostMapping(value = "/updateMat0021")
	private CommonResult updateMat0021(@NotNull @RequestBody List<Pop0310VO> voList) throws Exception {
		pop0310Service.updateMat0021(voList);
		return responseService.getSuccessResult();
	}	

	
	



	
	
	

}
