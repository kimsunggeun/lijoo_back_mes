package kr.co.igns.business.out.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.igns.business.mat.model.mat0070.Mat0012VO;
import kr.co.igns.business.mat.model.mat0070.TransRptSubVO;
import kr.co.igns.business.mat.model.mat0070.TransRptVO;
import kr.co.igns.business.out.dao.postgre.Out0040Dao;
import kr.co.igns.business.out.model.out0040.MatOutputRptSubVO;
import kr.co.igns.business.out.model.out0040.MatOutputRptVO;
import kr.co.igns.business.out.model.out0040.Out0040ReqDto;
import kr.co.igns.business.out.model.out0040.Out0040VO;
import kr.co.igns.framework.comm.dao.postgre.SystemDao;
import kr.co.igns.framework.comm.model.PrintInfoVO;
import kr.co.igns.framework.comm.model.SystemReqDto;
import kr.co.igns.framework.report.model.ReportVO;
import kr.co.igns.framework.report.service.ReportService;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import kr.co.igns.framework.utils.type.IntegerUtils;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@RequiredArgsConstructor
@Service
public class Out0040Service {
	
	private final Out0040Dao out0040Dao;
	private final SystemDao systemDao;
	private final ReportService reportService;
	
	//공정외주발주등록 조회
	public List<Out0040VO> getOut0011(Out0040ReqDto reqDto) {
		System.out.println("조회시작");
		List<Out0040VO> list = out0040Dao.getOut0011(reqDto);
		int idCount = 0;
		String currentIlno = "";
		for(Out0040VO vo : list) {
			if(!vo.getInIlno().equals(currentIlno)) {
				idCount++;
			}
			
			vo.setId(Integer.toString(idCount));
			System.out.println("vo 확인" + vo);
			currentIlno = vo.getInIlno();
		}
        return list;
    }

	//거래명세서 출력
	public void exportTransRpt(HttpServletRequest request, HttpServletResponse response, List<Out0040VO> reqDto) {
		SystemReqDto pDto = new SystemReqDto();
		pDto.setComCode(reqDto.get(0).getComCode());
		pDto.setReportCode("TRNSC");
		pDto.setUserFlag("Y");
		
		List<PrintInfoVO> printList = systemDao.getPrintInfo(pDto);
		
		ReportVO reportVO = new ReportVO();
		reportVO.setFileName(printList.get(0).getReportType() + ".jasper");
		reportVO.setJrxmlPath("D:\\SmartMES Web\\report\\" + reqDto.get(0).getComCode() + "\\");
		reportVO.setExportFileName(printList.get(0).getTypeName());
		reportVO.setType("pdf");	//레포트 유형
		
		HashMap<String, Object>  param = new HashMap<String, Object>();
		param.put("comCode", reqDto.get(0).getComCode());
		param.put("facCode", reqDto.get(0).getFacCode());
		param.put("inIlno", reqDto.get(0).getInIlno());
		
		List<TransRptVO> transRptHeader = out0040Dao.getTransRptHeader(param);
											
		for (TransRptVO transRptVo : transRptHeader) {
			DecimalFormat df = new DecimalFormat("###,###"); 
			String totalHangl = IntegerUtils.convertIntToKorean(Integer.toString(transRptVo.getTotal())) + "원 (\\ " + df.format(transRptVo.getTotal()) + ")";
			transRptVo.setTotalHangl(totalHangl);
			HashMap<String, Object> param2 = new HashMap<String, Object>();
			param2.put("comCode", transRptVo.getComCode());
			param2.put("facCode", transRptVo.getFacCode());	
			param2.put("inIlno", transRptVo.getIlno());	
			
			List<TransRptSubVO> detail = out0040Dao.getTransRptSub(param2);			
			transRptVo.setDetailData(new JRBeanCollectionDataSource(detail));		
		}
						
		HashMap<String, Object>  rptParam = new HashMap<String, Object>();
		rptParam.put("fileName", reportVO.getExportFileName() + "." + reportVO.getType());
		rptParam.put("subPath", reportVO.getJrxmlPath());
		
		reportVO.setParameter(rptParam);
		
		JRDataSource dataSource = new JRBeanCollectionDataSource(transRptHeader);
		reportVO.setDataSource(dataSource);
		
		// 레포트
		reportService.exportReport(request, response, reportVO);
	}
		
	//외주자재출고증 출력
	public void exportMatOutputRpt(HttpServletRequest request, HttpServletResponse response, List<Out0040VO> reqDto) {
		SystemReqDto pDto = new SystemReqDto();
		pDto.setComCode(reqDto.get(0).getComCode());
		pDto.setReportCode("MTRL_OUT");
		pDto.setUserFlag("Y");
		
		List<PrintInfoVO> printList = systemDao.getPrintInfo(pDto);
		
		ReportVO reportVO = new ReportVO();
		reportVO.setFileName(printList.get(0).getReportType() + ".jasper");
		reportVO.setJrxmlPath("D:\\SmartMES Web\\report\\" + reqDto.get(0).getComCode() + "\\");
		reportVO.setExportFileName(printList.get(0).getTypeName());
		reportVO.setType("pdf");	//레포트 유형
		
		HashMap<String, Object>  param = new HashMap<String, Object>();
		param.put("comCode", reqDto.get(0).getComCode());
		param.put("facCode", reqDto.get(0).getFacCode());
		param.put("inIlno", reqDto.get(0).getInIlno());
		
		MatOutputRptVO transRptHeader = out0040Dao.getMatOutputRptHeader(param);
										
		HashMap<String, Object> param2 = new HashMap<String, Object>();
		param2.put("comCode", transRptHeader.getComCode());
		param2.put("facCode", transRptHeader.getFacCode());	
		param2.put("inIlno", transRptHeader.getInIlno());	
		
		List<MatOutputRptSubVO> detail = out0040Dao.getMatOutputRptSub(param2);			
						
		HashMap<String, Object>  rptParam = new HashMap<String, Object>();
		rptParam.put("inDate", transRptHeader.getInDate());
		rptParam.put("custName", transRptHeader.getCustName());
		rptParam.put("facName", transRptHeader.getFacName());
		rptParam.put("comName", transRptHeader.getComName());
		rptParam.put("lotDetail", transRptHeader.getLotDetail());
		rptParam.put("inIlno", transRptHeader.getInIlno());
		rptParam.put("total", transRptHeader.getTotal());
		
		reportVO.setParameter(rptParam);
		
		JRDataSource dataSource = new JRBeanCollectionDataSource(detail);
		reportVO.setDataSource(dataSource);

		// 레포트
		reportService.exportReport(request, response, reportVO);
	}
}