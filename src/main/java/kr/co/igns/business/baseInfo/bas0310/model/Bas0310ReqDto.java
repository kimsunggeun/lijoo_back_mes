package kr.co.igns.business.baseInfo.bas0310.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "거래처정보 조회")
@Data
public class Bas0310ReqDto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "거래처코드")
	private String custCode;
	@Schema(description = "거래처명")
	private String custName;
	@Schema(description = "거래처유형")
	private String custType;
	@Schema(description = "품번")
	private String partNo;
}
