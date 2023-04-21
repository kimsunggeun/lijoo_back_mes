package kr.co.igns.business.sales.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.sales.model.sal0020.Sal0020VO;

@Mapper
public interface Sal0020Dao {
	//고객주문업로드 가져오기
	List<Sal0020VO> getCustOrder(Sal0020VO vo);
	
	//고객주문업로드 저장하기
	int ctCustOrder(Sal0020VO vo);
	
	//고객주문업로드 상세 저장하기
	int ctCustOrderDetail(Sal0020VO vo);
	
	

}
