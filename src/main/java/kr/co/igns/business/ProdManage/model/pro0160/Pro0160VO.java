package kr.co.igns.business.ProdManage.model.pro0160;

import lombok.Data;

@Data
public class Pro0160VO {
	private String comCode;    		//회사코드
	private String facCode;    		//공장코드
	private String ilno;			//일련번호
	private String workNo;    		//작업지시번호
	private String workDate;    	//생산일
	private String workCode;    	//작업장 코드
	private String workDecode;    	//작업반코드
	private String proType;			//생산구분코드
	private String defCode;			//불량코드
	private String partNo;			//품번
	private String partName;		//품명
	private String qty;    			//수량
	private String eventCd;    		//작업명 코드(이벤트)
	private String lotNo;    		//생산LOT
	private String lotDetail;    	//생산 전산번호
	private String printCnt;  		//라벨발행 횟수
	private String cancelFlag;    	//작업취소 유무
	private String userFlag;    	//사용유무
	private String makeDate;    	//등록일
	private String maker;    		//등록자
	private String editDate;    	//수정일
	private String editor;    		//수정자

	private boolean __created__;
	private boolean __modified__;
}
