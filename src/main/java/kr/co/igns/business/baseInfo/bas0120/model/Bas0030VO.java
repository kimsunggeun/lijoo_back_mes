package kr.co.igns.business.baseInfo.bas0120.model;

import lombok.Data;

@Data
//공장정보
public class Bas0030VO {
	
	private String comCode;        //회사코드
	private String facCode;        //공장코드
	private String facName;        //공장명
	private String facNumber;      //공장등록번호
	private String name;           //공장대표자명
	private String postNo;         //우편번호
	private String addr;           //주소
	private String tel;            //전화번호
	private String fax;            //팩스번호
	private String userFlag;       //사용유무
	private String makeDate;       //등록일
	private String maker;          //등록자
	private String editDate;       //수정일
	private String editor;         //수정자
	
	private boolean __created__;
	private boolean __modified__;

}
