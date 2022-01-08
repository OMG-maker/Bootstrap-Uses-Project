package com.example.vaccinesideeffectswebsite.config.auth;

import com.example.vaccinesideeffectswebsite.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

//시큐리티가 /loginProc 주소 요청이 오면 낚아채서 로그인을 진행시킨다.
//로그인 진행이 완료가 되면 시큐리티 session을 만들어준다.
//오틎젝트 => Authentication 타입 객체
// User 오브젝트 타입 => UserDetails 타입 객체

// Security Session 에 들어갈 수 있는 객체는 Authentication 객체 뿐
// 그 후 Authentication 객체 안에서 UserDetails 객체를 꺼냄

// Authentication 객체에 저장할 수 있는 유일한 타입
public class PrincipalDetails implements UserDetails, OAuth2User{

	private static final long serialVersionUID = 1L;
	private User user; // 컴포지션
	private Map<String, Object> attributes;

	// 일반 시큐리티 로그인시 사용
	public PrincipalDetails(User user) {
		this.user = user;
	}
	
	// OAuth2.0 로그인시 사용
	public PrincipalDetails(User user, Map<String, Object> attributes) {
		this.user = user;
		this.attributes = attributes;
	}
	
	public User getUser() {
		return user;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	public String getUserFirstName() {
		return user.getUserFirstName();
	}

	public String getUserSecondName() {
		return user.getUserSecondName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	// 계정이 잠겼는지
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	// 비밀번호 변경기간이 지났는지
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	// 계정이 활성화 되어있는지
	@Override
	public boolean isEnabled() {
		// 만약 사이트에서 1년동안 회원이 로그인하지 않았을 시에 휴면계정으로 변경하려면
		// if(현재시간 - user.getLoginDate() => 1년){ return false; }
		return true;
	}

	// 해당 User의 권한을 리턴하는 함수
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collet = new ArrayList<GrantedAuthority>();
//		collet.add(new GrantedAuthority(){
//			@Override
//			public String getAuthority(){
//				return user.getRole();
//			}
//		});
		collet.add(()->{ return user.getRole();});
		return collet;
	}

	// 리소스 서버로 부터 받는 회원정보
	@Override
	public Map<String, Object> getAttributes() {
		return attributes;
	}

	// User의 PrimaryKey
	@Override
	public String getName() {
		return user.getId()+"";
	}
	
}
