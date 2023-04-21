package kr.co.igns.business.ProdManage.model.pro0110;

import lombok.Data;

@Data
public class Pro0110VO {
	private String comCode;
	private String planDate;			//공장 코드
	private String workCrew;			//작업조 코드
	private String WorkCode;			//작업장 코드
	private String WorkDecode;			//작업반 코드
	private String workDecodeName;		//작업반명
	private String workNo;				//작업지시번호
	private String orderState;			//작업지시 상태 코드
	private String priCode;				//우선순위코드
	private String partNo;				//품번 코드
	private String partName;			//품번명
	private String itemType;			//품목군
	private String partType;			//제품군
	private String partSpec;			//품번 스펙
	private String lotNo;				//생산 lot
	private String unit;				//단위
	private String orderQty;			//지시량
	private String qty;					//생산수량
	private String proRate;				//진척율
	private String remark;
	private String makeDate;
	private String maker;
	private String editDate;
	private String editor;
}
