# Institute Management System RESTful API




This project implements a RESTful API for an Institute Management System using Java and Spring Boot. It allows for the registration, modification, and retrieval of institute information. 


## Technical Requirements
- **Technology Stack:**
  - Java
  - Spring Boot
  - Spring Security
  - Database: MySQL


## Project Structure
- **The project follows a clean structure:**

  - src/main/java: Java source files
  - controllers: API endpoints
  - services: Business logic
  - repositories: Data access

## Functional Requirements

### Institute Registration

- **Endpoint:** `/institutes/registration`
- **Fields:**
  - Institute Name
  - Location
  - Contact Information
  - Additional Details

### Institute Modification

- **Endpoint:** `PUT /institutes/{instituteId}`
- **Fields:**
  - Institute Name
  - Location
  - Contact Information

### Institute Information Retrieval

- **Endpoint:** `GET /institutes/{instituteId}`

## Security and Registration Flow

1. **Institute Admin Registration:**
   - The `POST /api/institutes` endpoint allows Institute Admin registration without authentication.

2. **Login for Admin Access:**
   - After registration, the Admin needs to log in using the Spring Security login mechanism.

3. **Admin Authentication:**
   - Admin credentials are validated using Spring Security.

4. **Access Control:**
   - Upon successful authentication, the Admin gains access to other protected API endpoints, such as modifying and retrieving institute information.
  
# Dockerfile

## Use the official OpenJDK 11 image as the base image
FROM openjdk:11-jre-slim

## Set the working directory inside the container
WORKDIR /app

## Copy the compiled JAR file into the container
COPY target/institute-management-system.jar institute-management-system.jar

## Define the command to run your application
ENTRYPOINT ["java", "-jar", "institute-management-system.jar"]

## Building the Docker Image
# Build Command:


docker build -t institute-management-system:latest .
# Running the Docker Container
# Run Command:

docker run -p 9090:9090 -d --name institute-management-container institute-management-system:latest
## Stopping the Docker Container
# Stop Command:

docker stop institute-management-container
