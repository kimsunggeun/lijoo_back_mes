package kr.co.igns.business.mat.model.mat0050;

import lombok.Data;

@Data
public class Mat0030VO {
	private String id;
	private String comCode;		//회사코드
	private String facCode;		//공장코드
	private String retDate; 	//입고일
	private String ilno;		//입고번호(일련번호)
	private String no;			//일련번호 순번
	private String ordNo;		//수주번호
	private String lotNo;		//입고 LOT NO
	private String lotDetail;	//입고 전산번호
	private String retCode;		//반품사유코드
	private String retQty;		//반품수량
	private String remark;		//비고
	private String retNo;		//반품번호
	private String maker;		//등록자
	private String make_date;	//등록일자
	private String editor;		//수정자
	private String edit_date;	//수정일자
	private String retAmount;	//반품금액
	private String inPrice;
}

