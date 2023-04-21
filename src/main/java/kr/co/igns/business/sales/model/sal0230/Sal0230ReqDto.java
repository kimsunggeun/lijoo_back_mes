package kr.co.igns.business.sales.model.sal0230;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "출하반품현황")
@Data
public class Sal0230ReqDto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")
	private String facCode;
	private String partNm;
	private String custCode;
	
	private String workDate;
	private String workFrDate;
}
