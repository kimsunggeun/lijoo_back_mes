package kr.co.igns.business.mat.model.mat0220;

import lombok.Data;

@Data
public class Mat0220VO {
	private String comCode;		//회사코드
	private String facCode;		//공장코드
	private String regiDate;	//등록일
	private String custName;	//거래처명
	private String ordNo;		//발주번호
	private String no;			//순번
	private String partNo;		//품번
	private String partName;	//품목
	private String partSpec;
	private String partUnit;
	private String qty;
	private String inQty;
	private String retQty;
	private String remQty;
	private String remRate;
	private String price;
	private String ordState;	//발주상태
	private String userFlag;	//사용유무
	private String makeDate;	//등록일
	private String maker;		//등록자
	private String editDate;	//수정일
	private String editor;		//수정자
	
	private boolean __created__;
	private boolean __modified__;
}
