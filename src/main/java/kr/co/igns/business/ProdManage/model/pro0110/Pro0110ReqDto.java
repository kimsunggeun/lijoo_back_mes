package kr.co.igns.business.ProdManage.model.pro0110;

import lombok.Data;

@Data
public class Pro0110ReqDto {
	private String comCode;
	private String facCode;
	private String frPlanDate;
	private String toPlanDate;
	private String workCode;		//작업장명
	private String workDecode;		//작업반
	private String partNo;
	private String partNm;
	private String itemType; //품목군
	private String partType; //제품군
}
