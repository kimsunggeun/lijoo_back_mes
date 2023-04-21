package kr.co.igns.business.mat.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import kr.co.igns.business.mat.dao.postgre.Mat0070Dao;
import kr.co.igns.business.mat.model.mat0070.Mat0070ReqDto;
import kr.co.igns.business.mat.model.mat0070.TransRptSubVO;
import kr.co.igns.business.mat.model.mat0070.TransRptVO;
import kr.co.igns.business.mat.model.mat0070.Mat0012VO;
import kr.co.igns.business.mat.model.mat0070.Mat0018VO;
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
public class Mat0070Service{

	private final Mat0070Dao mat0070Dao;
	private final SystemDao systemDao;
	private final ReportService reportService;
	
	//조회
	public List<Mat0012VO> getMat0012(Mat0070ReqDto reqDto){
		List<Mat0012VO> list = mat0070Dao.getMat0012(reqDto);
		int idCount = 0;
		String currentIlno = "";
		for(Mat0012VO vo : list) {
			if(!vo.getIlNo().equals(currentIlno)) {
				idCount++;
			}
			
			vo.setId(Integer.toString(idCount));
			System.out.println("vo 확인" + vo);
			currentIlno = vo.getIlNo();
		}
		return list;
	}
	
	public List<Mat0018VO> getMat0018(Mat0070ReqDto reqDto){
		List<Mat0018VO> list = mat0070Dao.getMat0018(reqDto);
		return list;
	}		
	
	public void exportTransRpt(HttpServletRequest request, HttpServletResponse response, List<Mat0012VO> reqDto)
	{
		
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
		
		ArrayList<String> rptKey = new ArrayList<String>();
		for (Mat0012VO mat0012Vo : reqDto) {
			rptKey.add(mat0012Vo.getIlNo());			
		}
		
		param.put("ilno_list", rptKey);
					
		List<TransRptVO> transRptHeader = mat0070Dao.getTransRptHeader(param);
											
		for (TransRptVO transRptVo : transRptHeader) {
			DecimalFormat df = new DecimalFormat("###,###"); 
			String totalHangl = IntegerUtils.convertIntToKorean(Integer.toString(transRptVo.getTotal())) + "원 (\\ " + df.format(transRptVo.getTotal()) + ")";
			transRptVo.setTotalHangl(totalHangl);
			HashMap<String, Object> param2 = new HashMap<String, Object>();
			param2.put("comCode", transRptVo.getComCode());
			param2.put("facCode", transRptVo.getFacCode());	
			param2.put("ilno", transRptVo.getIlno());	
			
			List<TransRptSubVO> detail = mat0070Dao.getTransRptSub(param2);			
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

	public void exportTransTagRpt(HttpServletRequest request, HttpServletResponse response, Mat0012VO reqDto)
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
		
//		if(reqDto.getPrintType().equals("A4"))
//		{
//			reportVO.setFileName("matInputRpt.jasper");
//		}
//		else
//		{
//			reportVO.setFileName("matInputBtypeRpt.jasper");
//		}
													
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
