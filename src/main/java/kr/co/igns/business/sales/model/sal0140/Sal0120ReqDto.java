package kr.co.igns.business.sales.model.sal0140;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "반품등록")
@Data
public class Sal0120ReqDto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "거래처코드")
	private String custCode;
	@Schema(description = "품명")
	private String partNm;
	@Schema(description = "조회시작일")
	private String workFrDate;
	@Schema(description = "조회종료일")
	private String workDate;
}