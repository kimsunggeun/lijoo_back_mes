package kr.co.igns.business.eqp.model.eqp0070;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Eqp0070DetailVO {
	private String comCode;
	private String facCode;	
	private String meaCode;
	private String corrMonth;	//검교정의뢰주기(월)
	private String corrPreDate;	//이전 검교정일 (마스터의 최종 검교정일)
	private String corrDate;	//검교정일
	private String corrNo;		//검교정 차수
	private String corrNextDate;//차기 검교정일
	private String corrAgency;	//검교정의뢰 기관
	private String corrJudge;	//검교정 판정
	private String corrReason;	//판정사유
	private String remark;
	private String insImage;
	private String userFlag;
	private String makeDate;	//등록일
	private String maker;		//등록자
	private String editDate;	//수정일
	private String editor;		//수정자
	private String imageBase64;
	private String contentType;		//
	private String fileSize;		//
	private MultipartFile file;
	private String created;
	private String modified;
	private String fileModified;
	
}
