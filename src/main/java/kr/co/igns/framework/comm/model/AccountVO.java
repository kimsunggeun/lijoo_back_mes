package kr.co.igns.framework.comm.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "부서관리")
@Data
public class AccountVO {
	private String id;
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "거래처 코드")
	private String custCode;
	@Schema(description = "거래처명")
	private String custName;
	@Schema(description = "거래처유형 코드")
	private String custType;
	@Schema(description = "거래유형 코드")
	private String matType;
	@Schema(description = "사업자등록번호")
	private String custNo;
	@Schema(description = "대표자명")
	private String name;
	@Schema(description = "업태")
	private String conType;
	@Schema(description = "업종")
	private String secType;
	@Schema(description = "우편번호")
	private String postNo;
	@Schema(description = "주소")
	private String addr;
	@Schema(description = "대표자 연락처")
	private String tel;
	@Schema(description = "거래처 팩스번호")
	private String fax;
	@Schema(description = "대표자 이메일")
	private String email;
	@Schema(description = "담당자명(이름)")
	private String manName;
	@Schema(description = "담당자 연락처")
	private String manTel;
	@Schema(description = "담당자 이메일")
	private String manAddr;
	@Schema(description = "사용유무")
	private String userFlag;
	@Schema(description = "비고")
	private String remark;
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
