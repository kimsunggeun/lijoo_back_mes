package kr.co.igns.business.baseInfo.bas0230.model;

import lombok.Data;

@Data
//품목정보
public class Bas0230VO_ITEM {
	private String id;            //아이디
	private String comCode;       //회사코드
	private String partNo;        //품번
	private String partName;      //품명
	private String spec;          //규격
	private String bomOx;		  //BOM 존재유무     
	                              
	private boolean __created__;
	private boolean __modified__;
}
