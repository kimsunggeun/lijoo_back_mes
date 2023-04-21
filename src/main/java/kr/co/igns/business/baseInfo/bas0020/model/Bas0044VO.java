package kr.co.igns.business.baseInfo.bas0020.model;

import lombok.Data;

@Data
public class Bas0044VO {
	
	private String id;         	//그리드 id
	private String comCode;    	//회사코드
	private String custCode;   	//거래처 코드
	private String partNo;  	//품목코드
	private String remark;   	//비고
	
	private String userFlag;
	
	private String makeDate;
	private String maker;

}
