
# Veriff API Integration - Mobile Wallet Project

## Project Overview
This project implements the **Veriff API** to integrate secure identity verification into a mobile wallet platform, facilitating smooth user onboarding and identity verification services. The project is developed by **DammyTech**, in collaboration with a company, for a proposed **mobile wallet** solution and more.

### Key Features:
- Identity verification using **Veriff API**.
- Integration with a backend system built on **Java** and **Spring Boot**.
- Built with XML configuration for a clean and organized project structure.
- Uses PostgreSQL for data storage.

## Prerequisites
To build and run this project, you need the following installed on your system:
- **Java Development Kit (JDK 11 or above)** 
- **Maven/Gradle** for dependency management
- **PostgreSQL** database
- **Spring Boot** for the backend service
- **Veriff API Key** (Sign up on Veriff's official website for access)

## Technologies Used
- **Java 11**
- **Spring Boot**
- **PostgreSQL**
- **Veriff API**
- **Thymeleaf** for templating
- **Spring Security** for authentication
- **XML Configuration** for project setup

## Installation

1. Clone the repository to your local machine:
   ```bash
   git clone https://github.com/DammyTech/veriff-api-integration.git
   ```

2. Navigate to the project directory:
   ```bash
   cd veriff-api-integration
   ```

3. Configure the database:
   - Update the `application.properties` file with your PostgreSQL credentials:
     ```properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/veriffdb
     spring.datasource.username=yourUsername
     spring.datasource.password=yourPassword
     spring.jpa.hibernate.ddl-auto=update
     ```

4. Set up your **Veriff API** credentials:
   - Add your Veriff API key in `application.properties`:
     ```properties
     veriff.api.key=your_api_key_here
     ```

5. Build the project:
   ```bash
   mvn clean install
   ```

6. Run the application:
   ```bash
   mvn spring-boot:run
   ```

## API Endpoints

- **POST** `/api/veriff/create-session`
  - This endpoint creates a new Veriff session to start the identity verification process.
  - Example request payload:
    ```json
    {
      "userId": "12345",
      "documentType": "PASSPORT",
      "callbackUrl": "https://yourapp.com/callback"
    }
    ```
  - Veriff will handle the verification process and send the result to the provided callback URL.

- **GET** `/api/veriff/session-status/{sessionId}`
  - Retrieves the current status of a specific verification session.
  - Example response:
    ```json
    {
      "status": "APPROVED",
      "reason": "Verification Successful"
    }
    ```

## Project Structure

- **src/main/java/**: Contains the Java code for the API integration, including controllers, services, and model classes.
- **src/main/resources/**: Configuration files, including `application.properties` and XML configuration.
- **src/main/resources/templates/**: Thymeleaf templates for frontend rendering.

## Contact Information
This project was developed by **DammyTech** in collaboration with a company for a proposed **mobile wallet** platform. For any queries, feature requests, or collaborations, feel free to contact **Peter Damilare** at [petersdamilare5@gmail.com](mailto:petersdamilare5@gmail.com).

## Future Enhancements
- Expand the integration to support additional user verification workflows.
- Introduce multi-factor authentication (MFA) for heightened security.
- Add support for international identity documents.
