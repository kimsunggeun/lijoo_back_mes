package kr.co.igns.business.baseInfo.bas0210.model;

import lombok.Data;

@Data
//품목별 거래처 정보
public class Bas0044VO {
	private String id;         //그리드 id
	private String comCode;    //회사코드
	private String partNo;     //품번
	private String custCode;   //거래처 코드	
	private String userFlag;   //사용유무
	private String makeDate;   //등록일
	private String maker;      //등록자
	private String editDate;   //수정일
	private String editor;     //수정자
	
	private String custType;   //거래처 유형
	private String matType;    //거래 유형
	private String name;       //대표자명
	
	private boolean __created__;
	private boolean __modified__;
}
