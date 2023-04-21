package kr.co.igns.business.mat.model.mat0091;

import java.util.List;

import lombok.Data;

@Data
public class Mat0091VO {
										
	private String id;			//순번
	private String comCode;		//회사코드
	private String facCode;		//공장코드
	private String regiDate;	//등록일
	private String planDate;	//산출일
	private String partNo;		//품번코드
	private String stockQty;	//재고수량
	private String currQty;		//현재고수량
	private String reqQty;		//소진수량
	private String expQty;		//미입고수량
	private String lackQty;		//부족수량
	private String sumQty;		//소진/미입고수량 합계
	private String formDate;	//산출 시작일
	private String toDate;		//산출 종료일
	private String userFlag;	//사용유무
	private String makeDate;	//등록일
	private String maker;		//등록자
	private String editDate;	//수정일
	private String editor;		//수정자
	
//	private boolean __created__;
//	private boolean __modified__;
}
