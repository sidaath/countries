# countries
Simple CRUD application backend with springboot.

Country object has two values, name and id. Id is assigned automatically.

http://127.0.0.1:8080/rest/v2/countries - Returns JSON array of all countries. 

POST request at http://127.0.0.1:8080/rest/v2/countries with json in the format of {"name": "<Country name>"} adds a country to the database.
PUT  request at http://127.0.0.1:8080/rest/v2/countries/<id> with json {"name":"<new name>"} updates country with id <id.>
DELETE request at http://127.0.0.1:8080/rest/v2/countries/<id> deletes entry with given id.


