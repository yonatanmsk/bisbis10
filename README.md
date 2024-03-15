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

## Dishes APIs

| API Description           | Endpoint                | Request Body                             | Response Status | Response Body                                                     |
|---------------------------|-------------------------|------------------------------------------|-----------------|------------------------------------------------------------------|
| Add a dish                | POST /restaurants//dishes | {"name":"Shakshuka","description":"Great one","price": 34} | 201 CREATED     |                                                                  |
| Update a dish             | PUT /restaurants//dishes/ | {"description":"Great one","price": 34} | 200 OK          |                                                                  |
| Delete a dish             | DELETE /restaurants//dishes/ |                                        | 204 No Content  |                                                                  |
| Get dishes by a restaurant| GET /restaurants//dishes  |                                         | 200 OK          | [{"id":"1","name":"Humus","description":"Good one","price": 48}] |