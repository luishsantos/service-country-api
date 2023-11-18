# service-country-api
service-country-api

# Requirements
* Java 11
* Docker Compose v2.21.0

# Run
Go to docker/ folder:
```shell
docker compose -f database.yaml up 
```
Go to v0.0.1 folder:

```shell
java -jar country-api-service-0.0.1.jar
```
If running on local machine, go to browser and search for:
http://localhost:8080/countries/Portugal

This should be the expected result:
```json
{"name":"Portugal","language":"Portuguese","capital":"Lisbon","currency":"Euro","latitude":39.5,"longitude":-8.0,"population":10305564}
```


