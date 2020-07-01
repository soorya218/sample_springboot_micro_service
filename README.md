# springboot micro-service
Sample Springboot microservice to show the overall structure of the code

This code uses spring-boot, hibernate (mysql) as frameworks and Java as language.

This code contains the proper way in which a micro-service can be implemented. 

# Code structure
"controller" --> where the REST APIs can be configured

"helpers/apimodels" --> where the JSON input can be converted to a format that can be used by hibernate to communicate with the mysql database

"helpers/utils" --> where the converter methods are defined which converts the JSONs and other methods which works on the data. It also functions as an interface between the Controller and the other layers below.

"helpers/responsemodels" --> where the DB entity structure is converted into appropriate JSON response that can be sent to the client through the REST API response structure

"service" --> where all the interfaces that are required for DB interaction with the layers below.

"repository" --> where the code resides which interact with the hibernate framework for the actual data storage and retrieval.

"entities" --> where the code that represents the tables in the database resides

"config" --> any configuration (such as swagger, security cors etc) can reside

"exceptions" --> where any exception handling code can reside

# Please note
Change the name of the db in application.properties and add/modify the entities to reflect the table structure before building.
