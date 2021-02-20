# SpringMVC
This is a repo for all the spring mvc 


To download spring jars used in this project use the below link
https://repo.spring.io/release/org/springframework/spring/

select the latest from the link

In this project we have shown how to handle exceptions in spring boot without using try and catch 

as try catch makes our code fuzzy and it is difficult to track.

Steps for Handling exceptions

*Create an exception handler class to handle all exceptions. Here it it globalexception class

*create a specific exception class that implements Runtimexception class and just create constructors for super class (StudentNotFound.class)

*Create a pojo class for storing errors and displaying it.

*Annotate the globalexception class with @ControllerAdvice which means for every class in the class path it will check first it there is any exception and then only
 will go to normal flow
 
 *Annotate each method with @ExceptionHandler(value= {StudentNotFound.class}) and add the exception class by this way we can handle multiple exceptions with different 
 methods
 
 
