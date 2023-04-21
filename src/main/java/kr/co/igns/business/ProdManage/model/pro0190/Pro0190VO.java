package kr.co.igns.business.ProdManage.model.pro0190;

import lombok.Data;

@Data
public class Pro0190VO {
	private String comCode;    		//회사코드
	private String facCode;    		//공장코드
	private String ilno;			//일련번호
	private String workNo;    		//작업지시번호
	private String lotDetail;    	//생산 전산번호
	private String inDate;    		//투입일자
	private String inLotDetail;    	//투입 전산번호
	private String inPartNo;    	//투입품번
	private String inPartName;    	//투입품명
	private String inQty;    		//투입수량
	private String workCode;    	//작업장 코드
	private String workDecode;    	//작업반코드
	private String proType;    		//생산 구분
	private String defCode;    		//불량코드
	private String partNo;			//품번
	private String partName;		//품명
	private String qty;				//수량
	private String eventCd;			//작업명
	private String lotNo;			//LOT
	private String printCnt;		//라벨발행횟수
	private String cancelFlag;		//작업취소유무
	private String whCode;			//창고
	private String worker;			//작업자
	private String makeDate;    	//등록일
	private String maker;    		//등록자
	private String editDate;    	//수정일
	private String editor;    		//수정자

	private boolean __created__;
	private boolean __modified__;
}
