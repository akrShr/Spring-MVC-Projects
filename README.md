# Spring-MVC-Projects

Customer Relationship Management :- To Track customers

Spring MVC and Hibernate mySQL App

Software Version:- Spring 5
		   Hibernate 5

We can do major CRUD operations needed to do with Spring MVC and Hibernate project

	Add new customers

	Update existing customers

	Delete customers

	List all customers in our database

The application should list employees on an HTML page in tabular format. The data in the table will be sorted on the last name in ascending order alphabetically.
On the top left corner, there will be a button to add an employee in the database. Once you click it a form appears to capture employee details. On saving the details, the user is redirected to the see the list of employees again.

With each row in the employee record table, we should have a button to update that employee record or delete it. On update, a prepopulated form with corresponding employee row's data appear. User can modify it and save to reflect changes on the list of employees presented in tabular format.
Once the user selects an employee to be deleted, the system will prompt us whether we want to delete the record. After the user confirms deletion the list of employees on the HTML page is refreshed.


Code Flow
Our browser will make a request to CustomerController which interact with CustomerService. The service layer will make use of data access object of CustomerDAO through which application connects to MySQL database over Hibernate.
Once we get the data back from the database then the controller places data in Spring MVC model to send it over to JSP pages. JSP pages render that data to web pages.

To interact with the database we use design pattern of Data Access Object(DAO). DAO uses the Hibernate API to access database calls. Between controller and DAO sit service layer with custom business logic. It is built on a Facade pattern.

Application Calls
Note: All calls are preceded by /customer

/listAll -> Get request : to dispaly all customers present in database.

/saveCustomer ->Post request : to save or update a Customer record.

/deleteCustomer -> Get request : to delete a Customer record.


################################################################################


Student Admission Management

Spring MVC with Spring MVC form validations

Software Version:- Spring 5
		   Hibernate 5

Student can enter details about them, which are captured and displayed on another page, once the data entered by the student is validated. The detail about the student is displayed with a message 'Hello' hence a student can verify that system correctly processed the information.

Once the application is loaded a welcome message appears and beneath there is a login page. The page will capture student details like First Name, Last Name, Student ID, Country etc. The Spring MVC form has input text fields, dropdown, checkboxes and radio buttons with labels either populated from business logic(Model) or properties file. 

These fields have validations as required field, fields with no whitespaces allowed, fields only supporting numeric data of specific length(Mobile), numeric data to be greater than a number(Age) and fields with custom validations like Student ID must start with 'NSD'. For validations, the system can also override default messages via a properties file.

If student's entered data is validated properly it is processed like the First Name and Last Name is combined and displayed on the next page with a 'Hello' message and other student's entered details.

CodeFlow
The browser interact with FrontController(WelcomeController) which delegate request to different controller classes (StudentController,ManagementController). From controller model object is passed to views so to capture student's data and comes back to the controller again for processing. Again controller populates model object and passes it to view to render response on the browser.
