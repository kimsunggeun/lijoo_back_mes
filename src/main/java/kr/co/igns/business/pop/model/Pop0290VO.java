package kr.co.igns.business.pop.model;

import lombok.Data;

@Data

public class Pop0290VO {
	private String comCode;
	private String facCode;
	private String nonIlno; // 비가동일련번호
	private String no;// 비가동 순번
	private String workNo; // 작업지시번호
	private String workDate; // 비가동 일자
	private String eqCode; // 설비코드
	private String workCode;// 작업장 코드
	private String workDeCode; // 작업반 코드
	private String stopCode; // 비가동코드
	private String startTime; // 비가동 시작 시간
	private String endTime; // 비가동 종료 시간
	private String stopTime; // 비가동시간(분)
	private String remark; // 비고
	private String userFlag; // 사용유무
	private String makeDate; // 등록일
	private String maker; // 등록자
	private String editDate; // 수정일
	private String editor; // 수정자
	private String eqName; // 설비이름
	private String dayInspDt; // 일상점검 최종 점검일자
	private String dayInspNextDt;// 일상점검 다음 점검일자
	private String periInspDt; // 정기점검 최종 점검일자
	private String periInspNextDt; // 정기점검 다음 점검일자
	private String eqState; // 설비 상태 코드
	private String selectCode;  // 정지시 사유코드
	private String sumStopTime;  // 비가동 총 시간
	private boolean __order__;
	private boolean __created__;
	private boolean __modified__;

	}

