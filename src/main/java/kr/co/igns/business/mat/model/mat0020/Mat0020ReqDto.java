package kr.co.igns.business.mat.model.mat0020;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "구매발주 생성")
@Data
public class Mat0020ReqDto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "거래처코드")
	private String custCode;
	@Schema(description = "등록일")
	private String regiDate;
	@Schema(description = "발주번호")
	private String ordNo;
	@Schema(description = "발주상태")
	private String ordState;
	@Schema(description = "순번")
	private String no;
	@Schema(description = "발주시작일")
	private String startDate;
	@Schema(description = "발주시작일")
	private String endDate;
	@Schema(description = "일자정보")
	private String dateType;
	@Schema(description = "품번")
	private String partNo;
}
