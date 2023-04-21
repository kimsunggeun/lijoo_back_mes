package kr.co.igns.framework.comm.model;

import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;


@Getter
@Setter
@Data
@Schema(description = "회사정보")
public class CompanyVO {
	private String id;
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "회사명")
	private String comName;
	@Schema(description = "법인등록번호")
	private String corNumber;
	@Schema(description = "사업자등록번호")
	private String comNumber;
	@Schema(description = "대표자명")
	private String name;
	@Schema(description = "우편번호")
	private String postNo;
	@Schema(description = "주소")
	private String addr;
	@Schema(description = "전화번호")
	private String tel;
	@Schema(description = "팩스번호")
	private String fax;
	@Schema(description = "파일 ID")
	private String fileId;
	@Schema(description = "파일 명")
	private String fileName;
	@Schema(description = "파일 사이즈")
	private String fileSize;
	@Schema(description = "파일")
	private MultipartFile file;
	@Schema(description = "등록일")
	private String makeDate;
	@Schema(description = "등록자")
	private String maker;
	@Schema(description = "수정일")
	private String editDate;
	@Schema(description = "수정자")
	private String editor;
	@Schema(description = "CI이미지")
	private String imgCi;
	@Schema(description = "CI")
	private String ciImageBase64;
	@Schema(description = "contentType")
	private String contentType;
	
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "공장명")
	private String facName;
	
	private String created;
	private String modified;
	
	private String fileModified;
//	private boolean __created__;
//	private boolean __modified__;
}
