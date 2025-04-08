# 🏛️ Rule Forge - Financial Rules Engine

<div align="center">

![Java](https://img.shields.io/badge/Java-21-orange?logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.1-brightgreen?logo=spring)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue?logo=postgresql)
![MongoDB](https://img.shields.io/badge/MongoDB-6.0-green?logo=mongodb)
![Neo4j](https://img.shields.io/badge/Neo4j-5.0-blue?logo=neo4j)
![License](https://img.shields.io/badge/License-MIT-yellow)

*A sophisticated financial rules engine built with Domain-Driven Design and Clean Architecture principles*

</div>

## 📋 Overview

**Rule Forge** is a powerful and flexible financial rules engine that allows users to create, manage, and execute complex business rules through a tree-based structure. Built with modern software architecture principles, it provides a robust foundation for financial decision-making systems.

### 🎯 Key Features

- **Dynamic Rule Creation**: Build complex financial rules using a visual tree structure
- **Multi-Input Support**: Handle both predefined and dynamic input structures
- **Real-time Validation**: Execute rules against JSON data with immediate feedback
- **Version Control**: Complete history tracking of rule modifications
- **Comparison Operations**: Support for singular and multi-value comparisons
- **Action System**: Execute actions based on rule outcomes
- **RESTful API**: Complete REST API with OpenAPI/Swagger documentation

## 🏗️ Architecture

This project follows **Domain-Driven Design (DDD)** and **Clean Architecture** principles, heavily utilizing Java Generics for type safety and code reusability.

### 📁 Project Structure

```
src/main/java/com/git/rule_forge/
├── 📦 _shared/              # Shared components across all modules
│   ├── application/         # Application services and use cases
│   ├── domain/             # Core domain entities and value objects
│   └── infrastructure/     # Infrastructure implementations
├── 📦 modules/
│   ├── input/              # Input management module
│   │   ├── domain/         # Input domain logic
│   │   ├── application/    # Input services and use cases
│   │   ├── infrastructure/ # Input persistence
│   │   └── adapter/        # Input controllers and DTOs
│   ├── tree/               # Rule tree management
│   │   ├── _shared/        # Shared tree components
│   │   ├── root/          # Root tree nodes (Static/Dynamic)
│   │   ├── node/          # Tree nodes (Block/If)
│   │   ├── comparison/    # Comparison operations
│   │   ├── action/        # Action nodes
│   │   └── generator/     # Tree generation services
│   └── engine/            # Rule execution engine
├── 📦 configuration/       # Application configuration
├── 📦 exception/          # Global exception handling
├── 📦 logging/           # Logging infrastructure
└── 📦 utils/            # Utility classes and annotations
```

### 🔧 Technology Stack

#### Core Framework
- **Java 21** - Latest LTS version with modern language features
- **Spring Boot 3.4.1** - Application framework with auto-configuration
- **Spring Security** - Authentication and authorization
- **Spring Data JPA** - Database abstraction layer

#### Databases
- **PostgreSQL** - Primary relational database for structured data
- **MongoDB** - Document database for logs and unstructured data
- **Neo4j** - Graph database for complex relationships (future use)

#### Additional Technologies
- **MapStruct** - Type-safe bean mapping
- **Swagger/OpenAPI 3** - API documentation
- **JWT** - Token-based authentication
- **Docker Compose** - Multi-container deployment
- **Hibernate** - ORM with advanced mapping strategies

## 🚀 Getting Started

### Prerequisites

- Java 21+
- Docker and Docker Compose
- Maven 3.9+

### 🐳 Quick Start with Docker

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/rule-forge.git
   cd rule-forge
   ```

2. **Start the infrastructure**
   ```bash
   docker-compose up -d
   ```

3. **Run the application**
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Access the API documentation**
   ```
   http://localhost:8080/api/swagger-ui.html
   ```

### 🔧 Manual Setup

#### Database Setup

**PostgreSQL** (Primary Database)
```sql
CREATE DATABASE application-database;
CREATE USER postgres WITH PASSWORD 'postgres';
GRANT ALL PRIVILEGES ON DATABASE application-database TO postgres;
```

**MongoDB** (Logging)
```bash
# MongoDB connection configured for logging service
# Default connection: mongodb://mongoadmin:secret@localhost:27017/app_logs
```

#### Environment Variables

Create a `.env` file in the root directory:

```env
# JWT Configuration
JWT_PUBLIC_KEY=your_public_key_here
JWT_PRIVATE_KEY=your_private_key_here

# Database Configuration
DB_HOST=localhost
DB_PORT=5432
DB_NAME=application-database
DB_USER=postgres
DB_PASSWORD=postgres

# MongoDB Configuration
MONGO_HOST=localhost
MONGO_PORT=27017
MONGO_DATABASE=app_logs
MONGO_USER=mongoadmin
MONGO_PASSWORD=secret

# Neo4j Configuration (Optional)
NEO4J_URI=neo4j://localhost:7999
NEO4J_USER=neo4j
NEO4J_PASSWORD=password
```

## 📖 Core Concepts

### 🌳 Rule Trees

Rule Forge organizes business rules in a hierarchical tree structure:

#### Root Nodes
- **Static Root**: Uses predefined input types (Person, Transaction, etc.)
- **Dynamic Root**: Uses custom JSON schemas defined at runtime

#### Tree Nodes
- **Block Nodes**: Group multiple operations that execute sequentially
- **If Nodes**: Conditional branches with if-then-else logic
- **Comparison Nodes**: Evaluate conditions (equals, greater than, contains, etc.)
- **Action Nodes**: Execute operations when rules are satisfied

### 🎯 Input System

#### Static Inputs (Predefined)
```java
public enum PredefinedTypeEnum {
    PERSON,           // Person-related validations
    TRANSACTION,      // Financial transaction rules
    ACCOUNT,          // Account validation rules
    DOCUMENT          // Document verification rules
}
```

#### Dynamic Inputs
Custom JSON schemas that define the structure of input data:

```json
{
  "name": "Custom Transaction Rule",
  "fields": {
    "amount": "Double",
    "currency": "String",
    "account.balance": "Double",
    "metadata.tags": "Array<String>"
  }
}
```

### 🔍 Comparison Operations

#### Singular Comparisons
- `IsEquals` - Exact equality
- `IsDifferent` - Inequality
- `IsLessThan` - Numeric less than
- `IsLessThanOrEqual` - Numeric less than or equal
- `IsMoreThan` - Numeric greater than
- `IsMoreThanOrEqual` - Numeric greater than or equal

#### Multi-Value Comparisons
- `Contains` - Value exists in array
- `NotContains` - Value doesn't exist in array

## 🔌 API Usage

### Creating a Static Rule Tree

```bash
POST /api/tree/root/static
Content-Type: application/json

{
  "name": "High Value Transaction Rule",
  "input_type": "TRANSACTION",
  "nodes": [
    {
      "type": "NodeTreeBlock",
      "name": "Validation Block",
      "nodes": [
        {
          "type": "ComparisonSingular",
          "field": "amount",
          "operation": "IsMoreThan",
          "value": "10000.00"
        }
      ]
    }
  ]
}
```

### Creating a Dynamic Rule Tree

```bash
POST /api/tree/root/dynamic
Content-Type: application/json

{
  "name": "Custom Business Rule",
  "dynamicInputId": "uuid-of-input-schema",
  "nodes": [
    {
      "type": "NodeTreeIf",
      "conditionalNodes": [
        {
          "type": "ComparisonMulti",
          "field": "tags",
          "operation": "Contains",
          "values": ["high-risk", "manual-review"]
        }
      ],
      "thenNodes": [
        {
          "type": "NodeTreeAction",
          "actionType": "SEND_EMAIL",
          "parameters": {
            "recipient": "risk@company.com",
            "template": "high-risk-alert"
          }
        }
      ]
    }
  ]
}
```

### Executing Rules

```bash
POST /api/engine/validate/{treeId}
Content-Type: application/json

{
  "amount": 15000.00,
  "currency": "USD",
  "account": {
    "balance": 50000.00
  },
  "tags": ["high-value", "international"]
}
```

## 🔧 Advanced Features

### 📊 Rule History & Versioning

Every rule modification is automatically tracked:

```bash
GET /api/tree/history/{treeId}
```

Revert to previous versions:

```bash
POST /api/engine/tree/reverse/{treeId}/{historyId}
```

### 🎛️ Dynamic Input Management

Create custom input schemas:

```bash
POST /api/input
Content-Type: application/json

{
  "name": "E-commerce Order Schema",
  "description": "Schema for order validation rules",
  "json": "{\"orderId\":\"String\",\"amount\":\"Double\",\"items\":[{\"sku\":\"String\",\"quantity\":\"Integer\"}]}"
}
```

### 🔄 Tree Generation Engine

The Tree Generator provides powerful capabilities:

- **Recursive Processing**: Handles deeply nested rule structures
- **Type Safety**: Strong typing with Java Generics
- **Validation**: Comprehensive input validation at all levels
- **Transaction Management**: Atomic operations with rollback capability

## 🧪 Testing

### Running Tests

```bash
# Run all tests
./mvnw test

# Run specific test suite
./mvnw test -Dtest=TreeGeneratorServiceTest

# Integration tests
./mvnw integration-test
```

### Test Coverage

The project maintains high test coverage with:
- Unit tests for domain logic
- Integration tests for service layers
- API tests for controllers
- Database tests for repositories

## 🚀 Deployment

### Docker Production Build

```bash
# Build application
./mvnw clean package -DskipTests

# Build Docker image
docker build -t rule-forge:latest .

# Run with production profile
docker run -p 8080:8080 \
  -e SPRING_PROFILES_ACTIVE=prod \
  -e JWT_PUBLIC_KEY=$JWT_PUBLIC_KEY \
  -e JWT_PRIVATE_KEY=$JWT_PRIVATE_KEY \
  rule-forge:latest
```

### Environment Profiles

- **development** - Local development with detailed logging
- **test** - Testing environment with in-memory databases
- **production** - Production-ready configuration with optimizations

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch: `git checkout -b feature/amazing-feature`
3. Commit your changes: `git commit -m 'Add amazing feature'`
4. Push to the branch: `git push origin feature/amazing-feature`
5. Open a Pull Request

### Coding Standards

- Follow DDD principles
- Maintain clean architecture boundaries
- Write comprehensive tests
- Use meaningful commit messages
- Document public APIs

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👥 Authors

- **Lucas Batista Pereira** - *Initial work* - [@Perebati](https://github.com/Perebati)

## 🙏 Acknowledgments

- Inspired by [Java Spring Clean DDD Template](https://github.com/Perebati/java-spring-clean-ddd-template)
- Built with modern Spring Boot ecosystem
- Follows Evans' Domain-Driven Design principles
- Implements Martin's Clean Architecture patterns

## 📞 Support

For support, email lucas.bpereira1999@gmail.com or create an issue in the repository.

---

<div align="center">
  <p>Made with ❤️ for the financial technology community</p>
</div>
