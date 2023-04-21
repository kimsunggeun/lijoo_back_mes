package kr.co.igns.business.sales.model.sal0210;

import lombok.Data;

@Data
public class Sal0210VO {
	private String comCode;			//회사코드
	private String facCode;         //공장코드
	private String ordNo;           //수주번호
	private String ordDate;         //수주일
	private String custCode;		//거래처코드
	private String custName;		//거래처명
	private String deliDate;		//예상납기일	
	private String no;    		    //수주순번
	private String itemType;		//품목군
	private String partType;		//제품군	
	private String partNo;			//품번
	private String partName;		//품명
	private String partSpec;		//규격
	private String partUnit;		//단위	
	private String qty;				//수주량
	private String outQty;			//출하량
	private String nowQty;			//잔량
	private String planQty;			//계획량
	private String price;			//단가
	private String amount;			//금액
	private String ordState;		//수주상태
	private String remark;          //수주상세비고
	private String makeDate;		//등록일
	private String maker;			//등록자
	private String editDate;        //수정일
	private String editor;          //수정자
	
	private boolean __created__;
	private boolean __modified__; 
}
