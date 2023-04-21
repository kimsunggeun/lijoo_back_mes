package kr.co.igns.business.baseInfo.bas0310.model;

import lombok.Data;

@Data
public class Bas0310VO {
	//거래처정보
	private String comCode;
	private String custCode;
	private String custName; 
	private String custType;
	private String custTypeNm;
	private String matType;
	private String matTypeNm;
	
	//품목정보
	private String partNo;
	private String partName;
	private String partSpec;
	private String remark;
	private String userFlag;
	private String makeDate;          //등록일
	private String maker;              //등록자
	private String editDate;          //수정일
	private String editor;             //수정자
	
	private boolean __created__;
	private boolean __modified__;
}
