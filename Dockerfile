FROM openjdk:16-alpine3.13
RUN mkdir /app
COPY build/libs/*.jar /app/hacker-bills.jar
ENTRYPOINT ["java","-jar","/app/hacker-bills.jar"]

# FROM gradle:7-jdk11-alpine AS build
# COPY --chown=gradle:gradle . /home/gradle/src
# WORKDIR /home/gradle/src
# RUN gradle build --no-daemon 

# FROM openjdk:8-jre-slim

# EXPOSE 8085

# RUN mkdir /app

# COPY --from=build /home/gradle/src/build/libs/*.jar /app/hacker-bills.jar

# ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/hacker-bills.jar"]
