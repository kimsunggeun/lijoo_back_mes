package kr.co.igns.business.sales.model.sal0120;

import lombok.Data;

@Data
public class Sal0120VO {
	private String id;
	private String comCode;			// 회사코드
	private String facCode;         // 공장코드
	private String ordNo;           // 수주번호
	private String ordTurn;			// 수주순번
	private String ordDate;			// 수주일
	private String ilno;    	    // 출하일련번호
	private String no;    		    // 출하순번
	private String outDate;			// 출하일
	private String outInspYn;		// 출하검사여부
	private String custCode;		// 거래처코드
	private String custName;		// 거래처명
	private String partNo;          // 품번코드
	private String partName;		// 품명
	private String lotNo;           // 출하LOT
	private String lotDetail; 		// 전산번호
	private String locCode;			// 위치코드
	private String stockQty;		// 출하전재고량
	private String outQty;			// 출하량
	private String nowQty;			// 잔량
	private String qty;				// 출하량
	private String price;			// 단가
	private String amount;			// 금액
	private String stockAmount;		// 재고단가 기준 출하금액 
	private String closeMonth;		// 마감월
	private String closeYn;			// 마감여부
	private String confirmYn;		// 마감확정여부
	private String remark;          // 비고
	private String makeDate;        // 등록일
	private String maker;           // 등록자
	private String editDate;        // 수정일
	private String editor;          // 수정자
}
