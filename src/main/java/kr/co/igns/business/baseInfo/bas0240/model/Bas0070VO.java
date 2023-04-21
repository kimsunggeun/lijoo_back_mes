package kr.co.igns.business.baseInfo.bas0240.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Bas0070VO {
	private String comCode;			//회사코드
	private String upType;			//구분
	private String proCode;			//공정코드(폴드명)
	private String proName;			//공정명
	private String upFileName;		//파일명
	private String modFileName;		//
	private String upFileSize;		//파일크기
	private String imageBase64;		//
	private String contentType;		//
	private String makeDate;      	//등록일
	private String maker;         	//등록자
	private String editDate;      	//수정일
	private String editor;        	//수정자
	
	private MultipartFile file;
	private String fileModified;
	
	private String created;
	private String modified;
}
