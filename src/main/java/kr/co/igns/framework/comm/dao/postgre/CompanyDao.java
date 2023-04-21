package kr.co.igns.framework.comm.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.framework.comm.model.ComCustomerReqDto;
import kr.co.igns.framework.comm.model.ComCustomerVO;
import kr.co.igns.framework.comm.model.CompanyReqDto;
import kr.co.igns.framework.comm.model.CompanyVO;

@Mapper
public interface CompanyDao {

	//회사코드 조회
	public List<CompanyVO> getCompany(CompanyReqDto reqDto);
	
	//거래처 정보 조회
	public List<ComCustomerVO> getComCustomer(ComCustomerReqDto reqDto);
	
	//공장코드 조회
	public List<CompanyVO> getFacCode(CompanyReqDto reqDto);
	int createCompany(CompanyVO vo);
	int updateCompany(CompanyVO vo);
	
}
