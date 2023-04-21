package kr.co.igns.business.mat.model.mat0020;

import lombok.Data;

@Data
public class Mat0011VO {
	private String id;			//아이디
	private String comCode;		//회사코드
	private String facCode;		//공장코드
	private String facName;		//공장코드
	private String ordNo;		//발주번호
	private String no;			//순번
	private String regiDate;	//등록일
	private String deliDate;	//납기일
	private String partNo;		//품번 코드
	private String partName;	//품명
	private String spec;		//규격
	private String stockQty;	//현재고량
	private String qty;			//발주수량
	private String price;		//단가
	private String amount;		//금액
	private String inQty;		//입고량
	private String remQty;		//잔량
	private String inInsp;	//입고상태
	private String retQty;		//반품량
	private String userFlag;	//사용유무
	private String makeDate;	//등록일
	private String maker;		//등록자
	private String editDate;	//수정일
	private String editor;		//수정자
	private String lotSize;		//로트크기
	private String inWh;		//입고창고
	private String partType;	//제품군코드
	private String waitQty;		//입고대기
	private String custCode;
	private String custName;
	private String ordState;
	
	private boolean __created__;
	private boolean __modified__;
}
