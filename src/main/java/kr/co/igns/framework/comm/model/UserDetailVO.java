package kr.co.igns.framework.comm.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Builder // builder를 사용할수 있게 합니다.
@Data // user 필드값의 getter를 자동으로 생성합니다.
public class UserDetailVO implements UserDetails{
	
	private ArrayList<UserCertVO> userVO;
	
	public UserDetailVO(ArrayList<UserCertVO> userAuthes) {
		this.userVO = userAuthes;
		//System.out.println("-----UserDetailVO : " + this.userVO);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() { //유저가 갖고 있는 권한 목록

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		//tb_user_info / user_role칼럼 
		for(int x=0; x<userVO.size(); x++) {
			//authorities.add(new SimpleGrantedAuthority(userVO.get(x).getRoleName()));
			authorities.add(new SimpleGrantedAuthority("admin"));
		}
		
		return authorities;
	}
    
	@Override
	public String getPassword() { //유저 비밀번호

		return userVO.get(0).getPassword();
	}

	@Override
	public String getUsername() {// 유저 이름 혹은 아이디

		return userVO.get(0).getUserId();
	}

	@Override
	public boolean isAccountNonExpired() {// 유저 아이디가 만료 되었는지

		return true;
	}

	@Override
	public boolean isAccountNonLocked() { // 유저 아이디가 Lock 걸렸는지

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() { //비밀번호가 만료 되었는지

		return true;
	}

	@Override
	public boolean isEnabled() { // 계정이 활성화 되었는지

		return true;
	}
    
    
    
}
