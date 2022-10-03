# Cybeat-API
[Category](#Category)<br>
[Order](#Order)<br>
[Menu](#Menu)<br>
[Customer](#Customer)

## Category
### API call
> GET https://cybeat-api.herokuapp.com/category
> <br> Headers: "Accept: application/json"
#### Response
> List of categories as below
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
> Or message about operation as below
```text
There is no categories
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
No "id" field
No category with id 1
```
***

### API call
> POST https://cybeat-api.herokuapp.com/category
> <br> Headers: "Accept: application/json"
#### Body
`json object` which contains: <br>
* `id` required | type: `Integer` - Id of category<br>
* `name` required | type: `String` - Name of category
#### Example
> POST https://cybeat-api.herokuapp.com/category
> <br> Headers: "Accept: application/json"

Body:
```json
{
  "id": 6,
  "name": "Alcohol"
}
```
#### Response
> Message about operation as below
```text
Category stored correctly
```
***

### API call
> PUT https://cybeat-api.herokuapp.com/category/{id}
> <br> Headers: "Accept: application/json"
#### Parameters
`id` required | type: `Integer` - Id of category
#### Body
`json object` which contains: <br>
* `id` required | type: `Integer` - Id of category<br>
* `name` required | type: `String` - Name of category
#### Example
> PUT https://cybeat-api.herokuapp.com/category/1
> <br> Headers: "Accept: application/json"

Body:
```json
{
  "id": 1,
  "name": "Pasta"
}
```
#### Response
> Message about operation from list below
```text
Category updated correctly
No "id" field
No category with id 1
Id in body must be equal to id in parameters
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
No "id" field
No category with id 1
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
No "id" field
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
No "id" field
No order with id 1
```
***

## Menu
## Customer