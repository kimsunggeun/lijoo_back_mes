package kr.co.igns.business.pop.model;

import lombok.Data;

@Data
public class Pop0030VO {
	
	private String comCode;		//회사코드
	private String facCode;		//공장코드
	
	private String regiDate;	//등록일
	private String ilno;		//일련번호
	private String lotNo;		//LotNo
	
	private String inType;		//입고구분
	private String inCate;		//입고유형
	
	private String custCode;	//거래처코드
	private String partNo;		//품목
	private String partName;	//품명
	
	private String inQty;		//입고량
	private String makeQty;		//구성량
	private String boxQty;		//BOX수량
	
	private String remark;		//비고
	
	private String printType;	//라벨출력구분
	private String userFlag;	//사용유무
	
	private String makeDate;
	private String maker;
	private String editDate;
	private String editor;

}
