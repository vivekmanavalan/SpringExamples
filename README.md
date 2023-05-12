# SpringMVC
This is a repo for all the spring mvc 


To download spring jars used in this project use the below link
https://repo.spring.io/release/org/springframework/spring/

select the latest from the link


# Dependency Injection:
Dependency Injection is the ability of an object to supply dependencies of another object.
 * constructor Injection
 * Setter Injection
 * Method Injection
 

The main idea behind DI is to remove the responsibility of creating objects and managing their dependencies from the objects 
themselves, and instead delegate this responsibility to a separate component known as the "container" or "framework". 
This allows for greater flexibility and modularity in the code, 
as dependencies can be easily swapped out or changed without affecting the implementation of the objects that use them.

# Spring Data JPA:
@Embeddable, @Embedded, @EmbeddedId

@EmbeddedId is used to represent a composite key in a table.

Composite key is a key that uses two or more columns to uniquely identify a row in a table. it cannot be null.

# SQL query for composite key
create table song(id int, name varchar(20), musician varchar(20) PRIMARY KEY(id, name));

Steps:
* To use the annotation @EmbeddedId we first need to create a @Embeddable class of composite keys //class SongId implements Serializable
* That class should implements the interface Serializable
* then in the entity class annotate the composite key with @EmbeddedId
* access specifier as the embeddable class name. ex private SongId id;


Rules of enity class
* cannot be final
* must be annotated with @Entity
* must have a no-arg constructor


# Connect two databases in spring boot:
create a additional datasource in application.properties

create two config for two datasource
in the config create a bean dataSource using the dataSource bean create another bean entityManagerFactory
using the entityManagerFactory bean as qualifier create a bean transactionManager

create two entity class and two repositories

All the entity, config and repository file for one database should be in a single package

In the controller or in service autowire both the repos 

depending on the request you can change call the repository

@ResponseBody:
@ResponseBody annotation tells a controller that the object returned is automatically serialized into JSON 
and passed back into the HttpResponse object. 

@RequestBody:
Spring automatically deserializes the JSON into a Java type assuming an appropriate one is specified. By default, 
the type we annotate with the @RequestBody annotation must correspond to the JSON sent from our client-side controller.
When we send a request with a body we need to use it in the method parameter
public String getMessage(@RequestBody Data data){}

# @Controller vs @RestController
@Controller:
	* @Controller indicates that the class is a controller for web services
	* Using this in MVC you can also render the view as well
	
@RestController:
	* @RestController indicates that the class is for Restful web services 
	* It's the combination of @Controller and @ResponseBody
	* we do not need to explicitly annotate each method with @ResponseBody
	
# @RestControllerAdvice vs @ControllerAdvice
@ControllerAdvice:
	* Indicates that the class can many @ExceptionHandler methods 
	* need to add @ResponseBody annotation at method level for each method
@RestControllerAdvice:
	* It's a combination of @ControllerAdvice and @ResponseBody
	

# Transaction Management in spring:
	A transaction is a sequence of actions performed by the application that together pipelined to perform a single operation. 
For example, booking a flight ticket is also a transaction where the end user has to enter his information 
and then make a payment to book the ticket.

	* To enable the transaction management we need to annotation the main application class with @EnableTransactionManagement
	* On the Method where we do save or update we need to annotate with @Transactional annotation
	* On doing this when an error occurs in the middle of save or update the transaction will be rolled back.
	* It'll either save fully or don't save anything
	
@Autowired:
@Autowired annotation is used to automatically wire dependencies into a class. 
This means that Spring Boot will automatically provide an instance of a dependency to the class that needs it, 
without the need for the developer to manually create or manage the dependency.

It's used to achieve loose coupling between classes and promote the use of dependency injection in Spring Boot applications.

How it works:
   * Spring Boot searches for a bean that matches the type of the dependency. 
   
   * If there's only one bean that matches, that bean will be injected.
   
   * If there are multiple beans that match the type of the dependency,
   
   * Spring Boot will look for a @Qualifier annotation on the field or constructor parameter. 
   
   * The @Qualifier annotation can be used to specify the name of the bean to inject.
   
   * If there's still no unique bean that matches the type and the @Qualifier annotation
   
   * Spring Boot will throw a NoUniqueBeanDefinitionException.
To know more about @Qualifier and autowired use chatgpt example	
	
@Query:
   * It can be used in the repository interface to execute native query
   
   * Method should be annotated with @Query
   
   * @Query(value = "select * from employee where name like ?1", nativeQuery = true )
	 List<Employee> findByName(String name);

findBy Methods for custom property names:
Spring Data JPA will parse the method name 
and generate the appropriate SQL query to retrieve the data based on the firstName property.

When a method is called on the repository, Spring Data JPA generates the appropriate SQL query based on the method name 
and returns the results.


@Valid
 * It is used in the combination with @RequestBody
 * It is used to validate the input received with the conditions added in the entity class like @NotNull, @Min @Max
 * public ResponseEntity<User> createUser(@Valid @RequestBody User user) {}
 
 
# Mapping in JPA:
One to One:
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id") //table name course
	private Course course;

For Bi-Directional:
	@OneToOne(mappedBy = "course")
	private Instructor instructor;

One to Many:
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "learner_id", referencedColumnName = "id")
	private List<Course> course;
For Bi-Directional:
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "learner_id")//table name learner
	private Instructor instructor;

Many to Many:
	//Serving entity
	@ManyToMany
	@JoinTable(name = "instructor_course", //new table name
	joinColumns = @JoinColumn(name = "emp_id"), //entity table name
	inverseJoinColumns = @JoinColumn(name = "project_id")) //another entity table name
	private List<Course> course;

For Bi-Directional:
	@ManyToMany(mappedBy = "course") //name of the variable in serving entity
	@JsonIgnore
	private List<Instructor> instructorList;


::::::::::::::::::::::::::::::::::::::::::::::::::::Database:::::::::::::::::::::::

Super Key: 
Super Key can contain multiple attributes that might not be able to identify tuples in a table independently, 
but when grouped with certain keys, they can identify tuples uniquely.

Candidate key:
A candidate key is a set of attributes (or attributes) that uniquely identify the tuples in relation to or table.
