package kr.co.igns.business.eqp.model.eqp0140;

import lombok.Data;

@Data
public class Eqp0020VO {
	private String comCode;			//회사코드
	private String facCode;			//공장코드
	private String meaCode;			//계측기코드
	private String corrMonth;		//검교정의뢰 주기(월)
	private String befCorrDate;		//이전 검교정일
	private String corrDate;		//검교정일
	private String corrNo;			//검교정 차수
	private String aftCorrDate;		//차기 검교정일
	private String corrAgency;		//검교정의뢰 기관
	private String corrJurge;		//검교정 판정
	private String corrReason;		//판정사유
	private String remark;			//비고
	private String insImage;		//파일첨부
	private String userFlag;		//사용유무
	private String makeDate;		//등록일
	private String maker;			//등록자
	private String editDate;		//수정일
	private String editor;			//수정자
	
}
