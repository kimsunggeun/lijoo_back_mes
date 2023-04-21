package kr.co.igns.framework.comm.model;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "사원정보")
@Getter
@Setter
@Data
public class UserReqDto {
	
	@Schema(description = "uuid")
	private int uuid;
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "사용자 ID")
	private String userId;
	@Schema(description = "사용자명")
	private String userName;
	@Schema(description = "사용자 PW")
	private String userPassword;
}
