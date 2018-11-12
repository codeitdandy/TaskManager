# TaskManager

Task Manager : Spring Boot 2.0.6 Release Based Simple Project to load tasks asynchronously into the front end while also providing REST based call API to consume tasks.
This Project demonstrates the use of Server Side Emits to produce an event stream of text , instead of blocking calls of HTTP thread based cycle.

# Getting Started
Download/Clone the Repository into local workspace.
Maven manages all dependencies, import the project as an Existing Maven Project in your favourite IDE and resolve Maven updates (if required) and build and run the project
It can be built and run from the command line using mvn spring-boot:run
It can also be run as a jar file , use maven goals like mvn package to create snapshot uber jars available in target folder

# Prerequisites
IDE Supporting
Maven tool installed as a command line option.
PostgreSQL installed in local machine ( localhost exposing port 5432 user postgresql)

# Test
It provides a simple RESTful API with /tasks to fetch all the tasks aysnchronously.
API is available at  http://localhost:8080/tasks. 
Use either POSTMAN or Chrome Advanced REST Client or any of your favourite REST clients to fetch the tasks.

# Security

To demonstrate the security aspects and explore the Spring boot advancements in security, spring-boot starter security is used to secue the REST endpoints. It acts a simple HTTP basic authentication .(There is a maven dependency available to import for spring boot starter security)
To keep things simple , HTTP basic authentication is demonstrated by allowing for the system generated Key value each time the TaskManager server starts. It is possible to create your own username and passwords along with authentication and authorization by writing wrappers around spring boot security configuration but has been left out in this project to demonstrate the concept.

Use the following combination for basic authenticaton. (USER:user ,password: System generated Token available in the console , For eg: Check the console for Using generated security password: <8fbfbb1f-f312-45b5-8a97-ace73376c3a6>


# Deployment
Docker is being used as a mode of deploying. 
For this, Docker CE needs to be installed in your machine there will be requirement of Dockerfile which will create docker images.
Docker runs best with Linux but is equally supported in Windows, Macs. Check Accordingly

https://docs.docker.com/install/#nightly-builds

TaskManager is thought to be running as an independent service running in together will ScheduledTaskCreator service. Docker -compose file will allow managing both the container together.

A Docker image in docker hub is already made available for both creator and manager services.(rajarshi02/taskscheduler) ,(rajarshi02/taskmanager)

If interested to pull the images via hub , run the following docker pull rajarshi02/taskManager, docker pull rajarshi02/taskscheduler 

Else just run docker-compose up , followed by 

docker pull postgres (pull postgresql dependency supported for Version 10 and test whether it can connect to localhost at 5432, for remote hosts this will need to be changed in application.properties in the ScheduledTaskCreator codebase and configuration files in postgres (if required)  --> This pull of image is intentionally kept outside the docker-compose

Alternatively , this project can also be built locally for doing any changes by using the Dockerfile by running the below command and then running docker-compose 

docker build -t rajarshi02/taskmanager .



