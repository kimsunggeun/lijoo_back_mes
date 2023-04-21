package kr.co.igns.business.baseInfo.bas0320.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "환율정보관리")
@Data
public class Bas0320Dto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "일자")
	private String dtFrom;
	@Schema(description = "일자")
	private String dtTo;
	@Schema(description = "통화코드")
	private String currCode;

}
