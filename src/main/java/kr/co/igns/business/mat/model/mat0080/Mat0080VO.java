package kr.co.igns.business.mat.model.mat0080;

import lombok.Data;

@Data
public class Mat0080VO {
	private String id;
	private String comCode;		//회사코드
	private String facCode;		//공장코드
	private String custCode;	//거래처코드
	private String custName;	//거래처명(납품처)
	private String regiDate;	//발주일
	private String deliDate;	//납기일
	private String partNo;		//품번
	private String partName;	//품명
	private String no;
	
	private int qty;			//발주수량
	private String ordNo;		//발주번호
	private String ordState;	//발주상태
	private String maxOrdNo;
	
	private String spec;		//규격
	private String unit;		//단위코드
	private int price;			//단가
	private String amount;		//금액
	private String inQty;		//입고량
	private String remQty;		//잔량
	private String retQty;		//반품량
	private String userFlag;	//사용유무
	
	private String makeDate;    //등록일
	private String maker;       //등록자
	private String editDate;    //수정일
	private String editor;      //수정자

}
