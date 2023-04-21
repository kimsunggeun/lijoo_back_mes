package kr.co.igns.business.sales.model.sal0010;

import lombok.Data;

@Data
public class Sal0010VO {
	private String id;
	private String comCode;		//회사코드
	private String facCode;     //공장코드
	private String ordNo;       //수주번호(일련번호)
	private String ordDate; 	//수주일
	private String custCode;    //거래처 코드
	private String ordState;    //상태코드
	private String remark;      //비고
	private String makeDate;    //등록일
	private String maker;       //등록자
	private String editDate;    //수정일
	private String editor;      //수정자
	private String partNo;		//품번
	private String partName; 	//품명
	private String price;		//단가
	private String spec;		//규격
	private String unit; 		//단위
	private String partType;	//제품군
	
	private boolean __created__;
	private boolean __modified__;
	
	private String maxOrdNo; 	// 수주번호 데이터
	private String startDate;		// 수주시작일
	private String endDate;		// 수주종료일
}
