package kr.co.igns.business.pop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.igns.business.pop.model.Pro0010ReqDto;
import kr.co.igns.business.pop.model.Pro0021ReqDto;
import kr.co.igns.business.pop.model.Pro0021VO;
import kr.co.igns.business.pop.model.Pro0023ReqDto;
import kr.co.igns.business.pop.model.Pro0025ReqDto;
import kr.co.igns.business.pop.model.Pro0025VO;
import kr.co.igns.business.pop.model.pro0020ReqDto;
import kr.co.igns.business.pop.model.pro0020VO;
import kr.co.igns.business.pop.service.Pop0210Service;
import kr.co.igns.business.sales.model.sal0160.Sal0160VO;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;
import kr.co.igns.business.pop.model.Pro0025errorVO;

@Tag(name = "Pop210Controller", description = "pop 환경")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pop")
public class Pop0210Controller {

	private final ResponseService responseService;
	private final Pop0210Service pop0210Service;
	
	@Operation(summary="pop 작업반 설정 저장 조회", description="pop 설정 저장")
	@PostMapping(value="/getPro0020")
	public CommonResult getPro0020(@RequestBody pro0020ReqDto reqDto){
		return responseService.getListResult(pop0210Service.getPro0020(reqDto));
    }
	
	@Operation(summary="pop 작업반 설정 저장", description="pop 설정 저장")
	@PostMapping(value="/setPro0020")
	public CommonResult setPro0020(@RequestBody List<pro0020VO> reqDto){
		pop0210Service.setPro0020(reqDto);
		return responseService.getSuccessResult();
    }
	
	@Operation(summary="pop 작업환경 조회", description="pop 작업화면 조회")
	@PostMapping(value="/getPro0021")
	public CommonResult getPro0021(@RequestBody Pro0021ReqDto reqDto){
		Pro0021VO rs = new Pro0021VO();
		rs = pop0210Service.getPro0021(reqDto);

		if(rs == null) return responseService.getSuccessResult();

		return responseService.getSingleResult(rs);
    }
	
	@Operation(summary="pop 작업환경 저장", description="pop 작업환경 저장")
	@PostMapping(value="/setPro0021")
	public CommonResult setPro0021(@RequestBody Pro0021VO reqDto){
		pop0210Service.setPro0021(reqDto);
		return responseService.getSuccessResult();
    }
	
	@Operation(summary="pop 작업자 정보 조회", description="popup 작업자 조회 para:comCode, facCode, ilno")
	@PostMapping(value="/getPro0022")
	public CommonResult getPro0022(@RequestBody Pro0021ReqDto reqDto){
		return responseService.getListResult(pop0210Service.getPro0022(reqDto));
    }

	@Operation(summary="pop 작업자 지정 저장", description="pop 작업자 지정 저장")
	@PostMapping(value="/setPro0022")
	public CommonResult setPro0022(@RequestBody Pro0021VO reqDto){
		pop0210Service.setPro0022(reqDto);
		return responseService.getSuccessResult();
    }
	
	//작업지시팝업 조회
	@Operation(summary="pop 작업지시팝업 조회", description="작업지시팝업")
	@PostMapping(value="/getPro0050")
	public CommonResult getPro0050 (@RequestBody Pro0010ReqDto reqDto){
		return responseService.getListResult(pop0210Service.getPro0050(reqDto));
	}
	
	//작업지시 상태 버튼(작업반 작업정보 업데이트)
	@Operation(summary="작업지시 상태 버튼", description="작업반 작업정보 업데이트")
	@PostMapping(value="/setPro0050")
	public CommonResult setPro0050(@RequestBody Pro0010ReqDto reqDto){
		pop0210Service.setPro0050(reqDto);
		return responseService.getSuccessResult();
	}
	
