package org.example.config.secure;

import lombok.RequiredArgsConstructor;
import org.example.dao.UserLoginDAO;
import org.example.service.models.userLoginDetails.UserLoginDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@EnableWebSecurity
@Profile("prod")
public class SecurityConfigProd extends WebSecurityConfigurerAdapter {

    private final UserLoginDAO userLoginDAO;

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserLoginDetailsService(userLoginDAO);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                .antMatchers("/").permitAll()
                .antMatchers("/**").permitAll()
//                .antMatchers("/resources/**").permitAll()
//                .antMatchers("/**").hasAnyAuthority("ADMIN","MANAGER","USER")
//                .antMatchers("/find/**").hasAnyAuthority("ADMIN","MANAGER","USER")
                .and()
                .logout().logoutSuccessUrl("/")
                .and()
                .exceptionHandling().accessDeniedPage("/access/denied")
                .and()
                .formLogin();
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("h2-console/**").permitAll()
                .and()
                .headers()
                .frameOptions().disable();
    }

}