#Shopify Backend Developer Intern Challenge
>The task is to build an inventory tracking system for a logistics company. Details of the project can be found [here](https://docs.google.com/document/d/1z9LZ_kZBUbg-O2MhZVVSqTmvDko5IJWHtuFmIu_Xg1A/#)

# Project Description

>This is a simple inventory tracking logistics system with CRUD functionality and an  additional feature of loading all 
> inventory data to a CSV file. The project was built with SpringBoot(Java).

# EndPoints
***

>#Create Inventory Item
> #### Post http://localhost:8080/api/inventory/
 
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
>#Find All Inventory
> #### Get http://localhost:8080/api/inventory/

#####Parameter
 ```
 Inventory Id
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
>#Delete Inventory
> #### Delete http://localhost:8080/api/inventory/{id}

#####Parameter
 ```
 Inventory Id
```

##Response
####200 Ok on successful request
***
>#Update Inventory Item
> #### Patch http://localhost:8080/api/inventory/{id}

#####Parameters
Path Parameter: Id
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


