package kr.co.igns.framework.comm.model;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "거래처관리")
@Data
public class AccountReqDto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "거래처 코드")
	private String custCode;
}
