package kr.co.igns.business.mat.model.mat0050;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mat0012VO {
	private int id;
	private String comCode;		//회사코드
	private String facCode;		//공장코드
	private String ordNo;		//발주번호
	private String no;			//순번
	private String regiDate;	//입고일
	private String ilno;		//입고번호(일련번호)
	private String partNo;		//품번 코드
	private String partName;    //품명
	private String inQty;		//입고량
	private String remark;		//비고
	private String inStatus;	//입고상태
	private String inType; 		//입고구분
	private String inTypeName;   //입고구분명
	private String unit;		//유닛
	private String spec; 		//스펙
	private String qty;
	private String inAmount;
	private String custCode;
	private String custName;
	private String retAmount;
}
