package kr.co.igns.business.pop.model;

import lombok.Data;

@Data
public class Pop0020VO {
	private String id;
	private String comCode; 	//회사코드
	private String facCode;		//공장코드
	private String custCode;	//거래처코드
	private String custName;
	private String no;			//순번
	private String regiDate;	//입고일
	private String inType;		//입고구분
    private String makeQty;		//구성량
    private String boxQty;		//BOX수량
	private String ordNo;		//발주번호
	private String deliDate;	//납기일
	private String partNo;		//품번
	private String partName;	//품명
	private String stockQty;
	private String qty;			//수량
	private String price;		//단가
	private String inAmount;	//합계 금액-mat0012
	private String amount;		//합계 금액
	private String inQty;		//입고량
	private String remQty;		//잔량
	private String userFlag;	//사용유무
	private String lotSize;		//로트 크기
	private String lotNo;		//로트번호
	private String inWh;		//창고 위치
	private String inInsp;		//입고검사  여부
	private String ilno;		//일련번호
	private String lotDetail;	//입고 전산번호
	private String inInspYn;	//입고대기 유무
	private String inStatus;	//입고상태
	private String serialNo;	//시리얼번호
	private String maker;		//작성자
	private String partType;	//재고구분
	private String waitQty;		//입고대기
}