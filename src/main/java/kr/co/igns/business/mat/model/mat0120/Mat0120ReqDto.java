package kr.co.igns.business.mat.model.mat0120;
import io.swagger.v3.oas.annotations.media.Schema;
import kr.co.igns.business.mat.model.mat0120.Mat0120ReqDto;
import lombok.*;

@Schema(description = "자재실사현황")
@Data
public class Mat0120ReqDto {
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
	@Schema(description = "시작일")
	private String startDate;
	@Schema(description = "종료일")
	private String endDate;	
}