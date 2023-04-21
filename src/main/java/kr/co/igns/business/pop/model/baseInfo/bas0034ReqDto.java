package kr.co.igns.business.pop.model.baseInfo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "작업장 및 작업반 팝업 선택")
@Data
public class bas0034ReqDto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "작업장코드")
	private String workCode;
	@Schema(description = "작업반코드")
	private String workDeCode;
}
