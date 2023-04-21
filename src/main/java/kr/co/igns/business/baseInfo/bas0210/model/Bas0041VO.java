package kr.co.igns.business.baseInfo.bas0210.model;

import lombok.Data;

@Data
//경로유형
public class Bas0041VO {
	private String id;
	private String comCode;    //회사코드
	private String partNo;     //품번
	private String pathType;   //경로유형 코드
	private String pathCode;   //경로코드
	private String inWhcode;   //입고창고 코드
	private String sortFlag;   //정렬순서
	private String remark;     //비고
	private String userFlag;   //사용유무
	private String makeDate;   //등록일
	private String maker;      //등록자
	private String editDate;   //수정일
	private String editor;     //수정자
	
	private String pathTypeName; //경로유형 명
	private String pathName;     //경로코드 명
	private String inWhName; //입고창고 명
	private String userFlagName; //사용유무
	
	
	private boolean __created__;
	private boolean __modified__;
}
