# GIT Hands-On Lab 1: Basic Git Commands

## Objectives
- Setup Git configuration
- Integrate notepad++ as default editor
- Add a file to source code repository

## Estimated Time: 30 minutes

---

## Step 1: Setup Git Configuration

### Check Git installation
```bash
git --version
```

### Configure global user settings
```bash
git config --global user.name "Your Name"
git config --global user.email "your.email@example.com"
```

### Verify configuration
```bash
git config --list
```

---

## Step 2: Integrate Notepad++ as Default Editor

### Check if notepad++ is accessible from Git Bash
```bash
notepad++ --version
```

### If not found, add to PATH via Environment Variables:
- Control Panel → System → Advanced System Settings → Environment Variables
- Add path of notepad++.exe (e.g., `C:\Program Files\Notepad++`) to PATH

### Configure notepad++ as default Git editor
```bash
git config --global core.editor "'C:/Program Files/Notepad++/notepad++.exe' -multiInst -notabbar -nosession -noPlugin"
```

### Verify editor configuration
```bash
git config -e --global
```

---

## Step 3: Add a File to Source Code Repository

### Create and initialize a new repository
```bash
mkdir GitDemo
cd GitDemo
git init
```

### Verify hidden .git directory
```bash
ls -la
```

### Create a file and add content
```bash
echo "Hello, Git!" > welcome.txt
cat welcome.txt
```

### Check Git status
```bash
git status
```
> Output: `welcome.txt` is listed under **untracked files**

### Stage the file (add to index/staging area)
```bash
git add welcome.txt
```

### Check status again
```bash
git status
```
> Output: `welcome.txt` is now listed under **changes to be committed**

### Commit with a message using default editor (Notepad++)
```bash
git commit
```
> Notepad++ opens — add commit message like "Initial commit: add welcome.txt", save and close

### Or commit with inline message
```bash
git commit -m "Initial commit: add welcome.txt"
```

### View commit history
```bash
git log
```

---

## Step 4: Connect to Remote Repository (GitLab/GitHub)

### Sign up at GitLab (https://gitlab.com) and create a project "GitDemo"

### Add remote origin
```bash
git remote add origin https://gitlab.com/yourusername/GitDemo.git
```

### Pull from remote (if it has initial content)
```bash
git pull origin master
```

### Push local to remote
```bash
git push origin master
```

### Verify on GitLab dashboard that `welcome.txt` appears in the repository.

---

## Summary

| Command | Description |
|---------|-------------|
| `git config --global user.name` | Set global username |
| `git config --global user.email` | Set global email |
| `git init` | Initialize a local repository |
| `git status` | Show working directory status |
| `git add <file>` | Stage a file |
| `git commit -m "msg"` | Commit staged changes |
| `git push origin master` | Push to remote |
| `git pull origin master` | Pull from remote |
