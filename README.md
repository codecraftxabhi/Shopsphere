# ShopSphere — E-commerce Backend

A production-style e-commerce REST API built with **Java 21, Spring Boot 4.1.1, Spring Security, JWT, PostgreSQL, Redis, Flyway and Docker**.

## Highlights
- JWT authentication and role-based authorization (`CUSTOMER`, `ADMIN`)
- Product catalog with pagination, filtering and Redis caching
- Category management
- Inventory with pessimistic locking during checkout
- Shopping cart
- Address management
- Transactional order creation and cancellation
- Coupon discounts
- Payment abstraction with idempotent order payment creation
- Reviews and ratings
- Wishlist
- Admin dashboard and order status management
- Global validation/error handling
- Flyway database migrations
- Swagger/OpenAPI
- Actuator health/metrics endpoints
- Docker Compose for PostgreSQL, Redis and the application
- GitHub Actions Maven CI

## Architecture
```text
Controller -> Service -> Repository -> PostgreSQL
                  |                  | +-> Redis cache
                  +----> Security / JWT
```

## Requirements

> Note: the generated project is designed for Java 21 + Maven and uses Spring Boot 4.1.1. The build should be verified locally/CI with `mvn clean verify`.

- Java 21+
- Maven 3.9+
- Docker Desktop (recommended)

## Run locally
```bash
git clone <your-repository-url>
cd shopsphere
docker compose up -d postgres redis
mvn spring-boot:run
```

API: `http://localhost:8080`
Swagger UI: `http://localhost:8080/swagger-ui/index.html`
Health: `http://localhost:8080/actuator/health`

### Default admin
- Email: `admin@shopsphere.local`
- Password: `Admin@12345`

Change these credentials before publishing a real deployment.

## Build the container
```bash
mvn clean package -DskipTests
docker compose up --build
```

## Authentication
Register or login to receive a JWT:
```http
POST /api/v1/auth/login
Content-Type: application/json

{"email":"admin@shopsphere.local","password":"Admin@12345"}
```
Use the returned token as:
```http
Authorization: Bearer <token>
```

## Core API
| Method | Endpoint | Auth |
|---|---|---|
| POST | `/api/v1/auth/register` | Public |
| POST | `/api/v1/auth/login` | Public |
| GET | `/api/v1/products` | Public |
| GET | `/api/v1/products/{id}` | Public |
| POST | `/api/v1/products` | Admin |
| GET | `/api/v1/categories` | Public |
| POST | `/api/v1/categories` | Admin |
| GET/POST | `/api/v1/cart` | User |
| POST | `/api/v1/orders` | User |
| GET | `/api/v1/orders` | User |
| PATCH | `/api/v1/orders/{id}/cancel` | User |
| POST | `/api/v1/payments/orders/{orderId}` | User |
| POST | `/api/v1/payments/{reference}/confirm` | Auth |
| GET/POST | `/api/v1/products/{productId}/reviews` | Mixed |
| GET/POST/DELETE | `/api/v1/wishlist` | User |
| GET | `/api/v1/admin/dashboard` | Admin |

## Design decisions
1. **DTOs instead of entities at API boundaries** prevent accidental persistence-model exposure.
2. **Flyway + `ddl-auto=validate`** keeps schema changes explicit and reviewable.
3. **Pessimistic inventory locking** protects checkout from concurrent stock decrements.
4. **Transactions** make order creation and stock updates atomic.
5. **Redis** is used for product caching; PostgreSQL remains the source of truth.
6. **JWT** keeps the REST API stateless.
7. **Soft deactivation** is used for products so historical order lines remain valid.

## Production hardening to add next
- Refresh-token rotation and revocation storage
- Real payment provider integration (Razorpay/Stripe)
- Outbox pattern + Kafka/RabbitMQ for order events
- Object storage for product images
- Full-text search with Elasticsearch/OpenSearch
- Rate limiting and API gateway
- Distributed tracing/OpenTelemetry
- Secret management via Vault/cloud secret manager
- Contract and Testcontainers integration tests
