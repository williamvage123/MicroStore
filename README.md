# eCommerce Microservices Project

This is an **eCommerce application** built using a **microservice architecture** with **Spring Boot**. The project is in the development phase, and currently focuses on backend microservices that communicate via **REST APIs** and **RabbitMQ**. The services are designed to handle various aspects of an eCommerce platform, such as user management, product catalog, and order processing.

## Key Features

- **Spring Boot-based Microservices**
    - Each service is developed as a standalone Spring Boot application.

- **Inter-service Communication:**
    - **REST APIs** for synchronous communication between services.
    - **RabbitMQ** for asynchronous messaging between microservices.

- **Current Services:**
    - **Product Service:** Handles product catalog and inventory (currently a placeholder).
    - **Order Service:** Manages order placement and processing (currently a placeholder).

## Technologies Used

1. **Backend:** Spring Boot (Java)
2. **Messaging:** RabbitMQ (for asynchronous communication)
3. **Communication:** RESTful APIs (for synchronous requests)
4. **Build Tools:** Maven
## REST API Overview

### **Order Service**

The Order Service handles operations related to order management. Below are the REST API endpoints for this service:

- **GET /api/orders**  
  Fetch a list of all orders.  
  **Response:** `200 OK` with an array of `OrderModel` objects.

- **POST /api/orders**  
  Create a new order.  
  **Request Body:** A JSON object representing the `OrderModel`.  
  **Response:** `201 Created` with the created `OrderModel` object.

- **GET /api/orders/{id}**  
  Fetch details of a specific order by its ID.  
  **Path Variable:** `id` (Long) - the ID of the order to retrieve.  
  **Response:** `200 OK` with the `OrderModel` object.

- **DELETE /api/orders/{id}**  
  Delete an order by its ID.  
  **Path Variable:** `id` (Long) - the ID of the order to delete.  
  **Response:** `204 No Content` (successful deletion).

### **Product Service**

The Product Service handles operations related to product management. Below are the REST API endpoints for this service:

- **GET /api/products**  
  Fetch a list of all products.  
  **Response:** `200 OK` with an array of `ProductModel` objects.

- **POST /api/products**  
  Create a new product.  
  **Request Body:** A JSON object representing the `ProductModel`.  
  **Response:** `201 Created` with the created `ProductModel` object.

- **GET /api/products/{id}**  
  Fetch details of a specific product by its ID.  
  **Path Variable:** `id` (Long) - the ID of the product to retrieve.  
  **Response:** `200 OK` with the `ProductModel` object.

- **DELETE /api/products/{id}**  
  Delete a product by its ID.  
  **Path Variable:** `id` (Long) - the ID of the product to delete.  
  **Response:** `204 No Content` (successful deletion).


## To-Do (Upcoming Features)

- **Database Integration:** Planning to add a relational database (PostgreSQL/MySQL) for persistent data storage.
- **Front-end:** Will add a front-end for user interaction using React.
- **Additional Microservices:**
    - **Payment Service:** To handle payments.
    - **Notification Service:** For sending updates via email or SMS.

---

## How to Run

1. #### Clone the repository:
   ```bash
   git clone https://github.com/williamvage123/MicroStore.git
   
2. #### Start RabbitMQ (if not already running): If you are using Docker, you can start RabbitMQ with the following command:

   ```bash
    docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:management
   ```
    This command starts RabbitMQ with the management console accessible at 
    `http://localhost:15672`

3. #### Build the Project using Maven: navigate to the root directory of your project and run the following Maven command to build the project:

    ```bash
    mvn clean install
    ```
4. #### Run the Microservices:
  - #### Order Service (Port 8081): ####
    ```bash
    cd Order
    mvn spring-boot:run   
    ```
    By default, the Order Service is configured to run on `http://localhost:8081`. You can change the port in the `application.properties` file if needed.

  - #### Product Service (Port 8082): ####
    In a separate terminal window, run:
    ```bash
    cd Product
    mvn spring-boot:run   
    ```
    By default, the Product Service is configured to run on `http://localhost:8082`. You can change the port in the `application.properties` file if needed.

5. #### Configuration
  - If you need to configure the ports differently, you can modify the `application.properties` file in each service.
6. #### Test the APIS:
    After starting both services, you can use a tool like **Postman** or **curl** to test the REST APIs:
- **Order Service API** (http://localhost:8081/api/orders)
- **Product Service API** (http://localhost:8082/api/products)




