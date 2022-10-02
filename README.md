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
> POST https://cybeat-api.herokuapp.com/category/1
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

## Order

> Soon

## Menu
## Customer