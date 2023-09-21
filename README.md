# Consultant-Centre

# A Back-end project using Java & Spring Boot

# Functionalities of this project is explained below

#public interface ClientService {<br />
      public   ClientOutput   registerClient  (  ClientInput   clientInput  );
    

      public SessionOutput bookSession(int mentorId, int clientId);

#}


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


# Schemas<br />


MentorRequestInput  <br />
{  <br />
  name  :-  string<br />
  email  :-  string<br />
  age  :- 	integer<br />
  gender  :- 	string<br />
  Enum:<br />
  [ MALE, FEMALE, OTHER ]<br />  
}


ClientInput<br />
{<br />
    name  :-  	string<br />
    age  :- 	integer<br />
    gender  :-  	string<br />
    Enum:<br />
    [ MALE, FEMALE, OTHER ]<br />
    email  :-	 string<br />
  }



MentorDetailsInput<br />
{<br />
   phoneNO  :-  	string<br />
   jobRole  :-	 string<br />
   Enum:<br />
   [ HR, SDE, ASDE ]<br />
   cv  :-  	string<br />
}<br />
