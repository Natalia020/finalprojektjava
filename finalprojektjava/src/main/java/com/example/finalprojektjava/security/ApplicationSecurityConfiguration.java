package com.example.projektjava.security;

import com.example.projektjava.auth.ApplicationUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {

  private final PasswordEncoder passwordEncoder;
  private final ApplicationUserService applicationUserService;

  @Autowired
  public ApplicationSecurityConfiguration(PasswordEncoder passwordEncoder,
      ApplicationUserService applicationUserService) {
    this.passwordEncoder = passwordEncoder;
    this.applicationUserService = applicationUserService;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
        .antMatchers( "/h2-console/**", "/css/*", "/js/*").permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .formLogin()
            .defaultSuccessUrl("/logged")
            .and().csrf().ignoringAntMatchers("/h2-console/**")//don't apply CSRF protection to /h2-console
            .and().headers().frameOptions().sameOrigin().and().logout().logoutUrl("/logout");

  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(daoAuthenticationProvider());
  }

  @Bean
  public DaoAuthenticationProvider daoAuthenticationProvider() {
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setPasswordEncoder(passwordEncoder);
    provider.setUserDetailsService(applicationUserService);
    return provider;
  }
}
