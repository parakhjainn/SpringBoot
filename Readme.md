# demo - Lecture 2

-  created just to print Hello World on localhost:8080/hello

# CoreDemo - Lecture 3

- demonstrate need of dependency injection 

# MavenDemo - Lecture 4

- added from spring initializer https://start.spring.io/ 

# SpringCoreDemo - Lecture 5

- without spring core DI
- with spring core DI
- multiple bean handling
- @Bean Demo 

## CoreDemo2

- added to demonstrate external library (JAR) in SpringCoreDemo

# Lecture 6

## CircularDependencyDemo

- with circular dependency + constructor injection = error
- with circular dependency + setter/field injection = code works but not good practice
- remove circular dependency from code by refactoring

## BeanScopeDemo

- Bean Scope (Singleton)
- Bean Scope (Prototype)
- Bean Scope (Singleton Confusion with @Bean)

## BeanInitialisationDemo

- Bean Initialization is Eager (Default)
- Bean Initialization - Lazy
- Note 
    - Singleton scope can have Eager (default) & Lazy Initialization
    - Prototype scope has always Lazy Initialization only.
- OrderService & PaymentService both are independent
    - both classes are singleton and eager -> Works
- OrderService dependent on PaymentService
    - OrderService is singleton & lazy while PaymentService is singleton & eager -> Works
    - OrderService is singleton & eager while PaymentService is singleton & lazy -> Ideally PaymentService shouldn't be created but since it is required by OrderService it'll be initialized at startup only
- When use @Lazy injection, we get Proxy class object
- Ciruclar dependency without using Lazy - Error
- Ciruclar dependency fix using @Lazy Injection

# Lecture 7 BeanLifecycleDemo

- Basic setup to understand bean lifecycle
- Aware interfaces demo
- Initialization Callbacks Demo 
    - way 1 implements InitializingBean interface
    - way 2 custom init method when using @Bean
    - way 3 PostConstruct Annotation (widely used)
- Destruction Callbacks demo
    - way 1 implements DisposableBean interface
    - way 2 custom destroy method when using @Bean
    - way 3 PreDestroy Annotation (widely used)
- for Lazy initialization, steps are same but from creation till end will execute when user calls any method of that bean
- Prototype Bean (After initialization callbacks, spring handover bean to Client)
- Circular dependency using @PostConstruct 
- solve Circular dependency using @PostConstruct 

# Lecture 8 XML Based Configuration

- quick recap of Annotation Config
- Converting Annotation config to XML Based config
- adding bean to xml
- get bean by type/id
- adding second bean & get bean by name (alias)
- dependency injections in beans - constructor injection 
- setter injection
- multiple beans of same type - multiple ways to solve like using `ref`
- prototype scope
- injecting collections to beans
- postconstruct and predestroy alternatives
- organising XML in multiple files

# Lecture 9 Spring Boot Core Demo

## Spring Core Demo

- using only spring context

## Spring Boot Core Demo

- spring boot starter parent
- Collecting IOC COntainer beans
- Understanding @SpringBoot Application
- @SpringBootConfiguration & @ComponentScan
- @EnableAutoConfiguration

# Lecture 10 SpringBootConfigurationDemo

- application.properties
- @ConfigurationProperties
- Runner Interfaces Demo (ApplicationRunner)
- Runner Interfaces Demo (CommandLineRunner)

# Lecture 11-13 SpringBootCRUDDemo

## Lecture 11

- exclude datasourceautoconfiguration to print hello world
- proper folder structure (MVC)
- @Entity
- Controller Service Repository and createStudent API

## Lecture 12

- extends JpaRepository Interface
- MySQL Configuration
- Get Student by Id & Get all Student API
- Update Student API
- Delete Student API

## Lecture 13

- Soft Delete changes in CRUD APIs
- auto increment id
- query param instead of path param

# Lecture 14 ServletCRUDDemo

# Lecture 15 Spring MVC

## SpringMVCDemo

- Dependencies added
- CSR added
- config added

## JSPDemo

- Dependencies added
- hello controller added
- views added 
- config added

# Lecture 16 crudDTODemo

- basic project with dependencies downloaded from spring initializer
- layered architecture with all code same as SpringBootCRUDDemo
- problem when using @Entity at all layers
    - client need to send unnecessary fields which they shouldn't
    - client can modify sensitive/internal data
- solution : DTOs
- extra DTOs
- validations : dependency
- validations added at DTOs level and check at controller

# Lecture 17 Exception Handling (continued with crudDTODemo)

- API URLs refactoring
- Repeated error logic refactoring via exception handling
- Error Response DTO

# Lecture 18 profileDemo

- basic project downloaded from spring initializer
- single value read from application.properties for all environments
- application.yml 
- show different messages for different environments. How? Profiling 
- Notification Service without profile (notification sent even in dev/staging env)
- Notification Service using @Profile

# Lecture 19 filterDemo

- basic project downloaded from spring initializer
- logging filter added
- authentification filter added 
- 