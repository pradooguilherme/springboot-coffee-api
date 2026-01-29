# springboot-coffee-api
A REST API for coffee shop management using Spring Boot, JPA, PostgreSQL

flowchart LR
  A[Client/Swagger] --> B[Controller]
  B --> C[Service]
  C --> D[Repository]
  D --> E[(Database)]

