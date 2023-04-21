package kr.co.igns.business.eqp.model.eqp0100;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "설비예비품 관리")
@Data
public class Eqp0100Dto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "자원구분")
	private String jobType;
	@Schema(description = "품번")
	private String partNo;
	@Schema(description = "예비품 구분")
	private String spareType;
	@Schema(description = "날짜from")
	private String frRegiDate;
	@Schema(description = "날짜to")
	private String toRegiDate;
}
