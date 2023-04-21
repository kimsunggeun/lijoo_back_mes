package kr.co.igns.business.qat.model.qat0060;

import lombok.Data;

@Data
public class Qat0060VO {
	private String id;
	private String comCode;		//회사코드
	private String facCode;		//공장코드
	private String ordNo;		//수주번호
	private String ilno;		//일련번호
	private String no;			//출하순번
	private String outDate;
	private String custName;
	private String custCode;
	private String partNo;
	private String partName;
	private String partType;
	private String spec;
	private String qty;
	private String unit;
	
	private String locCode;
	private String locName;
	private String lotNo;
	private String lotDetail;
	
	// 출하검사
	private String inspNo;
	private String insType;
	private String insCode;
	private String insUpp;
	private String insLow;
	private String insBase;
	private String insMeth;
	private String jugCodeh;
	private String insUnit;
	private String judge;
	private String sample1;
	private String sample2;
	private String sample3;
	private String sample4;
	private String sample5;
	private String serialNo;
	private String remark;
	private String inspTime;
	private String inspDate;
	private String dlvNo;
	private String maxIlno;
	private String insCnt;
	private String poNo;
	private String poSeq;
	private String dlvSeq;
	
	
	private String makeDate;
	private String maker;
	private String editDate;
	private String editor;
	private String sysName;
	private boolean __created__;
	private boolean __modified__;
}
