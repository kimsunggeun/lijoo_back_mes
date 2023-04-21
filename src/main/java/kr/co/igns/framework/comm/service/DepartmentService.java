package kr.co.igns.framework.comm.service;

import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.stereotype.Service;
import kr.co.igns.framework.comm.dao.postgre.DepartmentDao;
import kr.co.igns.framework.comm.model.DepartmentReqDto;
import kr.co.igns.framework.comm.model.DepartmentVO;
import kr.co.igns.framework.comm.model.CmCodeReqDto;
import kr.co.igns.framework.comm.model.CmCodeVO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;

@RequiredArgsConstructor
@Service
public class DepartmentService{

	private final DepartmentDao departmentDao;
	private final IgnsSessionUtils ignsSessionUtils;
	
	//조직코드 조회
	public List<DepartmentVO> getDepartment(DepartmentReqDto reqDto) {
		List<DepartmentVO> list = departmentDao.getDepartment(reqDto);
        return list;
    }
		
	//조직코드 중복체크
	public int checkDepartmentCd(DepartmentReqDto reqDto) {
		int count = departmentDao.checkDepartmentCd(reqDto);
        return count;
    }
	
	//조직코드 입력/수정
	public int createDepartment(List<DepartmentVO> voList) {
		String loginId = IgnsSessionUtils.getCurrentLoginUserCd();
		for(DepartmentVO vo : voList) {
			if(vo.is__created__()) {
				vo.setMaker(loginId.equals("") ? vo.getMaker() : loginId);
				departmentDao.createDepartment(vo);					
			} else if(vo.is__modified__()) {
				vo.setEditor(loginId.equals("") ? vo.getEditor() : loginId);
				departmentDao.updateDepartment(vo);
			}
		}
		return 0;
    }

	//조직코드 삭제
	public int deleteDepartment(List<DepartmentVO> voList) {
		for(DepartmentVO vo : voList) {
			departmentDao.deleteDepartment(vo);
		}
		return 0;
	}
	
}
