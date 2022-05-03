# API Info

## Entity
The data in the example is stored in an entity identified by name `UserDetailsEntity`.  
It holds key identifiers, user attributes, purge flag and created/updated timestamp fields.  
Visit `com.app.hpx.springdata.model.entity.UserDetailsEntity` class for more details.

<hr/>

## Controllers

### Create `UserDetails` record
In te API will add a new user record in the `User` table.  
In response you will receive `userKey` which is a unique public identifier for record created, along with create date-time.

#### Request
```shell
curl --location --request POST 'http://localhost:8089/app/v1/user/create' \
--header 'Content-Type: application/json' \
--data-raw '{
  "userName": "JohnDoe",
  "firstName": "John",
  "lastName": "Doe"
}'
```
#### Response
```yaml
{
  "userKey": "z6waOjIJvtHhrwUVIaf25o3INVjbTJST",
  "userName": "JohnDoe",
  "firstName": "John",
  "lastName": "Doe",
  "createdDateTime": "2022-05-03T01:01:37.381",
  "updatedDateTime": "2022-05-03T01:01:37.382"
}
  ```

### Remove `UserDetails` record

#### Request
```shell
curl --location --request DELETE 'http://localhost:8089/app/v1/user?userKey=%user-key%&purge=true'
```

<hr/>