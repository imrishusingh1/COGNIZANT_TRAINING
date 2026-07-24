# DevOps & CI/CD (Continuous Integration / Continuous Deployment)

## What is DevOps?
DevOps is a set of practices that combines software development (Dev) and IT operations (Ops). It aims to shorten the systems development life cycle and provide continuous delivery with high software quality.

## Continuous Integration (CI)
Continuous Integration is the practice of automating the integration of code changes from multiple contributors into a single software project. 
- **Goal:** Find and address bugs quicker, improve software quality, and reduce the time it takes to validate and release new software updates.
- **Tools:** Jenkins, GitHub Actions, GitLab CI.

## Continuous Deployment (CD)
Continuous Deployment goes one step further than Continuous Delivery. With this practice, every change that passes all stages of your production pipeline is released to your customers.
- **Goal:** Ensure that the software can be reliably released at any time.

## GitHub Actions Pipeline
In this module, we have included a sample `ci-cd-pipeline.yml` inside this folder which demonstrates a standard CI workflow for a Java application:
1. **Checkout:** Retrieves the source code from the Git repository.
2. **Setup JDK:** Configures the Java Development Kit (JDK 17).
3. **Build & Test:** Runs Maven commands (`mvn clean package`) to compile the code and run all unit tests.
If any test fails or the code fails to compile, the pipeline fails, preventing broken code from progressing.
