# SpringBootLattice

Video Link
-----------------
1) Google Drive - https://drive.google.com/file/d/1tv8J-HVS1Azx2l5wkRsKkxajj8h__OB6/view
2) Youtube - https://www.youtube.com/watch?v=9p9Pj07Tx8o&ab_channel=RahulTirkey

Frameworks and Libraries used,
 1) Mysql dependency
 2) Spring Web dependency
 3) Spring Data Jpa dependency (It has all the hibernate dependency)
 4) Spring Security dependency (It is used to override default behaviour for security handling)
 5) jsonwebtoken dependency (It is used for jwt token for stateless validation)
 
------------------------------------------------------------------------------------------------------------------------------------------
API Documentation(only for Inserting,Login,ShowAllPatients,Make Appointment)
-----------------------------

1) http://localhost:8080/patient (POST Request) (Allowed without any token)
  Example for RequestBody:-
  {
    "name":"vashi",
    "address":"Bangalore City",
    "email":"vashi@gmail.com",
    "phoneNo":"44543543756",
    "password":"vashi@jfds"
  }
  
  Example for ResponseBody:-
  {
    "name": "vashi",
    "address": "Bangalore City",
    "email": "vashi@gmail.com",
    "phoneNo": "44543543756",
    "password": "$2a$10$NXAVTY0DMCzS2pJXGC87r.9I.FUdC77jAn9M1iE00jn9JrI09Puli",
    "creationdate": "2021-03-21T16:59:01.612+00:00",
    "bookingDate": null,
    "booking": false,
    "role": "ROLE_USER"
}

2) http://localhost:8080/patient/login (POST Request) (Allowed without any token)
    Example for RequestBody:-
    {
    "email":"vashi@gmail.com",
    "password":""vashi@jfds"
    }
    
    Example for RequestBody:-
    {
    "token":        "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ2YXNoaUBeernbWFpbC5jb20iLCJpc1VzZXIiOnRydWUsImV4cCI6MTYxNjczMTAxNCwiaWF0IjoxNjE2MzQ2MjMyfQ.8UUVhLSL2Gpns_g6HwMeak1RU0uvP747mQS8J2wuLbl0BCXc6t0d6pFMBItChZKSrEZjLme9EUfshmK5doA_Ur2g"
    }
    
3)http://localhost:8080/allPatients (GET Request) (Token required)
  Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ2YXNoaUBeernbWFpbC5jb20iLCJpc1VzZXIiOnRydWUsImV4cCI6MTYxNjczMTAxNCwiaWF0IjoxNjE2MzQ2MjMyfQ.8UUVhLSL2Gpns_g6HwMeak1RU0uvP747mQS8J2wuLbl0BCXc6t0d6pFMBItChZKSrEZjLme9EUfshmK5doA_Ur2g
  
  Example for ResponseBody:-
  [
    {
        "name": "vashi",
        "address": "Bangalore City",
        "email": "vashi@gmail.com",
        "phoneNo": "44543543756",
        "password": "$2a$10$7LVQOFmAo5ENzrq0jsXFXOh07nZxApLU3IRVJ9eJqmy36dhLdIvaW",
        "creationdate": "2021-03-21T17:08:56.391+00:00",
        "bookingDate": null,
        "booking": false,
        "role": "ROLE_USER"
    },
    {
        "name": "dashi",
        "address": "Bangalore City",
        "email": "dashi@gmail.com",
        "phoneNo": "44543543756",
        "password": "$2a$10$uCF8ZaQuR98rCt2tlbp6/OU5tUR.F9evbMv/5qaWuEu.RJq7Bcx3C",
        "creationdate": "2021-03-21T17:09:23.005+00:00",
        "bookingDate": null,
        "booking": false,
        "role": "ROLE_USER"
    }
]

4)http://localhost:8080/patient/makeAppointment (Post Request) (Token required)
  Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ2YXNoaUBeernbWFpbC5jb20iLCJpc1VzZXIiOnRydWUsImV4cCI6MTYxNjczMTAxNCwiaWF0IjoxNjE2MzQ2MjMyfQ.8UUVhLSL2Gpns_g6HwMeak1RU0uvP747mQS8J2wuLbl0BCXc6t0d6pFMBItChZKSrEZjLme9EUfshmK5doA_Ur2g
  
  Example for RequestBody:-
  {"email" : "vashi@gmail.com"}
  
  Example for ResponseBody:-
  Appointment Successful for = vashi@gmail.com
  
-------------------------------------------------------------------------------------------------------------------------------------------------------

  
    
  
