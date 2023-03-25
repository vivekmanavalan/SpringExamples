# SpringMVC
This branch contains code for JWT Authentication using spring boot 3.0

Normally in previous versions of spring boot we will extend the WebConfigurerAdapter class

webconfigureradapter class is deprecated in spring 3.0

It had two configure methods that should be overrided

configure(AuthenticationManagerBuilder auth) where we could add username and password

using the auth.inMemoryAuthentication().withUser().withPassword() methods 


second configure method takes HttpSecurity as parameter

where we could authorize requests and access to urls

configure(HttpSecurity http)
http.csrf().disable().authorizeRequests().antMatchers("/getAll").permitAll()


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


