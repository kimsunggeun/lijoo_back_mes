package kr.co.igns.framework.comm.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "매뉴")
@Data
public class MenuVO {
	
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "시스템구분")
	private String sysType;
	@Schema(description = "메뉴코드")
	private String menuCode;
	@Schema(description = "메뉴명")
	private String menuName;
	@Schema(description = "모듈코드")
	private String moduleCode;
	@Schema(description = "부모메뉴코드명")
	private String paCode;
	@Schema(description = "프로그램코드")
	private String pgCode;
	@Schema(description = "언어코드")
	private String lanCode;
	@Schema(description = "정렬순서")
	private String sortFlag;
	@Schema(description = "비고")
	private String remark;
	@Schema(description = "사용유무")
	private String userFlag;
	@Schema(description = "등록자")
    private String maker;       
	@Schema(description = "수정자")
    private String editor; 
	
	private boolean __created__;
	private boolean __modified__;
}
