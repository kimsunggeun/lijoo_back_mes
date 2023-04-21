package kr.co.igns.business.eqp.model.eqp0050;

import lombok.Data;

@Data
public class Eqp0050VO {
	//수리내역
	private String comCode;
	private String facCode;
	private String eqCode;
	private String repNo;    
	private String regDate;	
	private String occDate;
	private String actDate;
	private String repRemark;	
	private String repCust;
	private String worker;    
	private String repAmount;	
	private String remark;	
	
	//검사항목
	private String inspDate;
	private String eqInsType;
	private String veqCode;
	private String eqInspNo;
	private String eqInsCode;
	private String insType;
	private String insMeth;
	private String jugCode;
	private String insUnit;
	private String insBase;
	private String insUpp;
	private String insLow;
	private String judge;
	private String meaValue;
	
	//예비품 정보
	private String id;			//id
	private String jobType;		//자원구분
	private String partNo;			//품번
	private String partName;		//품명
	private String spec;			//규격
	private String qty;				//현재고
	private String safeQty;			//적정재고
	private String spareType;		//예비품 구분
	private String grade;			//등급
	private String unit;			//환종 코드
	private String price;			//단가
	private String amount;			//금액
	private String stockCode;		//보관위치
	private String spareImage;		//이미지
	private String spareImageBase64;
	private String contentType;
	
	private String userFlag;
	private String makeDate;	
	private String maker;
	private String editDate;
	private String editor;	
	
	private String maxRepNo;
	
	
	
	private boolean __created__;
	private boolean __modified__;

}
