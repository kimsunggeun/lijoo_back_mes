package kr.co.igns.business.mat.model.mat0210;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "창고별 재고현황")
@Data
public class Mat0210ReqDto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")
	private String facCode;	
	@Schema(description = "창고위치코드")
	private String locCode;	
	@Schema(description = "품번코드")
	private String partNo;
}
