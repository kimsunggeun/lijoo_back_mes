package kr.co.igns.business.mat.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.mat.model.mat0080.Mat0080VO;


@Mapper
public interface Mat0080Dao {
	//구매발주업로드 가져오기
	List<Mat0080VO> getPurchaseOrder(Mat0080VO vo);
	
	int insertPurchaseOrder(Mat0080VO vo);
	
	int insertDetailPurchaseOrder(Mat0080VO vo);
}
