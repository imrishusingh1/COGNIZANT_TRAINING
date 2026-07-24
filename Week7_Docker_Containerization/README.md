# Docker Containerization

## Overview
Docker is an open platform for developing, shipping, and running applications. It enables you to separate your applications from your infrastructure so you can deliver software quickly. 

## Key Concepts
- **Image:** A lightweight, standalone, executable package of software that includes everything needed to run an application: code, runtime, system tools, system libraries, and settings.
- **Container:** A runtime instance of an image—what the image becomes in memory when executed.
- **Dockerfile:** A text document that contains all the commands a user could call on the command line to assemble an image.
- **Docker Compose:** A tool for defining and running multi-container Docker applications using a YAML file (`docker-compose.yml`).

## Files in this Module
### `Dockerfile`
This file defines the steps to containerize our Spring Boot Java applications:
1. Uses `openjdk:17-jdk-slim` as a lightweight base image.
2. Copies the compiled `.jar` file from the `target/` directory into the container.
3. Exposes port `8080` to the outside world.
4. Uses `ENTRYPOINT` to specify the command to run the Java application.

### `docker-compose.yml`
This file allows us to easily orchestrate the container. Instead of running long `docker run` commands with many flags, we can simply execute `docker-compose up -d`. This will:
- Build the Dockerfile in the current directory.
- Map the host's port 8080 to the container's port 8080.
- Run the container in detached mode.

## Benefits
- **Consistency:** Works identically on a developer's machine, a QA environment, and production.
- **Isolation:** Each container is isolated from the host and other containers.
- **Resource Efficiency:** Containers share the host OS kernel, making them much lighter than traditional Virtual Machines (VMs).
