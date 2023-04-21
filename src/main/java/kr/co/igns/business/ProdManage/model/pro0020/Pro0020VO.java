package kr.co.igns.business.ProdManage.model.pro0020;

import lombok.Data;

@Data
public class Pro0020VO {
	private String id;                  //그리드 id
	private String no;                  //no
	private String maxIlNo;             //maxIlNo
	private String comCode;				//회사코드
	private String facCode;				//공장코드
	private String ilno;				//일련번호
	private String partNo;				//품번코드
	private String partName;			//품명
	private String regiDate;			//등록일
	private String planDate;			//계획일
	private String planQty;				//계획수량
	private String prePlanQty;			//이전 계획수량
	private String workNo;				//작업지시번호
	private String woCnt;				//작지수량
	private String userFlag;			//사용유무
	private String makeDate;			//등록일
	private String maker;				//등록자
	private String editDate;			//수정일
	private String editor;				//수정자
	
	private boolean __created__;
	private boolean __modified__;
}
