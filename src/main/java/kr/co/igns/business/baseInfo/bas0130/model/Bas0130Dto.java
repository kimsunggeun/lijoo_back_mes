package kr.co.igns.business.baseInfo.bas0130.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "공장월력")
@Data
public class Bas0130Dto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "년")
	private String year;
	@Schema(description = "월")
	private String month;
	@Schema(description = "등록자")
	private String maker;	
}
