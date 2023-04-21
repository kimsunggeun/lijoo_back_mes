package kr.co.igns.business.baseInfo.bas0020.model;

import lombok.Data;

@Data
public class Bas0023VO {
	
	private String id;         //그리드 id
	private String no;         //순번
	private String comCode;    //회사코드
	private String custCode;   //거래처 코드
	private String custName;   //거래처명
	private String custType;   //거래처유형 코드
	private String matType;    //거래유형 코드
	private String custNo;     //사업자등록번호
	private String name;       //대표자명
	private String conType;    //업태
	private String secType;    //업종
	private String postNo;     //우편번호
	private String addr;       //주소
	private String tel;        //대표자 연락처
	private String fax;        //거래처 팩스번호
	private String email;      //대표자 이메일
	private String manName;    //담당자명(이름)
	private String manTel;     //담당자 연락처
	private String manAddr;    //담당자 이메일
	private String userFlag;   //사용유무
	private String remark;     //비고
	private String makeDate;   //등록일
	private String maker;      //등록자
	private String editDate;   //수정일
	private String editor;	   //수정자
	
	private boolean codeChk;   //중복체크 코드
}
