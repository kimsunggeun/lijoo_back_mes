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
import kr.co.igns.business.pop.service.Pop0010Service;
import kr.co.igns.business.pop.model.Pop0010ReqDto;
import kr.co.igns.business.pop.model.Pop0010VO;


@Tag(name = "Pop0010Controller", description = "pop 환경")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pop")
public class Pop0010Controller {
	
	private final ResponseService responseService;
	private final Pop0010Service pop0010Service;
	
	@Operation(summary="거래처코드에 의한 일련번호 조회", description="거래처코드에 따른 일련번호 조회")
	@PostMapping(value="/getIlno")
	public CommonResult getIlno(@RequestBody Pop0010ReqDto reqDto){
		return responseService.getListResult(pop0010Service.getIlno(reqDto));
    }
	
	@Operation(summary="입고번호에 의한 납품정보 상세 조회", description="pop 설정 저장")
	@PostMapping(value="/getMat0018")
	public CommonResult getMat0018(@RequestBody Pop0010ReqDto reqDto){
		return responseService.getListResult(pop0010Service.getMat0018(reqDto));
    }
	
	@Operation(summary="전산번호에 의한 납품정보 상세 조회", description="전산번호에 의한 납품정보 상세를 조회한다.")
	@PostMapping(value="/getMat0018_LotScan")
	public CommonResult getMat0018_LotScan(@RequestBody Pop0010ReqDto reqDto){
		return responseService.getListResult(pop0010Service.getMat0018_LotScan(reqDto));
    }

	@Operation(summary="전표스캔에 의한 납품정보 상세 조회", description="pop 설정 저장")
	@PostMapping(value="/getMat0018_Scan")
	public CommonResult getMat0018_Scan(@RequestBody Pop0010ReqDto reqDto){
		return responseService.getListResult(pop0010Service.getMat0018_Scan(reqDto));
    }
	
	@Operation(summary="구매 입고정보 입력/수정", description="구매 입고정보를 입력/수정한다.(__created__ = true 입력/__modified__ = true 수정)")
	@PostMapping(value = "/updateMat0018")
	private CommonResult updateMat0018(@NotNull @RequestBody List<Pop0010VO> voList) throws Exception {
		pop0010Service.updateMat0018(voList);
		return responseService.getSuccessResult();
	}

}
