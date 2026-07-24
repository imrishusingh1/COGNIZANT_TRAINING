# GIT Hands-On Lab 4: Conflict Resolution

## Objectives
- Implement conflict resolution during merge

## Estimated Time: 30 minutes

---

## Task Description
Simulate a merge conflict when both master and a branch modify the same file with different content, then resolve it.

---

## Step 1: Verify master is in clean state
```bash
git status
```
> Should show "nothing to commit, working tree clean"

---

## Step 2: Create branch "GitWork" and add hello.xml
```bash
git branch GitWork
git checkout GitWork
echo "<hello>World from Branch</hello>" > hello.xml
git add hello.xml
git commit -m "Add hello.xml in GitWork branch"
```

---

## Step 3: Switch to master and add DIFFERENT content to hello.xml
```bash
git checkout master
echo "<hello>World from Master</hello>" > hello.xml
git add hello.xml
git commit -m "Add hello.xml in master"
```

---

## Step 4: Visualize branch divergence
```bash
git log --oneline --graph --decorate --all
```

---

## Step 5: Check differences (Git diff)
```bash
git diff master GitWork
```

---

## Step 6: Attempt to merge (this will cause a conflict!)
```bash
git merge GitWork
```
> Git will report: **CONFLICT (add/add): Merge conflict in hello.xml**

---

## Step 7: View conflict markers in hello.xml
```bash
cat hello.xml
```

The file will look like:
```xml
<<<<<<< HEAD
<hello>World from Master</hello>
=======
<hello>World from Branch</hello>
>>>>>>> GitWork
```

---

## Step 8: Resolve conflict manually
Open hello.xml and edit to keep the desired content:
```xml
<hello>World - Resolved Merge Conflict</hello>
```
Remove the conflict markers (`<<<<<<<`, `=======`, `>>>>>>>`).

---

## Step 9: Mark conflict as resolved and commit
```bash
git add hello.xml
git commit -m "Resolve merge conflict in hello.xml"
```

---

## Step 10: Verify clean state
```bash
git status
git log --oneline --graph --decorate --all
```

---

## Using P4Merge for Visual Conflict Resolution

```bash
git mergetool
```
P4Merge will open showing:
- **Left**: Local changes (master)
- **Center**: Common base
- **Right**: Incoming changes (GitWork)
- **Bottom**: Merged result

Select the lines you want to keep in the bottom panel and save.

---

## Summary

| Command | Description |
|---------|-------------|
| `git diff <branch1> <branch2>` | Compare branches |
| `git merge <branch>` | Merge (may conflict) |
| `git status` | See conflicted files |
| `git add <file>` | Mark conflict resolved |
| `git commit` | Complete the merge |
| `git mergetool` | Visual conflict resolution |
