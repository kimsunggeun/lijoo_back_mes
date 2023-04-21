package kr.co.igns.business.baseInfo.bas0215.model;

import lombok.Data;

@Data
//BOM정보
public class Bas0043VO {
	private String id;          // id
	private String comCode;     // 회사코드
	private String facCode;		// 공장코드
	private String paPartNo;    // 부모품번
	private String pathType;    // 경로유형
	private String pathCode;    // 경로코드
	private String proNo;      	// 공정순서
	private String proCode;     // 공정코드
	private String level;       // 레벨
	private String dispNo;		// 표시순서
	private String partNo;      // 품번
	private String amount;      // 소진량
	private String remark;      // 비고
	private String userFlag;    // 사용유무
	private String makeDate;    // 등록일
	private String maker;       // 등록자
	private String editDate;    // 수정일
	private String editor;      // 수정자
	
	private boolean __created__;
	private boolean __modified__;
}                               
