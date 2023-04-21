package kr.co.igns.business.out.model.out0040;

import lombok.Data;

@Data
public class MatOutputRptSubVO {
	private int num;		   		//순번
	private String partNo;			//품번코드
	private String partName; 		//품명
    private String lotNo;   		//공정외주 입고 로트번호
    private String outLotDetail;	//공정외주 입고 전산번호
    private int qty;				//수량	
}
