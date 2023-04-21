package kr.co.igns.business.eqp.model.eqp0010;

import lombok.Data;

@Data
public class Eqp0010DetailVO {
	private String comCode;
	private String jobType;
	private String eqInsType;
	private String eqInsCode;
	private String eqInsName;	
	private String jugCode;	
	private String userFlag;
	private String makeDate;	
	private String maker;		
	private String editDate;	
	private String editor;	
	
	private boolean __created__;
	private boolean __modified__;
}
