A sample Spring Boot project demonstrating a rudimentary REST API. 

Run using: 

	mvnw clean spring-boot:run
	
Port: 

	8750
	
Supported endpoints:

	GET    localhost:8750/doctors
	
	GET    localhost:8750/doctors/{id}
	
	POST   localhost:8750/doctors
	
	PUT    localhost:8750/doctors/{id}
	
	DELETE localhost:8750/doctors/{id}
	
	
A Postman collection is included with sample tests in the base directory:
	SampleCode.postman_collection.json
