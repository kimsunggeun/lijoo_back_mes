package kr.co.igns.framework.comm.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.igns.framework.comm.dao.postgre.LoginDao;
import kr.co.igns.framework.comm.model.LoginReqDto;
import kr.co.igns.framework.comm.model.LoginVO;
import kr.co.igns.framework.comm.model.TokenVO;
import kr.co.igns.framework.config.exception.CEmailSigninFailedException;
import kr.co.igns.framework.config.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Service
@Log4j2
public class LoginService{

	private final LoginDao loginDao;
	private final JwtTokenProvider jwtTokenProvider;
	private final TokenService tokenService;
	private final PasswordEncoder passwordEncoder;
	private final UserDetailsService userDetailsService;
	
	public <T> Map<String, String> login(LoginReqDto loginDto, HttpServletRequest req) {
		if(!loginDto.getPerCode().equals("PDA") || loginDto.getUserId().equals("admin"))
			loginDto.setPerCode("");
		
		LoginVO vo = loginDao.login(loginDto);

		
        if(vo != null){
        	//2. 비밀번호 체크
        	//if(!loginDto.getUserPw().equals(vo.getUserPw())) {
     		if (!passwordEncoder.matches(loginDto.getUserPw(), vo.getUserPassword())) { //pw 디코딩
         		log.error("==== Incorrect password");
             	throw new CEmailSigninFailedException("");
         	}
     		
     		if(vo.getPerCode().equals("PDA") && !loginDto.getPerCode().equals(vo.getPerCode()))
 				throw new CEmailSigninFailedException("");
         	//3. 추가로직(사용자정보 전달?)
         	
         } else {
         	log.error("==== No account");
         	throw new CEmailSigninFailedException("");
         }
        
        
         //ID, 도메인 -> 토큰정보
         vo.setIp(JwtTokenProvider.getClientIP(req));
         String accessToken = jwtTokenProvider.createAccessToken(vo);
         //기존 refreshToken 발급여부 체크, 발급내역이 있으면 재발급 안함.
//         String refreshToken = tokenService.findBykey(loginDto);
//         if(refreshToken == null || refreshToken.equals("") || refreshToken.length() < 5) {
//        	 refreshToken = jwtTokenProvider.createRefreshToken(vo);
//         }
         
         String refreshToken = jwtTokenProvider.createRefreshToken(vo);
         Date refreshExpiration = jwtTokenProvider.extractAllClaims(refreshToken).getExpiration();
         
         //refresh token 정보 저장
         TokenVO tokenVO = new TokenVO();
         tokenVO.setKey(Integer.toString(vo.getUuid()));
         tokenVO.setValue(refreshToken);
         tokenVO.setExpirationDt(refreshExpiration);
         tokenService.createRefreshToken(tokenVO);
         
         //유저정보세션저장
         Authentication auth = jwtTokenProvider.getAuthentication(accessToken);
         SecurityContextHolder.getContext().setAuthentication(auth);
         System.out.println("##SecurityContextHolder getContext() : "+ SecurityContextHolder.getContext().getAuthentication());
         
         //return셋팅
         Map<String, String> resultMap = new HashMap<>();
         resultMap.put("uuid", Integer.toString(vo.getUuid()));
         resultMap.put("accessToken", accessToken);
         resultMap.put("refreshToken", refreshToken);
         resultMap.put("refreshTokenExpiration", refreshExpiration.toString());

         System.out.println("##create token : " + accessToken + "  / refreshToken : " + refreshToken + " / refreshExpiration : " + refreshExpiration);
         return resultMap;
    }
	
}
