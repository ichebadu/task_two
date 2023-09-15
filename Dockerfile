FROM openjdk:17-jdk
WORKDIR /app
COPY target/*.jar /app/task_two.jar
EXPOSE 8080
CMD ["java","-jar","task_two.jar"]