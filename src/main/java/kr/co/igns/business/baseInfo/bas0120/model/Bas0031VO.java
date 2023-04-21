package kr.co.igns.business.baseInfo.bas0120.model;

import lombok.Data;

@Data
//공정정보
public class Bas0031VO {
	private String comCode;          //회사코드
	private String facCode;          //공장코드
	private String proCode;          //공정코드
	private String proName;          //공정명
	private String proType;          //공정구분 코드
	private String catType;          //공정유형 코드
	private String sortFlag;         //정렬순서
	private String remark;           //비고
	private String userFlag;         //사용유무
	private String makeDate;         //등록일
	private String maker;            //등록자
	private String editDate;         //수정일
	private String editor;           //수정자
	
	private boolean __created__;
	private boolean __modified__;
}
