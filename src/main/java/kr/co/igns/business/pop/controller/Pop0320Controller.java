package kr.co.igns.business.pop.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.pop.model.Pop0310VO;
import kr.co.igns.business.pop.service.Pop0320Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Pop0320Controller", description = "로트병합")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pop")
public class Pop0320Controller {

	private final ResponseService responseService;
	private final Pop0320Service pop0320Service;

	@Operation(summary="pop0320 로트병합", description="로트병합을저장한다.(__created__ = true 입력/__modified__ = true 수정)")
	@PostMapping(value = "/mergeLotSavePro0019")
	private CommonResult mergeLotSaveMat0021(@NotNull @RequestBody List<Pop0310VO> voList) throws Exception {
		pop0320Service.createPro0019(voList);
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="pop0320 로트분할", description="로트병합을 업데이트한다.(__created__ = true 입력/__modified__ = true 수정)")
	@PostMapping(value = "/mergeLotUpdateMat0021")
	private CommonResult mergeLotSaveUpdateMat0021(@NotNull @RequestBody List<Pop0310VO> voList) throws Exception {
		System.out.print("업데이트실행");
		pop0320Service.updateMat0021(voList);
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="pop0320 로트분할", description="로트병합할 데이터를 업데이트 한다.")
	@PostMapping(value = "/mergedLotSaveUpdateMat0021")
	private CommonResult mergedLotSaveUpdateMat0021(@NotNull @RequestBody List<Pop0310VO> voList) throws Exception {
		pop0320Service.mergedUpdateMat0021(voList);
		return responseService.getSuccessResult();
	}	
}
