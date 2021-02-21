# SpringMVC
This is a repo for all the spring mvc 


To download spring jars used in this project use the below link
https://repo.spring.io/release/org/springframework/spring/

select the latest from the link


IN this project we have used spring data jpa to connect to the database and do CRUD operations using it's default methods

We extend JPARepository and give our entity class and the type of our primary key as arguments.


The default methods are 

findAll()
findById()
save()
delete()


To add some custom queries we need to use any one of the below methods.

```
@Repository
public interface CrudDao extends JpaRepository<Employee, Integer> {

	
	@Query(value = "SELECT * FROM Employee ORDER BY FIRST_NAME",nativeQuery = true)
	 public List<Employee> result();
	 
	 ************OR************
	 
	 @Query(value = "SELECT c FROM Employee c ORDER BY FIRST_NAME",nativeQuery = false)
	 public List<Employee> result();
}

```




The Major difference between these interfaces that we are extending CRUDRepository and JPARepository is 

* CRUDRepository provides only crud methods
* JPARepository extends PagingAndSortingRepository and that extends CRUDRepository
* PagingAndSortingRepository provide methods to perform pagination and sorting of records. 
