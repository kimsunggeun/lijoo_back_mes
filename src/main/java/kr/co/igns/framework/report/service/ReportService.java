package kr.co.igns.framework.report.service;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import kr.co.igns.framework.report.model.ReportVO;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JRFont;
import net.sf.jasperreports.engine.JRPropertiesHolder;
import net.sf.jasperreports.engine.JRPropertiesMap;
import net.sf.jasperreports.engine.JRPropertiesUtil;
import net.sf.jasperreports.engine.JRPropertyExpression;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRPptxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.Exporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.view.save.JREmbeddedImagesXmlSaveContributor;



/**
 * 
 * @ 프로젝트      : web mes
 * @ 패키지      : kr.co.igns.framework.report.service
 * @ 파일명      : ReportService.java
 * @ 기능명       : 
 * @ 작성자       : 김우빈
 * @ 최초생성일    : 2022. 12. 28
 * @ 프로그램 설명    :  report service
 * 
 * ■ 변경이력 (ex : [YYYY-MM-DD] 변경 내용 - 수정자)
 *   [2022. 12. 28] jasper 파일 생성 및 export 추가   - 김우빈
 */

@Service
@RequiredArgsConstructor
public class ReportService {

	final JRPropertiesUtil jrProps = JRPropertiesUtil.getInstance(DefaultJasperReportsContext.getInstance());
	// transformReport
	public void exportReport(HttpServletRequest request, HttpServletResponse response, ReportVO reportVO) {
		
		jrProps.setProperty(JRFont.DEFAULT_PDF_FONT_NAME, "맑은 고딕");
		jrProps.setProperty(JRFont.DEFAULT_PDF_ENCODING, "Identity-H");
		jrProps.setProperty(JRFont.DEFAULT_PDF_EMBEDDED, "TRUE");
		jrProps.setProperty(JRFont.DEFAULT_FONT_NAME, "맑은 고딕");
		
		JasperPrint report = null;
		
		// JasperPrint 생성
		try 
		{		
			
			String fileName = reportVO.getJrxmlPath() + reportVO.getFileName();
			JasperReport jasperReport = (JasperReport)JRLoader.loadObject(new File(fileName));
									
			//System.out.println("path : " + getClass().getClassLoader().getResource(reportVO.getJrxmlPath()).getPath() + reportVO.getFileName());
			//InputStream stream = getClass().getClassLoader().getResourceAsStream(reportVO.getJrxmlPath() + reportVO.getFileName());
			//JasperReport jasperReport = JasperCompileManager.compileReport(stream);	
			//System.out.println("report compiled");
			
			report = JasperFillManager.fillReport(jasperReport, reportVO.getParameter(), reportVO.getDataSource());
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		// report 출력
		try {
			reportStream(request, response, report, reportVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// export service
	public void reportStream(HttpServletRequest request, HttpServletResponse response, JasperPrint jasperPrint, ReportVO reportVO) throws Exception {
//		System.out.println("reportStream ::::::::::::::: " + reportVO);
//		System.out.println("reportStream ::::::::::::::: " + jasperPrint);
		// 확장자 설정
		//reportVO.setExportFileName(reportVO.getExportFileName()+"."+reportVO.getType());
		
		// octet-stream 8비트 단위의 바이너리 데이터를 의미함. 알 수없는 파일 형식을 사용할때 사용함 
		response.setContentType("application/octet-stream;charset=UTF-8");
		response.setHeader("report", "success");
		//response.setHeader("fileName", Base64.getEncoder().encodeToString(reportVO.getExportFileName().getBytes()));
		response.setHeader("fileName", reportVO.getExportFileName());
		// 프로젝트 경로에 파일 생성 시작
		@SuppressWarnings("rawtypes")
		Exporter exporter = null;
		reportVO.setType("pdf");
		switch (reportVO.getType()) {
		case "pptx":
			exporter = new JRPptxExporter();
			break;
	    case "pdf":
	        exporter = new JRPdfExporter();
	        break;
	    case "docx":
	    	exporter = new JRDocxExporter();
	    	break;
	    case "xls":
	    	exporter = new JRXlsExporter();
	    	break;
    	// html 이미지 출력 문제로 보류
//	    case "html":
//	        exporter = new HtmlExporter();
//	        break;
	    }
		
		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
		
		// html 이미지 출력 문제로 보류
//		if(reportVO.getType().equals("html")) {
//			SimpleHtmlExporterOutput htmlOutput = new SimpleHtmlExporterOutput(response.getOutputStream());
//			
////			htmlOutput.setImageHandler(new WebHtmlResourceHandler(request.getContextPath() + "html_images/{0}"));
////			exporter.setExporterOutput(htmlOutput);
//			exporter.setExporterOutput(new SimpleHtmlExporterOutput(response.getOutputStream()));
//		} else {			
//			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
//		}
		exporter.exportReport();
		
	}
	
}
