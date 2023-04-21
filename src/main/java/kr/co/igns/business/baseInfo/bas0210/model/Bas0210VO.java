package kr.co.igns.business.baseInfo.bas0210.model;

import lombok.Data;

@Data
public class Bas0210VO {
	private String pathCode;
	private String pathName;
	
	private String inWhcode;
	private String inWhname;	
	
	private String proCode;
	private String proName;
	
	private String id;         //그리드 id
	private String comCode;    //회사코드
	private String custCode;   //거래처 코드
	private String custName;   //거래처명
	private String custType;   //거래처유형 코드
	private String custTypeNm; //거래처유형 코드 이름
	private String matType;    //거래유형 코드
	private String matTypeNm;  //거래유형 코드 이름
	private String custNo;     //사업자등록번호
	private String name;       //대표자명
	private String conType;    //업태
	private String secType;    //업종
}
