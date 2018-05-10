# springboot-userapp
An app that allows login through url and first checks for website maintenance status.

To install app using docker:
Docker commands: 
-- git clone 
-- docker-compose build #docker should be installed in oyur host system.
-- docker-compose up
check whether the docker image is created -- docker images; and container is running --docker ps

To run app as spring-boot application:
Following changes need to be made in application.properties:
--change the autoddl option -- userapp.hibernate.hbm2ddl.auto=create #it will create the database for you, but you need to insert values in db(refer the init.sql)
--change the url --mysql.url=jdbc:mysql://localhost:3306/userapp

Now run the spring boot app.

After the app has started running:
check if it is running in http://localhost:8081/--it will print hello
to login from url
check url: http://localhost:8081/loginbyurl/?name=username&password=password
to set website under maintenance
check url: http://localhost:8081/setmaintenance
to reset website under maintenance
check url: http://localhost:8081/resetmaintenance
