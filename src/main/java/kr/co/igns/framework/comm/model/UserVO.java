package kr.co.igns.framework.comm.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.*;

@Data
public class UserVO {
																	
	private int uuid; 					//
	private String id;					//
	private String comCode;				//회사코드
	private String depCode;         	//부서코드
	private String userId;          	//사용자ID
	private String userName;        	//사용자명
	private String userPassword;    	//사용자 비밀번호
	private String userChangePassword;  //변경 사용자 비밀번호
	private String perCode;         	//권한그룹 코드
	private String typeCode;        	//사원유형 코드
	private String posiCode;        	//직위 코드
	private String facCode;				//공장코드
	private String hp;              	//핸드폰
	private String email;           	//이메일
	private String entDate;         	//입사일
	private String lanCode;         	//언어코드
	private String userImage;       	//이미지명
	private String userImageBase64;		//
	private String contentType;			//
	private String fileSize;			//
	private String remark;          	//비고
	private String userFlag;        	//사용유무
	private String makeDate;        	//등록일
	private String maker;           	//등록자
	private String editDate;        	//수정일
	private String editor;          	//수정자
	
	private MultipartFile file;
	//userDetail 객체
	private String password;
	private String name;
	
	private String fileModified;
	
	private String created;
	private String modified;
}
