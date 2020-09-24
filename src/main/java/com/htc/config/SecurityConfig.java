package com.htc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.htc.security.CustomUserDetailsService;
import com.htc.security.JwtAuthenticationEntryPoint;
import com.htc.security.JwtAuthenticationFilter;


/**
 * Created by Birame Ba on 11/02/2019.
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(customUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                    .and()
                .csrf()
                    .disable()
                .exceptionHandling()
                    .authenticationEntryPoint(unauthorizedHandler)
                    .and()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                .authorizeRequests()
                    .antMatchers(HttpMethod.GET,
                    	"/",
                        "/favicon.ico",
                        "/**/*.png",
                        "/**/*.gif",
                        "/**/*.svg",
                        "/**/*.jpg",
                        "/**/*.html",
                        "/**.html",
                        "/**/*.css",
                        "/**/*.js"
                        ,"/v2/api-docs",
                        "/swagger-resources", 
                       "/swagger-resources/configuration/ui", 
                       "/swagger-resources/configuration/security",
                       "/swagger-ui.html",
                       "/uploadMultipleFiles",
                       "/uploadFile",
                       "/downloadFile/**","/download/demandes.xlsx")
                        .permitAll()
                    .antMatchers("/auth/**")
                        .permitAll()
                    .antMatchers("/user/checkUsernameAvailability", "/user/checkEmailAvailability")
                        .permitAll()
                    .antMatchers(HttpMethod.GET,  "/users/**")
                        .permitAll()
                    .anyRequest()
                        .authenticated();

        // Add our custom JWT security filter
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

    }
//    public void configure(HttpSecurity http) throws Exception {
//        http
//        .requestMatchers()
//        .and()
//        .authorizeRequests()
//        .antMatchers("/auth/**")
//        .permitAll()
//        .antMatchers("/user/checkUsernameAvailability", "/user/checkEmailAvailability")
//        .permitAll()
//        .antMatchers(HttpMethod.GET,  "/users/**")
//        .permitAll()
//         .antMatchers("/demandes/**", "/etat/demande/**").authenticated();
//        
//        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
//}
}