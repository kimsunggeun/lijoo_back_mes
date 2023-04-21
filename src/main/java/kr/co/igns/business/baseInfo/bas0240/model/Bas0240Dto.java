package kr.co.igns.business.baseInfo.bas0240.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "작업표준서관리")
@Data
public class Bas0240Dto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "업로드 구분")
	private String upType;
}
