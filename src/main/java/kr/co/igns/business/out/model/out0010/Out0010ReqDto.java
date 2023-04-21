package kr.co.igns.business.out.model.out0010;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "공정외주발주 등록")
@Data
public class Out0010ReqDto {
	@Schema(description = "공장코드")
	private String comCode;
	@Schema(description = "거래처코드")
	private String custCode;
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "수주 시작일")
	private String startDate;
	@Schema(description = "수주 종료일")
	private String endDate;
	@Schema(description = "등록일")
	private String regiDate;
	@Schema(description = "발주 일련번호")
	private String ilno;
	@Schema(description = "유저 아이디")
	private String userId;
}
