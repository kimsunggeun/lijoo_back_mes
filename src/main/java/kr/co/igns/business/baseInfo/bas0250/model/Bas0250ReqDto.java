package kr.co.igns.business.baseInfo.bas0250.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "잡셋업유형")
@Data
public class Bas0250ReqDto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "잡셋업 항목")
	private String jobType;
	@Schema(description = "작업반 항목")
	private String workDecode;
	@Schema(description = "코드그룹")
	private String codegr;
	@Schema(description = "코드")
	private String code;
}
