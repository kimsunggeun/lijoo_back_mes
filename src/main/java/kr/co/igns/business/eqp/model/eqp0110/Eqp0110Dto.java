package kr.co.igns.business.eqp.model.eqp0110;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "설비 점검 현황 조회")
@Data
public class Eqp0110Dto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "설비점검 구분")
	private String eqInsType;
	@Schema(description = "설비코드")
	private String eqCode;
	@Schema(description = "판정")
	private String judge;
	@Schema(description = "점검시작일")
	private String startDate;
	@Schema(description = "점검종료일")
	private String endDate;

}
