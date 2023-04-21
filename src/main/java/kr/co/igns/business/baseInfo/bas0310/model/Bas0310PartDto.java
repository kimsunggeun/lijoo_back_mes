package kr.co.igns.business.baseInfo.bas0310.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "거래처별 품목등록")
@Data
public class Bas0310PartDto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "품번")
	private String partNo;
	@Schema(description = "거래처코드")
	private String custCode;
	@Schema(description = "로트크기")
	private String lotSize;
	@Schema(description = "입고검사여부")
	private String inInsp;
	@Schema(description = "출고검사여부")
	private String outInsp;
	@Schema(description = "공급처출하검사여부")
	private String supInsp;
	@Schema(description = "비고")
	private String remark;
	@Schema(description = "사용유무")
	private String userFlag;
	@Schema(description = "등록자")
	private String maker;
	@Schema(description = "수정자")
	private String editor;
	
	private boolean __created__;
	private boolean __modified__;
	
}
