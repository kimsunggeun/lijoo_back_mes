package kr.co.igns.business.baseInfo.bas0260.model;

import lombok.Data;

@Data
//예비품별 자원정보
public class Bas0260DetailVO {
	private String id;
	private String comCode;
	private String facCode;
	private String jobType;
	private String partNo;
	private String eqCode;
	private String userFlag;
	private String makeDate;
	private String maker;
	private String editDate;
	private String editor;
	
	private boolean __created__;
	private boolean __modified__;
}
