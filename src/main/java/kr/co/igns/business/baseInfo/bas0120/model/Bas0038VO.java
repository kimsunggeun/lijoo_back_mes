package kr.co.igns.business.baseInfo.bas0120.model;

import lombok.Data;

@Data
//경로정보 상세
public class Bas0038VO {
	private String comCode;      //회사코드
	private String facCode;      //공장코드
	private String pathCode;     //경로코드
	private String proCode;     //공정코드
	private String procNo;       //공정순서
	private String whCode;       //자동투입창고 코드
	private String remark;       //비고
	private String userFlag;     //사용유무
	private String makeDate;     //등록일
	private String maker;        //등록자
	private String editDate;     //수정일
	private String editor;       //수정자
	
	private boolean __created__;
	private boolean __modified__;
}
