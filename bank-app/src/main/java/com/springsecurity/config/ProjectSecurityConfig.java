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
        /*
            Default configuration which secures all the requests
         */

//        http.authorizeRequests((requests) -> {
//            ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)requests.anyRequest()).authenticated();
//        });
//        http.formLogin();
//        http.httpBasic();


        /*
            Custom configuration as per our requirements.
         */

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


        /*
            Configuration to deny all requests for all users regardless if they are authenticated or not authenticated.
         */

//        http.authorizeRequests((requests) -> {
//            ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)requests.anyRequest()).denyAll();
//        });
//        http.formLogin();
//        http.httpBasic();

        /*
            Configuration to permit all requests for all users.
         */

//        http.authorizeRequests((requests) -> {
//            ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)requests.anyRequest()).permitAll();
//        });
//        http.formLogin();
//        http.httpBasic();
    }
}
