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