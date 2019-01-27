package liverpool.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(this.userDetailsService).passwordEncoder(passwordEncoder());
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin()
		.usernameParameter("login")
		.passwordParameter("password")
		.loginPage("/user/login")
		.loginProcessingUrl("/user/login")
		.failureUrl("/user/login?fail=true")
		.and()
		.logout()
		.logoutUrl("/logout")
		.deleteCookies("JSESSIONID")
		.invalidateHttpSession(true)
		.and()
		.authorizeRequests()
		.antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/shop/**").hasAnyRole("ADMIN","USER")
		.antMatchers("user/**").hasAnyRole("User","ADMIN")
		.anyRequest().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/403")
		.and()
		.sessionManagement().maximumSessions(1);
		
		http.csrf().disable();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {

		//web.ignoring().antMatchers("/resources/**");
	}

}
