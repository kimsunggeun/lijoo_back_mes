package kr.co.igns.business.pop.model;

import java.util.List;

import lombok.Data;

@Data
public class Pro0021VO {
	private String comCode;
	private String facCode;
	private String workCode;
	private String workDecode;
	private String workDename;
	private String ilno;
	private String workType;
	private String metGbn;
	private String workCrew;
	private String workDate;
	private String workTime;
	private String worker;
	private String workerName;
	private String whCode;
	private String workNo;
	private String lotNo;
	private String lotSize;
	private String remark;
	private String makeDate;
	private String maker;
	private String makeTime;
	private String editDate;
	private String editor;
	private String newIlno;
	
	private String partNo;
	private String partName;
	private String pathCode;
	private String pathName;
	private String orderQty;
	private String planQty;	
	private String success = "true";
	
	//작업자
	private List<String> userId;
}
