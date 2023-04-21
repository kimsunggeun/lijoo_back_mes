package kr.co.igns.business.pop.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "pop 계정 설정 저장")
@Data
public class Pop0430ReqDto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "거래처코드")
	private String custCode;
	@Schema(description = "품번코드")
	private String partNo;
	@Schema(description = "시작일")
	private String startDate;
	@Schema(description = "종료일")
	private String endDate;
}
