package kr.co.igns.business.mat.model.mat0070;

import java.util.List;

import lombok.Data;

@Data
public class Mat0012VO {
	private String id;		//아이디
	private String comCode;// 회사코드
	private String facCode; // 공장코드
	private String ordNo;    // 발주번호
	private String no;		   // 순번
	private String regiDate; // 입고일
	private String ilNo;		   // 입고번호(일련번호)
	private String partNo;   // 품번코드
	private String custName; //거래처명
	private String custCode; //거래처코드
	private String partName; //품명
    private String qty;		   // 납품잔량	
    private String in_Qty;    // 입고량
    private String makeQty; // 구성량
    private String boxQty;   // Box수량
    private String inPrice;   // 입고단가
    private String inAmount; // 입고금액
    private String remQty;   // 잔량
    private String remark; //비고
    private String printType; //라벨출력 구분
    private String userFlag; //사용유무
    private String makeDate; //등록일
	private String maker;		//등록자
	private String editDate;	//수정일
	private String editor;		//수정자
	
	private List<Mat0018VO> detailData;
}
