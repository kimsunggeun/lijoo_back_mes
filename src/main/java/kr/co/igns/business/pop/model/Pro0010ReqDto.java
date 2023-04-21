package kr.co.igns.business.pop.model;

import java.util.List;

import lombok.Data;

@Data
public class Pro0010ReqDto {
	private String comCode;
	private String facCode;
	private String planDate;
	private String workCrew;
	
	private String workCode;
	private String workDecode;
	
	private String workNo;    		//작업지시번호
	private String lotNo;    		//생산 LOT	
	private String workDate;		//작업일
	private String orderState;
	private String btnOrderState;
	private String ilno;
	private List<String> userId;
	//private String userId;
}
