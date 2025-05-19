# Social Media REST API

This is a RESTful API for a simple social media application built using **Spring Boot**, **Hibernate**, and **PostgreSQL**. The application supports user registration, following other users, creating posts, liking posts, and viewing a feed of posts from followed users.

---

## 🚀 Features

* Register new users
* Follow/unfollow other users
* Create posts (title, body)
* Like posts
* View posts from followed users

---

## 🧱 Technologies Used

* Java 17
* Spring Boot
* Hibernate / JPA
* PostgreSQL
* Maven
* JUnit (for testing)
* JaCoCo (for coverage)
* Checkstyle (for style checks)

---

## 🛠️ How to Run the Application

### 1. Set Up PostgreSQL

* Ensure PostgreSQL is running locally on port `5432`
* Create a database named `socialmedia`
* Use default credentials `postgres`/`postgres` or update `application.properties`

```sql
CREATE DATABASE socialmedia;
```

### 2. Clone and Build

```bash
git clone <repo-url>
cd social-media
mvn clean install
```

### 3. Run

```bash
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`.

---

## 🔌 API Endpoints

| Method | Endpoint                            | Description                |
| ------ | ----------------------------------- | -------------------------- |
| POST   | `/api/users?username=`              | Create a new user          |
| POST   | `/api/users/{id}/follow/{targetId}` | Follow another user        |
| POST   | `/api/posts?userId=&title=&body=`   | Create a new post          |
| GET    | `/api/posts/feed/{userId}`          | View feed (followed posts) |
| POST   | `/api/posts/{postId}/like?userId=`  | Like a post                |

---

## 🧪 Testing & Quality Checks

### Run Unit Tests

```bash
mvn test
```

### Check Test Coverage (>80%)

```bash
mvn jacoco:report
# Report will be available in target/site/jacoco/index.html
```

### Run Checkstyle

```bash
mvn checkstyle:check
```

---

## 🧪 Postman

* A Postman collection (`Social Media API.postman_collection.json`) is available for testing all endpoints.
* Import it into Postman and set variables like `userId`, `postId`, etc.

---

## 📂 Project Structure

```
src
├── main
│   └── java/com/example/socialmedia
│       ├── controller
│       ├── model
│       ├── repository
│       ├── service
│       └── SocialMediaApplication.java
├── test
│   └── java/com/example/socialmedia
│       ├── controller
│       └── service
```

---

## 📈 Task Feedback

### Task 3: Build a RESTful API for a simple social media app

* **Was it easy to complete the task using AI?**
  Yes, it was easy. ChatGPT generated most of the code and structure correctly with minimal adjustments.

* **How long did task take you to complete?**
  \~60 minutes (including coding, testing, and writing this README).

* **Was the code ready to run after generation? What did you have to change to make it usable?**
  Yes, the code ran out of the box. Only changes needed were adjusting PostgreSQL credentials and creating the database.

* **Which challenges did you face during completion of the task?**
  Handling JPA relationships (like ManyToMany for followers and likes) and ensuring the bidirectional mappings worked well.

* **Which specific prompts you learned as a good practice to complete the task?**
  Asking ChatGPT to generate complete code files including `pom.xml`, `application.properties`, and structured layers (model, repo, service, controller) works best. Also, prompting for a Postman collection JSON was very helpful.

---

## 📜 License

This project is open source and available under the [MIT License](LICENSE).
