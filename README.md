# Consultant-Centre

# A Back-end project using Java & Spring Boot

# Functionalities of this project is explained below

# mentor-req-controller


POST:- http://localhost:8080/mentor_request/add

# client-controller


POST:- http://localhost:8080/client/register

POST:- http://localhost:8080/client/book_session/mentor_id/{mentorId}/client_id/{clientId}

# admin-controller


PUT:- http://localhost:8080/admin/reject_mentor_request/{id}

PUT:- http://localhost:8080/admin/approve_mentor_request/{id}

POST:- http://localhost:8080/admin/add_mentor_details/{id}

GET:- http://localhost:8080/admin/mentor_request/get_all

GET:- http://localhost:8080/admin/get_statistics

GET:- http://localhost:8080/admin/get_mentor_by_email/{email}

GET:- http://localhost:8080/admin/get_all_mentors


# Schemas


MentorRequestInput{
name	string
email	string
age	integer
gender	string
Enum:
[ MALE, FEMALE, OTHER ]
}


ClientInput
  name	string
  age	integer
  gender	string
  Enum:
  [ MALE, FEMALE, OTHER ]
  email	string



MentorDetailsInput{
phoneNO	string
jobRole	string
Enum:
[ HR, SDE, ASDE ]
cv	string
}
