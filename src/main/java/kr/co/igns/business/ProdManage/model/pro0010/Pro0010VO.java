package kr.co.igns.business.ProdManage.model.pro0010;

import lombok.Data;

@Data
public class Pro0010VO {
	private String comCode;				//회사코드
	private String facCode;				//공장코드
	private String ilno;				//일련번호
	private String partNo;				//품번코드
	private String regiDate;			//등록일
	private String frplanDate;			//계획일
	private String planDate;
	private String planQty;				//계획수량
	private String prePlanQty;			//이전 계획수량
	private String workNo;				//작업지시번호
	private String toplanDate;			//계획일2
	private String makeDate;			//등록일
	private String maker;				//등록자
	private String editDate;			//수정일
	private String editor;				//수정자
	
	private String planNo;				//생산게획번호
	private String workDate;			//생산일
	private String workCode;			//작업장
	private String workDecode;			//작업반
	private String orderState;			//작업지시상태
	private String orderQty;
	private String priCode;				//우선순위코드
	private String pathCode;			//경로유형코드
	private String workCrew;			//작업조 코드
	private String lotNo;				//LOT
	private String remark;				//비고
	

	private boolean __created__;
	private boolean __modified__;
}
