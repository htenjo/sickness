# Sickness report
This repo contains some useful reports for basic sickness analysis.

## Expected behaviour:
- Load information from a predefined cvs file
- Clean and validate each record in the CSV file
- Split records which start and end date have different months 
- Persist each record in PostgreSQL
- Create multiple queries to populate each required report
- Display report information using Google Charts and simple Html/JS/Css combination.

## Tools used here:
- Java 14
- PostgreSQL (Reactive Driver)
- SpringBoot 
- Spring WebFlux
- Spring Data
- Maven
- Lombok
- Google Charts
- Html/Css/Js

## Notes:
The current requirement is to load info and create some reports with that info. Transactions, 
additional optimizations, db normalizations or any additional refinement won't be taking into account
in the initial face. 

## TODO:
- Load info from excel
- Create tables:
  - Events raw
  - Events normalized
  - Sickness groups
  - Organization units?
  - Data model
- Rest endpoints x report class