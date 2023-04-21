package kr.co.igns.business.ProdManage.model.pro0140;

import lombok.Data;

@Data
public class Pro0140ReqDto {
	private String comCode;
	private String facCode;
	private String eqCode;			//설비
	private String eqName;			//설비명
	private String workCode;		//작업장명
	private String workDecode;		//작업반
	private String stopCode;		//비가동코드
	private String frPlanDate;		//from날짜
	private String toPlanDate;		//to날짜
}
