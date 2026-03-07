# Java Testing and Database Technologies

## 1. JUnit

### Introduction
**JUnit** is a popular **unit testing framework for Java** used to test individual components of an application. It allows developers to verify that each method works as expected.

### Features
- Supports **unit testing**
- Uses **annotations** for test methods
- Provides **assertion methods** to verify results
- Helps in **test-driven development (TDD)**
- Easy integration with build tools like **Maven** and **Gradle**

### Important Annotations

| Annotation | Description |
|------------|-------------|
| @Test | Marks a method as a test method |
| @BeforeEach | Runs before each test method |
| @AfterEach | Runs after each test method |
| @BeforeAll | Runs once before all tests |
| @AfterAll | Runs once after all tests |
| @Disabled | Skips a test method |

### Example Code

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testAddition() {
        int result = 5 + 3;
        assertEquals(8, result);
    }
}
```

### Advantages
- Detects bugs early
- Improves code quality
- Supports automated testing
- Easy integration with CI/CD pipelines

---

# 2. JDBC

## Introduction
JDBC (Java Database Connectivity) is a **Java API used to connect Java applications with relational databases**. It allows execution of SQL queries and retrieval of results.

## JDBC Architecture

JDBC consists of the following components:

- JDBC API
- Driver Manager
- JDBC Drivers
- Database

## Types of JDBC Drivers

| Type | Description |
|-----|-------------|
| Type 1 | JDBC-ODBC Bridge Driver |
| Type 2 | Native API Driver |
| Type 3 | Network Protocol Driver |
| Type 4 | Thin Driver (Pure Java Driver) |

## Steps to Connect Database Using JDBC

1. Import required packages  
2. Load the JDBC driver  
3. Establish connection  
4. Create statement  
5. Execute SQL query  
6. Process result set  
7. Close connection  

## Example Code

```java
import java.sql.*;

public class JdbcExample {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/testdb";
        String username = "postgres";
        String password = "root";

        try {

            Connection con = DriverManager.getConnection(url, username, password);

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");

            while(rs.next()){
                System.out.println(rs.getInt(1) + " " + rs.getString(2));
            }

            con.close();

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
```

## Advantages
- Platform independent
- Direct database connectivity
- Supports multiple databases

## Disadvantages
- Requires manual SQL queries
- More boilerplate code
- Manual object mapping

---

# 3. Hibernate

## Introduction
Hibernate is an **Object Relational Mapping (ORM) framework** for Java that simplifies database operations by mapping Java objects to database tables.

It eliminates most of the boilerplate JDBC code and automatically handles SQL generation.

## Key Concepts

| Concept | Description |
|-------|-------------|
| ORM | Mapping Java objects to database tables |
| Session | Interface for performing database operations |
| Transaction | Represents database transaction |
| Entity | Java class mapped to a database table |
| HQL | Hibernate Query Language |

## Hibernate Architecture

Main components include:

- Configuration
- SessionFactory
- Session
- Transaction
- Persistent Objects

## Example Entity Class

```java
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {

    @Id
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

## Example Hibernate Code

```java
Session session = sessionFactory.openSession();
Transaction tx = session.beginTransaction();

Student s = new Student();
s.setId(1);
s.setName("Sneha");

session.save(s);

tx.commit();
session.close();
```

## Advantages
- Reduces JDBC boilerplate code
- Automatic table mapping
- Database independent
- Supports caching and lazy loading

## Disadvantages
- Learning curve
- Slightly slower than JDBC for simple operations
- Requires configuration

---

# JDBC vs Hibernate Comparison

| Feature | JDBC | Hibernate |
|-------|------|-----------|
| Level | Low-level API | High-level ORM |
| SQL | Manual SQL queries | Automatic SQL generation |
| Code | Large amount of code | Less code |
| Performance | Faster for simple queries | Slightly slower |
| Object Mapping | Manual | Automatic |
