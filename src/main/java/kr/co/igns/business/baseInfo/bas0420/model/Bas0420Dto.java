package kr.co.igns.business.baseInfo.bas0420.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "품질기준마스터 관리")
@Data
public class Bas0420Dto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "품번")
	private String partNo;
	@Schema(description = "코드그룹")
	private String codegr;
	@Schema(description = "코드")
	private String code;
	
	@Schema(description = "검사순서")
	private String inspNo;
	@Schema(description = "검사유형 코드")
	private String insCode;
	@Schema(description = "검사항목 코드")
	private String insType;
	@Schema(description = "측정방법 코드")
	private String insMeth;
}
