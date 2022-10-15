# Cybeat-API
[Category](#Category)<br>
[Customer](#Customer)<br>
[Order](#Order)<br>
[Dish](#Dish)<br>

## Category
### API call
> GET https://cybeat-api.herokuapp.com/category
> <br> Headers: "Accept: application/json"
#### Response
> List of categories
```json
[
  {
    "id": 1,
    "name": "Sushi"
  },
  {
    "id": 2,
    "name": "Pizza"
  }
]
```
***


### API call
> GET https://cybeat-api.herokuapp.com/category/{id}
> <br> Headers: "Accept: application/json"
#### Parameters
`id` required | type: `Integer` - Id of category
#### Example
> GET https://cybeat-api.herokuapp.com/category/1
> <br> Accept: application/json
#### Response
> Category with specified id as below
```json
{
  "id": 1,
  "name": "Sushi"
}
```
> Or message about operation from list below
```text
No "id" field in body of request
No category with id 1
```
***


### API call
> POST https://cybeat-api.herokuapp.com/category
> <br> Headers: "Accept: application/json"
#### Body
`json object` which contains: <br>
* `name` required | type: `String` - Name of category
#### Example
> POST https://cybeat-api.herokuapp.com/category
> <br> Headers: "Accept: application/json"

Body:
```json
{
  "name": "Alcohol"
}
```
#### Response
> Category with specified id as below
```json
{
  "id": 16,
  "name": "Alcohol"
}
```
> Message about operation as below
```text
An error occurred, try later
```
***


### API call
> PUT https://cybeat-api.herokuapp.com/category/{id}
> <br> Headers: "Accept: application/json"
#### Parameters
`id` required | type: `Integer` - Id of category
#### Body
`json object` which contains: <br>
* `name` required | type: `String` - Name of category
#### Example
> PUT https://cybeat-api.herokuapp.com/category/1
> <br> Headers: "Accept: application/json"

Body:
```json
{
  "name": "Pasta"
}
```
#### Response
> Message about operation from list below
```text
Category updated correctly
No "id" field in body of request
No category with id 1
```
***


### API call
> DELETE https://cybeat-api.herokuapp.com/category/{id}
> <br> Headers: "Accept: application/json"
#### Parameters
`id` required | type: `Integer` - Id of category
#### Example
> DELETE https://cybeat-api.herokuapp.com/category/1
> <br> Headers: "Accept: application/json"
#### Response
> Message about operation from list below
```text
Category removed correctly
No "id" field in body of request
No category with id 1
```
***


### API call
> DELETE https://cybeat-api.herokuapp.com/category
> <br> Headers: "Accept: application/json"
#### Response
> Message about operation from list below
```text
0 entries deleted
```
***


## Customer
### API call
> GET https://cybeat-api.herokuapp.com/customer
> <br> Headers: "Accept: application/json"
#### Response
> List of customers
```json
[
  {
    "id": 6,
    "firstName": "Jane",
    "lastName": "Smith",
    "phone": "89500442211",
    "registrationDate": "Oct 15, 2022, 1:40:51 PM"
  },
  {
    "id": 4,
    "firstName": "John",
    "lastName": "Snow",
    "phone": "89500442211",
    "registrationDate": "Oct 10, 2022, 6:35:51 PM"
  }
]
```
***


### API call
> GET https://cybeat-api.herokuapp.com/customer/{id}
> <br> Headers: "Accept: application/json"
#### Parameters
`id` required | type: `Integer` - Id of customer
#### Example
> GET https://cybeat-api.herokuapp.com/customer/1
> <br> Accept: application/json
#### Response
> Customer with specified id as below
```json
{
  "id": 4,
  "firstName": "John",
  "lastName": "Snow",
  "phone": "89500442211",
  "registrationDate": "Oct 10, 2022, 6:35:51 PM"
}
```
> Or message about operation from list below
```text
No "id" field in body of request
No category with id 1
```
***


### API call
> POST https://cybeat-api.herokuapp.com/customer
> <br> Headers: "Accept: application/json"
#### Body
`json object` which contains: <br>
* `firstName` required | type: `String` - First name
* `lastName` required | type: `String` - Last name
* `phone` required | type: `String` - Phone
* `registrationDate` required | type: `String` - Date of registration
#### Example
> POST https://cybeat-api.herokuapp.com/customer
> <br> Headers: "Accept: application/json"

Body:
```json
{
  "firstName": "Mike",
  "lastName": "Ross",
  "phone": "+89500332255",
  "registrationDate": "Oct 15, 2022, 1:40:51 PM"
}
```
#### Response
> Customer with specified id as below
```json
{
  "id": 7,
  "firstName": "Mike",
  "lastName": "Ross",
  "phone": "+89500332255",
  "registrationDate": "Oct 15, 2022, 1:40:51 PM"
}
```
> Message about operation as below
```text
An error occurred, try later
```
***


### API call
> PUT https://cybeat-api.herokuapp.com/customer/{id}
> <br> Headers: "Accept: application/json"
#### Parameters
`id` required | type: `Integer` - Id of customer
#### Body
`json object` which contains: <br>
* `firstName` required | type: `String` - First name
* `lastName` required | type: `String` - Last name
* `phone` required | type: `String` - Phone
* `registrationDate` required | type: `String` - Date of registration
#### Example
> PUT https://cybeat-api.herokuapp.com/customer/1
> <br> Headers: "Accept: application/json"

Body:
```json
{
  "firstName": "John",
  "lastName": "Snow",
  "phone": "89500442211",
  "registrationDate": "Oct 10, 2022, 6:35:51 PM"
}
```
#### Response
> Message about operation from list below
```text
Customer updated correctly
No "id" field in body of request
No customer with id 1
```
***


### API call
> DELETE https://cybeat-api.herokuapp.com/category/{id}
> <br> Headers: "Accept: application/json"
#### Parameters
`id` required | type: `Integer` - Id of category
#### Example
> DELETE https://cybeat-api.herokuapp.com/category/1
> <br> Headers: "Accept: application/json"
#### Response
> Message about operation from list below
```text
Category removed correctly
No "id" field in body of request
No category with id 1
```
***


### API call
> DELETE https://cybeat-api.herokuapp.com/customer
> <br> Headers: "Accept: application/json"
#### Response
> Message about operation from list below
```text
0 entries deleted
```
***


## Dish
### API call
> GET https://cybeat-api.herokuapp.com/dish
> <br> Headers: "Accept: application/json"
#### Response
> List of dishes
```json
[
  {
    "id": 7,
    "item": "Test item",
    "categoryId": 17,
    "amount": 1,
    "price": 1.00
  },
  {
    "id": 8,
    "item": "Burger",
    "categoryId": 17,
    "amount": 200,
    "price": 19.90,
    "weight": 50,
    "calories": 67,
    "description": ""
  }
]
```
***


### API call
> GET https://cybeat-api.herokuapp.com/dish/{id}
> <br> Headers: "Accept: application/json"
#### Parameters
`id` required | type: `Integer`
#### Example
> GET https://cybeat-api.herokuapp.com/dish/8
> <br> Accept: application/json
#### Response
> Dish with specified id as below
```json
{
  "id": 8,
  "item": "Burger",
  "categoryId": 17,
  "amount": 200,
  "price": 19.90,
  "weight": 50,
  "calories": 67,
  "description": ""
}
```
> Or message about operation from list below
```text
No "id" field in body of request
No dish with id 1
```
***


### API call
> POST https://cybeat-api.herokuapp.com/dish
> <br> Headers: "Accept: application/json"
#### Body
`json object` which contains: <br>
* `item` required | type: `String`
* `categoryId` required | type: `Integer` - foreign key to Categories.id
* `amount` required | type: `Integer`
* `price` required | type: `BigDecimal/Float/Double`
* `weight` optional | type: `Integer nullable` - in grams
* `calories` optional | type: `Integer nullable` - in kcal
* `image` optional | type: `Integer nullable` - path
* `description` optional | type: `String nullable`
#### Example
> POST https://cybeat-api.herokuapp.com/dish
> <br> Headers: "Accept: application/json"

Body:
```json
{
  "item": "Burger",
  "categoryId": 17,
  "amount": 200,
  "price": 19.90,
  "weight": 50,
  "calories": 67,
  "image": null,
  "description": ""
}
```
#### Response
> Dish with specified id as below
```json
{
  "id": 8,
  "item": "Burger",
  "categoryId": 17,
  "amount": 200,
  "price": 19.90,
  "weight": 50,
  "calories": 67,
  "description": ""
}
```
> Message about operation as below
```text
An error occurred, try later
```
***


### API call
> PUT https://cybeat-api.herokuapp.com/dish/{id}
> <br> Headers: "Accept: application/json"
#### Parameters
`id` required | type: `Integer`
#### Body
`json object` which contains: <br>
* `item` required | type: `String`
* `categoryId` required | type: `Integer` - foreign key to Categories.id
* `amount` required | type: `Integer`
* `price` required | type: `BigDecimal/Float/Double`
* `weight` optional | type: `Integer nullable` - in grams
* `calories` optional | type: `Integer nullable` - in kcal
* `image` optional | type: `Integer nullable` - path
* `description` optional | type: `String nullable`
#### Example
> PUT https://cybeat-api.herokuapp.com/dish/7
> <br> Headers: "Accept: application/json"

Body:
```json
{
  "id": 7,
  "item": "Test item",
  "categoryId": 17,
  "amount": 1,
  "price": 1.00
}
```
#### Response
> Message about operation from list below
```text
Dish updated correctly
No "id" field in body of request
No dish with id 1
```
***


### API call
> DELETE https://cybeat-api.herokuapp.com/dish/{id}
> <br> Headers: "Accept: application/json"
#### Parameters
`id` required | type: `Integer`
#### Example
> DELETE https://cybeat-api.herokuapp.com/dish/1
> <br> Headers: "Accept: application/json"
#### Response
> Message about operation from list below
```text
Dish removed correctly
No "id" field in body of request
No dish with id 1
```
***


### API call
> DELETE https://cybeat-api.herokuapp.com/dish
> <br> Headers: "Accept: application/json"
#### Response
> Message about operation from list below
```text
0 entries deleted
```
***


## Order
### API call
> GET https://cybeat-api.herokuapp.com/order
> <br> Headers: "Accept: application/json"
#### Response
> List of orders as below
```json
[
  {
    "id": 1,
    "contents": [
      {
        "id": 1,
        "item": {
          "id": 1,
          "item": "Ham Sandwich",
          "category": {
            "id": 3,
            "name": "Burgers"
          },
          "amount": 2,
          "price": 55,
          "weight": 100,
          "calories": 100,
          "image": ""
        }
      },
      {
        "id": 2,
        "item": {
          "id": 2,
          "item": "Water",
          "category": {
            "id": 4,
            "name": "Drinks"
          },
          "amount": 1,
          "price": 15,
          "weight": 250,
          "calories": 100,
          "image": ""
        }
      }
    ]
  },
  {
    "id": 2,
    "contents": [
      {
        "id": 5,
        "item": {
          "id": 5,
          "item": "Cheeseburger",
          "category": {
            "id": 2,
            "name": "Pizza"
          },
          "amount": 1,
          "price": 85,
          "weight": 230,
          "calories": 501,
          "image": ""
        }
      },
      {
        "id": 6,
        "item": {
          "id": 2,
          "item": "Water",
          "category": {
            "id": 4,
            "name": "Drinks"
          },
          "amount": 2,
          "price": 15,
          "weight": 250,
          "calories": 100,
          "image": ""
        }
      }
    ]
  }
]
```
> Or message about operation as below
```text
There is no orders
```
***
### API call
> GET https://cybeat-api.herokuapp.com/order/{id}
> <br> Headers: "Accept: application/json"
#### Parameters
`id` required | type: `Integer` - Id of order
#### Example
> GET https://cybeat-api.herokuapp.com/order/1
> <br> Accept: application/json
#### Response
> Order with specified id as below
```json
{
  "id": 1,
  "contents": [
    {
      "id": 1,
      "item": {
        "id": 1,
        "item": "Ham Sandwich",
        "category": {
          "id": 3,
          "name": "Burgers"
        },
        "amount": 2,
        "price": 55,
        "weight": 100,
        "calories": 100,
        "image": ""
      }
    },
    {
      "id": 2,
      "item": {
        "id": 2,
        "item": "Water",
        "category": {
          "id": 4,
          "name": "Drinks"
        },
        "amount": 1,
        "price": 15,
        "weight": 250,
        "calories": 100,
        "image": ""
      }
    }
  ]
}
```
> Or message about operation from list below
```text
No "id" field in body of request
No order with id 1
```
***
### API call
> GET https://cybeat-api.herokuapp.com/order/{id}/total
> <br> Headers: "Accept: application/json"
#### Parameters
`id` required | type: `Integer` - Id of order
#### Example
> GET https://cybeat-api.herokuapp.com/order/1
> <br> Accept: application/json
#### Response
> Order total with specified id as below
231
> Or message about operation from list below
```text
No "id" field in body of request
No order with id 1
```
***