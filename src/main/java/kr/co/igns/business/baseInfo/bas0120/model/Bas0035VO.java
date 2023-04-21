package kr.co.igns.business.baseInfo.bas0120.model;

import lombok.Data;

@Data
public class Bas0035VO {             
	private String comCode;          //회사코드
	private String facCode;          //공장코드
	private String workCode;         //작업장 코드
	private String workDecode;       //작업반 코드
	private String workDename;       //작업반명
	private String workDedesc;       //작업반 설명
	private String proCode;          //공정 코드
	private String inWh;             //입고창고 코드
	private String outWh;            //출고창고 코드
	private String perWh;            //실적공정 코드
	private String sortFlag;         //정렬순서
	private String remark;           //비고
	private String userFlag;         //사용유무
	private String makeDate;         //등록일
	private String maker;            //등록자
	private String editDate;         //수정일
	private String editor;           //수정자
	
	private boolean __created__;
	private boolean __modified__;
}
