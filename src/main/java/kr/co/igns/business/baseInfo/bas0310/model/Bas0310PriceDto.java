package kr.co.igns.business.baseInfo.bas0310.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class Bas0310PriceDto {
	@Schema(description = "회사코드")
	private String comCode;           //회사코드
	@Schema(description = "품번")
	private String partNo;            //품번
	@Schema(description = "거래처코드")
	private String custCode;          //거래처 코드
	@Schema(description = "단가적용 시작일")
	private String appStartDate;     //단가적용 시작일
	@Schema(description = "단가적용 종료일")
	private String appEndDate;       //단가적용 종료일
	@Schema(description = "단가수정 여부")
	private String modiYN;            //단가수정여부
	@Schema(description = "단가적용 여부")
	private String appYN;             //단가적용여부
	@Schema(description = "단가")
	private String price;              //단가
	@Schema(description = "환종 코드")
	private String unit;               //환종 코드
	@Schema(description = "비고")
	private String remark;             //비고
	@Schema(description = "사용유무")
	private String userFlag;          //사용유무
	@Schema(description = "등록자")
	private String maker;     
	@Schema(description = "수정자")
	private String editor; 
	
	private boolean __created__;
	private boolean __modified__;

}
