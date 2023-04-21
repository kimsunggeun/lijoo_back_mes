package kr.co.igns.business.mat.model.mat0110;

import lombok.Data;

@Data
public class Mat0110VO {
	private String id;			//아이디
	private String comCode;		//회사코드
	private String facCode;		//공장코드
	private String locCode;		//창고위치 코드
	private String locName;		//창고위치 이름
	private String itemType;	//품목군
	private String partType;	//제품군
	private String partNo;		//품번
	private String partName;	//품명
	private String lotNo;		//LOT NO
	private String lotDetail;	//전산번호	
	private String regiDate;	//실사일
	private String regiNo;		//실사횟수
	private String stockQty;	//전산수량
	private String realQty;		//실사수량
	private String realState;	//실사상태
	private String stockType;	//재고유형	
	private String regiType;	//등록구분
	private String printType;	//라벨출력 구분
	private String userFlag;	//사용유무
	private String remark;		//비고
	private String makeDate;	//등록일
	private String maker;		//등록자
	private String editDate;	//수정일
	private String editor;		//수정자
	
	private boolean __created__;
	private boolean __modified__;
}
