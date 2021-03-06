#Shopify Backend Developer Intern Challenge
This is my solution to the Backend Developer Intern Challenge 2022. The task is to build an inventory tracking system for a logistics company. Details of the project can be found [here](https://docs.google.com/document/d/1z9LZ_kZBUbg-O2MhZVVSqTmvDko5IJWHtuFmIu_Xg1A/#)
***
#GitHub Repository
https://github.com/Leonardra/inventoryManagementSystem
***
# Project Description

This is a simple inventory tracking logistics system with CRUD functionality and an  additional feature of loading all 
inventory data to a CSV file. The project was built with SpringBoot(Java).


#Prerequisites
* Java 11
* Maven
* PostMan 
* MySQL


##To build
```shell
mvn clean install
```

##Database
To set up the database, run the sql script in [./resources/db/setup-db.sql](src/main/resources/db/setup-db.sql) on MySQL
##To run
```shell
java -jar ./target/inventoryManagement.jar
```


#Rest API Usage
***

##Create Inventory Item
> #### P0ST http://localhost:8080/api/inventory/
 
#####Parameter
 ```json
  {
  "productName": "String",
  "brand": "String",
  "productCategory": "String",
  "price": "Double"
 }
```

##Response
####200 OK on successful request 

```json
  {
  "id": "Long",
  "productName": "String",
  "brand": "String",
  "productCategory": "String",
  "price": "Double",
  "createdAt": "ISO 8601 timestamp",
  "updatedAt":"ISO 8601 timestamp"
 }
```
***
##Find All Inventory
> #### GET http://localhost:8080/api/inventory/

#####Parameter
 ```
 Inventory Id: Provide the id of the inventory
```

##Response
####302 FOUND on successful request

```json
  [
      {
      "id": "Long",
      "productName": "String",
      "brand": "String",
      "productCategory": "String",
      "price": "Double",
      "createdAt": "ISO 8601 timestamp",
      "updatedAt":"ISO 8601 timestamp"
      }
]
```
***
##Delete Inventory
> #### DELETE http://localhost:8080/api/inventory/{id}

#####Parameter
 ```
 Inventory Id
```

##Response
####200 Ok on successful request
***
##Update Inventory Item
> #### PATCH http://localhost:8080/api/inventory/{id}

#####Parameters
Path Parameter: id
 ```json
  {
  "productName": "String",
  "brand": "String",
  "productCategory": "String",
  "price": "Double"
 }
```

##Response
####200 OK on successful request

***
#Write to CSV File
####Get http://localhost:8080/api/inventory/downloadCsv


