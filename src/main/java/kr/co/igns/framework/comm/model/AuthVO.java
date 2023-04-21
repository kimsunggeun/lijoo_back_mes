package kr.co.igns.framework.comm.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "권한그룹")
@Data
public class AuthVO {
	
	private String id;
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "시스템구분")
	private String sysType;
	@Schema(description = "권한그룹(코드)")
	private String perCode;
	@Schema(description = "권한그룹명")
	private String perName;
	@Schema(description = "사용유무")
	private String userFlag;
	@Schema(description = "등록일")
	private String makeDate;
	@Schema(description = "등록자")
	private String maker;
	@Schema(description = "수정일")
	private String editDate;
	@Schema(description = "수정자")
	private String editor;
	
	private boolean __created__;
	private boolean __modified__;
}
