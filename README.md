# SpringMVC
This is a repo for all the spring mvc 


To download spring jars used in this project use the below link
https://repo.spring.io/release/org/springframework/spring/

select the latest from the link


In this project we have connected to the database and did CRUD operations using the Native hibernate API

we have unwrapped session from the entity manager and did all the crud operations.


Below are native hibernate methods.

create/save new entity   session.save();

findbyid                 session.get();

save/update              session.saveOrUpdate();

retrieve list of data    session.createQuery();

delete                   session.delete();
