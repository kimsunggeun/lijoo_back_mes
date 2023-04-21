package kr.co.igns.business.pop.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.*;
import org.springframework.stereotype.Service;

import kr.co.igns.business.ProdManage.model.pro0050.Pro0050VO;
import kr.co.igns.business.mat.model.mat0070.TransRptSubVO;
import kr.co.igns.business.mat.model.mat0070.TransRptVO;
import kr.co.igns.business.pop.dao.postgre.Pop0210Dao;
import kr.co.igns.business.pop.model.Pop0023VO;
import kr.co.igns.business.pop.model.Pro0010ReqDto;
import kr.co.igns.business.pop.model.Pro0021ReqDto;
import kr.co.igns.business.pop.model.Pro0021VO;
import kr.co.igns.business.pop.model.Pro0022VO;
import kr.co.igns.business.pop.model.Pro0023ReqDto;
import kr.co.igns.business.pop.model.Pro0024VO;
import kr.co.igns.business.pop.model.Pro0025ReqDto;
import kr.co.igns.business.pop.model.Pro0025VO;
import kr.co.igns.business.pop.model.Pro0025errorVO;
import kr.co.igns.business.pop.model.pro0020ReqDto;
import kr.co.igns.business.pop.model.pro0020VO;
import kr.co.igns.business.sales.model.sal0160.Sal0160VO;
import kr.co.igns.framework.comm.dao.postgre.SystemDao;
import kr.co.igns.framework.comm.model.PrintInfoVO;
import kr.co.igns.framework.comm.model.SystemReqDto;
import kr.co.igns.framework.report.model.ReportVO;
import kr.co.igns.framework.report.service.ReportService;
import kr.co.igns.framework.utils.type.IntegerUtils;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@RequiredArgsConstructor
@Service
public class Pop0210Service {
	
	private final Pop0210Dao pop0210dao;
	private final SystemDao systemDao;
	private final ReportService reportService;
	
	// 조회
	public List<pro0020VO> getPro0020(pro0020ReqDto reqDto) {
        return pop0210dao.getPop0020(reqDto);
    }
	
	//저장
	public int setPro0020(List<pro0020VO> reqDto) {
		reqDto.forEach(s -> pop0210dao.delPop0020(s));
		pop0210dao.setPop0020(reqDto);
        return 0;
    }
	
	// 조회
	public Pro0021VO getPro0021(Pro0021ReqDto reqDto) {
        return pop0210dao.getPop0021(reqDto);
    }
	
	public int setPro0021(Pro0021VO reqDto) {
		pop0210dao.setPop0021(reqDto);
        return 0;
    }
		
	public List<Pro0022VO> getPro0022(Pro0021ReqDto reqDto){
		return pop0210dao.getPro0022(reqDto);
	}
	
	public int setPro0022(Pro0021VO reqDto) {
		return pop0210dao.setPro0022(reqDto);
	}
	
	//작업지시팝업 조회
	public List<Pro0050VO> getPro0050 (Pro0010ReqDto reqDto){
		return pop0210dao.getPro0050(reqDto);
	}
	
	//작업지시 상태 버튼(작업반 작업정보 업데이트)
	public int setPro0050(Pro0010ReqDto reqDto){
		pop0210dao.setPro0050_before(reqDto);
		return pop0210dao.setPro0050(reqDto);
	}
	
	//실적등록
	public int setPro0025(Pro0025ReqDto reqDto) {
		return pop0210dao.setPro0025(reqDto);
	}
	
	//선택자재 투입 팝업
	public List<Pop0023VO> getPro23Select(Pro0023ReqDto reqDto) {
		return pop0210dao.getPro23Select(reqDto);
	}
	
	//자재투입
	public void setPro0023(Pro0023ReqDto reqDto) {
		System.out.println(reqDto.toString());
		pop0210dao.setPro0023(reqDto);
	} 
	
	//자재투입(공정재고 조회)
	public JSONArray getPro0023(Pro0023ReqDto reqDto){
		return new JSONArray(pop0210dao.getPro0023(reqDto));
	}
	
	//작업이력 조회
	public List<Pro0025VO> getPro0025(Pro0025ReqDto reqDto){
		return pop0210dao.getPro0025(reqDto);
	}
	
	//자재투입이력 조회
	public List<Pro0024VO> getPro0024(Pro0025ReqDto reqDto){
		return pop0210dao.getPro0024(reqDto);
	}

	//작업이력 조회
	public List<Pro0025VO> getPro0026(Pro0025ReqDto reqDto){
		return pop0210dao.getPro0026(reqDto);
	}
	
	//실적등록 취소 
	public void getBack(Pro0023ReqDto reqDto) {
		pop0210dao.getBack(reqDto);
	}
	
	// 이전 실적 체크
	public Pro0025errorVO getProcChk (Pro0025ReqDto reqDto) {
		return pop0210dao.getProcChk(reqDto);
	}
	// 다음 실적 체크
	public Pro0025errorVO getafProcChk (Pro0023ReqDto reqDto) {
		return pop0210dao.getafProcChk(reqDto);
	}
	
	//자동불출 = 'Y' 자재 수량 체크
	public Pro0025errorVO getMatChk (Pro0025ReqDto reqDto) {
		return pop0210dao.getMatChk(reqDto);
	}

	//공정이동/부품식별표 출력
	public void exportRpt(HttpServletRequest request, HttpServletResponse response, Pro0025ReqDto reqDto) {
		System.out.println("exportRpt ::::::::::" + reqDto);
//		List<Pro0025VO> list1 = new ArrayList<>();
//		List<Pro0025VO> list2 = new ArrayList<>();
//		List<List<Pro0025VO>> totList = new ArrayList<>();
//		for(int i=0; i < reqDto.getDetailData().size(); i++) {
//			Pro0025VO vo = reqDto.getDetailData().get(i);
//			if(!vo.getOrderState().equals("60"))
//				list1.add(vo);
//			else
//				list2.add(vo);
//		}
//		totList.add(list1);
//		totList.add(list2);
//		
//		for(int j=0; j < totList.size(); j++) {
			SystemReqDto pDto = new SystemReqDto();
			pDto.setComCode(reqDto.getComCode());
//			if(j == 0)
				pDto.setReportCode(reqDto.getRepType());
//			else
//				pDto.setReportCode("PRO_TRANS");
			pDto.setUserFlag("Y");
			
			List<PrintInfoVO> printList = systemDao.getPrintInfo(pDto);
			
			ReportVO reportVO = new ReportVO();
			reportVO.setFileName(printList.get(0).getReportType() + ".jasper");
			reportVO.setJrxmlPath("D:\\SmartMES Web\\report\\" + reqDto.getComCode() + "\\");
			reportVO.setExportFileName(printList.get(0).getTypeName());
			reportVO.setType("pdf");	//레포트 유형
												
			HashMap<String, Object>  rptParam = new HashMap<String, Object>();

			rptParam.put("fileName", reportVO.getExportFileName() + "." + reportVO.getType());
			rptParam.put("comName", reqDto.getComName());
			
			reportVO.setParameter(rptParam);
			
			JRDataSource dataSource = new JRBeanCollectionDataSource(reqDto.getDetailData());
			reportVO.setDataSource(dataSource);
			// 레포트
			reportService.exportReport(request, response, reportVO);	
//		}
	}
}
