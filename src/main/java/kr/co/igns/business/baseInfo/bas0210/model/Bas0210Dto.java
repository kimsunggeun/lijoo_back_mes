package kr.co.igns.business.baseInfo.bas0210.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "품목정보/경로정보/BOM정보/거래처정보")
@Data
public class Bas0210Dto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "품번")
	private String partNo;
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "품목군")
	private String itemType;
	@Schema(description = "제품군")
	private String partType;
	@Schema(description = "경로코드")
	private String pathCode;
	@Schema(description = "경로유형 코드")
	private String pathType;
	@Schema(description = "사용유무")
	private String userFlag;
	@Schema(description = "거래처 코드")
	private String custCode;
	@Schema(description = "거래처유형 코드")
	private String custType;
	@Schema(description = "거래유형 코드")
	private String matType;
}
