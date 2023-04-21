package kr.co.igns.business.pop.model;

import lombok.Data;

@Data
public class Pop0350ReqDto {
	private String comCode;  //회사코드
	private String partNo; 	 //품목코드
	private String pathCode; //경로유형
	private String proCode;	 //공정코드
}


