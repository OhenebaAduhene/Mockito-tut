package com.example.springsecuritytut.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.example.springsecuritytut.model.ApplicationUserPermission.COURSE_WRITE;
import static com.example.springsecuritytut.model.ApplicationUserRole.*;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public WebConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
//                .antMatchers("/","/stu").permitAll()
//                .antMatchers(HttpMethod.GET,"/stu").hasAnyRole(STUDENT.name(),ADMIN.name(),ADMINTRAINEE.name())
//                .antMatchers(HttpMethod.POST, "/mgn/**").hasAuthority(COURSE_WRITE.getPermission())
//                .antMatchers(HttpMethod.DELETE, "/mgn/**").hasAuthority(COURSE_WRITE.getPermission())
//                .antMatchers(HttpMethod.PUT, "/mgn/**").hasAuthority(COURSE_WRITE.getPermission())
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll();
//                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        final UserDetails portia = User.builder()
                .username("portia")
                .password(passwordEncoder.encode("password"))
                .authorities(ADMIN.getGrantedAuthorities())
                .build();

        final UserDetails wisdom = User.builder()
                .username("wisdom")
                .password(passwordEncoder.encode("hello"))
                .authorities(ADMINTRAINEE.getGrantedAuthorities())
                .build();


        final UserDetails addy = User.builder()
                .username("addy")
                .password(passwordEncoder.encode("hello"))
                .authorities(STUDENT.getGrantedAuthorities())
                .build();


        return new InMemoryUserDetailsManager(
                wisdom,portia,addy
        );
    }
}
