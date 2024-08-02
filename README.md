# Employee Management System

## Overview

The Employee Management System is a web application for managing employee data, built with Spring Boot for the backend and React.js for the frontend. This system supports CRUD operations for employee records and provides a responsive interface for managing employee details.

## Features

- **Add New Employees**: Create new employee profiles with details such as name, position, and department.
- **View Employees**: List all employees with search and filter options.
- **Update Employee Information**: Edit existing employee details.
- **Delete Employees**: Remove employee records from the system.
- **Responsive UI**: Optimized for both desktop and mobile devices.

## Technologies Used

- **Backend**: Spring Boot
  - RESTful APIs
  - Data Persistence with JPA/Hibernate
  - PostgreSQL Database
- **Frontend**: React.js
  - User Interface Components
  - State Management with React Hooks
  - Axios for HTTP Requests
- **Database**: PostgreSQL (running inside Docker)

## Prerequisites

- **Java 11+**: Required for running the Spring Boot application.
- **Node.js and npm**: Required for running and building the React.js frontend.
- **Docker**: Required for running PostgreSQL in a Docker container.

## Installation

### Backend

1. **Clone the repository**:
    ```bash
    git clone https://github.com/sainiharshit322/employee-management-system.git
    cd employee-management-system
    ```

2. **Navigate to the backend directory**:
    ```bash
    cd backend
    ```

3. **Configure Database**:
    Ensure your PostgreSQL container is running. Update `src/main/resources/application.properties` with your database connection details. Example configuration:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
    spring.datasource.username=postgres
    spring.datasource.password=password
    ```

4. **Build and run the Spring Boot application**:
    ```bash
    mvn spring-boot:run
    ```

   By default, the backend will be running on [http://localhost:8080](http://localhost:8080).

### Frontend

1. **Navigate to the frontend directory**:
    ```bash
    cd ../frontend
    ```

2. **Install dependencies**:
    ```bash
    npm install
    ```

3. **Run the React application**:
    ```bash
    npm start
    ```

   The frontend will be running on [http://localhost:3000](http://localhost:3000).

### PostgreSQL in Docker

1. **Pull and run the PostgreSQL Docker image**:
    ```bash
    docker pull postgres
    docker run --name postgres -e POSTGRES_USER=your_username -e POSTGRES_PASSWORD=your_password -e POSTGRES_DB=employee_db -p 5432:5432 -d postgres
    ```

   - Replace `your_username` and `your_password` with your desired PostgreSQL credentials.
   - `employee_db` is the name of the database to be created.

2. **Verify the PostgreSQL container is running**:
    ```bash
    docker ps
    ```

   You should see the PostgreSQL container listed.

## API Endpoints

### Employee Management

- **Get All Employees**
  - `GET /api/employees`

- **Get Employee by ID**
  - `GET /api/employee/{id}`

- **Create New Employee**
  - `POST /api/employee`
  - Request body: `{ "name": "John Doe", "position": "Developer", "department": "IT" }`

- **Update Employee**
  - `PATCH /api/employee/{id}`
  - Request body: `{ "name": "John Doe", "position": "Senior Developer", "department": "IT" }`

- **Delete Employee**
  - `DELETE /api/employee/{id}`

## Configuration

- **Backend Configuration**: Configuration properties can be found in `src/main/resources/application.properties`.
- **Frontend Configuration**: Modify API endpoint URLs in `src/api/index.js` to match your backend deployment.

## Running Tests

- **Backend**:
    ```bash
    mvn test
    ```

- **Frontend**:
    ```bash
    npm test
    ```

## Deployment

For deployment, you can use cloud platforms like Heroku, AWS, or Docker. Ensure that environment variables and database configurations are correctly set for your production environment.

## Contributing

Feel free to contribute by creating issues or pull requests. Follow the standard GitHub workflow: fork, create a feature branch, make your changes, and submit a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

For any questions or feedback, please reach out to [sainiharshit322@gmail.com](mailto:sainiharshit322@gmail.com).

