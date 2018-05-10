# springboot-userapp
An app that allows login through url and first checks for website maintenance status.

To install app using docker:
Docker commands: 
-- git clone
create the mysql docker image which is already updated with database; check the mysql-docker folder to create that image.
-- docker build -t mysql:v4 .
you can use any tag name of your mysql image, remember to change that name in docker-compose.yml file also.
check whether the docker image is created -- docker images;
-- docker-compose build #docker should be installed in your host system.
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
