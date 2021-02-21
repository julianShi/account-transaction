## account-transaction
A prototype to transfer money among accounts

## Steps to Run the code
- Install mysql. Use the default port 3306
- Create database, user, and grant the read/write privilege to the user
- Update the database, user, password information on https://github.com/julianShi/account-transaction/blob/main/src/main/resources/application.properties
- Do not create table. The Hinbernate will generate table automatically.
- Import the code as a Maven project to IDEA. 
- Reload Maven configuration on the pom.xml 
- Run the main method on https://github.com/julianShi/account-transaction/blob/main/src/main/java/com/systemDesign/accountTransaction/AccountApplication.java
- Once the application is running, and is listening to the port 8080, you can run the following commands on a terminal
```bash
curl -X POST 'http://localhost:8080/account?balance=100' # Create an account
curl -X GET 'http://localhost:8080/account/{id} # Get that account
curl -X GET 'http://localhost:8080/account/ # Get all accounts
```

## Resources
Video tutorials are available online 
https://youtu.be/dZwGxrr4sEQ
https://youtu.be/vgE69tJnfdQ
or
https://www.bilibili.com/video/BV1mb4y1R77C/
https://www.bilibili.com/video/BV1DK4y1S7Aq/
