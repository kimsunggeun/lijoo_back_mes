package kr.co.igns.business.sales.service;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import kr.co.igns.business.mat.model.mat0070.TransRptSubVO;
import kr.co.igns.business.mat.model.mat0070.TransRptVO;
import kr.co.igns.business.sales.dao.postgre.Sal0160Dao;
import kr.co.igns.business.sales.model.sal0160.Sal0160ReqDto;
import kr.co.igns.business.sales.model.sal0160.Sal0160VO;
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
public class Sal0160Service{

	private final Sal0160Dao sal0160Dao;
	private final SystemDao systemDao;
	private final ReportService reportService;
	private final IgnsSessionUtils ignsSessionUtils;
	
	//출하등록 조회
	public List<Sal0160VO> getSal0120(Sal0160ReqDto reqDto) {
		List<Sal0160VO> list = sal0160Dao.getSal0120(reqDto);
		int idCount = 1;
		String currentIlno = "";
		for(Sal0160VO vo : list) {
			if(!vo.getIlno().equals(currentIlno)) {
				idCount++;
			}
			
			vo.setId(Integer.toString(idCount));
			currentIlno = vo.getIlno();
		}
        return list;
    }

	public void exportTransRpt(HttpServletRequest request, HttpServletResponse response, List<Sal0160VO> reqDto) {
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
		param.put("ilno", reqDto.get(0).getIlno());
		
					
		List<TransRptVO> transRptHeader = sal0160Dao.getTransRptHeader(param);
											
		for (TransRptVO transRptVo : transRptHeader) {
			DecimalFormat df = new DecimalFormat("###,###"); 
			String totalHangl = IntegerUtils.convertIntToKorean(Integer.toString(transRptVo.getTotal())) + "원 (\\ " + df.format(transRptVo.getTotal()) + ")";
			transRptVo.setTotalHangl(totalHangl);
			HashMap<String, Object> param2 = new HashMap<String, Object>();
			param2.put("comCode", transRptVo.getComCode());
			param2.put("facCode", transRptVo.getFacCode());	
			param2.put("ilno", transRptVo.getIlno());	
			param2.put("custCode", transRptVo.getCustCode()); 
			
			List<TransRptSubVO> detail = sal0160Dao.getTransRptSub(param2);			
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
		
}
