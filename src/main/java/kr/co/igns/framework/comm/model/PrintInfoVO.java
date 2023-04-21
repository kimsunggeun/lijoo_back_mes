package kr.co.igns.framework.comm.model;

import lombok.Data;

@Data
public class PrintInfoVO {
	private String comCode;		//회사코드
	private String reportCode;	//출력물코드
	private String reportType;	//출력물구분
	private String typeName;	//타입명
	private String sizeName;	//사이즈명
	private String deviceName;	//기기명
	private String explain;		//설명
	private String userFlag; 	//사용유무
	private String makeDate; 	//등록일
	private String maker;		//등록자
	private String editDate;	//수정일
	private String editor;		//수정자
}
