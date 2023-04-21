package kr.co.igns.business.pop.model;

import java.util.List;

import lombok.Data;

@Data
public class Pro0025ReqDto {
	private String comCode;
	private String comName;
	private String facCode;
	private String ilNo;
	private String whCode;
	private String workNo;
	private String workDate;
	private String workCode;
	private String workDeCode;
	private String workType;
	private String pathCode;
	private String proType;
	private String defCode;
	private String partNo;
	private String qty;
	private String eventCd;
	private String lotNo;
	private String lotDetail;
	private String printCnt;
	private String cancelFlag;
	private String userFlag;
	private String userId;
	private String orderState;
	private String inputQty;
	private String box;
	
	private String frDate;
	private String toDate;
	
	private String repType;
	private List<Pro0025VO> detailData;

}
