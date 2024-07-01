# Chat Application

## Overview

The Chat Application is a Java-based messaging system designed to facilitate real-time communication between users. This application provides a user-friendly interface for sending and receiving messages, managing contacts, and maintaining chat histories. The backend is supported by MySQL for efficient data storage and management.

## Features

- User registration and login
- Real-time messaging
- Contact management
- Chat history
- User presence (online/offline status)

## Prerequisites

Before running the Chat Application, ensure you have the following installed:

- Java Development Kit (JDK) 8 or later
- MySQL Server
- MySQL Connector/J (Java MySQL driver)
- IDE (e.g., IntelliJ IDEA, Eclipse) or a text editor

## Setup Instructions

### 1. Clone the Repository

Clone the repository to your local machine using the following command:

```sh
git clone https://github.com/yourusername/chatapplication.git
```

### 2. Set Up the MySQL Database

1. Open MySQL Workbench or your preferred MySQL client.
2. Create a new database named `chatapplication`.
3. Execute the SQL script (provided separately) to create the necessary tables and initial data.

### 3. Configure the Database Connection

1. Open the `src/main/resources/database.properties` file.
2. Update the file with your MySQL database connection details:

```properties
db.url=jdbc:mysql://localhost:3306/chatapplication
db.username=your_mysql_username
db.password=your_mysql_password
```

### 4. Build and Run the Application

#### Using an IDE

1. Open the project in your preferred IDE.
2. Ensure that the MySQL Connector/J library is added to the project's dependencies.
3. Build and run the application from the IDE.

#### Using Command Line

1. Navigate to the project directory.
2. Compile the project using Maven:

```sh
mvn clean install
```

3. Run the application:

```sh
java -jar target/chatapplication-1.0-SNAPSHOT.jar
```

## Usage

1. **User Registration**: Register a new account by providing a username, password, and email.
2. **User Login**: Log in with your credentials to access the chat system.
3. **Contact Management**: Add and manage your contacts.
4. **Messaging**: 
    - **Send Messages**: Select a contact and send real-time messages.
    - **Receive Messages**: Receive messages from your contacts in real-time.
5. **Chat History**: View the history of your conversations with each contact.
6. **User Presence**: See the online/offline status of your contacts.

## Contributing

We welcome contributions to the Chat Application. To contribute, follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/your-feature`).
3. Make your changes and commit them (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature/your-feature`).
5. Open a pull request.

## License

This project is licensed under the MIT License. See the LICENSE file for details.

## Contact

If you have any questions or feedback, please contact us at [pranaypatel9696@gmail.com].

---

Thank you for using the Chat Application! Enjoy seamless and real-time communication.
