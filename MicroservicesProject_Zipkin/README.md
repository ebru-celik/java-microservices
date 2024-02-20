

# Spring Cloud Zipkin  & Sleuth


Zipkin & Sleuth Configuration has been established.


```
docker run --name my-postgresdb -e POSTGRES_PASSWORD=123456789 -d -p 9999:5432 postgres
```

```
docker run --name my-zipkin -d -p 9411:9411 --memory=256m  openzipkin/zipkin
```
