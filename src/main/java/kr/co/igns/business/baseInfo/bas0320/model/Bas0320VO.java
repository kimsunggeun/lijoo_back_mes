package kr.co.igns.business.baseInfo.bas0320.model;

import lombok.Data;

@Data
public class Bas0320VO {
	private int id;
	private String comCode;
	private String currDate;
	private String currCode;
	private String currName;
	private double price;
	private String makeDate;
	private String maker;
	private String editDate;
	private String editor;
	
	private boolean __created__;
	private boolean __modified__;
}
