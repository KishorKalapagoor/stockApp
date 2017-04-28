## Stock App

This application developed using spring REST to fetch stock quote details from yahoo service.
You can provide input any Stock symbols and get symbol, value.
Additional to this application log REST request in Mysql database using Hibernate.



### Usage

- Run the application and go on http://localhost:8080/
- Use the following urls to invoke controllers methods and see the interactions
  with the database:
    * `http://localhost:8080/stock/getQuote?symbols=FB+BAC+F+BMY`: get stock values for requested stock symbols.
    * `http://localhost:8080/stock/geQuoteLog?startDate=26-01-2017`: get stock quote log dump from date requested
        * `http://localhost:8080/stock/geQuoteLog.csv?startDate=26-01-2017`: get stock quote log as csv dump from date requested

### Build and run

#### Configurations

Open the `application.properties` file and set configurations for the
database connection.

#### Prerequisites

- Java 7
- Maven 3

#### From terminal

Go on the project's root folder, then type:

    $ mvn spring-boot:run

#### From Eclipse (Spring Tool Suite)

Import as *Existing Maven Project* and run it as *Spring Boot App*.
