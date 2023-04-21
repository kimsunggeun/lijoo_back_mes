package kr.co.igns.business.baseInfo.bas0230.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Bom역전개")
@Data
public class Bas0230Dto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "품목군코드")
	private String itemType;
	@Schema(description = "제품군코드")
	private String partType;
	@Schema(description = "품번")
	private String partNo;	
}
