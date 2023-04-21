package kr.co.igns.business.baseInfo.bas0260.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
//예비품정보
public class Bas0260VO {
	private String id;
	private String comCode;		//회사코드
	private String facCode;		//공장코드
	private String facName;		//공장명
	private String jobType;		//자원구분
	private String partNo;			//품번
	private String partName;		//품명
	private String spec;			//규격
	private String qty;				//현재고
	private String safeQty;		//적정재고
	private String grade;			//등급
	private String regDate;		//제작 소요일
	private String unit;			//환종 코드
	private String price;			//단가
	private String stockCode;		//보관위치
	private String spareImage;		//이미지
	private String spareImageBase64;
	private String contentType;
	private String userFlag;		//사용유무
	private String makeDate;		//등록일
	private String maker;			//등록자
	private String editDate;		//수정일
	private String editor;			//수정자
	private String created;
	private String modified;
	private MultipartFile file;
	private String fileModified;
	
	private boolean __created__;
	private boolean __modified__;
}
