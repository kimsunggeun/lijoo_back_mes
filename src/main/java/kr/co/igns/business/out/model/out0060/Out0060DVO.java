package kr.co.igns.business.out.model.out0060;

import java.util.List;

import kr.co.igns.business.mat.model.mat0070.Mat0018VO;
import lombok.Data;

@Data
public class Out0060DVO{
	private String comCode;    		
	private String facCode;    			
	private String ordNo;			
	private String no;    			
	private String regiDate;    		
	private String ilno;			
	private String serialNo;				
	private String partNo;		
	private String partName;		
	private String lotNo;				
	private String lotDetail;		
	private String qty;    			
	private String inPrice;		
	private String inAmount;				   		
	private String remQty;				
	private String remark;			
	private String printType;			
	private String userFlag;    
	private String makeDate;    		
	private String maker;    			
	private String editDate;    	
	private String editor;    		
	private String inInspYn;    		
	private String retAmount;   
	private String custName;
	
	
	private List<Mat0018VO> detailData;
}
