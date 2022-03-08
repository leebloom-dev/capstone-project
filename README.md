# README 
- - - -

# capstone-project
This application allows chefs(users) to save recipes.
This application will show a table of recipes.
Each recipe will also display a list of ingrediants and measurements.

- - - -

# Setting Up Spring
[start.spring.io](http://start.spring.io/)
1. Project type: Gradle
2. Language: Java
3. Spring Boot version: 2.6.3
4. Group: org.launchcode
5. Artifact: recipes (this will also change the Name and Package Name fields)
6. Packaging: JAR
7. Java version: 17
8. Add Spring Web dependency
9. Add Spring Boot DevTools dependency
10. Add Thymeleaf dependency
11. Click Generate to download the project files

### Importing the project into IntelliJ
1. Unzip the project .zip file
2. Move the resulting directory to your wherever you keep your coding projects
3. Close any open IntelliJ projects
4. From the Welcome dialog, select _Open_(see screenshot)
5. Browse to the project directory and select it

- - - -

# IntelliJ Template for New Thymeleaf Files
```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org/">
<head>
    <meta charset="UTF-8"/>
    <title></title>
</head>
<body>

</body>
</html>
```

- - - -

# IntelliJ - Connecting to MySQL
`src ==>...==> resources ==> application.properties`

Use the follow code to set the properties to allow IntelliJ to communicate with MySQL
```
spring.datasource.url=jdbc:mysql://localhost:3306/techjobs
spring.datasource.username=techjobs
spring.datasource.password=techjobs

# Specify the DBMS
spring.jpa.database = MYSQL

# Show or not log form each sql query
spring.jpa.show-sql = false

# Hibernate ddl auto (create, create-drop, update)
spring.jpa.hibernate.ddl-auto = update

# Use spring.jpa.properties.* for Hibernate native properties (the prefix is
# stripped before adding them to the entity manager)
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL8Dialect
```