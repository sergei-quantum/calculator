# Reverse polish notation calculator
Command line RPN calculator implementation with history (undo operation) support.

## Required dependencies
Please make sure you have the next dependencies installed on your laptop:
 - Java 11
 - Maven (3.1.0 and up)
 
##Running tests
- run `mvn test` command to execute all tests
 
##Building the project
- run `mvn clean install` to build the project

##Running the project
- run `java -jar target/calculator-1.0-SNAPSHOT.jar` to execute the application

###Supported operations
At the current moment it supports next operations:
 `+`, `-`, `*`, `/`, `sqrt`, `undo`, `clear`