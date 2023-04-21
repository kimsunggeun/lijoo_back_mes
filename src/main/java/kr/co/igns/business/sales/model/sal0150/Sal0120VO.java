package kr.co.igns.business.sales.model.sal0150;

import lombok.Data;

@Data
public class Sal0120VO {
	private String id;
	private String comCode;			//회사코드
	private String facCode;         //공장코드
	private String ordNo;           //수주번호
	private String ilno;    	    //일련번호
	private String no;    		    //출하순번
	private String outDate;			//출하일
	private String custCode;		//거래처코드
	private String partNo;			//품번코드
	private String lotNo;           //출하 LOT
	private String lotDetail;       //출하 전산번호
	private String qty;				//수량
	private String price;			//단가
	private String amount;			//금액
	private String closeMonth;		//마감월
	private String closeYn;			//마감여부
	private String confirmYn;		//마감확정여부
	private String remark;          //비고
	private String makeDate;		//등록일
	private String maker;			//등록자
	private String editDate;        //수정일
	private String editor;          //수정자
	
	private boolean __created__;
	private boolean __modified__;
}
