# travelBuddy
This is an API service built with Spring Boot and Postgresql for UBC CPSC304 project.
## Endpoints
These are not all the endpoints.
### Show All Postcodes
Retrieve a list of all the postcodes.<br>
**URL:**
/postcodelist <br>
**Method:**
`GET`<br>

### Show Covid Cases
Show the number of all covid cases based on geolocaiton.<br>
**URL:**
/covidcaselist <br>
**Method:**
`GET`

### Show Covid Cases by Type
Show the number of covic cases by type.<br>
**URL:**
/covidcaselist/case?type=:type <br>
**Method:**
`GET`

### Find City by Longgitude and Latitude
**URL:**
/covidcaselist/city/:lat/:lon <br>
**Method:**
`GET`

## Get Covid Case by Longitude and Latitude
**URL:**
/covidcaselist/:lat/:lon <br>
**Method:**
`GET`

### Get Total of Covid Case by Longitude and Latitude
**URL:**
/covidcaselist/total/:lat/:lon <br>
**Method:**
`GET`

## Insert Comment
Create new comment.<br>
**URL:**
/comment <br>
**Method:**
`POST`

### Upvote Comment
**URL:**
/upvote/:id <br>
**Method:**
`PUT`

## Downvote Comment
**URL:**
/downvote/:id <br>
**Method:**
`PUT`

### Delete Comment
**URL:**
/comment/:id <br>
**Method:**
`DELETE`

### Get Comment by ID
**URL:**
/comment/:id <br>
**Method:**
`GET`


