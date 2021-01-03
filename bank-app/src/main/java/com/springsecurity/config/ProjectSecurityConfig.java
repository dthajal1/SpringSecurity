package com.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

@Configuration
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {

    /*
        * /myAccount - secured
        * /myBalance - secured
        * /myLoans - secured
        * /myCards - secured
        * /contact - not secured
        * /notices - not secured
    */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests((requests) -> {
            ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)requests.antMatchers("/myAccount")).authenticated();
            ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)requests.antMatchers("/myLoans")).authenticated();
            ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)requests.antMatchers("/myCards")).authenticated();
            ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)requests.antMatchers("/myBalance")).authenticated();
            ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)requests.antMatchers("/contact")).permitAll();
            ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)requests.antMatchers("/notices")).permitAll();
        });
        http.formLogin();
        http.httpBasic();
    }
}
