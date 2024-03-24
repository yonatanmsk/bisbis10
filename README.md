The bisbis10 restaurant management system you’re envisioning is a backend service designed to handle various operations related to restaurants, their dishes, and ratings. Here’s a general description of the system:

Restaurant Management System Overview
Purpose: The system aims to provide a comprehensive platform for managing restaurant data, including details about the restaurants, their cuisines, dishes, and customer ratings.

Functionality:

Restaurants API: Allows users to retrieve information about all restaurants or filter them by cuisine. Users can also view details of a specific restaurant, add new restaurants, update existing ones, or delete them.
Ratings API: Enables customers to post ratings for restaurants, which can be used to calculate the overall rating and improve the restaurant’s service based on customer feedback.
Dishes API: Manages the dishes offered by each restaurant, including the ability to add, update, or delete dishes, as well as retrieve a list of dishes for a specific restaurant.
Example endpoints:

GET /restaurants: Fetches a list of all restaurants with basic details. <br>
GET /restaurants?cuisine=: Retrieves restaurants that match a specific cuisine.<br>
GET /restaurants/{id}: Provides detailed information about a single restaurant, including its dishes.<br>
POST /restaurants: Adds a new restaurant to the system.<br>
PUT /restaurants/{id}: Updates the details of an existing restaurant.<br>
DELETE /restaurants/{id}: Removes a restaurant from the system.<br>
POST /ratings: Submits a new rating for a restaurant.<br>
POST /restaurants/{id}/dishes: Adds a new dish to a restaurant’s menu.<br>
PUT /restaurants/{id}/dishes/{dishId}: Updates the details of an existing dish.<br>
DELETE /restaurants/{id}/dishes/{dishId}: Deletes a dish from the restaurant’s menu.<br>
GET /restaurants/{id}/dishes: Retrieves the list of dishes offered by a restaurant.<br>
Technical Aspects:

The system should be built using Java Spring Boot, leveraging its robust framework for creating RESTful APIs.
Data persistence can be managed using an in-memory database like H2 for simplicity, or a more robust solution like PostgreSQL for production.
Proper validation, error handling, and response status codes are essential for a smooth user experience.
Unit and integration tests should be written to ensure the reliability of the API endpoints.
Homework Task:

Candidates are expected to design and implement the above APIs, adhering to RESTful principles.
The task will assess their ability to create a well-structured backend service, handle database operations, and follow best practices in API development.
This homework assignment will give you insight into the candidate’s technical skills, problem-solving abilities, and familiarity with backend development using Java Spring Boot. 🚀🍽️



## Restaurants APIs

| API Description           | Endpoint                | Request Body                                             | Response Status | Response Body                                                                                           |
|---------------------------|-------------------------|----------------------------------------------------------|-----------------|--------------------------------------------------------------------------------------------------------|
| Get all restaurants       | GET /restaurants        |                                                          | 200 OK          | [{"id": "1","name": "Taizu","rating" : 4.83,"isKosher" : false,"cuisines": ["Asian","Mexican","Indian"]}] |
| Get restaurants by cuisine| GET /restaurants?cuisine= |                                                         | 200 OK          | [{"id": "1","name": "Taizu","rating" : 4.83,"isKosher" : false,"cuisines": ["Asian","Mexican","Indian"]}] |
| Get restaurant            | GET /restaurants/       |                                                          | 200 OK          | {"id": "1","name": "Taizu","rating" : 4.83,"isKosher" : false,"cuisines": ["Asian","Mexican","Indian"],"dishes": [{"id": "1","name": "Noodles","description": "Amazing one","price": 59}]} |
| Add a restaurant          | POST /restaurants       | {"name": "Taizu","isKosher": false,"cuisines": ["Asian","Mexican","Indian"]} | 201 CREATED     |                                                                                                        |
| Update a restaurant       | PUT /restaurants/       | {"cuisines": ["Asian"]}                                 | 200 OK          |                                                                                                        |
| Delete a restaurant       | DELETE /restaurant/     |                                                          | 204 No Content  |                                                                                                        |

## Ratings APIs

| API Description           | Endpoint               | Request Body                          | Response Status | Response Body |
|---------------------------|------------------------|---------------------------------------|-----------------|---------------|
| Add a restaurant rating   | POST /ratings          | {"restaurantId": 2, "rating":3.3}     | 200 OK          |               |

## Order APIs

| API Description           | Endpoint               | Request Body                          | Response Status | Response Body |
|---------------------------|------------------------|---------------------------------------|-----------------|---------------|
| Order    | POST /order          | {"restaurantId": 2, orderItems:[{"dishId":12,amount:1},{"dishId":14,amount:1}  ]   | 200 OK          |  {orderId:"ef401fc8-d545-424b-928d-4789cd47bb6e"}             |

## Dishes APIs

| API Description           | Endpoint                | Request Body                             | Response Status | Response Body                                                     |
|---------------------------|-------------------------|------------------------------------------|-----------------|------------------------------------------------------------------|
| Add a dish                | POST /restaurants//dishes | {"name":"Shakshuka","description":"Great one","price": 34} | 201 CREATED     |                                                                  |
| Update a dish             | PUT /restaurants//dishes/ | {"description":"Great one","price": 34} | 200 OK          |                                                                  |
| Delete a dish             | DELETE /restaurants//dishes/ |                                        | 204 No Content  |                                                                  |
| Get dishes by a restaurant| GET /restaurants//dishes  |                                         | 200 OK          | [{"id":"1","name":"Humus","description":"Good one","price": 48}] |




## Jump Start:
For your convenience compose.yml includes Postgresql DB, the app is already pointing to this connection.
in addition, you have the schema and data SQL files that can setup your DB schema and init data. 


## Instructions:
 1. fork this repo to your GitHub account.
 2. clone it to your local machine.
 3. complete the tasks.
 4. submit a pull request with your solution
