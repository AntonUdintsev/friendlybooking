#!/bin/bash

# Step 1: Compile the project and package it as a JAR
echo "Compiling the project..."
mvn clean package -DskipTests

# Step 2: Build the Docker image
echo "Building Docker image..."
docker-compose build

# Step 3: Rebuild and restart containers
echo "Rebuilding and restarting containers..."
docker-compose up --build -d

echo "Deployment complete!"