package kr.co.igns.business.baseInfo.bas0120.model;

import lombok.Data;

@Data
//작업장정보
public class Bas0034VO {
	private String comCode;         //회사코드
	private String facCode;         //공장코드
	private String workCode;        //작업장 코드
	private String workName;        //작업장명
	private String workType;        //작업장유형
	private String workDesc;        //작업장설명
	private String depCode;         //작업 부서(부서코드)
	private String sortFlag;        //정렬순서
	private String remark;          //비고
	private String userFlag;        //사용유무
	private String makeDate;        //등록일
	private String maker;           //등록자
	private String editDate;        //수정일
	private String editor;          //수정자
	
	private boolean __created__;
	private boolean __modified__;
}
