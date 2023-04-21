package kr.co.igns.business.pop.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;
import kr.co.igns.business.pop.service.Pop0040Service;
import kr.co.igns.business.pop.model.Pop0010ReqDto;
import kr.co.igns.business.pop.model.Pop0010VO;
import kr.co.igns.business.pop.model.Pop0040ReqDto;
import kr.co.igns.business.pop.model.Pop0040VO;

@Tag(name = "Pop0040Controller", description = "pop 환경")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pop/pop0040")

public class Pop0040Controller {

	private final ResponseService responseService;
	private final Pop0040Service pop0040Service;

	@Operation(summary="창고코드 조회2", description="창고코드 조회2")
	@PostMapping(value="/getOutWh")
	public CommonResult getOutWh(@RequestBody Pop0040ReqDto reqDto){
		return responseService.getListResult(pop0040Service.getOutWh(reqDto));
    }
	
	@Operation(summary="품번, 품명 조회", description="품번, 품명 조회")
	@PostMapping(value="/getPartNo")
	public CommonResult getPartNo(@RequestBody Pop0040ReqDto reqDto){
		return responseService.getListResult(pop0040Service.getPartNo(reqDto));
    }
	
	//재고마스터 상세 조회
	@Operation(summary="창고코드, 품번에 의한 재고마스터 상세 조회", description="창고코드, 품번에 의한 재고마스터 상세 조회")
	@PostMapping(value="/getMat0021")
	public CommonResult getMat0021(@RequestBody Pop0040ReqDto reqDto){
		return responseService.getListResult(pop0040Service.getMat0021(reqDto));
    }
	
	@Operation(summary="창고 이동", description="창고를 이동시킨다")
	@PostMapping(value = "/createMat0020")
	private CommonResult createMat0020(@RequestBody List<Pop0040VO> voList) throws Exception {
		pop0040Service.createMat0020(voList);
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="창고 이동이력", description="창고 이동이력을 저장한다.")
	@PostMapping(value = "/createMat0031")
	private CommonResult createMat0031(@RequestBody List<Pop0040VO> voList) throws Exception {
		pop0040Service.createMat0031(voList);
		return responseService.getSuccessResult();
	}
}
