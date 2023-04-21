package kr.co.igns.business.mat.model.mat0050;

import lombok.Data;

@Data
public class Mat0021VO {
	private String comCode;			//회사코드
	private String facCode;			//공장코드
	private String locCode;			//창고위치코드
	private String stockType;		//재고구분(품목구분)
	private String eventCd;			//재고이벤트명
	private String partNo;			//품번코드
	private String stockQty;		//재고수량
	private String stockAmount;		//재고금액
	private String regiDate;		//등록익
	private String lotNo;			//LOT NO
	private String lotDetail;		//전산번호
	private String userFlag;		//사용유무
	private String makeDate;		//등록일
	private String maker;			//등록자
	private String editDate;		//수정일
	private String editor;			//수정자
	private String outQty;			//출고수량
	private String selectType;		//불량선별 구분		
	private String retAmount;		//반품수량
	private String retQty;
	private String inPrice;
}