	//실적/불량등록
    @Operation(summary="실적/불량등록", description="실적/불량 등록")
    @PostMapping(value="/setPro0025")
    public CommonResult setPro0025(@RequestBody List<Pro0025ReqDto> reqDto) {
    	String error = "";
    	// 이전 실적 확인
    	if (reqDto.get(0).getDefCode().equals("")) {
    		error = pop0210Service.getProcChk(reqDto.get(0)).getError();
    	}
    	
    	if (error.equals("")) {
    		// 자재불출 및 자재수량 체크
    		error = pop0210Service.getMatChk(reqDto.get(0)).getError();
    		if (!error.equals("")) throw new RuntimeException(error);
    		reqDto.forEach(dto -> {
        		pop0210Service.setPro0025(dto);
        	});	
    	}    	
    	else
    	{
    		throw new RuntimeException(error);
    	}
    	return responseService.getSuccessResult();
    }
	
	//선택자재 투입 팝업
	@Operation(summary="자재선택 팝입", description="자재 선택 팝업 조회:comCode, facCode")
	@PostMapping(value="/getPro23Select")
	public CommonResult getPro23Select(@RequestBody Pro0023ReqDto reqDto) {
		return responseService.getListResult(pop0210Service.getPro23Select(reqDto));
	}
	
	//자재투입
	@Operation(summary="자재투입", description="전산번호 입력 para:comCode, facCode, ilno, lotDetail, userId")
	@PostMapping(value="/setPro0023")
	public CommonResult setPro0023(@RequestBody Pro0023ReqDto reqDto) {
		pop0210Service.setPro0023(reqDto);
		return responseService.getSuccessResult();
	} 
	
	//자재투입(공정재고 조회)
	@Operation(summary="자재투입(공정재고) 조회", description="자재투입 공정재고 조회 para: comCode, facCode, ilno")
	@PostMapping(value="/getPro0023")
	public CommonResult getPro0023(@RequestBody Pro0023ReqDto reqDto){
		return responseService.getListResult((pop0210Service.getPro0023(reqDto)).toList());
	}
	
	//작업이력 조회
	@Operation(summary="작업 이력 탭 조회", description="작업이력 탭 조회 para: comCode, facCode, ilno, workNo, frDate, toDate")
	@PostMapping(value="/getPro0025")
	public CommonResult getPro0025(@RequestBody Pro0025ReqDto reqDto){
		return responseService.getListResult(pop0210Service.getPro0025(reqDto));
	}
	
	//작업이력 조회
    @Operation(summary="자재 투입 이력 조회", description="자재 투입 이력 조회 para: comCode, facCode, lotDetail")
    @PostMapping(value="/getPro0024")
    public CommonResult getPro0024(@RequestBody Pro0025ReqDto reqDto){
    	return responseService.getListResult(pop0210Service.getPro0024(reqDto));
    }
	
	//작업이력 조회
	@Operation(summary="작업 이력 조회", description="실적등록 고 조회 para: comCode, facCode, ilno, workNo")
	@PostMapping(value="/getPro0026")
	public CommonResult getPro0026(@RequestBody Pro0025ReqDto reqDto){
		return responseService.getListResult(pop0210Service.getPro0026(reqDto));
	}
	
	//실적등록 취소 
	@Operation(summary="실적등록 취소", description="실적등록취소 para: comCode, facCode, ilno, lotDetail")
	@PostMapping(value="/getBack")
	public CommonResult getBack(@RequestBody List<Pro0023ReqDto> reqDto) {
		String error = ""; 
		// 다음 실적 확인    	
		error = pop0210Service.getafProcChk(reqDto.get(0)).getError();
		
		if (!error.equals("")) throw new RuntimeException(error);
		
		reqDto.forEach(dto -> {
			String error2 = "";
	    	
	    	if (error2.equals("")) {
	    		// 자재불출 및 삭제
	    		pop0210Service.getBack(dto);
	    	}
	    	else {
	    		throw new RuntimeException(error2);
	    	}
    	});
		
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="공정이동/부품식별표 출력", description="공정이동/부품식별표 출력")
	@PostMapping(value="/exportRpt")
	public void exportRpt(HttpServletRequest request, HttpServletResponse response, @RequestBody Pro0025ReqDto reqDto) {		
		pop0210Service.exportRpt(request, response, reqDto);
	}
}
