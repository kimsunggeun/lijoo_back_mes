package kr.co.igns.business.pop.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "pop 계정 설정 저장")
@Data
public class Pop0420ReqDto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "거래처코드")
	private String custCode;
	@Schema(description = "수주번호")
	private String ordNo;
}