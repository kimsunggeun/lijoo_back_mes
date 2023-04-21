package kr.co.igns.business.mat.model.mat0250;

import lombok.Data;

@Data
public class Mat0014VO {
	private String comName;		//회사명
	private String facName;		//공장명
	private String regiDate; 	//등록일
	private String ilno; 		//일련번호
	private String no;	 		//순번
	private String partNo; 		//품번코드
	private String partName;    //품명
	private String lotNo; 		//기타입고 LOT NO
	private String lotDetail;	//기타입고 전산번호
	private String qty; 		//수량
	private String makeQty; 	//구성량
	private String remark;		//비고
	private String printType; 	//라벨출력 구분
	private String userFlag; 	//사용유무
	private String makeDate; 	//등록일
	private String maker; 		//등록자
	private String editDate; 	//수정일
	private String editor; 		//수정자
}
