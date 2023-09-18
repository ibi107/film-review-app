# Film Review Application

## Backend - /moviesAPI

### MongoDB Entities
Movie and Review classes represent database entities stored in their respective collections in MongoDB.

### Controller classes
The controller classes MovieController and ReviewController handle HTTP request mappings, taking CRUD methods from their own repositories.

### Repository classes
Repository classes contain default CRUD operations imported by Spring, but also custom defined operations.

### Service classes
Contain service-related methods for MongoDB entities.

## Frontend - /moviesClient

### ./src/App.jsx
Start point of the frontend application, routes are established here.

### ./src/components
Holds pages which are references in App.jsx, used pre-defined design elements provided by Material-UI (https://www.material-tailwind.com/), styling is done using using Tailwind CSS.

