package kr.co.igns.business.pop.model;

import lombok.Data;

@Data
public class Pop0120VO {
	private String comCode;			//회사코드
	private String facCode;			//공장코드
	private String custCode;		//거래처코드
	private String workNo;			//작업시지번호
	private String workDate;		//생산일
	private String inIlno;			//납품일련번호
	private String ilno;			//작업일련번호
	private String eventCd;			//작업명코드
	private String outLotDetail;	//공정외주입고 전산번호
	private String lotDetail;		//전산번호
	private String lotNo;			//공정실적 LOT
	private String qty;				//수량
	private String inQty;			//입고량
	private String partNo;			//품목코드
	private String outDeliQty;		//공정외주 납품수량
	private String outWaitDeliQty;	//공정외주 납품대기수량
	private String outYn;			//공정사용유무
	private String remark;			//비고
	private String whCode;			//창고코드
	private String userFlag;		//사용유무
	private String cancelFlag;		//취소유무
	private String outNonDeliQty;	//공정외주 납품잔량
	
	private String proType;			//납품구분
	private String maxLotDetail;
	
	private String maker;			//동록자
	private String makeDate;		//동록일
}
