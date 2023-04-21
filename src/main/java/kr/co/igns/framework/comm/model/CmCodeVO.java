package kr.co.igns.framework.comm.model;

import lombok.*;

@Data
public class CmCodeVO {
	private String id;			//
	private String comCode;		//회사코드
	private String codegr;      //코드그룹
	private String code;        //코드
	private String codeName;    //코드명
	private String userFlag;    //사용유무
	private String makeDate;    //등록일
	private String maker;       //등록자
	private String editDate;    //수정일
	private String editor;      //수정자
	                                  
	private boolean __created__;
	private boolean __modified__;
}
