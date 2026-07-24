# GIT Hands-On Lab 5: Clean Up and Push to Remote

## Objectives
- Execute clean up steps
- Push back to remote Git repository

## Estimated Time: 10 minutes

---

## Prerequisites
- Completed HOL 4 (conflict resolution)
- Local repository with resolved conflict

---

## Step 1: Verify master is in clean state
```bash
git status
```
> Should show "nothing to commit, working tree clean"

---

## Step 2: List all available branches
```bash
git branch -a
```
> Shows all local and remote branches

---

## Step 3: Pull the remote repository to master (sync)
```bash
git checkout master
git pull origin master
```
> This ensures your local master is up-to-date with remote

---

## Step 4: Push pending changes to remote repository
```bash
git push origin master
```

---

## Step 5: Clean up merged branches

### Delete merged local branch
```bash
git branch -d GitWork
```

### Delete remote branch (if pushed earlier)
```bash
git push origin --delete GitWork
```

---

## Step 6: Verify changes on GitLab

1. Go to your GitLab project dashboard
2. Check **Repository** → observe updated files
3. Check **Commits** → see all commit history
4. Branches section should show only `master` (GitWork deleted)

---

## Step 7: Additional Clean Up Commands

### Remove untracked files (dry run first!)
```bash
git clean -n   # dry run - shows what would be removed
git clean -f   # actually removes untracked files
git clean -fd  # removes untracked files and directories
```

### Reset to last commit (discard unstaged changes)
```bash
git checkout -- .
```

### Stash work in progress (save temporarily)
```bash
git stash
git stash pop   # restore stashed changes
git stash list  # list all stashes
```

---

## Full Workflow Summary (HOL 1-5)

```
git config --global user.name "Name"     # Setup (HOL 1)
git init / git clone                      # Initialize repo
git add .gitignore                        # Ignore files (HOL 2)
git branch feature                        # Create branch (HOL 3)
git checkout feature
git add . && git commit -m "changes"
git checkout master
git merge feature                         # Merge (may conflict - HOL 4)
# Resolve conflicts if any
git add . && git commit -m "resolved"
git pull origin master                    # Sync with remote (HOL 5)
git push origin master                    # Push to remote
git branch -d feature                     # Cleanup
```

---

## Summary

| Command | Description |
|---------|-------------|
| `git pull origin master` | Fetch + merge from remote |
| `git push origin master` | Push to remote |
| `git branch -d <name>` | Delete local branch |
| `git push origin --delete <name>` | Delete remote branch |
| `git clean -fd` | Remove untracked files/dirs |
| `git stash` | Temporarily save work |
| `git stash pop` | Restore stashed work |
