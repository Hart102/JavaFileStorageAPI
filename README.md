# File Storage Api

A Java-based server for managing file storage operations. This server allows you to:
- Accept and store files in a database.
- Retrieve all stored files.
- Retrieve a single file by its identifier.
- View file in your browser.
- Delete files from the database.

## Technologies Used

- **Java**: Backend server development.
- **Spring Boot**: Simplified application setup and management.
- **H2 Database**: Lightweight relational database for storing files.
- **Maven**: Build and dependency management.


### Prerequisites
- Java 23 or later



### HTTP Method	Endpoint	        Description
POST	        /files	            Upload a file
GET	            /files	            Retrieve all files
GET	            /files/{id}	        Retrieve a specific file
Get             /file/read/{id}     View file in the browser
DELETE	        /files/{id}	        Delete a specific file