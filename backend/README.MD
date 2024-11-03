# Evalart Test
## By: David Grajales
## Date: 25 /10 /2024

### Introduction: 

This is the solution for an Evalart's test. The service has an OpenAPI swagger for an easy way to test the service out.
The application requires to have mounted the database already.

#### Dependencies

- latest docker
- OpenJDK 23
- SO (develoment enviroment): Fedora Linux 40
- Springboot 3.3.5


### Deployment instructions.

#### Local

you will need java 23 or superior to run the service.
1) Create a folder where you from where you want to launch the service
2) copy the .jar executable located in build/lib/name.jar in that folder
3) Modify the spring.r2dbc.url field in the application.yml and put your own IP
3) Copy the application.yml file to that folder
4) run the next command, edit to the PATH to the absolute path to the destination folder

```shell
java -jar PATH/your-app.jar --spring.config.location=classpath:PATH/application.yml
```
#### Docker
You need to install docker in your system and the database already up and running

1) Build the service 
```shell
./gradlew build
```
2) build the dockerfile
 ```shell
    docker build -t evalarttestbackend .
```
4) Run the dockerfile

 ```shell
    docker run -p 8080:8080 --network host evalarttestbackend
```

### Creating records in the tables and backup

Some tables have foreing key constrains that prevent the creation of records in one table if an element does not exist in another
the correct order to create elements is the following:

1) products
2) Subsidiary
3) Subsidiary branch
4) Stock

Products and Subsidiaries are independent of any other table and their fields ar just id and name.
subsidiary branches have a subsidiary_id foreing key, stock has 2 foreing key: product_id and subsiduary_branch_id.

the service allows creating and modifying all entities easily using the OpenAPi swagger.

To access the openAPi swagger just follow http://localhost:8080/swagger-ui.html

please note that I have provided a database backup. My advice is to use pgAdmin and run the sql backup file to restore the database so you can use the same data I used for my own testing

