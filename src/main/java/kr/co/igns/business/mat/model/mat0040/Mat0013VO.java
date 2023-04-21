package kr.co.igns.business.mat.model.mat0040;

import lombok.Data;

@Data
public class Mat0013VO {
	private String comCode;		//회사코드
	private String facCode;		//공장코드
	private String regiDate;	//등록일
	private String ilno;		//일련번호
	private String inType;		//입고구분
	private String inCate;		//입고유형
	private String custCode;	//거래처코드
	private String partNo;		//품번 코드
	private String inQty;		//입고량
	private String makeQty;		//구성량
	private String boxQty;		//BOX수량
	private String remark;		//비고
	private String printType;	//라벨출력 구분
	private String userFlag;	//사용유무
	private String makeDate;	//등록일
	private String maker;		//등록자
	private String editDate;	//수정일
	private String editor;		//수정자
	private String sumQty;		//총수량
	private String inWh; 	//입고창고코드
	private String inWhNm;		//입고창고명
	
	//기타/사급자재 입고 상세
	private String no;			//순번
	private String lotNo;		//기타입고 LOT NO
	private String lotDetail;	//기타입고 전산번호
	private String qty;			//수량
	
	//품번 정보
	private String partName;
	private String spec;
	private String lotSize;
	
	//재고 정보 마스터
	private String price;
	private String inAmount;
	private String stockQty;

	private boolean __created__;
	private boolean __modified__;
	
}
