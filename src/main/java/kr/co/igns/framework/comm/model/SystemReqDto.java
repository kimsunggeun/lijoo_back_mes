package kr.co.igns.framework.comm.model;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "매뉴")
@Data
public class SystemReqDto {

	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "출력물코드")
	private String reportCode;
	@Schema(description = "제약조건구분")
	private String constType;
	@Schema(description = "옵션구분")
	private String optionType;
	@Schema(description = "대시보드코드")
	private String dbCode;
	@Schema(description = "자동재생시간")
	private String autoTime;
	@Schema(description = "사용유무")
	private String userFlag;
	@Schema(description = "수정자")
	private String editor;
}
