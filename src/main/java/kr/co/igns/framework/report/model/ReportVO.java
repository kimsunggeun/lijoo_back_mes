package kr.co.igns.framework.report.model;

import java.util.ArrayList;
import java.util.Map;

import antlr.collections.List;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import net.sf.jasperreports.engine.JRDataSource;

/**
 * 
 * @ 프로젝트      : web mes
 * @ 패키지      : kr.co.igns.framework.report.model
 * @ 파일명      : ReportVO.java
 * @ 기능명       : 
 * @ 작성자       : 김우빈
 * @ 최초생성일    : 2022. 12. 28
 * @ 프로그램 설명    :  jasper Report VO
 * 
 * ■ 변경이력 (ex : [YYYY-MM-DD] 변경 내용 - 수정자)
 *   [2022. 5. 18] 파라메타들 추가   - 김우빈
 */
@Data
public class ReportVO {
	private String jrxmlPath;              // jrxml 파일 경로 classpath 기준  src/main/resource 밑부터 시작
	private String fileName;               // 파일명
	private String exportFileName;         // 파일명
	private String type;                   // 레포트 타입 ex) ppt, pdf, docx, web
	private Map<String, Object> parameter; // jrxml 파일에 들어갈 파라메타
	private JRDataSource dataSource; // 
	
	
}
