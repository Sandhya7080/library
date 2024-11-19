# Online Library System

This is an Online Library Management System that I have developed using Java, Spring Boot, MySQL, and frontend technologies like HTML, CSS, JavaScript, and Bootstrap. The system provides users with the ability to view, search, and interact with books, while the admin can manage books, users, and queries.

## Features Implemented

### User Modules:
- **Home Page:**
  - Displays a user-friendly interface with easy navigation.
  - Includes a search bar for users to search for books by title or author.
  
- **Books Page:**
  - Users can browse books listed in different categories such as Computer Science, Mathematics, etc.
  - Each book displays details like the title, author, description, and a download link.
  - Responsive design for mobile and desktop views.

### Admin Modules:
- **Admin Login:**
  - Admins can log in with hardcoded credentials (username: `admin`, password: `CSE@Books`).
  - If credentials are valid, the admin is redirected to the dashboard page.
  - If invalid, the system returns the user to the login page.

- **Book Management:**
  - Admins can upload new books by entering book details (title, author, image URL, and download link).
  - Admins can view all books in the system, and manage them through the backend.
  - Books are stored in the MySQL database and can be accessed or modified via the admin interface.
  - Admin can delete books from the database.

- **Query Management:**
  - Admins can view all user queries (requests for books, questions, etc.) submitted through a form.
  - The system allows admins to respond to queries and resolve them.

### Database:
- The application uses a MySQL database to store book information, user queries, and admin login credentials.
- Tables include `books`, `queries`, and `users` for efficient data storage.

## Technologies Used

- **Backend:**
  - Java
  - Spring Boot
  - MySQL Database
  - Spring Data JPA for database interactions
  - Spring Security for basic authentication

- **Frontend:**
  - HTML5, CSS3
  - JavaScript
  - Bootstrap for responsive UI
