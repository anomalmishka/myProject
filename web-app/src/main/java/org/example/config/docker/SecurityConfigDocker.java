package org.example.config.docker;

import lombok.RequiredArgsConstructor;
import org.example.dao.UserRepository;
import org.example.service.MyUserDetailsService;
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
@Profile("docker")
public class SecurityConfigDocker extends WebSecurityConfigurerAdapter {

    private final UserRepository userRepository;

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new MyUserDetailsService(userRepository);
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
                .antMatchers("/create/**").hasAnyAuthority("AUTHOR")
                .antMatchers("/update/**").hasAnyAuthority("EDITOR", "AUTHOR")
                .antMatchers("/delete/**").hasAnyAuthority("AUTHOR")
                .antMatchers("/read/**").hasAnyAuthority("READER", "EDITOR", "AUTHOR")
                .antMatchers("/find/**").hasAnyAuthority("AUTHOR")
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
