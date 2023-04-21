package kr.co.igns.business.sales.model.sal0230;

import lombok.Data;

@Data
public class Sal0230VO {
	private String id;
	private String comCode;			//회사코드
	private String facCode;			//공장코드
	private String comName;			//회사명
	private String facName;			//공장명
	private String ilno;			//일련번호
	private String custCode;		//거래처코드
	private String partNo;
	private String partName;
	private String lotNo;			//출하 LOT
	private String lotDetail;		//출하 전산번호
	private String retNo;			//반품번호
	private String retDate;			//반품일자
	private String retLotNo;		//반품 LOT
	private String retLotDetail;	//반품 전산번호
	private String retCode;			//반품구분
	private String retType;			//반품불량사유
	private String locCode;			//반품 창고코드
	private String retQty;			//반품수량
	private String remark;			//비고
	private String makeDate;		//등록일
	private String maker;			//등록자
	private String editDate;		//수정일
	private String editor;			//수정자
}
