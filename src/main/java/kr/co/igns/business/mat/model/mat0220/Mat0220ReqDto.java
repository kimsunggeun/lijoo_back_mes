package kr.co.igns.business.mat.model.mat0220;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "구매발주 생성")
@Data
public class Mat0220ReqDto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "발주일")
	private String frRegiDate;
	@Schema(description = "발주일")
	private String toRegiDate;
	@Schema(description = "발주번호")
	private String ordNo;
	@Schema(description = "품번")
	private String partNo;
	@Schema(description = "품명")
	private String partName;
	@Schema(description = "거래처코드")
	private String custCode;
	@Schema(description = "발주상태")
	private String ordState;
}
