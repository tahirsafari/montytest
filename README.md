# montytest
Sample Spring based Backend API enabled with JSON Web Token authentication
Database it connects to is mysql. For more info, please have a look at db config
Customer Controller is meant to receive and list client data. Auth Controller is meant for signup and login for users so token could be assigned.
Please follow the following steps to setup the app;
1- App is maven based so please run the required maven commands on your local environment like maven clean install .
2- Please create the database in mysql with the name mentioned in mysql.configuration file
3- DB tables will be auto generated. To create a user, you can either call api end point or run unit test added in AuthControllerTests
4- Token will have to be sent through header obviously. 

