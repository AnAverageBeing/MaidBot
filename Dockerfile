# Set the base image to temurin (JDK 17)
FROM adoptium/temurin:17-jdk AS builder

# Create the /app directory
RUN mkdir /app

# Set the working directory to /app
WORKDIR /app

# Copy the MaidBot.jar file to the container
COPY MaidBot.jar .

# Set the environment variable to enable GC optimization flags
ENV JAVA_TOOL_OPTIONS="-XX:+UseG1GC -XX:+UseStringDeduplication -XX:+UnlockExperimentalVMOptions -XX:+UseZGC -XX:ParallelGCThreads=2 -XX:+TieredCompilation"

# Expose the default port used by your Discord bot
EXPOSE 80

# Start the bot with the command: java -jar MaidBot.jar
CMD ["java", "-jar", "MaidBot.jar"]
