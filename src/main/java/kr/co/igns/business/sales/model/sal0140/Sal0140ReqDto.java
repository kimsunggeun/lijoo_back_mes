package kr.co.igns.business.sales.model.sal0140;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "반품내역")
@Data
public class Sal0140ReqDto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "일련번호")
	private String ilno;
	@Schema(description = "Lot No")
	private String lotNo;
	@Schema(description = "번호")
	private String no;
	@Schema(description = "Lot 번호")
	private String lotDetail;
}
