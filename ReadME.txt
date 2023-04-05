This application was created with Intellij IDEA. I have used mySQL for my preferred RDBMS.

To Run The Application : 

1) I have also uploaded the tables export file in the repositary, you just need to import tables inside a db (name = imtdb)
2) Import the project using IDE, intellij(Preferred) or STS/Eclipse, all the properties are in the application.properties file in the resources folder,
if you need to changes some data like mySQL connection username/password or localhost port number you can do so in the said file
3) Click Run : IDE should load all the dependecies by default, use PostMan or any other equivalent application for calling APIs.

Description : 
	 	This is an Insurance Management Platform Application that allows user to manage policies, clients and claims by performing all the CRUD operations on them. These operations
will be stored in a DB. There are total 15 different APIs that provide all the functionality required for this assignment. The structure is fairly simple and self explanatory. I have used
only the traditional conventions for structuring the projects. The models are stored inside model package, Repositaries inside repositary package and i have also made a DAO as a service
provider to the controllers. Make sure to check model properties names this will help in performing CRUD operations. For now i have skipped all the optional requirement due to time penalty
apart from the that the functionaly is good and Exception handling is also all over the controller so that when an exception occurs all the relevant message will be displayed in the 
error response JSON.



Thank You