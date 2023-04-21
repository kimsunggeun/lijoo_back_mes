package kr.co.igns.framework.comm.service;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.igns.framework.comm.dao.postgre.MenuStatisticsDao;
import kr.co.igns.framework.comm.model.MenuStatisticsReqDto;
import kr.co.igns.framework.comm.model.MenuStatisticsVO;
import kr.co.igns.framework.utils.etc.IgnsSessionUtils;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class MenuStatisticsService{

	private final MenuStatisticsDao menuStatisticsDao;
	private final IgnsSessionUtils ignsSessionUtils;
	
	public List<MenuStatisticsVO> getMenuStatistics(MenuStatisticsReqDto dto) {
		return menuStatisticsDao.getMenuStatistics(dto);
	}

	public int saveMenuStatistics(MenuStatisticsReqDto dto) throws UnknownHostException, SocketException {
		
		InetAddress ip = InetAddress.getLocalHost();
		   
		NetworkInterface network = NetworkInterface.getByInetAddress(ip);
		byte[] mac = network.getHardwareAddress();
	   
		String ipValue = ip.getHostAddress();
        System.out.println("아이피 확인 : " + ipValue);
//
//        String ipValue2 = ip.getHostName();
//        System.out.println("아이피 확인2 : " + ipValue2);
        
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < mac.length; j++) {
			sb.append(String.format("%02X%s", mac[j], (j < mac.length - 1) ? "-" : ""));
		}
		dto.setMacAdrs(sb.toString());
		
		menuStatisticsDao.saveMenuStatistics(dto);
		return 0;
	}

	
}
