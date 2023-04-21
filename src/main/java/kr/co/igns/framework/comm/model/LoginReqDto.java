package kr.co.igns.framework.comm.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "로그인")
@Data
public class LoginReqDto {
	@Schema(description = "사용자 ID")
    private String userId;
	@Schema(description = "사용자 PW")
    private String userPw;
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "권한그룹 코드")
	private String perCode;
}
