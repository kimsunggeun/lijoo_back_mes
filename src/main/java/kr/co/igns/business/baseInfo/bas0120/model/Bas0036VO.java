package kr.co.igns.business.baseInfo.bas0120.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
//설비정보
public class Bas0036VO {
	private String comCode;       //회사코드
	private String facCode;       //공장코드
	private String eqCode;        //설비코드
	private String eqName;        //설비명
	private String eqSpec;        //설비사양
	private String eqGrade;       //설비등급 코드
	private String proCode;       //공정코드(설비그룹)
	private String eqState;       //설비상태 코드
	private String makeCom;       //제작회사
	private String perCom;        //구입회사
	private String proDate;       //제조일
	private String insDate;       //설치일
	private String desDate;       //폐기일
	private String eqpImage;      //이미지
	private String dayInspYn;	  //일상점검 유무			//추가된 내용 시작
	private String dayInspDt;	  //일상점검 최종 점검일자
	private String dayInspNextDt; //일상점검 다음 점검일자
	private String periInspYn;	  //정기점검 유무
	private String periInspCycle; //정기점검주기(일)
	private String periInspDt;	  //정기점검 최종 점검일자
	private String periInspNextDt;//정기점검 다음 점검일자	    
	private String preStr;		  //금형 현재 타수
	private String moldLoc;		  //금형위치				//추가된 내용 끝
	private String remark;        //비고
	private String userFlag;      //사용유무
	private String makeDate;      //등록일
	private String maker;         //등록자
	private String editDate;      //수정일
	private String editor;        //수정자
	private String imageBase64;
	private String contentType;		//
	private String fileSize;		//
	private MultipartFile file;
	private String created;
	private String modified;
	private String fileModified;
	
	
	
	private boolean __created__;
	private boolean __modified__;
}
