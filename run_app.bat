@echo off

REM Start MariaDB (adjust the path based on your installation)
net start MySQL

REM Wait for MariaDB to start
timeout /t 5

REM Run the Spring Boot application
@REM mvnw.cmd spring-boot:run
