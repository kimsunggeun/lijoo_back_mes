package kr.co.igns.business.sales.model.sal0220;

import lombok.Data;

@Data
public class Sal0220VO {
	private String comCode;			//회사코드
	private String facCode;         //공장코드
	private String ordNo;           //수주번호
	private String ordTurn;			//수주순번
	private String ilNo;			//출하일련번호	
	private String no;    		    //출하순번	
	private String outDate;         //출하일
	private String outInspYn;		//출하검사여부
	private String custCode;		//거래처코드
	private String custName;		//거래처명
	private String itemType;		//품목군
	private String partType;		//제품군	
	private String partNo;			//품번
	private String partName;		//품명
	private String spec;			//규격
	private String unit;			//단위	
	private String lotNo;			//출하LOT
	private String lotDetail;		//전산번호
	private String locCode;			//위치코드
	private String qty;				//출하량
	private String stockQty;		//재고량
	private String price;			//단가
	private String amount;			//금액
	private String closeMonth;		//마감월
	private String closeYn;         //마감여부
	private String confirmYn;		//마감확정여부
	private String remark;			//비고
	private String makeDate;		//등록일
	private String maker;			//등록자
	private String editDate;        //수정일
	private String editor;          //수정자
	
	private boolean __created__;
	private boolean __modified__; 
}
