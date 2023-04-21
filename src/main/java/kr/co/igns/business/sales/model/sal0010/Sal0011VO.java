package kr.co.igns.business.sales.model.sal0010;

import lombok.Data;

@Data
public class Sal0011VO {
	private String id;
	private String comCode;		//회사코드
	private String facCode;     //공장코드
	private String ordNo;       //수주번호(일련번호)
	private String no;    		//순번
	private String deliDate;	//예상납기일
	private String partNo;		//품번 코드
	private String qty;    		//수주량
	private String outQty;    	//출하량
	private String nowQty;    	//잔량
	private String planQty;    	//계획량
	private String price;    	//단가
	private String amount;    	//금액
	private String remark;      //비고
	private String makeDate;    //등록일
	private String maker;       //등록자
	private String editDate;    //수정일
	private String editor;      //수정자
	
	private boolean __created__;
	private boolean __modified__;
	
	private String maxNo;		//순번 자동부여
}
