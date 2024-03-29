# Set the base image to temurin (JDK 17)
FROM eclipse-temurin:17 AS builder

# Create the /app directory
RUN mkdir /app

# Set the working directory to /app
WORKDIR /app

# Copy the MaidBot.jar  and config,txt to the container
COPY MaidBot.jar .
COPY config.txt .

# Set the environment variable to enable GC optimization flags
ENV JAVA_TOOL_OPTIONS="-XX:+UseG1GC -XX:+UseStringDeduplication -XX:+UnlockExperimentalVMOptions -XX:+TieredCompilation"


# Start the bot with the command: java -jar MaidBot.jar
CMD ["java", "-jar", "MaidBot.jar"]
