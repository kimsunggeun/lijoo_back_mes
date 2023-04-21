package kr.co.igns.business.baseInfo.bas0260.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "예비품 정보")
@Data
public class Bas0260Dto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "자원구분")
	private String jobType;
	@Schema(description = "사용유무")
	private String userFlag;
	@Schema(description = "품번")
	private String partNo;
}
