package kr.co.igns.business.mat.model.mat0230;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "구매발주 생성")
@Data
public class Mat0230ReqDto {
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "거래처코드")
	private String custCode;
	@Schema(description = "품번")
	private String partNo;
	@Schema(description = "품명")
	private String partName;
	@Schema(description = "입고구분")
	private String inType;
	@Schema(description = "입고시작일")
	private String frRegiDate;
	@Schema(description = "입고종료일")
	private String toRegiDate;
}
