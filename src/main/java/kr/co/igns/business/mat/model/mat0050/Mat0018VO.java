package kr.co.igns.business.mat.model.mat0050;

import lombok.Data;

@Data
public class Mat0018VO {

	private int id;		
	private String comCode;		//회사코드
	private String facCode;		//공장코드
	private String lotNo;		//구매입고 LOT NO
	private String lotDetail;	//구매입고 전산번호
	private String qty;			//수량
	private String retQty;		//반품량
	private String stockQty;    //재고량
	private String ilno;		//입고번호(일련번호)
	private String ordNo;		//발주번호
	private String no;			//순번
	private String regiDate;	//입고일
	private String inStatus;    //입고상태
	private String retAmount;
}
