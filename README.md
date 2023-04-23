### DoctorAnywhere - Interns Take Home Assignment

##### Task: 
Building a Simple RESTful API with Java and Spring Boot

##### About this project:

- Uses Maven to manage dependencies
- Uses Spring Data JPA to store the task data in a Postgresql database.

- Contains a data model for a "Task" object that includes the following properties:
  - id: Long (a unique identifier for the task)
    
  - title: String (title of the task)
    
  - description: String (description of the task)
   
  - completed: Boolean (flag indicating whether the task has been completed)
- Contains the following RESTful endpoints 
  - GET /tasks: Get a list of all tasks
    
  - POST /tasks: Create a new task
    
  - GET /tasks/{id}: Get a single task by ID
    
  - PUT /tasks/{id}: Update a task by ID
    
  - DELETE /tasks/{id}: Delete a task by ID

##### How to run this project:

1. Clone the repository from https://github.com/ramaven/DoctorAnywhereTest
2. Set language level in project structure to 17 and use Java SDK 17. 
3. Navigate to te DemoTaskApplication file and run the main method. 