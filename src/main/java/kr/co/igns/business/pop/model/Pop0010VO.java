package kr.co.igns.business.pop.model;

import lombok.Data;

@Data
public class Pop0010VO {
	private String comCode;		//회사코드
	private String facCode;		//공장코드
	private String ordNo;		//발주번호
	private String no;			//순번
	private String regiDate;	//입고일
	private String ilno;		//입고번호(일련번호)
	private String partNo;		//품번 코드
	private String partName;	//품명
	private String qty;			//발주수량
	private String inQty;		//입고량
	private String makeQty;		//구성량
	private String boxQty;		//BOX수량
	private String inPrice;		//입고단가
	private String inAmount;	//입고금액
	private String remQty;		//잔량
	private String remark;		//비고
	private String printType;	//라벨출력 구분
	private String userFlag;	//사용유무
	private String makeDate;	//등록일
	private String maker;		//등록자
	private String editDate;	//수정일
	private String editor;		//수정자
	private String inStatus;	//입고상태
	private String preWhCode;	//이전 창고 코드
	private String lotNo;
	private String deliDate;	//
	private String status;		//
	private String serialNo;
	private String lotDetail;	//
	private String inWh;		//
	private String partType;	//제품군
	private String stockAmount;	//
	private String eventCd;		//재고이벤트명
	private String inType;		
	private String custCode;	//거래처코드
	private String inInsp;		//입고검사 유무
	private String locCode;	
	private String supplyYn;
}
