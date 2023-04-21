package kr.co.igns.business.out.model.out0040;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "공정외주출하검사")
@Data
public class Out0040ReqDto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "거래처코드")
	private String custCode;
	@Schema(description = "품번 코드")
	private String partNo;
	@Schema(description = "납품 시작일")
	private String startDate;
	@Schema(description = "납품 종료일")
	private String endDate;
	
}
