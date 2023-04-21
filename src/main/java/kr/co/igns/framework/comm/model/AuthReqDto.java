package kr.co.igns.framework.comm.model;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "권한그룹/권한메뉴 Dto")
@Data
public class AuthReqDto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "시스템구분")
	private String sysType;
	@Schema(description = "권한그룹(코드)")
	private String perCode;
	@Schema(description = "권한그룹명")
	private String perName;
	@Schema(description = "메뉴코드")
	private String menuCode;
	@Schema(description = "언어코드")
	private String lanCode;
	@Schema(description = "사용유무")
	private String userFlag;
    
}
