package kr.co.igns.business.out.model.out0120;

import lombok.Data;

@Data
public class Out0120VO{
	private String comCode;	     //회사코드
	private String facCode;	     //공장코드
	private String custCode;	     //거래차코드
	private String ilno;	     //작업 일련번호
	private String workNo;	     //작업지시번
	private String lotDetail;    //공정실적 전산번호
	private String inDate;	     //납품일자
	private String inIlno;	     //납품번호(일련번호)
	private String inNo;         //납품 순번
	private String nextProcNo;   //다음공정명
	private String lotNo;	     //공정외주 입고 로트번호
	private String outLotDetail; //공정외주 입고 전산번호
	private String proType;		 //납품구분(생산구분)
	private String partNo;       //품번 코드
	private String qty;			 //납품수량
	private String inPrice;		 //가공비 단가
	private String inAmount;	 //가공비 금액
	private String outInspCode;	 //공정외주검사 진행상태 코드
	private String remark;		 //비고
	private String printType;	 //라벨출력 구분
	private String userFlag;     //사용유무
	private String makeDate;     //등록일
	private String maker;        //등록자
	private String editDate;     //수정일
	private String editor;       //수정자
	
	private boolean __created__;
	private boolean __modified__;
	
}
