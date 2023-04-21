package kr.co.igns.business.qat.model.qat0010;

import lombok.Data;

@Data
public class Bas0061VO {
	
	private String id;       //그리드 id
	private String comCode;  //회사코드
	private String partNo;   //품번 코드
	private String partName; //품명
	private String inspNo;   //검사순서
	private String insCode;  //검사유형 코드
	private String insType;  //검사항목 코드
	private String insMeth;  //측정방법 코드
	private String jugCodeh; //판정방법 코드
	private String insUnit;  //검사단위 코드
	private String insBase;  //검사기준
	private String insUpp;   //상한치
	private String insLow;   //하한치
	private String insCnt;   //시료수
	private String remark;   //비고
	private String userFlag; //사용유무
	private String makeDate; //등록일
	private String maker;    //등록자
	private String editDate; //수정일
	private String editor;   //수정자
	
	private String facCode;  //공장코드
	private String ilno;     //일련번호
	private String ordNo;    //발주번호
	private String no;       //순번
	private String regiDate; //입고일
	private String inQty;    //입고량
	private String makeQty;  //구성량
	private String boxQty;   //BOX수량
	private String inAmount; //입고금액
	
	//qat0010 데이터 조회
	private String judge;     //판정
	private String sample1;   //시료1
	private String sample2;   //시료2
	private String sample3;   //시료3
	private String sample4;   //시료4
	private String sample5;   //시료5
	
	//mat0020데이터 저장
	private String partType;  //제품군 코드
	private String inPrice;	  //단가
	private String locCode;
	

}
