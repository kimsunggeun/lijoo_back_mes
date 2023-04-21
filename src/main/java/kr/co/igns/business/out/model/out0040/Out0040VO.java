package kr.co.igns.business.out.model.out0040;

import lombok.Data;

@Data
public class Out0040VO{
	private String id;					//id
	private String num;					//
	private String comCode;    			//회사코드
	private String facCode;    			//공장코드
	private String ilno;				//일련번호
	private String workNo;    			//작업지시번호
	private String lotDetail;    		//공정실적 전산번호
	private String custCode;			//거래처코드
	private String inDate;				//납품일자
	private String inIlno;				//납품번호(일련번호)
	private String inNo;				//납품 순번
	private String nextProcNo;			//다음 공정명
	private String lotNo;    			//공정실적 LOT
	private String outLotDetail;		//공정외주 입고 전산번호
	private String proType;				//생산 구분 코드
	private String partNo;    			//품번
	private String qty;    				//수량
	private String inPrice;				//가공비 단가
	private String inAmount;			//가공비 금액
	private String outInspCode;			//공정외주검사 진행상태 코드
	private String remark;				//비고
	private String printType;			//라벨출력 구분
	private String userFlag;    		//사용유무
	private String makeDate;    		//등록일
	private String maker;    			//등록자
	private String editDate;    		//수정일
	private String editor;    			//수정자
}
