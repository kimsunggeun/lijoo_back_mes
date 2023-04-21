package kr.co.igns.business.mat.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.igns.business.mat.dao.postgre.Mat0230Dao;
import kr.co.igns.business.mat.model.mat0230.Mat0230ReqDto;
import kr.co.igns.business.mat.model.mat0230.Mat0230VO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Mat0230Service{

	private final Mat0230Dao mat0230Dao;
	private final IgnsSessionUtils ignsSessionUtils;
	
	//재고정보(MASTER) 조회
	public List<Mat0230VO> getMat0230(Mat0230ReqDto reqDto) {
        
		List<Mat0230VO> list = mat0230Dao.getMat0018_mat0230(reqDto);
		List<Mat0230VO> list2 = mat0230Dao.getMat0014_mat0230(reqDto);
		list.addAll(list2);
		return list;
    }
}
