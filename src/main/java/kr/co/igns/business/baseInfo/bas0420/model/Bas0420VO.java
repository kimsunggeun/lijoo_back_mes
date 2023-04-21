package kr.co.igns.business.baseInfo.bas0420.model;

import lombok.Data;

@Data
public class Bas0420VO {
	private String comCode;      //회사코드
	private String partNo;       //품번 코드
	private String partName;     //품명
	private String inspNo;       //검사순서
	private String insCode;      //검사유형 코드
	private String insCodeName;  //검사유형 이름
	private String insType;      //검사항목 코드
	private String insTypeName;  //검사항목 이름
	private String insMeth;      //측정방법 코드
	private String insMethName;  //측정방법 이름
	private String jugCodeh;     //판정방법 코드
	private String jugCodehName; //판정방법 이름
	private String insUnit;      //검사단위 코드
	private String insUnitName;  //검사단위 이름
	private String insBase;      //검사기준
	private String insUpp;       //상한치
	private String insLow;       //하한치
	private String insCnt;       //시료수
	private String remark;       //비고
	private String userFlag;     //사용유무
	private String makeDate;     //등록일
	private String maker;        //등록자
	private String editDate;     //수정일
	private String editor;       //수정자
	private String sysCode;      //수정자
	private String sysName;      //수정자
	private int chk;      		 //chk
	
	private boolean __created__;
	private boolean __modified__;
}
