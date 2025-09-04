# Inventory-Supply Management System

A Spring Boot application for managing inventory, supplies, and delivery operations with features for tracking expiry dates, disposal requests, and regional delivery management.

## Features

- **Inventory Management**
  - Add and track inventory items
  - Monitor expiry dates
  - View expired items

- **Disposal Management**
  - Request disposal for expired items
  - Connect with disposal companies
  - Track disposal history
  - Confirm disposal operations

- **Delivery System**
  - Regional delivery company management
  - Track delivered items
  - Manage delivery companies by location
  - Mark items as delivered

- **Predictive Analysis**
  - Region-based demand prediction
  - Seasonal demand forecasting
  - Product recommendations by region and season

## Technology Stack

- **Backend Framework:** Spring Boot
- **Database:** MySQL (via XAMPP)
- **Database Management:** phpMyAdmin
- **Build Tool:** Maven
- **Java Version:** JDK 17+

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/example/inventory/
│   │       ├── controller/    # REST endpoints
│   │       ├── model/        # Entity classes
│   │       ├── repository/   # Database repositories
│   │       └── services/     # Business logic
│   └── resources/
│       └── application.properties  # Application configuration
```

## Setup and Installation

1. **Prerequisites**
   - JDK 17 or higher
   - Maven
   - MySQL Server

2. **Database Configuration**
   - Install and start XAMPP
   - Start Apache and MySQL services in XAMPP Control Panel
   - Access phpMyAdmin through `http://localhost/phpmyadmin`
   - Create a MySQL database
   - Update application.properties with your database credentials
   - Use phpMyAdmin interface to monitor and manage database entries

3. **Build and Run**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

## API Endpoints

### Inventory Management
- `POST /add` - Add new inventory item
- `GET /fetch/{id}` - Fetch item by ID
- `GET /expired` - Get list of expired items
- `GET /abouttoexpire` - Get items about to expire

### Disposal Management
- `POST /addcompany` - Add disposal company
- `GET /disposerequest/{itemId}` - Request item disposal
- `POST /confirmdisposal/{itemId}/{companyId}` - Confirm item disposal

### Delivery Management
- `POST /adddeliverycompany` - Add delivery company
- `GET /getdeliverycompanies/{location}` - Get delivery companies by location
- `POST /markdelivered/{itemId}/{deliveryCompanyId}` - Mark item as delivered

### Predictive Analysis
- `GET /getprediction/{region}/{season}` - Get demand predictions

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.
