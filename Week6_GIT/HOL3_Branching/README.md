# GIT Hands-On Lab 3: Branching and Merging

## Objectives
- Explain branching and merging
- Create a branch, make changes, and merge with master

## Estimated Time: 30 minutes

---

## Branching

### Step 1: Create a new branch "GitNewBranch"
```bash
git branch GitNewBranch
```

### Step 2: List all local and remote branches
```bash
git branch -a
```
> The `*` marks the currently active branch (master/main)

### Step 3: Switch to the new branch
```bash
git checkout GitNewBranch
```
Or using modern syntax:
```bash
git switch GitNewBranch
```

### Step 4: Add a file with content in the branch
```bash
echo "Feature work done in branch" > feature.txt
git add feature.txt
```

### Step 5: Commit changes to the branch
```bash
git commit -m "Add feature.txt in GitNewBranch"
```

### Step 6: Check status
```bash
git status
```

---

## Merging

### Step 7: Switch back to master
```bash
git checkout master
```

### Step 8: Merge the branch into master
```bash
git merge GitNewBranch
```
> This performs a fast-forward merge if master hasn't diverged.

### Step 9: View the merge in git log
```bash
git log --oneline --graph --decorate --all
```

### Step 10: Push merged master to remote
```bash
git push origin master
```

### Step 11: Delete the branch (optional, after merging)
```bash
git branch -d GitNewBranch
```

---

## GitLab Merge Request (Alternative to Command Line Merge)

1. Push your branch to GitLab:
   ```bash
   git push origin GitNewBranch
   ```
2. Go to GitLab project → **Merge Requests** → **New Merge Request**
3. Set source branch: `GitNewBranch`, target: `master`
4. Add title and description
5. Click **Create Merge Request**
6. Review changes → Click **Merge**

---

## Summary

| Command | Description |
|---------|-------------|
| `git branch <name>` | Create a new branch |
| `git branch -a` | List all branches |
| `git checkout <branch>` | Switch to a branch |
| `git merge <branch>` | Merge branch into current |
| `git branch -d <name>` | Delete a merged branch |
| `git log --oneline --graph` | Visualize branch history |
