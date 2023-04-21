package kr.co.igns.business.eqp.model.eqp0100;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
//예비품 정보
public class Eqp0100VO {
	private String id;
	private String comCode;		//회사코드
	private String facCode;		//공장코드
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
	private String userFlag;		//사용유무
	private String makeDate;		//등록일
	private String maker;			//등록자
	private String editDate;		//수정일
	private String editor;			//수정자
	private String regiDate;		//등록일(디테일)
	private String spareType;		//예비품 구분(디테일)
	private String gubun;
	private String seq;
	private String amount;
	private String created;
	private String modified;
	
	private boolean __created__;
	private boolean __modified__;
}
