# Spring Security Tutorial

## Spring Security Internal Flow
![Spring Security Internal Flow](./img/spring-security-internal-flow.png)
* AuthenticationFilter - intercepts and performs authentication of particular request
* Authentication - using the supplied username and password from the user, authentication object is formed which is 
    passed into Authentication Manager
* AuthenticationManager - once received request from filter, it passes it on to AuthenticationProvider after validating
    the user details
* AuthenticationProvider -  It has all the logic of validating user details using UserDetailsService and PasswordEncoder.
* UserDetailsService - UserDetailsService retrieves UserDetails and implements the User interface using the supplied 
    username.
* PasswordEncoder - Service interface for encoding passwords.
* SecurityContext - Stores the authentication data after successful authentication. The second time the user sends 
    the same request, it will not have to go through this entire loop again.

## What we will be building
### FrontEnd
* Login, notices, and contact-us pages should be visible to the user without logging in
![Login](./img/log-in.png)
![Notices](./img/notices.png)
![Contact Us](./img/contact-us.png)
* Dashboard: account info, balances, loans, and cards should be secured
![Dashboard](./img/dashboard.png)
![Account Information](./img/account.png)
![Balance](./img/balance.png)
![Loans](./img/loans.png)
![Cards](./img/cards.png)

### BackEnd
* Services without any security
    * /contact – This service should accept the details from the Contact Us page in the UI and save to the DB.
    * /notices – This service should send the notice details from the DB to the ‘NOTICES’ page in the UI

* Services with security
    * /myAccount – This service should send the account details of the logged in user from the DB to the UI
    * /myBalance – This service should send the balance and transaction details of the logged in user from the DB to
    the UI
    * /myLoans – This service should send the loan details of the logged in user from the DB to the UI
    * /myCards – This service should send the card details of the logged in user from the DB to the UI
    
## Step By Step Guide
* Go to start.spring.io and create a new project. Add SpringWeb and SpringSecurity depenedencies to it.
* Create a separate package for controllers (Need to add @ComponentScan). Add all the rest controllers. (Rest Services)
    * @GetMapping <- reading data from the database
    * @PostMapping <- reading data and saving to the DB 
* By default, Spring Security will secure all the requests made within the application. However as mentioned above, our
    requirements are different (i.e we shouldn't secure /contact and /notices).
    * You can go to Postman, create a request and see it yourself. 
* To override the default behavior, we need to create a config class that extends `WebSecurityConfigurerAdapter` and 
    override its `configure(HttpSecurity http)` class.
    * `WebSecurityConfigurerAdapter` <- base class for entire spring security.
    * `.permitAll()` <- not secured
    * `.authenticated()` <- secured


