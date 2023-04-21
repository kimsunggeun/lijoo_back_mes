package kr.co.igns.business.sales.model.sal0120;

import lombok.Data;

@Data
public class Sal0012VO {
	
	private String id;
	private String comCode;			// 회사코드
	private String facCode;			// 공장코드
	private String ordNo;			// 수주번호
	private String no;				// 수주순번
	private String ordTurn;			// x
	private String ordDate;			// 수주일
	private String custCode;		// 거래처코드
	private String custName;		// 거래처명
	private String ordState;		// 상태코드	
	private String deliDate;		// 납기일
	private String partNo;			// 품번
	private String partName;		// 품명
	private String qty;				// 수주량
	private String outQty;			// 출하량
	private String nowQty;			// 잔량
	private String planQty;			// 계획량
	private String price;			// 단가
	private String amount;			// 금액
	private String outInspYn;		// 출하검사유무
	private String remark;			// 비고
	private String makeDate;		// 등록일
	private String maker;			// 등록자
	private String editDate;		// 수정일
	private String editor;			// 수정자

}
