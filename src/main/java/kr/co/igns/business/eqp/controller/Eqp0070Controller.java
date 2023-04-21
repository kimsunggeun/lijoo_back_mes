package kr.co.igns.business.eqp.controller;

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
import kr.co.igns.business.eqp.model.eqp0070.Eqp0070Dto;
import kr.co.igns.business.eqp.model.eqp0070.Eqp0070VO;
import kr.co.igns.business.eqp.model.eqp0070.Eqp0070DetailVO;
import kr.co.igns.business.eqp.service.Eqp0070Service;
import kr.co.igns.framework.config.response.CommonResult;
import kr.co.igns.framework.config.response.ResponseService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Eqp0070Controller", description = "계측기 검교정 등록")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Eqp0070Controller {
	
	private final ResponseService responseService;
	private final Eqp0070Service eqp0070Service;
	
	@Operation(summary="계측기 마스터 조회", description="계측기 마스터를 조회한다")
	@PostMapping(value="/getHeaderItem")
	public CommonResult getItemInfo2(@RequestBody Eqp0070Dto dto){
		List<Eqp0070VO> vo = eqp0070Service.getHeaderItem(dto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="계측기 검교정 조회", description="계측기 검교정을 조회한다")
	@PostMapping(value="/getDetailItem")
	public CommonResult getDetailItem(@RequestBody Eqp0070Dto dto){
		List<Eqp0070DetailVO> vo = eqp0070Service.getDetailItem(dto);
		return responseService.getListResult(vo);
    }
	
	@Operation(summary="계측기 검교정 입력/수정", description="계측기 검교정 정보를 입력/수정한다.(__created__ = true 입력/__modified__ = true 수정)")
	@PostMapping(value = "/saveCorrItem")
	@Transactional(rollbackFor = Exception.class)
	private CommonResult createEqp0070(@ModelAttribute Eqp0070DetailVO vo) throws Exception {
		System.out.println("컨트롤러에서 vo 체크 ::::::::::::::::::::::::::: " + vo);
		eqp0070Service.saveEqp0070(vo);
		return responseService.getSuccessResult();
	}
	
	@Operation(summary="계측기 검교정 삭제", description="계측기 검교정 정보를 삭제한다")
	@PostMapping(value = "/deleteCorrItem")
	private CommonResult deleteEqp0070(@NotNull @RequestBody List<Eqp0070DetailVO> voList) throws Exception {
		eqp0070Service.deleteEqp0070(voList);
		return responseService.getSuccessResult();
	}	
}
