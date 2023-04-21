package kr.co.igns.business.qat.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.qat.model.qat0010.Bas0061VO;
import kr.co.igns.business.qat.model.qat0010.Mat0012VO;
import kr.co.igns.business.qat.model.qat0010.Qat0010Dto;
import kr.co.igns.business.qat.model.qat0010.Qat0010VO;

@Mapper
public interface Qat0010Dao {
	//납품정보 조회
	List<Mat0012VO> getDelInfo(Qat0010Dto dto);
	//검사내역 가져오기
	List<Bas0061VO> getInsDetails(Qat0010Dto dto);
	List<Qat0010VO> getMat0018_Qat0010(Qat0010Dto dto);
	//검사내역 저장하기
	int saveInsDetails(Qat0010VO vo);
    //구매입고등록 상태 UPDATE
	int utMat0012(Qat0010VO vo);
	//구매발주정보상세 업데이트
	int utMat0011(Qat0010VO vo);
	//구매입고정보 상세 업데이트
	int utMat0018(Qat0010VO vo);
	//재고마스터 update/insert
	int upsertMat0020(Qat0010VO vo);
	//재고디테일 생성
	int ctMat0021(Qat0010VO vo);
	String getPrice(Qat0010VO vo);
	//Etc
	//검사항목 갯수
	int cntBas0061(Qat0010VO vo);
	//검사내역 합격 갯수
	int cntQat0010(Qat0010VO vo);
	List<Qat0010VO> getLotDetail(Qat0010VO vo);
	
	//검사내역 취소
	String maxOrdNo(Qat0010VO vo);			//검사번호 채번
	int deleteQat0010(Qat0010VO vo);	//검사내역 삭제
	int updateMat0012(Qat0010VO vo);	//입고정보 입고상태 업데이트
	int deleteMat0021_2(Qat0010VO vo);	//재고정보 상세 삭제
	int updateMat0020(Qat0010VO vo);	//재고정보 마스터 재고량 재고금액 업데이트
	int updateMat0018(Qat0010VO vo);	//구매 입고정보 상세 입고대기유무 업데이트
	int updateMat0011_2(Qat0010VO vo);	//구매 발주정보 상세 입고량 입고대기 업데이트
	
	
	//삭제
	int deleteMat0021(Qat0010VO vo);
	int updateMat0020_2(Qat0010VO vo);
	int deleteMat0018(Qat0010VO vo);	
	int deleteMat0012(Qat0010VO vo);
	int updateMat0011(Qat0010VO vo);

}
