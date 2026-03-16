# Maven Web Application with Apache Tomcat (IntelliJ IDEA)

This guide explains how to **create, configure, and run a Maven Web Application using Apache Tomcat in IntelliJ IDEA**.

---

## Prerequisites

Make sure the following are installed on your system:

- Java JDK 8 or higher
- Apache Maven
- Apache Tomcat (9 or 10)
- IntelliJ IDEA

Check installations:

```bash
java -version
mvn -version
```

---

# 1. Create Maven Web Project

In IntelliJ IDEA:

```
File → New → Project
```

Select:

```
Maven Archetype
```

Choose the archetype:

```
org.apache.maven.archetypes:maven-archetype-webapp
Version: 1.4
```

Fill the project details:

```
GroupId: com.example
ArtifactId: demo-webapp
Version: 1.0-SNAPSHOT
```

---

# 2. Project Structure

After creating the project, the structure should look like:

```
demo-webapp
│
├── pom.xml
└── src
    └── main
        └── webapp
            ├── WEB-INF
            │   └── web.xml
            └── index.jsp
```

---

# 3. Configure pom.xml

Make sure the packaging type is **WAR**.

```xml
<packaging>war</packaging>
```

Example minimal `pom.xml`:

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">

    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>demo-webapp</artifactId>
    <version>1.0-SNAPSHOT</version>

    <packaging>war</packaging>

</project>
```

---

# 4. Add Apache Tomcat Server in IntelliJ

Open:

```
Run → Edit Configurations
```

Click:

```
+ → Tomcat Server → Local
```

Configure the Tomcat installation directory:

```
D:\apache-tomcat-9
```

---

# 5. Deploy the Maven Artifact

Go to the **Deployment** tab.

Click:

```
+ → Artifact
```

Select:

```
demo-webapp:war exploded
```

Set the application context:

```
/demo-webapp
```

---

# 6. Run the Application

Start the server:

```
Run ▶
```

Tomcat will start on:

```
http://localhost:8080
```

---

# 7. Test the Application

Open your browser:

```
http://localhost:8080/demo-webapp
```

You should see the content from:

```
src/main/webapp/index.jsp
```

Example `index.jsp`:

```jsp
<html>
<body>
<h1>Hello Maven + Tomcat</h1>
</body>
</html>
```

---

# 8. Build WAR File Using Maven

Run the following command:

```bash
mvn clean package
```

The WAR file will be generated in:

```
target/demo-webapp.war
```

You can manually deploy it to:

```
apache-tomcat/webapps/
```

---

# 9. Enable Auto Reload in IntelliJ

Go to:

```
File → Settings → Compiler
```

Enable:

```
Build project automatically
```

While Tomcat is running, update classes with:

```
Ctrl + F10
```

---

# 10. Useful Maven Commands

Build project:

```bash
mvn clean install
```

Run tests:

```bash
mvn test
```

Package WAR file:

```bash
mvn package
```

---

# 11. Project Structure Overview

```
demo-webapp
│
├── pom.xml
├── src
│   └── main
│       ├── java
│       └── webapp
│           ├── WEB-INF
│           │   └── web.xml
│           └── index.jsp
└── target
```

---

# Notes

- Tomcat runs the application using the **WAR deployment**.
- JSP files are placed inside the `webapp` directory.
- `web.xml` contains servlet configuration.
- Maven manages dependencies and build lifecycle.