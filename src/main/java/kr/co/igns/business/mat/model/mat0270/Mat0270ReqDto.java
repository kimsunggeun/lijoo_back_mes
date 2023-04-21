package kr.co.igns.business.mat.model.mat0270;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "반품현황 조회")
@Data
public class Mat0270ReqDto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "창고코드")
	private String whCode;
	@Schema(description = "입고구분")
	private String inType;
	@Schema(description = "입고시작일")
	private String workFrDate;
	@Schema(description = "입고종료일")
	private String workDate;
}
