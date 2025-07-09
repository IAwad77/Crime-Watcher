## Crime Watcher


Crime Watcher is a full-stack crime reporting and analytics system designed using a modular microservices architecture. It allows users to report, view, and analyze crime incidents within a city. The project was built to simulate a real-world software engineering environment, with an emphasis on clean REST APIs, layered backend services, full test coverage, and DevOps best practices.



## What It Does

Citizens can submit crime reports including location, type, and description

Admins can view and monitor reported incidents from a dashboard

Backend services validate and store reports

A separate analytics engine detects crime patterns over time

Frontend UI enables both reporting and browsing of incidents

All services are containerized with Docker and orchestrated using Kubernetes



## Architecture

Crime Watcher is composed of multiple Spring Boot microservices:

UserService – manages users and their roles (citizen or admin)

IncidentService – handles storage and retrieval of crime incidents

AnalyticsService – computes statistics such as frequency and category trends

GatewayService – acts as the central API gateway routing traffic to appropriate services



## Each microservice includes:

Layered architecture (Controller to Service to Repository)

Isolated REST APIs

DTOs and input validation

Dockerfile and Kubernetes manifest for containerization and deployment

Full testing suites including unit, integration, and BDD tests



## Testing

Testing is a core focus of this project:

Unit tests using JUnit and Mockito

Integration tests using WebApplicationFactory to test API endpoints

BDD tests written in Gherkin and implemented using Cucumber and Selenium WebDriver for UI scenarios

End-to-end test coverage for critical workflows



## Tech Stack
Java 21 with Spring Boot 3

PostgreSQL as the primary data store

Maven for project builds and dependency management

Docker and Kubernetes for containerization and orchestration

React for the frontend UI

GitHub Actions for continuous integration

Testing frameworks: JUnit, Mockito, Cucumber, Selenium



## DevOps
CI/CD pipeline runs all test types and builds Docker images

Docker Compose used for local development

Kubernetes manifests provided for each service to support scalable deployment



## Project Status

Crime Watcher is an ongoing project that is consistently being worked on and improved. New features, refinements, and test coverage are regularly added as part of continuous learning and development.

