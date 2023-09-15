# Task Two Application

Task Two is a simple application that allows users to perform basic CRUD operations (Create, Read, Update, Delete) for user data. Users can be created, updated, deleted, and retrieved using this application.

## Table of Contents

- [Introduction](#introduction)
- [Technologies Used](#technologies-used)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Tests](#tests)
- [Contributing](#contributing)
- [License](#license)

## Introduction

This application provides a user service that allows operations such as adding a user, updating user information, deleting a user, and finding a user. It is built to demonstrate basic API functionality for user management.

## Technologies Used

- Java
- Spring Boot
- Hibernate
- Maven
- JUnit
- Mockito

## Features

- Add a new user with a name, age, and email.
- Update an existing user's information.
- Delete a user based on their name.
- Find a user based on their name.

## Installation

1. Clone the repository to your local machine.

```bash
git clone <repository_url>
Open the project in your preferred Java IDE.

Build the project using Maven:

bash
Copy code
mvn clean install
Run the Spring Boot application.
Usage
To use the application, you can send HTTP requests to the appropriate endpoints. Below are the available endpoints and their functionality:

Add a User:

Endpoint: POST /api
Request Body:
json
Copy code
{
    "name": "John Doe",
    "age": 30,
    "email": "john.doe@example.com"
}
Response: User information including the assigned ID.
Update a User:

Endpoint: PUT /api/{user_id}
Request Body:
json
Copy code
{
    "name": "Updated Name",
    "age": 35,
    "email": "updated.email@example.com"
}
Response: Updated user information.
Delete a User:

Endpoint: DELETE /api/{user_id}
Response: Message indicating successful deletion.
Find a User:

Endpoint: GET /api/{user_id}
Response: User information based on the provided name.
Tests
Unit tests are available to ensure the correctness of the application's functionality. To run the tests, execute the following command:

bash
Copy code
mvn test

GitHub Actions Workflow
Build and Deploy Task Two
To enable continuous integration and deployment, we've configured a GitHub Actions workflow named "Build and Deploy Task Two." This workflow automates the build and deployment of your Task Two application whenever new commits are pushed to the main branch.

Workflow Details
The workflow comprises two primary jobs:

build Job: Responsible for building the application. It performs the following steps:

Checks out the latest code from the repository.
Sets up Docker Buildx for the build process.
deploy Job: Handles the deployment of your application and depends on the successful completion of the build job. The steps in this job include:

Checking out the latest code from the repository.
Setting up JDK 17 for the deployment environment.
Running unit tests to validate the application's functionality.
Building the application using Maven.
Building the Docker image for the application.
Logging in to Docker Hub using your credentials.
Pushing the Docker image to Docker Hub, making it available for deployment.
Usage
The workflow triggers automatically whenever new changes are pushed to the main branch, eliminating the need for manual initiation.

Environment Variables
The workflow relies on the following environment variables:

ASC_PACKAGE_PATH: Set to ${{ github.workspace }}.
JAVA_VERSION: Set to 17.
Secrets
For secure storage of sensitive information, such as Docker Hub credentials, GitHub Secrets are employed. Be sure to configure the following secrets in your repository:

DOCKER_HUB_USERNAME: Your Docker Hub username.
DOCKER_SECRET: Your Docker Hub password or access token.
With this workflow in place, you can ensure that your Task Two application is automatically built and deployed with each update to the main branch.