package kr.co.igns.business.mat.model.mat0270;

import lombok.Data;

@Data
public class Mat0270VO {
	private String comName;		//회사명
	private String facName;		//공장명
	private String whCode;		//창고코드
	private String inType;		//입고구분
	private String regiDate;	//입고일
	private String retDate;		//반품일
	private String ilno;		//입고번호(일련번호)
	private String no;			//일련번호 순번
	private String partNo;		//품번코드
	private String partName;	//품명
	private String lotNo;		//입고 LOT NO
	private String lotDetail;	//입고 전산번호
	private String inQty;		//입고수량
	private String qty;			//현재고
	private String retCode;		//반품사유코드
	private String retQty;		//반품수량
	private String retAmount;	//반품금액
	private String remark;		//비고
	private String printType; 	//라벨출력 구분
	private String userFlag; 	//사용유무
	private String makeDate; 	//등록일
	private String maker; 		//등록자
	private String editDate; 	//수정일
	private String editor; 		//수정자
	private String ordNo;		//수주번호
	
}
