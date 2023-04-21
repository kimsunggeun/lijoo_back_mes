package kr.co.igns.business.sales.model.sal0160;
import lombok.Data;

@Data
public class Sal0160VO {
	private String id;
	private String comCode;			// 회사코드
	private String facCode;         // 공장코드
	private String ordNo;           // 수주번호
	private String ordTurn;			// 수주순번
	private String ilno;    	    // 출하일련번호
	private String no;    		    // 출하순번
	private String outDate;			// 출하일
	private String outInspYn;		// 출하검사여부
	private String custCode;		// 거래처코드
	private String partNo;          // 품번코드
	private String lotNo;           // 출하LOT
	private String lotDetail; 		// 기존전산번호
	private String outNo;    		// 전산번호 순번
	private String stockQty;		// 출하전재고량
	private String qty;				// 출하량
	private String price;			// 단가
	private String amount;			// 금액
	private String closeMonth;		// 마감월
	private String closeYn;			// 마감여부
	private String confirmYn;		// 마감확정여부
	private String remark;          // 비고
	private String makeDate;        // 등록일
	private String maker;           // 등록자
	private String editDate;        // 수정일
	private String editor;          // 수정자
}
