package kr.co.igns.business.mat.model.mat0070;

import lombok.Data;

@Data
public class TransRptSubVO {

	private int num;		   // 순번
	private String partNo;   // 품번코드
	private String partName; //품명
    private int qty;		   // 납품잔량	
    private int boxQty;   // Box수량
    private int inPrice;   // 입고단가
    private int inAmount; // 입고금액
}
