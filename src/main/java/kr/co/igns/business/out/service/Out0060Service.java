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
import kr.co.igns.business.out.dao.postgre.Out0060Dao;

import kr.co.igns.business.out.model.out0060.Out0060DVO;
import kr.co.igns.business.out.model.out0060.Out0060ReqDto;
import kr.co.igns.business.out.model.out0060.Out0060VO;
import kr.co.igns.business.out.model.out0060.outMainRptVO;
import kr.co.igns.business.out.model.out0060.outSubRptVO;
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
public class Out0060Service {
	
	private final Out0060Dao out0060Dao;
	private final SystemDao systemDao;
	private final ReportService reportService;
	
	//조회
	public List<Out0060VO> getOut0060VO(Out0060ReqDto reqDto){
		List<Out0060VO> list = out0060Dao.getOut0060VO(reqDto);
		int idCount = 0;
		String currentIlno = "";
		for(Out0060VO vo : list) {
			if(!vo.getIlno().equals(currentIlno)) {
				idCount++;
			}
			
			vo.setId(Integer.toString(idCount));
			System.out.println("vo 확인" + vo);
			currentIlno = vo.getIlno();
		}
		return list;
	}
	// 디테일조회
	public List<Out0060DVO> geOut0060DVO(Out0060ReqDto dto) {
		List<Out0060DVO> list = out0060Dao.geOut0060DVO(dto);
        return list;
    }
	
	//공정외주발주등록 등록/수정

	public void exportTransRpt(HttpServletRequest request, HttpServletResponse response, List<Out0060VO> reqDto) {
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
		
					
		List<TransRptVO> transRptHeader = out0060Dao.getTransRptHeader(param);
											
		for (TransRptVO transRptVo : transRptHeader) {
			DecimalFormat df = new DecimalFormat("###,###"); 
			String totalHangl = IntegerUtils.convertIntToKorean(Integer.toString(transRptVo.getTotal())) + "원 (\\ " + df.format(transRptVo.getTotal()) + ")";
			transRptVo.setTotalHangl(totalHangl);
			HashMap<String, Object> param2 = new HashMap<String, Object>();
			param2.put("comCode", transRptVo.getComCode());
			param2.put("facCode", transRptVo.getFacCode());	
			param2.put("ilno", transRptVo.getIlno());	
			
			List<TransRptSubVO> detail = out0060Dao.getTransRptSub(param2);			
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


	public void exportTransTagRpt(HttpServletRequest request, HttpServletResponse response, Out0060DVO reqDto)
	{
		
		SystemReqDto pDto = new SystemReqDto();
		pDto.setComCode(reqDto.getComCode());
		pDto.setReportCode("MTRL_IN");
		pDto.setUserFlag("Y");
		
		List<PrintInfoVO> printList = systemDao.getPrintInfo(pDto);
		
		ReportVO reportVO = new ReportVO();
		reportVO.setFileName(printList.get(0).getReportType() + ".jasper");
		reportVO.setJrxmlPath("D:\\SmartMES Web\\report\\" + reqDto.getComCode() + "\\");
		reportVO.setExportFileName(printList.get(0).getTypeName());
		reportVO.setType("pdf");	//레포트 유형
		

													
		HashMap<String, Object>  rptParam = new HashMap<String, Object>();

		rptParam.put("fileName", reportVO.getExportFileName() + "." + reportVO.getType());
		rptParam.put("custName", reqDto.getCustName());
		rptParam.put("regiDate", reqDto.getRegiDate());
		
		reportVO.setParameter(rptParam);
		
		JRDataSource dataSource = new JRBeanCollectionDataSource(reqDto.getDetailData());
		reportVO.setDataSource(dataSource);


		// 레포트
		reportService.exportReport(request, response, reportVO);
	}
	

}