# travelBuddy
This is an API service built with Spring Boot and Postgresql for UBC CPSC304 project.

## Show All Postcodes
Retrieve a list of all the postcodes.<br>
**URL:**
/postcodelist <br>
**Method:**
`GET`<br>

## Show Covid Cases
Show the number of all covid cases based on geolocaiton.<br>
**URL:**
/covidcaselist <br>
**Method:**
`GET`

## Show Covid Cases by Type
Show the number of covic cases by type.<br>
**URL:**
/covidcaselist/casetype/:casetype <br>
**Method:**
`GET`


## Insert Comment
Create new comment.<br>
**URL:**
/comment <br>
**Method:**
`POST`

## Upvote Comment
**URL:**
/upvote <br>
**Method:**
`PUT`


## Downvote Comment
**URL:**
/downvote <br>
**Method:**
`PUT`


## Get Comment by ID
**URL:**
/comment/:id <br>
**Method:**
`GET`


