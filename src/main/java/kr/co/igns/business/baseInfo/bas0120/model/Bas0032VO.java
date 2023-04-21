package kr.co.igns.business.baseInfo.bas0120.model;

import lombok.Data;

@Data
//창고정보
public class Bas0032VO {
	private String comCode;       //회사코드
	private String facCode;       //공장코드
	private String whCode;        //창고코드
	private String whName;        //창고명
	private String whType;        //창고구분 코드
	private String whDesc;        //창고설명
	private String sortFlag;      //정렬순서
	private String remark;        //비고
	private String userFlag;      //사용유무
	private String makeDate;      //등록일
	private String maker;         //등록자
	private String editDate;      //수정일
	private String editor;        //수정자
	
	private boolean __created__;
	private boolean __modified__;
}
