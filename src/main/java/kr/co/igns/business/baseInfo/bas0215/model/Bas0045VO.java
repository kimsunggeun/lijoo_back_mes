package kr.co.igns.business.baseInfo.bas0215.model;

import lombok.Data;

@Data
//품목별 거래처 정보 상세(단가이력)
public class Bas0045VO {
	private String id;            //그리드 id
	private String comCode;       //회사코드
	private String partNo;        //품번
	private String custCode;      //거래처 코드
	private String appStartDate;  //단가적용 시작일
	private String appEndDate;    //단가적용 종료일
	private String modiYn;        //단가수정여부
	private String appYn;         //단가적용여부
	private String price;         //단가
	private String unit;          //환종 코드
	private String remark;        //비고
	private String userFlag;      //사용유무
	private String makeDate;      //등록일
	private String maker;         //등록자
	private String editDate;      //수정일
	private String editor;        //수정자
	
	private boolean __created__;
	private boolean __modified__;
}
