package kr.co.igns.business.baseInfo.bas0130.model;

import lombok.Data;

@Data
public class Bas0080VO {
	private String comCode;      //회사코드
	private String facCode;      //공장코드
	private String workType;     //근무구분
	private String workCode;     //작업구분
	private String startTime;    //시작시간
	private String endTime;  	 //종료시간
	private String remark;       //비고
	private String userFlag;     //사용유무
	private String makeDate;     //등록일
	private String maker;        //등록자
	private String editDate;     //수정일
	private String editor;       //수정자
	
	private boolean __created__;
	private boolean __modified__;
}
