package kr.co.igns.business.mat.model.mat0070;

import lombok.Data;

@Data
public class Mat0018VO {
	private String comCode;// 회사코드
	private String facCode; // 공장코드
	private String ordNo;    // 발주번호
	private String no;		   // 순번
	private String regiDate; // 입고일
	private String ilNo;		   // 입고번호(일련번호)
	private String serialNo;   // 일련번호 순번
	private String partNo;	//품번코드
	private String partName;	//품명
	private String lotNo;		//구매입고 LOT NO
	private String lotDetail;	//구매입고 전산번호
    private String qty;		   // 수량
    private String status;    // 입고상태
    private String remark; //비고
    private String printType; //라벨출력 구분
    private String userFlag; //사용유무
    private String makeDate; //등록일
	private String maker;		//등록자
	private String editDate;	//수정일
	private String editor;		//수정자
	
	private boolean __created__;
	private boolean __modified__;
}
