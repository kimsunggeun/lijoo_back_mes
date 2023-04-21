package kr.co.igns.business.sales.model.sal0130;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "출하검사")
@Data
public class Sal0130ReqDto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "거래처명")
	private String custCode;
	@Schema(description = "제품군")
	private String partType;
	@Schema(description = "품명")
	private String partName;
	@Schema(description = "출하일from")
	private String frDate;
	@Schema(description = "출하일to")
	private String toDate;
}
