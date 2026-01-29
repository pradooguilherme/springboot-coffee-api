# springboot-coffee-api
A REST API for coffee shop management using Spring Boot, JPA, PostgreSQL

## Architecture Overview

### Sequence and Layers

```mermaid
flowchart TD
  A[Client] --> B[Controller]
  B --> C[Service]
  C --> D[Repository]
  D --> DB[(PostgreSQL)]

