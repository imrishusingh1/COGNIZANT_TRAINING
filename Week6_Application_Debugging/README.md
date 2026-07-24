# Application Debugging

## Overview
Debugging is the process of identifying and removing errors from computer hardware or software. In modern software development, utilizing the right debugging tools is crucial for efficiency.

## Java / Spring Boot Debugging
- **IDE Debugger (Eclipse, IntelliJ, VS Code):**
  - **Breakpoints:** Pause execution at a specific line of code.
  - **Step Over (F8):** Execute the current line and move to the next.
  - **Step Into (F7):** Dive into the method being called on the current line.
  - **Step Out (Shift+F8):** Finish executing the current method and return to the caller.
  - **Variables View:** Inspect the current state and values of variables in scope.
- **Logging:**
  - Using SLF4J and Logback to trace application flow and state without pausing execution.
  - Log levels: `TRACE`, `DEBUG`, `INFO`, `WARN`, `ERROR`.

## React / Frontend Debugging
- **Browser Developer Tools (Chrome DevTools):**
  - **Elements Tab:** Inspect and modify the DOM and CSS in real-time.
  - **Console:** View JavaScript errors, warnings, and log outputs (`console.log`).
  - **Sources:** Set breakpoints in JavaScript/TypeScript code.
  - **Network:** Monitor API requests, responses, status codes, and payload sizes.
- **React Developer Tools (Browser Extension):**
  - **Components:** Inspect the React component tree, props, and state.
  - **Profiler:** Record performance data to identify rendering bottlenecks.

*(No specific coding hands-on tasks were mandated for this module in the curriculum; it is applied practically throughout the other modules.)*
