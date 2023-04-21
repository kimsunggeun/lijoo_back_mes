package kr.co.igns.framework.comm.model;

import lombok.*;

@Data
public class UserMenuVO {
	private String id;			//
	private String comCode;		//회사코드   		
	private String sysType;     //시스템구분  
	private String menuCode;    //메뉴코드  
	private String menuName;    //메뉴명   
	private String moduleCode;  //모듈코드
	private String paCode;      //부모메뉴코드   
	private String pgCode;      //프로그램코드
	private String lanCode;		//언어코드
	private String sortFlag;    //정렬순서  
	private String remark;      //비고       
	private String userFlag;    //사용유무  
    private String makeDate;    //등록일   
    private String maker;       //등록자       
    private String editDate;    //수정일   
    private String editor;      //수정자
    
}