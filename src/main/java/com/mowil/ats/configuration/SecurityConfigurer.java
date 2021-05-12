package com.mowil.ats.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.mowil.ats.services.AllUserDetailsService;

@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private AllUserDetailsService allUserDetailService;

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(allUserDetailService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

	return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
	return super.authenticationManagerBean();
    }

    private static final String[] AUTH_WHITELIST = {
	    // -- Swagger UI v2
	    "/v2/api-docs", "/swagger-resources", "/swagger-resources/**", "/configuration/ui",
	    "/configuration/security", "/swagger-ui.html", "/webjars/**",
	    // -- Swagger UI v3 (OpenAPI)
	    "/v3/api-docs/**", "/swagger-ui/**",
	    // customs
	    "/api-docs/**", "/swagger-ui.html", "/authenticate" };

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

	// We don't need CSRF for this example
	httpSecurity.csrf().disable()
		// dont authenticate this particular request
		.authorizeRequests().antMatchers(AUTH_WHITELIST).permitAll().antMatchers("/**").
		// all other requests need to be authenticated
		authenticated().and().
		// make sure we use stateless session; session won't be used to
		// store user's state.
		exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	// Add a filter to validate the tokens with every request
	httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

}
