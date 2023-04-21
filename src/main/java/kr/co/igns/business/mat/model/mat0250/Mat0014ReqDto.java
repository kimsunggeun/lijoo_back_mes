package kr.co.igns.business.mat.model.mat0250;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "기사/사급자재 상세현황 조회")
@Data
public class Mat0014ReqDto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "등록일")
	private String regiDate;
	@Schema(description = "일련번호")
	private String ilno;
}
