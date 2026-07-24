# Code Quality & SonarQube

## Overview
Code quality is a crucial metric in software development that determines the long-term maintainability, readability, and security of an application. SonarQube is an open-source platform developed by SonarSource for continuous inspection of code quality.

## Key Metrics in SonarQube
1. **Reliability (Bugs):** An issue that represents something wrong in the code. If this has not broken yet, it will, and probably at the worst possible moment.
2. **Security (Vulnerabilities):** A security-related issue which represents a potential backdoor for attackers.
3. **Maintainability (Code Smells):** A maintainability-related issue in the code. Leaving it as-is means that at best developers will have a harder time maintaining the code, and at worst, they'll be confused by the state of the code.
4. **Coverage:** The percentage of code lines covered by unit tests. High coverage reduces the chance of undetected bugs.
5. **Duplications:** Identical or very similar lines of code that have been copied and pasted. 

## Integration
In this project, SonarQube is integrated via the `sonar-project.properties` file.
When running the Sonar scanner, it reads this file to determine the source directories, binary directories, and the locations of the test coverage reports (like Jacoco XML reports).

## Best Practices
- **Clean as You Code:** Fix new issues (in new or changed code) before they merge to the main branch.
- **Quality Gates:** Define a set of conditions that a project must meet before it can be released into production.
- **Fail Fast:** If the Quality Gate fails, the CI/CD build should fail, preventing poor quality code from being deployed.
