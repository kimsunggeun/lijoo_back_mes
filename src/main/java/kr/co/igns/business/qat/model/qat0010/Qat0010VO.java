package kr.co.igns.business.qat.model.qat0010;

import lombok.Data;

@Data
public class Qat0010VO {
	
	private String id;        //그리드 id
	private String comCode;   //회사코드
	private String facCode;   //공장코드	
	private String ilno;      //입고번호(일련번호)
	private String ilno2;      //검사번호
	private String serialNo;  //일련번호 순번
	private String inspDate;  //검사일
	private String custCode;  //거래처코드
	private String partNo;    //품번 코드
	private String inspNo;    //검사순서
	private String insCode;   //검사유형 코드
	private String insType;   //검사항목 코드
	private String insMeth;   //측정방법 코드
	private String jugCodeh;  //판정방법 코드
	private String insUnit;   //검사단위 코드
	private String judge;     //판정
	private String sample1;   //시료1
	private String sample2;   //시료2
	private String sample3;   //시료3
	private String sample4;   //시료4
	private String sample5;   //시료5
	private String remark;    //비고
	private String makeDate;  //등록일
	private String maker;     //등록자
	private String editDate;  //수정일
	private String editor;    //수정자
		
	private String inStatus;  //입고상태
	private String inQty;     //입고량
	private String makeQty;   //구성량
	private String inAmount;  //입고금액
	private String boxQty;    //BOX수량
	private String lotDetail; //입고금액
	private String ordNo;     //발주번호
	private String no;        //순번
	private String regiDate;  //입고일
	private String stockQty;    //재고수량
	private String stockAmount; //재고금액	
	private String remQty;
	private String lotNo;
	private String qty;
	private String partType;
	private String inPrice;
	private String waitQty;
	private String locCode;
	private String inInspYn;
	private String inStatus2;  //입고상태 입력
	private String maxOrdNo; //검사번호 채번
}
