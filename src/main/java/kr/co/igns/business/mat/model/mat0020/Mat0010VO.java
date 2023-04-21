package kr.co.igns.business.mat.model.mat0020;

import lombok.Data;

@Data
public class Mat0010VO {
	private String comCode;		//회사코드
	private String facCode;		//공장코드
	private String regiDate;	//등록일
	private String ordNo;		//발주번호
	private String custCode;	//거래처코드
	private String ordState;	//발주상태
	private String userFlag;	//사용유무
	private String makeDate;	//등록일
	private String maker;		//등록자
	private String editDate;	//수정일
	private String editor;		//수정자
	
	private boolean __created__;
	private boolean __modified__;
	
	private String maxOrdNo;	//
}
