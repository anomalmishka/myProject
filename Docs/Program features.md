### Search for available flights
### Filters by:
* • Airlines
* • Transfers
* • Durations
### Viewing flight information
### Login and user registration
### Password Recovery
### Booking and cancellation of tickets
### View available seats on a flight
### User Account
* • Viewing user data
* • Editing
* • Passenger list for substitution
### Admin panel
* • Blocking and unblocking users
* • Adding flights
* • Adding airlines


### General requirements:
* • Unit tests for all service entities.
* • DAO tests for all NON-CRUD requests to the database, through the database in memory.
* • Integration tests for all controller methods only for RestController(1 happy pass). There is no need to test the steals.
* • Integration tests for each business requirement in the assignment. There is no need to test stolen controllers
* • Validation of input data.
* • Isolated transactions.
* • To the application in the repository, a Postman collection should be created for all available controllers.
* • Error handling, in the form of a special entity with the fields:
* • Error code (response status by HttpStatusCode protocol)
* • Type of exception
* • Clarifications errors for the user/client
* • Services and data models should provide high flexibility for future changes. OOP SOLID and etc