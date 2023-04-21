package kr.co.igns.business.mat.model.mat0250;

import lombok.Data;

@Data
public class Mat0250VO {
	private String comCode;		//회사코드
	private String comName;		//회사명
	private String facCode;		//공장코드
	private String facName;		//공장명
	private String regiDate; 	//등록일
	private String ilno; 		//일련번호
	private String inType; 		//입고구분
	private String inCate; 		//입고유형
	private String custCode; 	//거래처코드
	private String partNo; 		//품번 코드
	private String inQty; 		//입고량
	private String makeQty; 	//구성량
	private String boxQty; 		//BOX수량
	private String remark;		//비고
	private String printType; 	//라벨출력 구분
	private String userFlag; 	//사용유무
	private String makeDate; 	//등록일
	private String maker; 		//등록자
	private String editDate; 	//수정일
	private String editor; 		//수정자
}
