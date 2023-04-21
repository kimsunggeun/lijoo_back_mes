package kr.co.igns.business.pop.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "pop 계정 설정 저장")
@Data
public class pro0020ReqDto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "사용자")
	private String userId;
	@Schema(description = "작업반")
	private String workDecode;
}
