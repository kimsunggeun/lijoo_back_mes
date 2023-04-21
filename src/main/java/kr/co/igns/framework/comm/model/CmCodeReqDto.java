package kr.co.igns.framework.comm.model;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "공통코드 Dto")
@Data
public class CmCodeReqDto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "코드그룹")
	private String codegr;
	@Schema(description = "코드")
	private String code;
	@Schema(description = "시스템코드")
    private String sysCode;
	@Schema(description = "사용유무")
    private String userFlag;
	
}
