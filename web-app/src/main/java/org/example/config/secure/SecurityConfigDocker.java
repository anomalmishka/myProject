package org.example.config.secure;

import lombok.RequiredArgsConstructor;
import org.example.config.CustomAuthenticationFailureHandler;
import org.example.config.CustomLogoutSuccessHandler;
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
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@RequiredArgsConstructor
@EnableWebSecurity
@Profile("docker")
public class SecurityConfigDocker extends WebSecurityConfigurerAdapter {

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
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new CustomAuthenticationFailureHandler();
    }
    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        return new CustomLogoutSuccessHandler();
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
                .antMatchers("/").permitAll()
                .antMatchers("/templates/**").permitAll()
                .antMatchers("/registration/**").permitAll()
                .antMatchers("/restore/password/**").permitAll()
                .antMatchers("/models/**").hasAnyAuthority("ADMIN","MANAGER")
                .antMatchers("/order/**").hasAnyAuthority("ADMIN","MANAGER","USER")
                .antMatchers("/profile/**").hasAnyAuthority("ADMIN","MANAGER","USER")
                .antMatchers("/admin/**").hasAnyAuthority("ADMIN")
//                .anyRequest().authenticated()
                .and()
                .formLogin()
//                .loginPage("/login")
//                .loginProcessingUrl("/perform_login")
//                .successForwardUrl("/")
//                .defaultSuccessUrl("/", true)
                .failureUrl("/access/denied")
//                .failureHandler(authenticationFailureHandler())
                .and()
                .exceptionHandling()
                .accessDeniedPage("/access/denied")
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .deleteCookies("JSESSIONID");
//                .logoutSuccessHandler(logoutSuccessHandler());

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("h2-console/**").permitAll()
//                .anyRequest().authenticated()
                .and()
                .headers()
                .frameOptions().disable();
    }
}
