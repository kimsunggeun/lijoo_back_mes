package kr.co.igns.business.ProdManage.model.pro0050;

import lombok.Data;

@Data
public class Pro0050VO {
	private String comCode;    		//회사코드
	private String facCode;    		//공장코드
	private String workNo;    		//작업지시번호
	private String planDate;    	//계획일
	private String workDate;    	//생산일
	private String workCode;    	//작업장 코드
	private String workName;    	//작업장명
	private String workDecode;		//작업반 코드
	private String workDeName;    	//작업반명
	private String orderState;		//작업지시 상태 코드
	private String orderStateNm;
	private String priCode;			//우선순위코드
	private String priCodeNm;
	private String pathCode;    	//경로코드
	private String pathName;		//경로코드 이름
	private String workCrew;    	//작업조 코드
	private String itemType;		//제품군
	private String partType;		//품목군
	private String partNo;    		//품번
	private String partName;    	//품명
	private String partSpec;    	//스펙
	private String orderQty;    	//지시량
	private String lotNo;    		//생산 LOT
	private String remark;    		//비고
	private String planNo;    		//생산계획 번호
	private String btnOrderState; //작업지시 상태
	private String preProCode;
	private String preQty;
	private String proCode;
	private String qty;
	private String makeDate;    	//등록일
	private String maker;    		//등록자
	private String editDate;    	//수정일
	private String editor;    		//수정자
	
	private boolean __created__;
	private boolean __modified__;
}
