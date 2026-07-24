# GIT Hands-On Lab 2: Git Ignore

## Objectives
- Explain git ignore
- Ignore unwanted files and folders using .gitignore

## Estimated Time: 20 minutes

---

## Prerequisites
- Git environment set up (HOL 1)
- A local Git repository in the system

---

## Task Description
Create a `.log` file and a `log` folder in the Git working directory.
Update `.gitignore` so that on committing:
- All `.log` extension files are ignored
- All `log` folders are ignored

---

## Step 1: Create Files to be Ignored

```bash
cd GitDemo

# Create a .log file
echo "This is a log file" > application.log
echo "This is a debug log" > debug.log

# Create a log folder with files
mkdir log
echo "Log entry 1" > log/server.log
echo "Log entry 2" > log/error.log
```

## Step 2: Check Status (Before .gitignore)

```bash
git status
```
> You will see `application.log`, `debug.log`, and `log/` listed as untracked files.

---

## Step 3: Create .gitignore File

```bash
# Create .gitignore
notepad++ .gitignore
```

Add these rules in the file:
```
# Ignore all .log files
*.log

# Ignore log folders
log/

# Common ignores (good practice)
*.class
*.jar
target/
.idea/
node_modules/
```

Save and close Notepad++.

---

## Step 4: Verify .gitignore Works

```bash
git status
```

Expected output:
- `application.log` and `debug.log` should **NOT appear** (ignored)
- `log/` folder should **NOT appear** (ignored)
- `.gitignore` itself appears as untracked (we need to commit it)

---

## Step 5: Commit .gitignore

```bash
git add .gitignore
git commit -m "Add .gitignore to ignore log files and folders"
git push origin master
```

---

## Step 6: Verify on GitLab

- Go to GitLab project
- Only `.gitignore` should be committed
- No `.log` files or `log/` folders should appear in the repository

---

## Summary

| Pattern | What it ignores |
|---------|----------------|
| `*.log` | All files with .log extension |
| `log/` | All folders named "log" |
| `target/` | Maven target folder |
| `*.class` | Compiled Java class files |
| `node_modules/` | Node.js dependencies |

> **Note**: Files already tracked by Git are NOT automatically ignored by adding them to `.gitignore`.
> Use `git rm --cached <file>` to stop tracking a previously committed file.
