#!/bin/sh

# Check if Docker is installed
if ! command -v docker &> /dev/null
then
    echo "Docker not found, installing..."
    # Install Docker
    curl -fsSL https://get.docker.com -o get-docker.sh
    sudo sh get-docker.sh
    rm get-docker.sh
fi

# Build the Docker image with a tag
docker build -t my-discord-bot .

# Run the Docker container from the built image, mapping the container's port 80 to the host's port 8080
docker run my-discord-bot
