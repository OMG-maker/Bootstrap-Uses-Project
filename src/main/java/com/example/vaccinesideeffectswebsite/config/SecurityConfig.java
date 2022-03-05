package com.example.vaccinesideeffectswebsite.config;

import com.example.vaccinesideeffectswebsite.config.oauth.PrincipalOauth2UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration // IoC 빈(bean)을 등록
@EnableWebSecurity // 필터 체인 관리 시작 어노테이션
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true) // 특정 주소 접근시 권한 및 인증을 위한 어노테이션 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private PrincipalOauth2UserService principalOauth2UserService;

	@Bean
	public BCryptPasswordEncoder encodePwd() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//httpSecurity.httpBasic().disable();  // 기존 SecurityConfig 에서 사용하던 강제 login 무효화
		http.csrf().disable();
		http.authorizeRequests()
			.antMatchers("/user/**").authenticated() // 인증만 되면 들어갈 수 있는 주소
			//.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
			//.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN') and hasRole('ROLE_USER')")
			.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
			.anyRequest().permitAll()
		.and()
			.formLogin()
			.loginPage("/login")
			.usernameParameter("userEmail") // 해당 코드를 사용하면 PrincipalDetailsService 에서 username 이 아닌 username2 를 사용해야한다.
			.loginProcessingUrl("/loginProc") // loginProc 주소가 호출이 되면 시큐리틱 낚아채서 대신 로그인을 진행함
			.defaultSuccessUrl("/index") // 성공했을때 이동하는 페이지

		.and()
			.oauth2Login()
			.loginPage("/login")
			.userInfoEndpoint()
			.userService(principalOauth2UserService);

		http.logout() // 로그아웃 처리
				.logoutUrl("/logout") // 로그아웃 처리 URL
				.logoutSuccessUrl("/index") // 로그아웃 성공 후 이동 URL
                .invalidateHttpSession(true) // 로그아웃 이후 세션 전체 삭제 여부
				.deleteCookies("JSESSIONID"); // 로그아웃 후 쿠키 삭제
	}
}
