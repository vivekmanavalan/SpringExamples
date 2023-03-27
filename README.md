# SpringMVC
This branch contains code for JWT Authentication using spring boot 3.0

# STEP 1:
Normally in previous versions of spring boot we will extend the WebConfigurerAdapter class

webconfigureradapter class is deprecated in spring 3.0

It had two configure methods that should be overrided

configure(AuthenticationManagerBuilder auth) where we could add username and password

using the auth.inMemoryAuthentication().withUser().withPassword() methods 

second configure method takes HttpSecurity as parameter

where we could authorize requests and access to urls

configure(HttpSecurity http)
http.csrf().disable().authorizeRequests().antMatchers("/getAll").permitAll()

# Spring 3.0 steps
Steps for spring security jwt

create a security config class 

create a method of UserDetailsService class from spring security core
 in this method you can harcode the username and password.
 
create a method of SecurityFilterChain class 
	In this method you can give the authorization 
	
create a postmapping in controller called authenticate

create a DTO class that has username and password 

get the request in the API of that DTO type

check if it's authenticated then generate token 

create a JWtservice class add necessary methods to generate and validate token

Then we need to the .addFilterbefore mathod in the security config 

when a request comes in it'll first check if the token is valid or not 

then we can serve the request.



We can split this JWT Authentication into three steps:
* Username and password validation with database which can be done like a normal spring security based application
  * To do username and password validation we need to do few things in Security Config file
  * Follow the step 1 in first line
* Generating token using Jwts.builder and we can setClaims and setSubject(username) and setIssuedAt - date and setExpiration and signWith(signKey(), Signature.HS256).compact()
* Third step is validating the token when the request comes with token 
  * First we need get the request header which has "Authorization" property
  * Then check if the token has "Bearer" string attached in the start and get the token by subString(7) which will remove the bearer keyword
  * Then extract username from it and password using the reverse process by decoding the signature




