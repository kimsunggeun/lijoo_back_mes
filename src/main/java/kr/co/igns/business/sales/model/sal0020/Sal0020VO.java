package kr.co.igns.business.sales.model.sal0020;

import lombok.Data;

@Data
public class Sal0020VO {	
	private String id;	
	private String comCode;
	private String facCode;	
	private String ordNo;
	private String ordDate;
	private String no;
	private String deliDate;
	private String partNo;
	private String partName;
	private String custCode;
	private String custName;
	private String remark;
	private String ordSate;
	private String qty;
	private String maxOrdNo;
	
	private String makeDate;    //등록일
	private String maker;       //등록자
	private String editDate;    //수정일
	private String editor;      //수정자

}
