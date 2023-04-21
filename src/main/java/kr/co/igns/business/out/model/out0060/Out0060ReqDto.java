package kr.co.igns.business.out.model.out0060;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "공정외주출하검사")
@Data
public class Out0060ReqDto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")
	private String facCode;

	@Schema(description = "품번 코드")
	private String partNo;
	@Schema(description = "입고일")
	private String regiDate;
	@Schema(description = "납품 종료일")
	private String endDate;
	@Schema(description = "주문번호")
	private String ilno;
	
}
