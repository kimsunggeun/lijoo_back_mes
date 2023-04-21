package kr.co.igns.business.pop.model;

import lombok.Data;

@Data
public class Pop0040VO {
	private String id;          //아이디
	private String comCode;		//회사코드
	private String facCode;		//공장코드
	private String locCode;		//창고위치코드
	private String locName;		//창고위치명
	private String lotSize;		//로트크기
	private String stockType;	//재고구분
	private String eventCd;		//재고이벤트명
	private String partNo;		//품번코드
	private String partName;	//품명
	private String stockQty;	//재고수량
	private String stockAmount;	//재고금액
	private String regiDate;	//재고등록일
	private String lotNo;		//LOT NO
	private String lotDetail;	//전산번호
	private String userFlag;	//사용유무
	private String makeDate;	//등록일
	private String maker;		//등록자
	private String editDate;	//수정일
	private String editor;		//수정자
	private String inWh;		//입고창고
	private String spec;		//규격
	
	private String newLocCode;		//새로운 창고코드
	private String mat0020Qty;		//mat0020의 재고량
	private String mat0020Amount; 	//mat0020의 재고금액
	
}
