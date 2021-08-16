package com.cos.blog.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cos.blog.model.User;

import lombok.Getter;

// 스프링 시큐리티가 로그인 요청을 가로채서 로그인을 진행하고 완료되면 UserDetails 타입의 오브젝트를
// 스프링 시큐리티의 고유한 세션 저장소에 저장을 함.
@Getter
public class PrincipalDetail implements UserDetails{
	private User user; //컴포지션(객체를 들고 있는 것)

	public PrincipalDetail(User user) {
			this.user = user;
	}
	
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	//계정이 만료되지 않았는지 리턴한다(true : 만료됨)
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
// 계정이 잠겼는지 아닌지 리턴한다(true : 잠기지 않음)
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
//비밀번호가 만료됐는지 리턴한다(true : 만료안됨)
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
//계정이 활성화 됐는지 리턴한다(사용가능인지) (true : 활성화)
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	//계정이 갖고 있는 권한 목록을 리턴한다(권한이 여러개  있을 수 있어서 루프를 돌아야 하는데 우리는 한개만)
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Collection<GrantedAuthority> collectors = new ArrayList<>();
		collectors.add(() -> {return "ROLE_" + user.getRole();});
		return collectors;
	}
}
