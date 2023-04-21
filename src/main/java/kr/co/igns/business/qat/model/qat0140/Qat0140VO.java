package kr.co.igns.business.qat.model.qat0140;

import lombok.Data;

@Data
public class Qat0140VO {
	private String id;
	private String comCode;			//회사코드
	private String facCode;			//공장코드
	private String ordNo;			//수주번호
	private String ilno;			//일련번호
	private String no;				//출하순번
	private String lotNo;			//출하 LOT
	private String lotDetail;		//출하 전산번호
	private String retLotNo;		//반품 LOT
	private String retLotDetail;	//반품 전산번호
	private String retCode;			//반품구분 코드
	private String retType;			//반품불량사유 코드
	private String whCode;			//반품 창고코드
	private String partNo;			//품번 코드
	private String retQty;			//반품수량
	private String remark;			//비고
	private String makeDate;		//등록일
	private String maker;			//등록자
	private String editDate;		//수정일
	private String editor;			//수정자

	
	private boolean __created__;
	private boolean __modified__;
}
