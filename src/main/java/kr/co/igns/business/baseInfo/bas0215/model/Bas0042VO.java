package kr.co.igns.business.baseInfo.bas0215.model;

import lombok.Data;

@Data
//경로정보 상세
public class Bas0042VO {
	private String id;         //그리드 id
	private String comCode;    //회사코드
	private String partNo;     //품번
	private String pathType;   //경로유형 코드
	private String pathCode;   //경로코드
	private String pathNo;     //공정순서
	private String proCode;    //공정코드
	private String matCost;    //재료비
	private String proCost;    //가공비
	private String labCost;    //노무비
	private String remark;     //비고
	private String userFlag;   //사용유무
	private String makeDate;   //등록일
	private String maker;      //등록자
	private String editDate;   //수정일
	private String editor;     //수정자
	
	private boolean __created__;
	private boolean __modified__;
}
