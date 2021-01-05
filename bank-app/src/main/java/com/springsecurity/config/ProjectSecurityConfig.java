package com.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

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



    /*
        Configuring multiple users using InMemoryAuthentication
     */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("admin").password("1234").authorities("admin").and()
//                .withUser("user").password("1234").authorities("read").and()
//                .passwordEncoder(NoOpPasswordEncoder.getInstance());
//        // authenticating multiple users
//        // passwordEncoder is a must have or else spring will throw an error
//        // NoOpPasswordEncoder is not recommended
//    }


    /*
        Configuring multiple users using InMemoryUserDetailsManager
    */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
//        UserDetails adminUser = User.withUsername("admin").password("1234").authorities("admin").build();
//        UserDetails user = User.withUsername("user").password("1234").authorities("read").build();
//        userDetailsService.createUser(adminUser);
//        userDetailsService.createUser(user);
//        auth.userDetailsService(userDetailsService);
//    }

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
