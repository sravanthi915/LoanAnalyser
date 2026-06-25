
# Loan Analyzer Backend

## Overview

Loan Analyzer is a Spring Boot backend application that helps analyze customer loan eligibility based on salary, monthly expenses, and existing EMI obligations.

## Tech Stack

* Java 17
* Spring Boot
* Spring Data JPA
* Oracle Database
* Maven
* Postman

## Features

* Customer Registration
* Loan Eligibility Analysis
* Get Customer By ID
* Get All Customers
* Update Customer Details
* Delete Customer Details
* Oracle Database Integration
* RESTful APIs

## API Endpoints

### Register Customer

POST /customer/register

### Analyze Loan Eligibility

POST /loan/analyse

### Get Customer By ID

GET /customer/{id}

### Get All Customers

GET /customers

### Update Customer

PUT /customer/{id}

### Delete Customer

DELETE /customer/{id}

## Architecture

Controller → Service → Repository → Oracle Database

## Future Enhancements

* Validation
* Global Exception Handling
* Swagger Documentation
* JWT Authentication
* Role-Based Access Control

