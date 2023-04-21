package kr.co.igns.framework.comm.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.framework.comm.model.DepartmentReqDto;
import kr.co.igns.framework.comm.model.DepartmentVO;

@Mapper
public interface DepartmentDao {

	List<DepartmentVO> getDepartment(DepartmentReqDto reqDto);
	int checkDepartmentCd(DepartmentReqDto reqDto);
	
	int createDepartment(DepartmentVO vo);
	int updateDepartment(DepartmentVO vo);
	int deleteDepartment(DepartmentVO vo);
}
