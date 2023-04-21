package kr.co.igns.business.mat.model.mat0110;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "자재실사")
@Data
public class Mat0110ReqDto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "창고위치코드")
	private String locCode;	
	@Schema(description = "품목군")
	private String itemType;
	@Schema(description = "제품군")
	private String partType;	
	@Schema(description = "품번코드")
	private String partNo;
}
