package kr.co.igns.business.baseInfo.bas0215.model;

import lombok.Data;

@Data
//품목정보
public class Bas0040VO {
	private String id;            //아이디
	private String facCode;       //공장코드
	private String comCode;       //회사코드
	private String partNo;        //품번
	private String partName;      //품명
	private String spec;          //규격
	private String itemType;      //품목군 코드
	private String partType;      //제품군 코드
	private String unit;          //단위 코드
	private String inWh;          //입고창고 코드
	private String outWh;         //출고창고 코드
	private String lotSize;       //로트크기
	private String safeCnt;       //안전재고
	private String sysName;    //제품군
	private String inInsp;        //입고검사 유무
	private String proInsp;       //공정검사 유무
	private String rotInsp;       //순회검사 유무
	private String outInsp;       //출하검사 유무
	private String lastInsp;      //최종검사 유무
	private String supInsp;       //공급처출하검사여부
	private String leadTime;      //리드타임(일수)
	private String weightYn;      //단중사용여부
	private String weight;        //단중(kg)  
	private String userDef1;      //사용자정의1  
	private String userDef2;      //사용자정의2  
	private String userDef3;      //사용자정의3  
	private String remark;        //비고      
	private String userFlag;      //사용유무    
	private String makeDate;      //등록일     
	private String maker;         //등록자     
	private String editDate;      //수정일     
	private String editor;        //수정자     
	                              
	private boolean __created__;
	private boolean __modified__;
}
