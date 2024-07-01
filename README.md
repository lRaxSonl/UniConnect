<h1><b>UniConnect</b></h1>

UniConnect is a simple social network (small school project).

Dependencies: Apache Freemarker, Spring Data JPA, Lombok, Spring Security, MariaDB Driver, Spring Web, Java Mail Sender.



![opera_4LwBGdRgho](https://github.com/lRaxSonl/UniConnect/assets/124626560/5aa63b05-6bb9-436f-bdc5-f3794c387f7e)



<h1><b>Project functionality</b></h1>
Blog Platform:
Development of a blog platform where users can create their own blogs, post articles and comment on other users' content.
It includes a tag management system, categories and the ability to subscribe to interesting blogs.

<h1><b>Documentation</b></h1>
<b>How install Maven?</b>

1. Go to the official Maven website, navigate to the download section, and download the latest stable version. 

2. Unzip the archive into the installation directory, for example, 'C:\Program Files\maven' on Windows or '/opt/maven' on Linux.

3. Set the environment variable M2_HOME to 'C:\Program Files\maven' and add '%M2_HOME%\bin' to the PATH environment variable.

4. Verify the installation by typing the following command in the command prompt:
<br>
<br>

<b>How download Maven?</b>

1. To set the M2_HOME environment variable to "C:\Program Files\maven", and then set the PATH environment variable using M2_HOME, follow these instructions in Windows:

2. Right-click on the "My Computer" icon (or "This PC" in newer versions of Windows) and select "Properties".

3. In the System window, select "Advanced system settings" (or "Advanced system settings" in newer versions of Windows).

4. In the System Properties window, go to the "Advanced" tab and click on the "Environment Variables" button.

5. In the "Environment Variables" section, click on the "New" button to create a new environment variable.

6. Enter M2_HOME in the "Variable name" field and "C:\Program Files\maven" in the "Variable value" field. Click "OK".

7. Find the PATH environment variable in the list of system variables and select it, then click on the "Edit" button.

8. Add "%M2_HOME%\bin" to the list of PATH variable values, separating each value with a semicolon (;).

9. Click "OK" to close all windows and save the changes.

10. After this, the M2_HOME environment variable will be set to "C:\Program Files\maven", and the PATH environment variable will include the path to the Maven bin folder.
To run the project, you need to "git clone" the repository, adding a link to the project.
<br>
https://maven.apache.org/
<br>
https://www.examclouds.com/ru/java/java-core-russian/install-maven
<br>
<br>
<b>How to open Project?</b>

1. To download a project using Maven, you will need a pom.xml file, which contains information about the project and its dependencies. Next, run the following command in a command prompt or terminal:

<b>mvn clean install</b>

2. This command will compile and install the project into your local Maven repository. If you want to just download the project without compiling, you can run the following command:

<b>mvn dependency:copy-dependencies</b>

3. It will download all the project dependencies to a local folder. Make sure Maven is installed on your machine and configured correctly before running these commands.
<br>
<br>
Project made with Maven
<br>
Language - java
<br>
Spring Boot version 3.2.2
<br>
Java version 17
<br>

<h1><b>Dependencies</b></h1>

<b>spring-boot-starter-data-jpa</b> - allows you to use the capabilities of Spring Boot to work with the database via JPA,
such as automatically creating tables, creating queries based on named methods in repositories, etc.

<b>jjwt</b> - allows you to use the JJWT library to work with JSON Web Tokens

<b>spring-boot-starter-freemarker</b> - you get all the necessary dependencies and configurations to work
with FreeMarker within a Spring Boot application without having to add each library separately

<b>spring-boot-starter-mail</b> - you can easily configure and use the functionality of sending mail messages,
for example, for sending notifications, registration confirmation emails and other scenarios for your web applications

<b>spring-boot-starter-security</b> - you can easily configure and use the authentication functionality,
authorization, attack protection and other security measures in your application

<b>spring-boot-starter-web</b> - allows you to quickly start developing web applications in Java using Spring Boot,
minimizing the need to manually add dependencies and configure configurations

<b>mariadb-java-client</b> - allows developers to create applications that can connect to the MariaDB database,
execute SQL queries, process query results, etc.

<b>lombok</b> - allows programmers to focus on business logic and make the code more concise and readable.
The library integrates with various development environments and project build tools, such as Maven or Gradle,
and is a popular tool in the Java ecosystem.

<b>spring-boot-starter-test</b> - developers can easily write and run various types of tests (unit, integration, system) in
their Spring Boot-based applications, which helps ensure application quality and stability

<b>spring-boot-maven-plugin</b> - This plugin provides integration for building, running and
Packaging Spring Boot based applications using the Maven build system



