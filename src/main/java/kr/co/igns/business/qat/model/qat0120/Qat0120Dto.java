package kr.co.igns.business.qat.model.qat0120;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class Qat0120Dto {
	@Schema(description = "공장명")
	private String comCode; 
	@Schema(description = "불량코드")
	private String defCode; 
	@Schema(description = "회사코드")
	private String facCode; 
	@Schema(description = "품번")
	private String partNo; 
	@Schema(description = "조회시작일")
	private String reqDtFrom;
	@Schema(description = "조회종료일")
	private String reqDtTo;
	
}
