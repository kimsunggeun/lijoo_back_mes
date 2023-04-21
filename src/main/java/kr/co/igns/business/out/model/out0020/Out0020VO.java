package kr.co.igns.business.out.model.out0020;

import lombok.Data;

@Data
public class Out0020VO{
	private String comCode;		//회사코드
	private String facCode;		//공장코드
	private String ilno;		//발주번호(일련번호)
	private String no;			//발주 순번
	private String inIlno;		//입고번호(일련번호)
	private String inNo;		//입고 순번
	private String pathCode;	//경로코드(라우팅)
	private String procNo;		//공정순서(코드)
	private String lotNo;		//공정외주 입고 로트번호
	private String lotDetail;	//공정외주 입고 전산번호
	private String partNo;		//품번 코드
	private String qty;			//발주량
	private String inQty;		//입고량
	private String makeQty;		//구성량
	private String boxQty;		//BOX수량
	private String remQty;		//잔량
	private String inPrice;		//입고단가
	private String inAmount;	//입고금액
	private String outInspCode;	//공정외주검사 진행상태 코드
	private String remark;		//비고
	private String printType;	//라벨출력 구분
	private String userFlag;	//사용유무
	private String makeDate;	//등록일
	private String maker;		//등록자
	private String editDate;	//수정일
	private String editor;		//수정자
	
	private boolean __created__;
	private boolean __modified__;
	
}
